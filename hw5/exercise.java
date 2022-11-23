import java.util.ArrayList;
import java.util.List;

public class exercise {
    List<Integer> moveToEnd(List<Integer> list, int b) {
        /* YOUR CODE HERE */
        if(list.isEmpty()){
            return list;
        }
        int count = 0;

        for (int i=0; i<list.size() ;i++){
            if (list.get(i) == b){ // check if the cur item is == to b then increase count
                count++;
            }
            else {
                int t = list.get(i); // store the temp item that is not b that is not b and switch with the b
                list.set(i,b);
                list.set(i-count,t);
            }
        }

        return list; // return the modified list
    }

    public static void main(String[] args) {
        exercise yer = new exercise();
        List<Integer> list = new ArrayList<>(List.of(2, 1, 2, 2, 2, 6, 8, 2));
        System.out.println(yer.moveToEnd(list, 2));
        ///[1, 6, 8, 2, 2, 2, 2, 2]

        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4));
        System.out.println(yer.moveToEnd(list1, 3));
        //[1,2,4,3]

    }
}
