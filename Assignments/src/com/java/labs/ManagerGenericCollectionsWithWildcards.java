import java.util.Collection;
import java.util.ArrayList;

public class ManagerGenericCollectionsWithWildcards <E>{

    private Collection<?> items;
    public void addItemsToCollection(Collection<E> items) {
        this.items = items;
    }

    public Collection<?> getItems() {
        return items;
    }

    public void printItems(Collection<?> items) {
        for (Object item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        ManagerGenericCollectionsWithWildcards manager = new ManagerGenericCollectionsWithWildcards();

        Collection<Integer> intCollection = new ArrayList<>();
        intCollection.add(1);
        intCollection.add(2);
        intCollection.add(3);

        manager.addItemsToCollection(intCollection);
        System.out.println("Printing Integer Collection:");
        manager.printItems(manager.getItems());

        Collection<String> stringCollection = new ArrayList<>();
        stringCollection.add("Apple");
        stringCollection.add("Banana");

        manager.addItemsToCollection(stringCollection);
        System.out.println("\nPrinting String Collection:");
        manager.printItems(manager.getItems());
    }
}