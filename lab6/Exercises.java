import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exercises {
    public static void queueToStack(Queue<Integer> q, Stack<Integer> stack) {
        while (!q.isEmpty()) {
            int n = q.remove();
            stack.push(n);
        }
    }
    //11.3
    //Write a similar method called stackToQueue that receives a reference to a stack and a
    //reference to a queue and moves all stack elements to the queue.
    public static void stackToQueue(Queue<Integer> q , Stack<Integer> stack){
        while(!stack.isEmpty()){
            int n = stack.pop();
            q.add(n);
        }
    }
    //11.4
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= 5 ; i++)
            queue.add(i);
        System.out.println(queue); // [1, 2, 3, 4, 5]

        System.out.println(sum(queue)); // What prints here? Why? // the size of the queue decrease,
        System.out.println(queue); // What prints here? Why? whatever the queue is left with
    }

//    public static int sum(Queue<Integer> q) {
//        int sum = 0;
//        for (int i = 0; i < q.size(); i++) {
//            int n = q.remove();
//            sum += n;
//        }
//        return sum;
//    }

    //Fix the problem with the code fragment in Exercise 11.4: Write a
    //method called sum that sums the elements of a queue. The output of your program
    //should be as shown in the comments on lines 9 and 10 of the following code fragment:
    //1 import java.util.*
    public static int sum(Queue<Integer> q) {
        int sum = 0;
        // sun = 15
        // queue = [1, 2, 3, 4, 5]
        for (int i = 0; i < q.size(); i++) {
            int n = q.remove();
            sum += n;
            q.add(n); // add the value back

        }
        return sum;
    }

}
