package beans;

import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ComponentSystemEventListener;
import javax.faces.event.ListenerFor;
import javax.faces.event.ListenersFor;
import javax.faces.event.PostAddToViewEvent;
import javax.faces.event.PreRenderComponentEvent;

/**
 *
 * @author Anghel Leonard
 */
@FacesComponent(value = TomComponent.COMPONENT_TYPE, createTag = true)
@ListenersFor({
  @ListenerFor(systemEventClass=PostAddToViewEvent.class),
  @ListenerFor(systemEventClass=PreRenderComponentEvent.class)
})
public class TomComponent extends UIComponentBase implements ComponentSystemEventListener {

 public static final String COMPONENT_FAMILY = "jsf.listenerforanduicomponent";
 public static final String COMPONENT_TYPE = "jsf.listenerforanduicomponent.TomComponent";

 @Override
 public void processEvent(ComponentSystemEvent event) throws AbortProcessingException {
  System.out.println("EVENT EMITTED: " + event);
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

