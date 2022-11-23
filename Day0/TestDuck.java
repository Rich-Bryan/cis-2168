public class TestDuck {
    public static void main(String[] args) {
        Duck duck = new Duck();
        System.out.println(duck.getAge());

        duck.setAge(8);
        System.out.println(duck.getAge());
    }
}
