import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        SLListSimple<Integer> list = new SLListSimple<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        Iterator<Integer> iterator = list.iterator();
        System.out.println("Try next method");
        while(iterator.hasNext()){
            Integer k = iterator.next();
            System.out.println(k + "");
        }
        System.out.println("/n Try iterator method");
        for(Integer integer: list){
            System.out.println(integer + " ");
        }

    }
}