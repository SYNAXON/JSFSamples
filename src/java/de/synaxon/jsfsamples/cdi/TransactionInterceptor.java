package de.synaxon.jsfsamples.cdi;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;

/**
 *
 * @author Karl Spies
 */
@Transactional
@Interceptor
public class TransactionInterceptor {

    @Inject
    Logger log;

    @AroundInvoke
    public Object manageTransaction(InvocationContext ctx) throws Exception {
        log.info(ctx.getMethod().getName() + " => " + ctx.getMethod().getDeclaringClass().getName());
        Object obj = ctx.proceed();
        log.info(ctx.getMethod().getName() + " => " + ctx.getMethod().getDeclaringClass().getName());
        return obj;

    }
}
