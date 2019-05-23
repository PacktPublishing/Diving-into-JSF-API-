package beans;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

/**
 *
 * @author Anghel Leonard
 */
@FacesComponent(value = JerryComponent.COMPONENT_TYPE, createTag = true)
public class JerryComponent extends UIComponentBase {
   
 public static final String COMPONENT_FAMILY = "jsf.listenerforandrenderer";
 public static final String COMPONENT_TYPE = "jsf.listenerforandrenderer.JerryComponent";   

 public JerryComponent() {
  setRendererType(TomAndJerryRenderer.RENDERER_TYPE);
 }                   
   
 @Override
 public String getFamily() {
  return COMPONENT_FAMILY;
 }     
}

