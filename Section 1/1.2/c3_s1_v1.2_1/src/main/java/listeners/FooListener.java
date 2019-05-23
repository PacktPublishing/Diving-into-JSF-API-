package listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author Anghel Leonard
 */
public class FooListener implements ActionListener {
 
    private static final Logger LOGGER = Logger.getLogger(FooListener.class.getName());
     
    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        
         LOGGER.log(Level.INFO, "FooListener#processAction() method called ...");        
    }            
}
