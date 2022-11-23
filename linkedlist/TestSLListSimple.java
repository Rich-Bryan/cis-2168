public class TestSLListSimple {
   public static void main(String[] args) {
      SLListSimple<Integer> list = new SLListSimple<>();
      //list.removeFirst();  // should throw an Exception
      //list.removeLast();   // should throw an Exception
      //list.addFirst(5); // 5 ->
      //list.addFirst(7); // 7 -> 5 ->
      //list.addLast(8); // 7 -> 5 -> 8 ->
      list.addFirst(5);
      list.addLast(10);
      list.addLast(59);
      list.addLast(40);
      for (Integer element : list)
         System.out.print(element + " "); // prints list contents
      list.removeLast();
      //System.out.println(list.size());
      System.out.println(list);
   }
}
