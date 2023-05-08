package prac21.prac21;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Around(value = "allServiceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        log.info("Method: " + joinPoint.getSignature()
                + " took " + (System.currentTimeMillis() - start) + " mc");
        return proceed;
    }
    @Pointcut(value = "within(prac21.prac21.Services.*)")
    public void allServiceMethods() {}
}