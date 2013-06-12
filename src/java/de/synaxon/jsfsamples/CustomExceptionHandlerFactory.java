/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.synaxon.jsfsamples;

import javax.faces.context.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Karl Spies
 */
public class CustomExceptionHandlerFactory extends javax.faces.context.ExceptionHandlerFactory {

    static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandlerFactory.class);
    private final javax.faces.context.ExceptionHandlerFactory parent;

    /**
     * Create a new JSFExceptionHandlerFactory instance using the given ExceptionHandlerFactory as parent to
     * delegate.
     *
     * @param aParent The parent ExceptionHandlerFactory which will provide the default ExceptionHandler
     * implementation.
     */
    public CustomExceptionHandlerFactory(final javax.faces.context.ExceptionHandlerFactory aParent) {
        super();
        this.parent = aParent;
    }

    /**
     * @return A new JSFExceptionHandler with a wrapped ExceptionHandler provided by the given parent
     * JSFExceptionHandlerFactory.
     */
    @Override
    public ExceptionHandler getExceptionHandler() {
        LOGGER.info("!!!!!!! ExceptionHandler Init !!!!!!!");
        ExceptionHandler result = new CustomExceptionHandler(parent.getExceptionHandler());
        return result;
    }
}
