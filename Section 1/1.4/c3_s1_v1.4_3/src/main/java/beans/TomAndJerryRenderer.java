package beans;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ComponentSystemEventListener;
import javax.faces.event.ListenerFor;
import javax.faces.event.PostAddToViewEvent;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 *
 * @author Anghel Leonard
 */
@ListenerFor(systemEventClass = PostAddToViewEvent.class)
@FacesRenderer(componentFamily = TomComponent.COMPONENT_FAMILY,
        rendererType = TomAndJerryRenderer.RENDERER_TYPE)
public class TomAndJerryRenderer extends Renderer implements ComponentSystemEventListener {

    public static final String RENDERER_TYPE = "jsf.listenerforandrenderer.TomAndJerryRenderer";

    @Override
    public void processEvent(ComponentSystemEvent event) throws AbortProcessingException {
        System.out.println("EVENT EMITTED: " + event);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.write("I'm Tom the cat or Jerry the mice !");
    }
}
