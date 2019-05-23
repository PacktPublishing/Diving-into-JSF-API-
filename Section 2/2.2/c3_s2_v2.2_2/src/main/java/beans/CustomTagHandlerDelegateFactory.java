package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.facelets.BehaviorHandler;
import javax.faces.view.facelets.ComponentHandler;
import javax.faces.view.facelets.ConverterHandler;
import javax.faces.view.facelets.TagHandlerDelegate;
import javax.faces.view.facelets.TagHandlerDelegateFactory;
import javax.faces.view.facelets.ValidatorHandler;

/**
 * 
 * @author Anghel Leonard
 */
public class CustomTagHandlerDelegateFactory extends TagHandlerDelegateFactory {

    private static final Logger LOG = Logger.getLogger(CustomTagHandlerDelegateFactory.class.getName());
    private TagHandlerDelegateFactory tagHandlerDelegateFactory;

    public CustomTagHandlerDelegateFactory() {
    }

    public CustomTagHandlerDelegateFactory(TagHandlerDelegateFactory tagHandlerDelegateFactory) {
        this.tagHandlerDelegateFactory = tagHandlerDelegateFactory;
    }

    @Override
    public TagHandlerDelegate createComponentHandlerDelegate(ComponentHandler owner) {
        LOG.log(Level.INFO, "Inside ''TagHandlerDelegateFactory.createComponentHandlerDelegate'' method [{0}]", owner);
        return new CustomTagHandlerDelegate(tagHandlerDelegateFactory.createComponentHandlerDelegate(owner));
    }

    @Override
    public TagHandlerDelegate createValidatorHandlerDelegate(ValidatorHandler owner) {
        LOG.info("Inside 'TagHandlerDelegateFactory.createValidatorHandlerDelegate' method");
        return tagHandlerDelegateFactory.createValidatorHandlerDelegate(owner);
    }

    @Override
    public TagHandlerDelegate createConverterHandlerDelegate(ConverterHandler owner) {
        LOG.info("Inside 'TagHandlerDelegateFactory.createConverterHandlerDelegate' method");
        return tagHandlerDelegateFactory.createConverterHandlerDelegate(owner);
    }

    @Override
    public TagHandlerDelegate createBehaviorHandlerDelegate(BehaviorHandler owner) {
        LOG.info("Inside 'TagHandlerDelegateFactory.createBehaviorHandlerDelegate' method");
        return tagHandlerDelegateFactory.createBehaviorHandlerDelegate(owner);
    }
}
