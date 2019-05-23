package beans;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;

/**
 *
 * @author Anghel Leonard
 */
public class CustomResourceHandler extends ResourceHandlerWrapper {

    private final ResourceHandler wrapped;

    public CustomResourceHandler(ResourceHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public Resource createResource(String resourceName, String libraryName) {

        if (!resourceName.equals("sample.css")) {
            //return super.createResource(resourceName, libraryName);  //in JSF 2.0 and JSF 2.2
            return super.createResourceFromId(libraryName + "/" + resourceName); //only in JSF 2.2
        } else {
            return new SampleResource(resourceName);
        }
    }

    @Override
    public ResourceHandler getWrapped() {
        return this.wrapped;
    }
}
