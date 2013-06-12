package de.synaxon.jsfsamples;

import javax.faces.application.Application;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

/**
 *
 * @author Karl Spies
 */
public class ApplicationListener implements SystemEventListener {

    /**
     * {@inheritDoc}
     */
    @Override
    public void processEvent(SystemEvent event) {
        System.out.println("=========>    ApplicationListener called from: " + event.getClass().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isListenerForSource(Object source) {
        boolean result;
        result = (source instanceof Application);
        return result;
    }
}
