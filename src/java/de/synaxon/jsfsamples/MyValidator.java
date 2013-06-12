/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.synaxon.jsfsamples;

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
        throw new ValidatorException(new FacesMessage("So geht das nicht!"));
    }
}
