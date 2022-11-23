public class ElectingLeader<E> {

    public static void main(String[] args) {
        int n = 9; // n = 1000000;
        int m = 5; // m = 10;
        //answer is 8

//        int n = 1000000;
//        int m = 10;
        //answer is 630 538

//        int n = 7;
//        int m = 2;
        //answer is 7
        CircularQueue<Integer> circle = new CircularQueue<>();
        for(int i = 1; i <= n; i++){ //place people in the circle
            circle.enqueue(i);
        }
        circle.print();

        for(int i = n; i != 1; i--){
            circle.delete(m);
        }
        circle.print();
    }





}
