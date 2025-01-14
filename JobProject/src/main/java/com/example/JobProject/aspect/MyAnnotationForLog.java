package com.example.JobProject.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//! THIS ANNOTATION IS USED AS A MARKER TO IDENTIFY THE METHOD THAT NEEDS TO BE LOG
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotationForLog {
}
