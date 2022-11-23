import java.util.Arrays;
import java.util.Random;

public class Lottery {
    public static void main(String[] args) {
        int n = 49;
        int k = 6;
        int[] numbers = new int[n];
        //to store the lottery result
        int[] result = new int[k];

        //creating the 49 numbers
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = i+1;

        }
        for(int i = 0; i< result.length; i++){
            int r = (int)(Math.random()*n);
            // pick the elements at random location of the numbers array
            result[i] = numbers[r];
            //moe the last elements of the numbers array to this randomly generated location
            numbers[r] = numbers[n-1];
            n--;


        }
        System.out.println(Arrays.toString(numbers));
        System.out.println("result: "+Arrays.toString(result));


    }
}
