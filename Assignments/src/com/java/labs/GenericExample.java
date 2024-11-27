public class GenericExample{
    public static <T> void PrintArray(T[] array)
    {
        for(T element : array)
        {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static <T>T pickany(T a, T b)
    {
        return a;
    }
    public static <T extends Number> double sum(T a , T b)
    {
        return a.doubleValue()+b.doubleValue();
    }
    public static void main(String[] args)
    {
        Integer in[] = {1,5,9};
        String str[] = {"learn","java"};
        PrintArray(in);
        PrintArray(str);
        String result = pickany("Sam","artha");
        System.out.println(result);
        System.out.println(sum(3.3,4.8));
    }
}