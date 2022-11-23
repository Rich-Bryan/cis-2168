public class Reverser {
    public int[] reverse(int[] nums) {

        for(int i = 0; i < nums.length/2; i++){
            exch(nums,i,nums.length-1-i);
        }
        return nums;


        //return new int[] {}; // change this line
    }

    private void exch(int[] a, int i, int j){
        // exchanges the elements at positions i and j in array a
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}
