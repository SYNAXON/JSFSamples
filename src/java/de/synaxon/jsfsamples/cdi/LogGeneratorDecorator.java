package de.synaxon.jsfsamples.cdi;

import java.util.Random;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author Karl Spies
 */
@Decorator
public abstract class LogGeneratorDecorator implements Generator {

    @Inject
    @Delegate
    @Any
    Generator generator;
    @Inject
    Logger log;

    @Override
    public Random getRandom() {
        log.info("Should be called after the interceptor!");
        return generator.getRandom();
    }
}
