package de.synaxon.jsfsamples.cdi;

import java.util.Random;

/**
 *
 * @author Karl Spies
 */
public class RandomGenerator implements Generator {

    private Random random = new Random(System.currentTimeMillis());

    @Override
    @Transactional(requiresNew = false)
    public Random getRandom() {
        return random;
    }
}
