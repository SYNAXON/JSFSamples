package de.synaxon.jsfsamples.behavior;

import javax.faces.component.behavior.ClientBehaviorBase;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.FacesBehavior;

/**
 *
 * @author karl spies
 */
@FacesBehavior("de.synaxon.jsfsamples.behavior.KarlArsch")
public class ConfimBehavior extends ClientBehaviorBase {

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        return "confirm('Sind sie sicher');";
    }
}
