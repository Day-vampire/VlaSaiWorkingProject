package com.example.JobProject.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//! This my annotation which intended to limit the frequency of calls to controller methods.
//! It uses Redis to store the status of the limits.
//! This will help protect the application from intruders.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotationForCallRestriction {
    String value() default ""; // key for Redis
    int limit() default 5;     // max calls
    long duration() default 30000; // max 5 calls in duration 30sec
}