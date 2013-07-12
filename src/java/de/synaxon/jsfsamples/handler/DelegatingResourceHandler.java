/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.synaxon.jsfsamples.handler;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;
import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author karl spies
 */
public class DelegatingResourceHandler extends ResourceHandlerWrapper {

    private final ResourceHandler wrappedHandler;
    private static final Logger LOGGER = LoggerFactory.getLogger(DelegatingResourceHandler.class);

    /**
     *
     * @param wrappedHandler the wrapped handler
     */
    public DelegatingResourceHandler(ResourceHandler wrappedHandler) {
        this.wrappedHandler = wrappedHandler;
    }

    @Override
    public ResourceHandler getWrapped() {
        return wrappedHandler;
    }

    @Override
    public Resource createResource(String resourceName, String libraryName) {

        Object someCDIService = getBeanFromFacesContext("myCoolCdiService");

        // otherwise delegate to the default implementation.
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Delegating resource creation to default implementation. name: " + resourceName
                    + " and library: " + libraryName);
        }
        return super.createResource(resourceName, libraryName, null);
    }

    /**
     * Gets a bean from the faces context.
     *
     * @param name name of the bean to get
     * @return bean instance as returned from faces context.
     */
    public Object getBeanFromFacesContext(String name) {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().getELResolver().getValue(context.getELContext(), null, name);
    }
}
