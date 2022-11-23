import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLibraryMethods {
    public static void main(String[] args) {
        Integer[] intData = {3,2,1};
        System.out.println(Arrays.toString(intData));
        Arrays.sort(intData);
        System.out.println("sorted: "+ Arrays.toString(intData));

        List<Integer> intList = new ArrayList<>(List.of(4,3,2,-9));
        System.out.println("unsorted List: "+ intList);
        Collections.sort(intList);
        System.out.println(intList);

        //string
        List<String> sList = new ArrayList<>(List.of("abv", "zelda", "fail"));
        System.out.println("unsorted," + sList);
        Collections.sort(sList);
        System.out.println(sList);
    }
}
