public class TestLemur {
    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);

        Primate primate = lemur;
        System.out.println(((Lemur)primate).age);
        System.out.println(primate.hasHair());
        System.out.println(((Lemur)primate).isTailStriped());

        HasTail hasTail = lemur;
        //System.out.println(hasTail.age);
        System.out.println(hasTail.isTailStriped());
        System.out.println(((Lemur)hasTail).age);
        System.out.println(((Lemur)hasTail).hasHair());
    }
}
