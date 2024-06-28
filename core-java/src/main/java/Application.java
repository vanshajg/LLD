import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 1};
        Arrays.sort(arr, (Integer a, Integer b) -> b - a);
        System.out.println(Arrays.toString(arr));
        String hello = ";";
    }
}
