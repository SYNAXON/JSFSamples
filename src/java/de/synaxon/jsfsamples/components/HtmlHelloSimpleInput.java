package de.synaxon.jsfsamples.components;

import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author karl spies
 */
@FacesComponent("HelloSimpleInput")
public class HtmlHelloSimpleInput extends UIInput {

    @Override
    public void encodeAll(FacesContext context) throws IOException {
        System.out.println("Mein Renderer");
        super.encodeAll(context);
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.writeText("My custom input element", null);
    }
}
