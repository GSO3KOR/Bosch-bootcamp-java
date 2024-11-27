import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

class ManagerGenericCollectionsWithWildcards <E> {

    // Method that accepts a List of objects with a wildcard (any subtype of Number)
    public void printNumbers(List<? extends Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }

    // Method that accepts any List of objects
    public <E> void printItems(List<E> list) {
        for (E item : list) {
            System.out.println(item);
        }
    }

    // Create a new instance of the class using reflection
    public void createInstanceUsingReflection() {
        try {
            // Get the Class object for ManagerGenericCollectionsWithWildcards
            Class<?> clazz = ManagerGenericCollectionsWithWildcards.class;

            // Print class name
            System.out.println("Class Name: " + clazz.getName());

            // Get and print all constructors of the class
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println(" - " + constructor);
            }

            // Create an instance using the default constructor
            ManagerGenericCollectionsWithWildcards instance = (ManagerGenericCollectionsWithWildcards) constructors[0].newInstance();
            System.out.println("\nNew instance created using default constructor: " + instance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ManagerGenericCollectionsWithWildcards manager = new ManagerGenericCollectionsWithWildcards();

        // Example usage of printNumbers method with wildcard
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        manager.printNumbers(integerList);

        // Example usage of printItems method with generics
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        manager.printItems(stringList);

        // Create an instance using reflection
        manager.createInstanceUsingReflection();
    }
}
