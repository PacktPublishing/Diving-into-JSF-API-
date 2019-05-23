package beans;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Anghel Leonard
 */
public class URLHandler extends ViewHandlerWrapper {

    private ViewHandler baseViewHandler;

    public URLHandler(ViewHandler baseViewHandler) {
        this.baseViewHandler = baseViewHandler;
    }

    @Override
    public String getActionURL(FacesContext context, String viewId) {
        return convertToRelativeURL(context, baseViewHandler.getActionURL(context, viewId));
    }

    @Override
    public String getResourceURL(FacesContext context, String path) {
        return convertToRelativeURL(context, baseViewHandler.getResourceURL(context, path));
    }

    @Override
    public ViewHandler getWrapped() {
        return baseViewHandler;
    }

    private String convertToRelativeURL(FacesContext context, String theURL) {

        final HttpServletRequest request = ((HttpServletRequest) context.getExternalContext().getRequest());
        final URI uri;
        String prefix = "";

        String string_uri = request.getRequestURI();

        try {
            uri = new URI(string_uri);
        } catch (URISyntaxException ex) {
            Logger.getLogger(URLHandler.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

        String path = uri.getPath();
        String new_path = path.replace("//", "/");

        if (theURL.startsWith("/")) {
            int count = new_path.length() - new_path.replace("/", "").length();
            for (int i = 0; i < (count - 1); i++) {
                prefix = prefix + "/..";
            }
            if (prefix.length() > 0) {
                prefix = prefix.substring(1);
            }
        }

        return (prefix + theURL);
    }
}
