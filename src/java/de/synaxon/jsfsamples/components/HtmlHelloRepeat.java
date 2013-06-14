package de.synaxon.jsfsamples.components;

import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;

/**
 *
 * @author karl spies
 */
@FacesComponent("helloRepeat")
public class HtmlHelloRepeat extends UINamingContainer {

    /**
     *
     * @return
     */
    public Object[] getItems() {
        Integer intValue = getFactor();
        setFactor(intValue);
        return new Object[intValue.intValue()];
    }

    /**
     *
     * @return
     */
    public Integer getFactor() {
        if (getStateHelper().get("factor") == null) {
            Object totalStars = getAttributes().get("totalStars");
            Integer size = Integer.valueOf(String.valueOf(totalStars));
            setFactor(size);
        }
        return (Integer) getStateHelper().get("factor");
    }

    /**
     *
     * @param factor
     */
    public void setFactor(Integer factor) {
        factor++;
        getStateHelper().put("factor", factor);
    }
}
