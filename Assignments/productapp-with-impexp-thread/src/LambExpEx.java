import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.Arrays;

public class LambExpEx {
    public static void main(String[] args){
        BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;
        int x = 10;
        int y = 20;
        System.out.println(isSumEven.test(x, y));

        Predicate<Integer> isNotPrime = n -> {
            if (n < 2) return true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return true;
            }
            return false;
        };

        int num = 17;
        System.out.println(isNotPrime.test(num));

        num = 18;
        System.out.println(isNotPrime.test(num));

        Function<Integer[], Integer> sumOfSquares = (arr) -> {
            int sum = 0;
            for (int n : arr) {
                if (n % 2 == 0) {
                    sum += n * n;
                }
            }
            return sum;
        };

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int result = sumOfSquares.apply(numbers);
        System.out.println("Sum of squares of even numbers: " + result);

        String[] words = {"Hello", "bosch", "welcome", "to", "java"};

        BiConsumer<String[], String[]> sortByLength = (arr1, arr2) -> {
            Arrays.sort(arr1, (str1, str2) -> Integer.compare(str1.length(), str2.length()));
        };

        sortByLength.accept(words, words);

        Consumer<String[]> printArray = (arr) -> {
            System.out.println("Sorted Array: " + Arrays.toString(arr));
        };

        printArray.accept(words);

        String str1 = "Hello";
        String str2 = "Bosch";

        BiConsumer<String, String> compareStrings = (s1, s2) -> {
            int res = s1.compareTo(s2);
            System.out.println("Comparison result: " + res);
        };

        compareStrings.accept(str1, str2);
        compareStrings.accept("Hello", "Hello");
        compareStrings.accept("All", "Bosch");
    }
}
