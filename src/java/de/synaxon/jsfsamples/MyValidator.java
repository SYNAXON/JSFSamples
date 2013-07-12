package de.synaxon.jsfsamples;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author karl spies
 */
@FacesValidator(value = "myValidator")
public class MyValidator implements Validator {

    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {

        System.out.println("===> MyValidator validate: " + value + " Component: " + component.getId());

        String messageBundleFQCN = context.getApplication().getMessageBundle();
        Locale locale = context.getViewRoot().getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle(messageBundleFQCN, locale);

        throw new ValidatorException(new FacesMessage(bundle.getString("myValidator")));
    }
}
