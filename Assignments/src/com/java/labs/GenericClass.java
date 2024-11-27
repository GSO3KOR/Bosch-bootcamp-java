public class GenericClass<T> {
    private T data;

    public GenericClass(T data)
    {
        this.data = data;
    }

    public T getData()
    {
        return data;
    }

    public static void main(String[] args)
    {
        GenericClass<String> str = new GenericClass<>("Hello");
        System.out.println(str.getData());
        GenericClass<Integer> integ = new GenericClass<>(3);
        System.out.println(integ.getData());
    }
}
