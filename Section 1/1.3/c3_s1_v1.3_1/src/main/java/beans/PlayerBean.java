package beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class PlayerBean {

    private String name;
    private String surname;
    private String bank;
    private String cbank;

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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCbank() {
        return cbank;
    }

    public void setCbank(String cbank) {
        this.cbank = cbank;
    }

    public void validateAccount(ComponentSystemEvent event) {

        UIComponent uis = event.getComponent();

        //obtain bank account
        String bankAccount = null;
        UIInput uiBankAccount = (UIInput) uis.findComponent("bankAccountId");
        Object bankAccountObj = uiBankAccount.getLocalValue();
        if (bankAccountObj != null) {
            bankAccount = String.valueOf(bankAccountObj).trim();
        }

        //obtain bank account confirmation
        String bankAccountC = null;
        UIInput uiBankAccountC = (UIInput) uis.findComponent("confirmBankAccountId");
        Object bankAccountCObj = uiBankAccountC.getLocalValue();
        if (bankAccountCObj != null) {
            bankAccountC = String.valueOf(bankAccountCObj).trim();
        }

        if ((bankAccount != null) && (bankAccountC != null)) {
            if (!bankAccount.equals(bankAccountC)) {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("Bank account must match bank account confirmation !");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(uiBankAccount.getClientId(), facesMessage);
                facesContext.renderResponse();
            }
        }
    }
}
