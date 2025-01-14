package com.example.JobProject.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.JobProject.aspect.MyAnnotationForCallRestriction;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.data.redis.core.RedisTemplate;


import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class CallRestrictionAspect {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Pointcut("@annotation(callRestriction)")
    public void callMyAnnotationForCallRestriction(MyAnnotationForCallRestriction callRestriction) { }

    @Around("callMyAnnotationForCallRestriction(callRestriction)")
    public Object rateLimit(ProceedingJoinPoint joinPoint, MyAnnotationForCallRestriction callRestriction) throws Throwable {
        String key = callRestriction.value();
        if (key.isEmpty()) {
            key = joinPoint.getSignature().getName();
        }

        Long count = redisTemplate.opsForValue().increment(key);
        if (count == 1) {
            redisTemplate.expire(key, callRestriction.duration(), TimeUnit.MILLISECONDS);
        }

        if (count != null && count > callRestriction.limit()) {
            System.out.println("######################################################################################################## RETE LIMIT EXCEEDED ##########################################################################################################");
            throw new RuntimeException("Rate limit exceeded. Please try again later.");
        }

        return joinPoint.proceed();
    }
}