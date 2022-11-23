import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int i = 4;
        int j = -9;
        int Y = j-i;
        while(i > j){
            if(Y %2 ==0){
                Y = 7+Y;
            }else{
                Y += 1;
            }
            i--;
            j = j + 3;
        }
        System.out.println((Y));
    }
}