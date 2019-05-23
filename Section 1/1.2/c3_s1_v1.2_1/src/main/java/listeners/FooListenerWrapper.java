package listeners;

import javax.faces.event.ActionListener;
import javax.faces.event.ActionListenerWrapper;

/**
 *
 * @author Anghel Leonard
 */
public class FooListenerWrapper extends ActionListenerWrapper {

    FooListener fooListener = new FooListener();

    @Override
    public ActionListener getWrapped() {
        return fooListener;
    }
}
