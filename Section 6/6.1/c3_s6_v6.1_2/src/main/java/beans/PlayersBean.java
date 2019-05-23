package beans;

import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class PlayersBean {
    
    public void generateInputTextPlayerAction() {
      
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIComponent formComponent = facesContext.getViewRoot().findComponent("playerForm");
        
        HtmlInputText playerInputText = new HtmlInputText();
        Map passThroughAttrs = playerInputText.getPassThroughAttributes();
        passThroughAttrs.put("placeholder", "Enter player email");
        passThroughAttrs.put("type", "email");
        
        formComponent.getChildren().add(playerInputText);
    }
}
