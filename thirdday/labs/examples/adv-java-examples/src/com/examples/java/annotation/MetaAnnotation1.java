package com.examples.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface MetaAnnotation1 {

//    Element Types

//    TYPE (class, interface, enum)
//    FIELD (instance variables)
//    METHOD (methods)
//    PARAMETER (parameters)
//    CONSTRUCTOR (constructors)
//    LOCAL_VARIABLE (local variables)
//    ANNOTATION_TYPE (another annotation)
//    PACKAGE (package declarations)
//    TYPE_USE (type annotations)
//    MODULE (module declarations)
}
