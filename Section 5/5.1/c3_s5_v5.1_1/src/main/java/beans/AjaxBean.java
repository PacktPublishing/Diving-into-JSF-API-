package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
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
    
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }       
    
    public void ajaxAction() {        
        logger.log(Level.INFO, "Name: {0}", name);
        name = name.toUpperCase();
    }
}
