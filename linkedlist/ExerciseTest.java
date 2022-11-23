import org.w3c.dom.Node;

public class ExerciseTest {
    public static void main(String[] args) {
        //Exercise<Integer? list = new Exercise<>();
        Exercise<String> list = new Exercise<>();

        list.addFirst("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");

        Exercise<Integer> list1 = new Exercise<>();
        list1.addFirst(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);

        System.out.println(list);
        System.out.println(list1);
        System.out.println();


        System.out.println(list.find(list,"6"));

        list1.delete(2);

        System.out.println(list1);
    }
}
