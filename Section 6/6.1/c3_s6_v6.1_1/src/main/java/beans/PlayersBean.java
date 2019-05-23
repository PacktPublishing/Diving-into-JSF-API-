package beans;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class PlayersBean {

    private Map<String, String> attrs = new HashMap<>();
    private String email="";   

    /**
     * Creates a new instance of PlayersBean
     */
    public PlayersBean() {
        attrs.put("type", "email");
        attrs.put("placeholder", "Enter player e-mail");
    }

    public Map<String, String> getAttrs() {
        return attrs;
    }    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }      
}

