public class Node<E> {
    //create the class node of the linked list
    E data;
    Node next;
    //create the constructor
    Node(E e){
        this(e,null);
    }
    Node(E e, Node node){
        data = e;
        next = node;
    }

}
