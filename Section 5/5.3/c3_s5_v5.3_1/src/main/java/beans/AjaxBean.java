package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class AjaxBean {
    
    private static final Logger logger =
            Logger.getLogger(AjaxBean.class.getName());
    private String name = "nothing";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.log (Level.INFO, "Name: {0}", name);
        this.name = name;
    }
    
    public void upperCaseName(){
        logger.log (Level.INFO, "AJAX listener without AjaxBehaviorEvent");
        name = name.toUpperCase();
        logger.log (Level.INFO, "Name: {0}", name);
    }
    
    public void upperCaseNameABE(AjaxBehaviorEvent event){         
        logger.log (Level.INFO, "AJAX listener with AjaxBehaviorEvent");
        name = name.toUpperCase();
        logger.log (Level.INFO, "Name: {0}", name);
    }
    
}
