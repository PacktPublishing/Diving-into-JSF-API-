package beans;

import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

/**
 *
 * @author Anghel Leonard
 */
public class CustomExceptionHandler extends ExceptionHandlerWrapper {

    private final ExceptionHandler exceptionHandler;

    CustomExceptionHandler(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return exceptionHandler;
    }

    @Override
    public void handle() throws FacesException {

        final Iterator<ExceptionQueuedEvent> queue = getUnhandledExceptionQueuedEvents().iterator();

        while (queue.hasNext()) {

            // treat exceptions one by one
            ExceptionQueuedEvent item = queue.next();
            ExceptionQueuedEventContext exceptionQueuedEventContext
                    = (ExceptionQueuedEventContext) item.getSource();

            FacesContext facesContext = FacesContext.getCurrentInstance();           
            Throwable throwable = exceptionQueuedEventContext.getException();
            NavigationHandler nav = facesContext.getApplication().getNavigationHandler();

            if (throwable.getCause().getCause() instanceof javax.faces.convert.ConverterException) {
                
                //redirect to error_c page    
                queue.remove();
                nav.handleNavigation(facesContext, null, "/error_c");
                facesContext.renderResponse();
            } else if (throwable.getCause().getCause() instanceof javax.faces.validator.ValidatorException) {
                
                //redirect to error_v page   
                queue.remove();
                nav.handleNavigation(facesContext, null, "/error_v");
                facesContext.renderResponse();
            }
        }

        getWrapped().handle();
    }
}
