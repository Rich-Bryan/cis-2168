import java.util.Arrays;

public class TestReverse {
    public static void main(String[] args) {
        int[] a = {2, 1, 6, 8};
        Reverser reverser = new Reverser();
        int[] aReversed = reverser.reverse(a);
        System.out.println(Arrays.toString(aReversed) ); // [8, 6, 1, 2]
        int[] b = {2, 1, 5};
        int[] bReversed = reverser.reverse(b);
        System.out.println(Arrays.toString(bReversed) ); // [5, 1, 2]


//        TEST
//        int[] a = {1,2,3};
//        System.out.println(a.length/2);
//        for(int i = 0; i < a.length/2; i++){
//            int temp = a[i];
//            a[i] = a[a.length-1-i];
//            a[a.length-1-i] = temp;
//        }
//        System.out.println(Arrays.toString(a));
    }
}


