import java.util.ArrayList;

public class ArrayListExercise {
    public static void main(String[] args) {
        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("one");
        arrList.add("two");
        arrList.add("three");
        arrList.add("four");

        for(int i = arrList.size()-1; i >= 0; i--){
            arrList.add(i,"+");
        }
        System.out.println(arrList);

    }
}
