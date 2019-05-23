package beans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ComponentSystemEventListener;
import javax.faces.event.PostAddToViewEvent;

/**
 *
 * @author Anghel Leonard
 */
@FacesComponent(value = TomComponent.COMPONENT_TYPE, createTag = true)
public class TomComponent extends UIComponentBase implements ComponentSystemEventListener {

    private static final Logger LOG = Logger.getLogger(TomComponent.class.getName());

    public static final String COMPONENT_FAMILY
            = "jsf.uicomponentwithsubscribetoevent";
    public static final String COMPONENT_TYPE
            = "jsf.uicomponentwithsubscribetoevent.TomComponent";

    public TomComponent() {
        tomSubscribeToEvent();
    }

    public final void tomSubscribeToEvent() {        
        subscribeToEvent(PostAddToViewEvent.class, this);
    }

    @Override
    public void processEvent(ComponentSystemEvent event) throws AbortProcessingException {
        LOG.log(Level.INFO, "EVENT EMITTED: {0}", event);
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.write("I'm Tom the cat!");
    }

    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }
}
