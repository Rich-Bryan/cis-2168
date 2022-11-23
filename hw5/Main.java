public class Main extends Building {
    public Main() { System.out.print("h "); }
    public Main(String name) {
        this();
        System.out.print("hn " + name);
        }
 public static void main(String[] args) { new Main("x "); }
 }
 class Building {
 public Building() { System.out.print("b "); }

 public Building(String name) {
         this();
         System.out.print("bn " + name);
         }
}