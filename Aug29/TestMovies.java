import java.util.*;

public class TestMovies {
   List<MovieInfo> movieList = new ArrayList<>();

   public static void main(String[] args) {

      new TestMovies().go();
   }

   public void go() {
      populateList();
      System.out.println("Movies, Unsorted:");
      System.out.println(movieList); //output as read from file

      Collections.sort(movieList);
      System.out.println("\nMovies, Sorted by Title:");
      System.out.println(movieList); //output as sorted by title

      MovieInfo.GenreOrder gs = new MovieInfo.GenreOrder();
      Collections.sort(movieList, gs);
      System.out.println("\nMovies, Sorted by Genre:");
      System.out.println(movieList);

      MovieInfo.ActorOrder ao = new MovieInfo.ActorOrder();
      Collections.sort(movieList,ao);
      System.out.println("\nMovies, Sorted by Actor:");
      System.out.println(movieList);

   }

   public void populateList() {
      // read the file, create MovieInfo instances, and
      // populate the ArrayList movieList with these instances
      In in = new In("movieInfo.txt");
      String line;
      String[] tokens;
      //token[0] = name, token[1] = genre, token[2] = Actor name
      while (in.hasNextLine()) {
         // YOUR CODE HERE
         line = in.readLine();
         //split the token into 3 part
         tokens = line.split("/");
         //adding the item inside the array list
         movieList.add(new MovieInfo(tokens[0], tokens[1], tokens[2]));
      }
   }

}
