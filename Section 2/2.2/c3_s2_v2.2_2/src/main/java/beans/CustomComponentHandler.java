package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.ComponentConfig;
import javax.faces.view.facelets.ComponentHandler;
import javax.faces.view.facelets.FaceletContext;

/**
 *
 * @author Anghel Leonard
 */
public class CustomComponentHandler extends ComponentHandler {

    private static final Logger LOG = Logger.getLogger(CustomComponentHandler.class.getName());

    public CustomComponentHandler(ComponentConfig config) {
        super(config);
    }

    //only in JSF 2.2
    @Override
    public UIComponent createComponent(FaceletContext ctx) {
        LOG.info("Inside 'createComponent' method");
        return super.createComponent(ctx);
    }

    @Override
    public void onComponentCreated(FaceletContext ctx, UIComponent c, UIComponent parent) {
        LOG.log(Level.INFO, "Inside ''onComponentCreated'' method [{0}]", c);
        super.onComponentCreated(ctx, c, parent);
    }

    @Override
    public void onComponentPopulated(FaceletContext ctx, UIComponent c, UIComponent parent) {
        LOG.log(Level.INFO, "Inside ''onComponentPopulated'' method [{0}]", c);
        super.onComponentPopulated(ctx, c, parent);
    }
}
