class number{
    private int n;

    public void setN(int n){
        this.n = n;
    }
    public int getN(){
        return this.n;
    }

}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        number number = new number();
        number.setN(10);
        System.out.println(number.getN());

    }
}