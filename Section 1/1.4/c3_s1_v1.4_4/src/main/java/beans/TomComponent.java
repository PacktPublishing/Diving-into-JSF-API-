package beans;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

/**
 *
 * @author Anghel Leonard
 */
@FacesComponent(value = TomComponent.COMPONENT_TYPE, createTag = true)
public class TomComponent extends UIComponentBase {
   
 public static final String COMPONENT_FAMILY = "jsf.listenerforandrenderer";
 public static final String COMPONENT_TYPE = "jsf.listenerforandrenderer.TomComponent";   

 public TomComponent() {
  setRendererType(TomAndJerryRenderer.RENDERER_TYPE);
 }                   
   
 @Override
 public String getFamily() {
  return COMPONENT_FAMILY;
 }     
}

