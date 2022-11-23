import java.util.Comparator;

public class MovieInfo implements Comparable<MovieInfo>{  // CHANGE THIS LINE TO MAKE THIS CLASS COMPARABLE
   String title;
   String genre;
   String leadActor;

   MovieInfo(String t, String g, String a) {
      title = t; genre = g; leadActor = a;
   }
   public String toString() {

      return title + " " + genre + " " + leadActor + "\n";
   }

   // getters
   public String getTitle() {
      return title;
   }
   public String getGenre( ) {
      return genre;
   }
   public String getActor( ) {
      return leadActor;
   }
   public int compareTo(MovieInfo other1) {
      // YOUR CODE HERE;
      return title.compareTo(other1.getTitle());
   }

   //sort by genre
   public static class GenreOrder implements Comparator<MovieInfo> {
      @Override
      public int compare(MovieInfo movie1, MovieInfo movie2) {
         return movie1.getGenre().compareTo(movie2.getGenre());
      }
   }
   //sort by actor name
   public static class ActorOrder implements Comparator<MovieInfo> {
      @Override
      public int compare(MovieInfo movie1, MovieInfo movie2) {
         return movie1.getActor().compareTo(movie2.getActor());
   }

   }
}
