package com.examples.java.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MetaAnnotation2 {

//    RetentionPolicy.SOURCE: Discarded during compilation and not available in the compiled bytecode.
//    RetentionPolicy.CLASS: Retained in the class file by the compiler but ignored by the JVM (default).
//    RetentionPolicy.RUNTIME: Retained at runtime and available via reflection.
}
