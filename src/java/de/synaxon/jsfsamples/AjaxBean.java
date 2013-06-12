package de.synaxon.jsfsamples;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

/**
 *
 * @author karl spies
 */
@Named
@RequestScoped
public class AjaxBean {

    private String someInput;
    private boolean disabled = false;

    /**
     *
     * @param e
     */
    public void callMeBaby(AjaxBehaviorEvent e) throws Exception {
        System.out.println("AJAX: " + e.toString());
        //throw new Exception("Hello");
    }

    /**
     * @return the someInput
     */
    public String getSomeInput() {
        return someInput;
    }

    /**
     * @param someInput the someInput to set
     */
    public void setSomeInput(String someInput) {
        System.out.println("There is a value: " + someInput);
        this.someInput = someInput;
    }

    /**
     * @return the disabled
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * @param disabled the disabled to set
     */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
