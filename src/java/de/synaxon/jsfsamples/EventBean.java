package de.synaxon.jsfsamples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Karl Spies
 */
@Named
@SessionScoped
public class EventBean implements Serializable {

    static final Logger LOGGER = LoggerFactory.getLogger(EventBean.class);
    private String buttonId;
    private String value;
    @Inject
    @Invalid
    private Event<Item> itemEvent;

    /**
     *
     * @return the implicit navigation rule
     */
    public String outcome() {
        LOGGER.debug("Just an action method 1 !");
        //queueException("Just an action method!");
        return "welcome";
    }

    /**
     *
     * @param event Fired if button clicked
     */
    public void printIt(ActionEvent event) {
        setButtonId(event.getComponent().getClientId());
        LOGGER.debug("ActionListener Method called from: " + getButtonId());
        LOGGER.debug("Firing event to system!");
        Item i = new Item();
        i.setValue(42);
        i.setLimit(666);
        itemEvent.fire(i);
        LOGGER.debug("Georg wills wissen!");
    }

    /**
     *
     * @param event systemEvent to log in console
     */
    public void viewLog(ComponentSystemEvent event) throws Exception {
        //queueException("Just an action method 2 !");
        LOGGER.debug("ComponentSystemEvent called from: " + event.getSource().getClass().getName());
        //throw new Exception("Just one Exception!");
    }

    /**
     *
     * @return a list of excellent Developers
     */
    public List<String> getValues() {
        //queueException("Just an action method 3!");
        ArrayList<String> names = new ArrayList();
        names.add("Jan");
        names.add("Viktor");
        names.add("Georg");
        return names;
    }

    /**
     *
     * @param e an event which holds the value change data
     */
    public void valueChangeMethod(ValueChangeEvent e) {
        LOGGER.debug("ValueChangeListener Method called from: " + e.getComponent().getClientId());
        LOGGER.debug("===> Old value: " + e.getOldValue());
        LOGGER.debug("===> New value: " + e.getNewValue().toString());
    }

    /**
     *
     * @param item
     */
    public void itemObserver(@Observes @Invalid Item item) {
        LOGGER.debug("Event was fired! => " + item);
    }

    /**
     * @return the buttonId
     */
    public String getButtonId() {
        return buttonId;
    }

    /**
     * @param buttonId the buttonId to set
     */
    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    private void queueException(String message) {
        Exception e = new Exception(message);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExceptionQueuedEventContext eventContext = new ExceptionQueuedEventContext(ctx, e);
        eventContext.getAttributes().put("key", "value");
        ctx.getApplication().publishEvent(ctx, ExceptionQueuedEvent.class, eventContext);
    }
}
