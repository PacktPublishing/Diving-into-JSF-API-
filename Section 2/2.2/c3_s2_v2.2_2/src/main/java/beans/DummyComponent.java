package beans;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

/**
 * 
 * @author Anghel Leonard
 */
@FacesComponent(value=DummyComponent.COMPONENT_TYPE)
public class DummyComponent extends UIComponentBase {

    public static final String COMPONENT_FAMILY = "dummy.components";
    public static final String COMPONENT_TYPE = "dummy";

    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }
}
