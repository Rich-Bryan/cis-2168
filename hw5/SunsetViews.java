import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SunsetViews {
    /*loop thru the direction in the sun
    start i = 0
    add index height[0] to stack
    index = 1
    if height[1] >= peek()
        yes : pop(); add(1)
    index = 2
        if height[2] >= peek()
                No: so push(2)
    index = 3
        yes : pop(), add(3)

     */
    //while(maxHeight < height.length)

    public List<Integer> sunsetViews(int[] buildings, String direction) {
        Stack<Integer> sunFacing  = new Stack<>();

        //if the building is empty
        if(buildings.length < 1){// check if the building size is less than 1 we return empty
            return sunFacing;
        }
        // east
        int i = 1;
        sunFacing.push(0); // add the first item onto the stack

        if(direction.equals("EAST")) {
            while (i < buildings.length) {
                //check if the top stack is < buildings[i] until is not
                while(!sunFacing.isEmpty() && buildings[sunFacing.peek()] <= buildings[i]) {
                    sunFacing.pop();
                }
                sunFacing.push(i);
                i++;
            }
        }else if(direction.equals("WEST")) {
            //west
            while (i < buildings.length) {
                if (buildings[i] > buildings[sunFacing.peek()]) {
                    sunFacing.push(i);
                }
                i++;
            }
        }

        return sunFacing;
    }

    // a couple of test cases for the sunsetViews() method
    public static void main(String[] args) {
        SunsetViews solution = new SunsetViews();
        // test 1
        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};
        System.out.println(solution.sunsetViews(buildings, "EAST")); // prints [1, 3, 6, 7]
        System.out.println(solution.sunsetViews(buildings, "WEST")); // prints [0, 1]

        // test 2
        buildings = new int[]{0, 1};
        System.out.println(solution.sunsetViews(buildings, "EAST")); // prints [1]
        System.out.println(solution.sunsetViews(buildings, "WEST")); // prints [1]

        // test 3
        buildings = new int[]{};
        System.out.println(solution.sunsetViews(buildings, "EAST")); // prints []
        System.out.println(solution.sunsetViews(buildings, "WEST")); // prints []

        // test 4
        buildings = new int[]{1, 2, 3, 1, 5, 6, 9, 1, 9, 9, 11, 10, 9, 12, 8};
        System.out.println(solution.sunsetViews(buildings, "EAST")); // prints [13, 14]
        System.out.println(solution.sunsetViews(buildings, "WEST")); // prints [0, 1, 2, 4, 5, 6, 10, 13]
    }


}
