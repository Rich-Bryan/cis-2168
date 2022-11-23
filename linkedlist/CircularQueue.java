import java.util.NoSuchElementException;
//9.2
public class CircularQueue<E>{
        private Node first; //reference to the first node
        private Node last; // references the most recently added Node
        private int n; // number of Nodes in this CircularQueue
        private class Node {
            E data;
            Node next;
        }
        public void enqueue(E element){
            Node oldLast = last;
            last = new Node();
            last.data = element;
            if(isEmpty()) {
                first = last;
            }else{
                oldLast.next = last;
            }
            last.next = first;
            n++;
        }
        public E dequeue(){
            if(isEmpty()){
                {throw new NoSuchElementException("list is empty. Bye");}
            }
            E removed = first.data;
            if(first == last){ // if there is only one node
                first = null;
                last = null;
            }else {
                first = first.next;
                last.next = first;
            }
            n--;
            return removed;
        }
    public void delete(int k){
        Node cur = first;
        Node oldFirst = first;

        if(k == 1){ // if k is at the first node, shift to the next node
            if(size() == 1){ // if the size is equal to one
                first = null;
                last = null;
                System.out.println("null");
                return;
            }else {
                first = first.next; // remove thr first item
                last.next = first; //
            }
        }
        for(int i = 1;i < k-1; i++){ // check which node to remove
            cur = cur.next;
        }

        cur.next = cur.next.next; // remove the kth node
        first = cur.next; // switch the reference of the first
        last = oldFirst; // // switch the reference to last
        n--;
    }
        public boolean isEmpty(){
            return n == 0;
        }
        public int size(){
            return n;
        }
        public void print(){
            Node cur = first;
            while(cur.next != first){
                System.out.print(cur.data + "-> ");
                cur = cur.next;
            }
            System.out.println(cur.data + "-> ");

        }

    public static void main(String[] args) {
        CircularQueue<Integer> list = new CircularQueue<>();
        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);
        list.enqueue(4);
        list.enqueue(5);
        list.enqueue(6);
        list.enqueue(7);
        list.enqueue(8);
        list.enqueue(9);
        list.dequeue();
        list.print();

//        list.delete(5);
//        list.print();
//        list.delete(5);
//        list.print();
//        list.delete(5);
//        list.print();
//        list.delete(5);
//        list.print();
//        list.delete(5);
//        list.print();
//        list.delete(5);
//        list.print();
//        list.delete(5);
//        list.print();
//        list.delete(5);
//        list.print();




    }
}
