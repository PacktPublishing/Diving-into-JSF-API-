package beans;

import javax.faces.application.Resource;
import javax.faces.application.ResourceWrapper;

/**
 *
 * @author Anghel Leonard
 */
public class SampleResource extends ResourceWrapper {

    private final String resourceName;

    public SampleResource(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public String getRequestPath() {
        return "samples/css/" + this.resourceName;
    }

    @Override
    public Resource getWrapped() {
        return this;
    }
}
