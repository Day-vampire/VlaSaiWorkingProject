package com.example.JobProject.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(MyAnnotationForLog)")
    public void callMyAnnotationForLog() {}

    @Around("callMyAnnotationForLog()")
    public Object MyMethodTimeAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        System.out.println("\n ######################################################################################################## EXECUTION TIME ##########################################################################################################\n");
        logger.info("Method {} executed in {} ms", joinPoint.getSignature(), executionTime);
        System.out.println("\n ##################################################################################################################################################################################################################################\n");
        return proceed;
    }
}