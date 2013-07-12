package de.synaxon.jsfsamples;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author karl spies
 */
@FacesConverter(value = "myConverter")
public class MyConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("===> MyConverter getAsObject: " + value + " Component: " + component.getId());
        //throw new ConverterException("Conversion failed.");
        return value;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("===> MyConverter getAsString: " + value + " Component: " + component.getId());
        return (String) value;
    }
}
