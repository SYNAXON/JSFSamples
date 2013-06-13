package de.synaxon.jsfsamples.components;

import java.io.IOException;
import java.util.Date;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author karl spies
 */
@FacesComponent(value = "HtmlHelloWorld")
public class HtmlHelloWorld extends UIComponentBase {

    @Override
    public String getFamily() {
        return "synaxon.faces.Hello";
    }

    @Override
    public void encodeAll(FacesContext context) throws IOException {
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement("div", this);
        responseWriter.writeAttribute("style", "color: red;", null);
        responseWriter.writeText("HelloWorld! today is: " + new Date(), null);
        responseWriter.endElement("div");
    }
}
