public class TestIn {
   public static void main(String[] args) {
      In in = new In("movieInfo.txt");
      String line;
      String[] tokens;
      while (in.hasNextLine()) {
         line = in.readLine();
         System.out.println(line);
      }

      // add more tests below
   }
}
