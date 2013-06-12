/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.synaxon.jsfsamples;

import javax.faces.FacesException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Karl Spies
 */
public class CustomExceptionHandler extends ExceptionHandlerWrapper {

    static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);
    private ExceptionHandler wrapped;

    public CustomExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public javax.faces.context.ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public void handle() throws FacesException {
        for (ExceptionQueuedEvent event : getUnhandledExceptionQueuedEvents()) {
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
            LOGGER.error(context.getException().getMessage(), context.getException());
        }

        // Let the parent handle the rest
        getWrapped().handle();
    }
}
