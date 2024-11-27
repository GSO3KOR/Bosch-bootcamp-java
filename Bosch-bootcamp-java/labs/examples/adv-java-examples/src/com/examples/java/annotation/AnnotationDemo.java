package com.examples.java.annotation;

@MetaAnnotation2
@MetaAnnotation3
@MetaAnnotation4
@MetaAnnotation5("Hello")
@MetaAnnotation5("Welcome")
public class AnnotationDemo {

    @MetaAnnotation1
    public void myMethod() {
        System.out.println("Hello, this is myMethod!");
    }

    @Init
    public void initMethod() {
        System.out.println("Hello, this is initMethod!");
    }

    public static void main(String[] args) {
        AnnotationDemo annotationDemo = new AnnotationDemo();
        annotationDemo.myMethod();
        annotationDemo.initMethod();
    }
}