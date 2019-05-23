package beans;

import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;;
import javax.inject.Named;


/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class ExceptionBean {
    
    public void validatorExceptionAction(){
        throw new javax.faces.validator.ValidatorException(new FacesMessage("Some validation exception ..."));        
    }    
    
    public void converterExceptionAction(){
        throw new javax.faces.convert.ConverterException(new FacesMessage("Some converter exception ..."));        
    }
    
    public void ioExceptionAction() throws IOException{
        throw new IOException();
    }
}
