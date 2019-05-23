package beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
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

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public void upload() {

        if (file != null) {

            logger.info("File Details:");
            logger.log(Level.INFO, "File name:{0}", file.getName());
            logger.log(Level.INFO, "Content type:{0}", file.getContentType());
            logger.log(Level.INFO, "Submitted file name:{0}", file.getSubmittedFileName());            
            logger.log(Level.INFO, "File size:{0}", file.getSize());

            try (InputStream inputStream = file.getInputStream(); FileOutputStream outputStream = new FileOutputStream("D:" + File.separator + "files" + File.separator +file.getSubmittedFileName())) {

                int bytesRead = 0;
                final byte[] chunck = new byte[1024];
                while ((bytesRead = inputStream.read(chunck)) != -1) {
                    outputStream.write(chunck, 0, bytesRead);
                }

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload successfully ended!"));
            } catch (IOException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload failed!"));
            }
        }
    }
}
