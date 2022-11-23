import java.util.ArrayList;
import java.util.List;

public class second {
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

    }
    public static List<Integer> zigzag(List<List<Integer>> matrix){
        //storing the result
        List<Integer> result = new ArrayList<>();
        //height and the width of the matrix;
        int height = matrix.size()-1;
        int width = matrix.get(0).size()-1;
        //check if we are going down
        boolean goingDown = true;

        //keep track of the position
        int row = 0;
        int col = 0;
        // loop through while we are not out of bounds
        /*
        [1,2,3]
        [4,5,6]
        [7,8,9]
         */
        while(!OutOfBound(row,col,height,width)){
            result.add(matrix.get(row).get(col));
            if(goingDown){
                //this check to go down or right
                if(col == 0 || row == height){
                    goingDown = false;
                    if(col == 0){
                        row++; // down
                    }else{
                        col++;//right
                    }
                }else{
                    row++;//down
                    col--;//left
                }

                //for going up
            }else{
                if(row == 0 || col ==width){
                    goingDown = true;
                    if(col == width){
                        row++;//down
                    }else{
                        col++;//right
                    }
                }else{
                    row--;//up
                    col++;//right
                }
            }

        }
        return result;
    }

    public static boolean OutOfBound(int row, int col, int height, int width){
        return row < 0 || row > height || col < 0 || col>width;
    }
}
