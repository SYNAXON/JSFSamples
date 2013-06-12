/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.synaxon.jsfsamples;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name = "";
    private String lastname = "";

    public String getName() {
        System.out.println("=====> getName()");
        return name;
    }

    public void setName(String newValue) {
        System.out.println("=====> setName()");
        name = newValue;
    }

    public String getLastname() {
        System.out.println("=====> getLastname()");
        return lastname;
    }

    public void setLastname(String newValue) {
        System.out.println("=====> setLastname()");
        lastname = newValue;
    }

    public void inputChanged(ValueChangeEvent event) {
        System.out.println("=====> ChangeListener: " + event.getOldValue() + " zu " + event.getNewValue());
    }

    public String welcome() {
        setName("immediate");
        System.out.println("=====> Action called!");
        return "welcome";
    }

    public String getStage() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        return ctx.getApplication().getProjectStage().name();
    }
}
