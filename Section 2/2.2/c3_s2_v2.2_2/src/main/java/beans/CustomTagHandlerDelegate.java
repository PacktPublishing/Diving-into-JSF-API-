package beans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.MetaRuleset;
import javax.faces.view.facelets.TagHandlerDelegate;

/**
 * 
 * @author Anghel Leonard
 */
public class CustomTagHandlerDelegate extends TagHandlerDelegate{
    
    private static final Logger logger = Logger.getLogger(CustomTagHandlerDelegate.class.getName());    
    private TagHandlerDelegate tagHandlerDelegate;
    
    public CustomTagHandlerDelegate(){        
    }
    
    public CustomTagHandlerDelegate (TagHandlerDelegate tagHandlerDelegate){
        this.tagHandlerDelegate = tagHandlerDelegate;
    }
    
    @Override
    public MetaRuleset createMetaRuleset(Class type) {
        logger.info("Inside 'TagHandlerDelegate.createMetaRuleset' method");
        return tagHandlerDelegate.createMetaRuleset(type);
    }

    @Override
    public void apply(FaceletContext ctx, UIComponent comp) throws IOException {
        logger.log(Level.INFO, "Inside ''TagHandlerDelegate.apply'' method [{0}]", comp);
        tagHandlerDelegate.apply(ctx, comp);
    }
    
}
