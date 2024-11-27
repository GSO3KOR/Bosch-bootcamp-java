
import java.util.ArrayList;
import java.util.List;

public class pecsExample {
    public static void printList(List<? extends Number> list)
    {
        for(Number num : list )
            System.out.println(num);
    }

    public static  void addToList(List<? super Integer> list)
    {
        list.add(123);
    }

    public static void main(String[] args)
    {
        List<Integer> intList = List.of(1,2,3);
        printList(intList);

        List<Object> objList = new ArrayList<>();
        addToList(objList);
        System.out.println(objList);
    }
}
