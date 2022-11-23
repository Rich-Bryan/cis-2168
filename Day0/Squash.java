import java.util.Arrays;

public class Squash {
    public static void main(String[] args) {
        int[] a = {0,0,0,0,0,1,1,0,0,0,7,7,7,1,1,0};
        int[] b = {0};
        System.out.println(squash(a));

    }
    public static String squash(int[] arr) {
        int[] new_arr = new int[arr.length];

        //if the arr only has one item
        if (arr.length<=1){
            return Arrays.toString(arr);
        }
        int j=0;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] != arr[i - 1]) {
                new_arr[j] = arr[i-1];
                j++;
            }
            //System.out.println("change: "+Arrays.toString(new_arr));

        }
        //add the last item in to the array
        new_arr[j] = arr[arr.length-1];
        j++;
        // adding the left over in the array with -1
        int diff = arr.length-j;
        for(int i =0; i < diff; i++){
            new_arr[new_arr.length-i-1] = -1;
        }
        return Arrays.toString(new_arr);
    }
}
