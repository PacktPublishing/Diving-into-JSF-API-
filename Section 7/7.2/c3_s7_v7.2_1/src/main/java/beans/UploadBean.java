package beans;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class UploadBean {

    private static final Logger logger = Logger.getLogger(UploadBean.class.getName());
    private Part file;
    private String fileInString;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public void upload() {
        try {
            if (file != null) {
                Scanner scanner = new Scanner(file.getInputStream(), "UTF-8").useDelimiter("\\A");
                fileInString = scanner.hasNext() ? scanner.next() : "";
                logger.info(fileInString);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload successfully ended!"));
            }
        } catch (IOException | NoSuchElementException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload failed!"));
        }
    }
}
