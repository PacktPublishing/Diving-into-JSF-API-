package beans;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Leonard
 */
@FacesValidator
public class NameValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        boolean has = pattern.matcher(String.valueOf(value)).find();

        if (has) {
            FacesMessage message = new FacesMessage();
            message.setDetail("The name should contain only alphanumeric characters!");
            message.setSummary("Name not valid ...");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
