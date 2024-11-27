public class MyAnnotation {
    @CustomAnnot(value = "My method") // Corrected annotation syntax
    public void myMethod() {
        System.out.println("Executing annotated method!");
    }

    public static void main(String[] args) throws Exception {
        // Reflectively access and use the annotation
        MyAnnotation obj = new MyAnnotation();
        obj.myMethod();

        // Access annotation value via reflection
        CustomAnnot annotation = obj
                .getClass()
                .getMethod("myMethod")
                .getAnnotation(CustomAnnot.class);
        System.out.println("Annotation Value: " + annotation.value());
    }
}
