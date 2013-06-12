package de.synaxon.jsfsamples.cdi;

import java.util.Random;
import javax.enterprise.inject.Alternative;

/**
 *
 * @author Karl Spies
 */
@Alternative
public class NotRandomGenerator implements Generator {

    @Override
    public Random getRandom() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
