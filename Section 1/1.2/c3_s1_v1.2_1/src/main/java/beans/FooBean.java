package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class FooBean {

    private static final Logger LOGGER = Logger.getLogger(FooBean.class.getName());

    private String foo;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        LOGGER.log(Level.INFO, "FooBean#setFoo(String foo) method called ...");
        this.foo = foo;
    }

    public void actionListenerMethod(ActionEvent e) {
        LOGGER.log(Level.INFO, "FooBean#actionListenerMethod(e) method called ...");
    }

    public void ajaxActionListenerMethod(AjaxBehaviorEvent e) {
        LOGGER.log(Level.INFO, "FooBean#ajaxActionListenerMethod(e) method called ...");
    }

    public void actionListenerMethod() {
        LOGGER.log(Level.INFO, "FooBean#actionListenerMethod() method called ...");
    }

    public String actionMethod() {
        LOGGER.log(Level.INFO, "FooBean#actionMethod() method called ...");
        return "done";
    }
}
