package de.synaxon.jsfsamples;

import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author Karl Spies
 */
public class ClickCounter implements ActionListener {

    /**
     * {@inheritDoc}
     */
    @Override
    public void processAction(ActionEvent event) {
        System.out.println("ActionListener Class called from: " + event.getComponent().getClientId());
    }
}
