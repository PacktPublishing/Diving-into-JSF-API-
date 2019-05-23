package listeners;

import beans.BuzzBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.inject.Inject;

/**
 *
 * @author Anghel Leonard
 */
public class ApplicationFooListener implements ActionListener {

    private static final Logger LOGGER = Logger.getLogger(ApplicationFooListener.class.getName());
    
    @Inject
    private BuzzBean buzzBean;
   
    private ActionListener actionListener;

    public ApplicationFooListener() {      
    }

    public ApplicationFooListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {

        LOGGER.log(Level.INFO, "ApplicationFooListener#processAction() called ...");
        LOGGER.log(Level.INFO, "ApplicationFooListener#processAction(): the injected BuzzBean: {0}", buzzBean.getBuzz());
        actionListener.processAction(event);
    }
}
