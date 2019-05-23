package beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Anghel Leonard
 */
@FacesValidator(value = "playerValidator")
public class PlayerValidator implements Validator {

    @Override
    public void validate(FacesContext context,
            UIComponent component, Object value) throws ValidatorException {

        if (value == null || "".equals(value.toString().trim())) {
            FacesMessage facesMessages = new FacesMessage();
            String msg = (String) component.getAttributes().get("message");
            if (msg == null) {
                msg = "Please enter player name and surname!";
            }
            facesMessages.setDetail(msg);
            facesMessages.setSummary(msg);
            facesMessages.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(facesMessages);
        }

    }
}
