package com.examples.java.annotation;

import java.lang.annotation.Inherited;

@Inherited
public @interface MetaAnnotation4 {
//    Indicates that an annotation on a class will be inherited by its subclasses.
//    It works only with class-level annotations
}

@MetaAnnotation4
class Parent {
}

class Child extends Parent {
    // Child inherits @MyAnnotation4 from Parent
}