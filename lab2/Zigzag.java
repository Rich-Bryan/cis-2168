import java.util.ArrayList;
import java.util.List;

public class Zigzag {
    public static void main(String[] args) {
        List<List<Integer>> table;
        List<Integer> result;

        List<Integer> row1, row2, row3, row4, row5, row6;
        /*------------- START TEST 1 ---------------*/
        row1 = new ArrayList<>(List.of(1, 3, 4, 7));
        row2 = new ArrayList<>(List.of(2, 5, 6, 8));
        table = new ArrayList<>(List.of(row1, row2));
        result = zigzag(table);
        System.out.println("Test 1 result: \n\t " + result + "\n"); // [ 1, 2, 3, 4, 5, 6, 7, 8 ]

        /*------------- START TEST 2 ---------------*/
        row1 = new ArrayList<>(List.of(1, 3, 4, 10));
        row2 = new ArrayList<>(List.of(2, 5, 9, 11));
        row3 = new ArrayList<>(List.of(6, 8, 12, 15));
        row4 = new ArrayList<>(List.of(7, 13, 14, 16));
        table = new ArrayList<>(List.of(row1, row2, row3, row4));
        result = zigzag(table);
        System.out.println("Test 2 result: \n\t " + result + "\n");  // should print [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]

        /*------------- START TEST 3 ---------------*/
        row1 = new ArrayList<>(List.of(1)); // [1]
        table = new ArrayList<>(List.of(row1));
        result = zigzag(table);
        System.out.println("Test 3 result: \n\t " + result + "\n");  // should print [1]
        /*
        [1,3,4,10]
        [2,5,9,11]
        [6,8,12,15]
        [7,13,14,16]
         */
        /*
        [1,2,3]
        [4,5,6]
        [7,8,9]
         */

    }

    public static List<Integer> zigzag(List<List<Integer>> matrix) {
        // YOUR CODE HERE
        //new arraylist to store the result
        List<Integer> result = new ArrayList<>();
        //check if the array is empty
        if (matrix.size() <= 0) {
            return result;
        }
        // finding the row and columns
        int row = matrix.size();
        int col = matrix.get(0).size();
        int sizeOfArray = row * col;
        //get the starting point for the row(y) and col(x)
        int x = 0, y = 0;

        //use a while loop
        while (result.size() < sizeOfArray) {
            result.add(matrix.get(y).get(x));
            //check if the indexes are even
            int sum = x + y;
            boolean isEven = sum % 2 == 0;
            //EVEN Index
            if (isEven) {
                //if we have space to go down and left
                if (y < row - 1 && x > 0) {
                    y++; // to down
                    x--; // to left
                    //if we don't have space to go left, we go down
                } else if (y < row - 1) {
                    y++; // down
                    //if we don't have space for either, we go right
                } else {
                    x++; //right
                }
                //ODD Index
            } else {
                // if we have space to go right and up
                if (x < col - 1 && y > 0) {
                    x++;//right
                    y--;//up
                }
                //if we don't have space to go up, we to right
                else if (x < col - 1) {
                    x++; //right
                }
                //if we don't have space for either
                else {
                    y++;//down
                }
            }
        }
        return result;
    }

}
