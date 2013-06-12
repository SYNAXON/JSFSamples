package de.synaxon.jsfsamples;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Karl Spies
 */
public class LifeCycleListener implements PhaseListener {

    static final Logger LOGGER = LoggerFactory.getLogger(LifeCycleListener.class);
    private static final long serialVersionUID = 1L;

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    @Override
    public void beforePhase(PhaseEvent e) {
        LOGGER.info("BEFORE PHASE: " + e.getPhaseId());
    }

    @Override
    public void afterPhase(PhaseEvent e) {
        LOGGER.info("AFTER PHASE: " + e.getPhaseId());
    }
}
