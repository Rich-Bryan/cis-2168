import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {

//        [1, 4, 8, 9, 11, 15, 17, 28, 41, 59]
//        [4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81]
//        output: [4, 11, 17, 28, 59]
        List<Integer> arr1 = new ArrayList<>(List.of(1, 4, 8, 9, 11, 15, 17, 28, 41, 59));
        List<Integer> arr2 = new ArrayList<>(List.of(4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81));
        //System.out.println(intersect(arr1,arr2));
        System.out.println(improvedIntersect(arr1,arr2));
        System.out.println(ReverseCheat(improvedIntersect(arr1,arr2)));
        //System.out.println(ReverseReal(arr1));


    }
    //O(n^2)
    public static List<Integer> intersect(List<Integer> a, List<Integer> b){
        //create the array that stores the unique item
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < b.size(); j++){
                //check the arraylist if we have a same value and add it to the new arraylist
                if(a.get(i) == b.get(j)){
                    result.add(a.get(i));
                }
            }
        }
        return result;
    }
    //O(n)
    public static List<Integer> improvedIntersect(List<Integer> a, List<Integer> b) {
        //create the array that stores the unique item
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < a.size() && j < b.size()){
            if(a.get(i) > b.get(j)){
                j++;
            } else if(a.get(i) < b.get(j)) {
                i++;
            }else{
                result.add(a.get(i));
                i++;
                j++;
            }
        }
        return result;
    }

    public static List<Integer> ReverseCheat(List<Integer> arr){
        Collections.reverse(arr);

        return arr;
    }
    public static List<Integer> ReverseReal(List<Integer> arr){
        for(int i = 0; i < arr.size()/2; i++){
            int temp = arr.get(i);
            arr.set(i, arr.get(arr.size()-1-i));
            arr.set(arr.size()-1-i, temp);
        }
        return arr;
    }
}
