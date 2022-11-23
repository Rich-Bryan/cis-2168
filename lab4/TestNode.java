public class TestNode {
    public static void main(String[] args) {
//        Node last = new Node(5);
//        Node middle = new Node(1,last);
//        Node first = new Node(2,middle);

        //to -> be -> or -> not -> to -> be ->.
        //String
        Node last = new Node("be");
        Node fifth = new Node("to", last);
        Node forth = new Node("not", fifth);
        Node third = new Node("or", forth);
        Node second = new Node("be",third);
        Node first = new Node("to", second);



        //print the nodes
        for(Node x = first; x != null; x = x.next){
            System.out.print(x.data + " -> ");
        }
        //System.out.println("null");

    }
}
