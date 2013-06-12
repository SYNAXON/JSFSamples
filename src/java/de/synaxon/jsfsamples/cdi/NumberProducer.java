package de.synaxon.jsfsamples.cdi;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class NumberProducer implements Serializable {

    @Inject
    private Generator generator;
    private int maxNumber = 100;

    @Produces
    @Random
    int next() {
        return generator.getRandom().nextInt(maxNumber);
    }

    @Produces
    @MaxNumber
    int getMaxNumber() {
        return maxNumber;
    }
}
