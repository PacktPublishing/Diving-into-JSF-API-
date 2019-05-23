package listeners;

import beans.BuzzBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ActionListenerWrapper;
import javax.inject.Inject;

/**
 *
 * @author Anghel Leonard
 */
public class ApplicationFooListenerWrapper extends ActionListenerWrapper {

    private static final Logger LOGGER = Logger.getLogger(ApplicationFooListenerWrapper.class.getName());

    @Inject
    private BuzzBean buzzBean;
    
    private ActionListener actionListener;

    public ApplicationFooListenerWrapper() {
    }

    public ApplicationFooListenerWrapper(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        LOGGER.log(Level.INFO, "ApplicationFooListenerWrapper#processAction(): Wrapper class called ...");
        LOGGER.log(Level.INFO, "ApplicationFooListenerWrapper#processAction(): the injected BuzzBean: {0}", buzzBean.getBuzz());
        getWrapped().processAction(event);
    }

    @Override
    public ActionListener getWrapped() {
        return this.actionListener;
    }
}
