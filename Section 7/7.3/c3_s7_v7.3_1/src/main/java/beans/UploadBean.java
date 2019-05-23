package beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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
    private List<Part> files;

    public List<Part> getFile() {
        return files;
    }

    public void setFile(List<Part> files) {
        this.files = files;
    }

    public void upload() {

        if (files != null) {

            logger.info("Files Details:");
            for (Part file : files) {

                logger.log(Level.INFO, "File component id:{0}", file.getName());
                logger.log(Level.INFO, "Content type:{0}", file.getContentType());
                logger.log(Level.INFO, "Submitted file name:{0}", file.getSubmittedFileName());
                logger.log(Level.INFO, "File size:{0}", file.getSize());

                try (InputStream inputStream = file.getInputStream(); FileOutputStream outputStream = new FileOutputStream("D:" + File.separator + "files" + File.separator + file.getSubmittedFileName())) {

                    int bytesRead = 0;
                    final byte[] chunck = new byte[1024];
                    while ((bytesRead = inputStream.read(chunck)) != -1) {
                        outputStream.write(chunck, 0, bytesRead);
                    }

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload successfully ended: " + file.getSubmittedFileName()));
                } catch (IOException e) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload failed !"));
                }
            }
        }
    }
}
