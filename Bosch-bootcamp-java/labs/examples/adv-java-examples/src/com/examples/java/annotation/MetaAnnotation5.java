package com.examples.java.annotation;


import java.lang.annotation.Repeatable;

@Repeatable(MetaAnnotations.class)
public @interface MetaAnnotation5 {
    String value();

//    Allows the same annotation to be applied multiple times to the same element.
//    To use this, you must define a containing annotation that holds multiple instances of the annotation.
}

@interface MetaAnnotations {
    MetaAnnotation5[] value();
}

// Usage
@MetaAnnotation5("A")
@MetaAnnotation5("B")
class MyClass {
}

