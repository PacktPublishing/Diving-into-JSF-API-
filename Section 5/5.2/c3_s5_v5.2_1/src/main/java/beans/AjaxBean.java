package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class AjaxBean {

    private static final Logger logger =
            Logger.getLogger(AjaxBean.class.getName());
    private String name;
    private String surname;
    private String phone;
    private String age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void ajaxAction() {
        logger.log(Level.INFO, "Name = {0}", this.name);
        logger.log(Level.INFO, "Surname = {0}", this.surname);
        logger.log(Level.INFO, "Phone = {0}", this.phone);
        logger.log(Level.INFO, "Age = {0}", this.age);
        logger.log(Level.INFO, "Address = {0}", this.address);
    }
}
