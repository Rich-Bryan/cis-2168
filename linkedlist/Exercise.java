import java.util.NoSuchElementException;

public class Exercise <E>{
    private Node<E> first;   // reference to the first node
    private int n;           // the number of items on this list
    private Node<E> last; // reference to the last node

    /* Node is a static nested class. Node is private because list clients
       need not manipulate nodes directly (or even know about them)    */
    private static class Node<E> {
        private E data;
        private Node<E> next;
    }
    /* adds an item to the front of the list */
    public void addFirst(E item) {
        Node oldFirst = first;
        first = new Node<>();
        first.data = item;
        if(isEmpty()){
            last = first;
        }else{
            first.next = oldFirst;
        }
        n++;

    } // TODO
    public void addLast(E value){
        if(isEmpty()){
            addFirst(value);
        }else{
            Node oldLast = last;
            last = new Node<>();
            last.data = value;
            oldLast.next = last;
        }
        n++;
    }
    public E removeFirst() {
        if(isEmpty()) {throw new NoSuchElementException("list is empty. Bye");}
        E removeValue = first.data;
        if(first == last){ // if there is one node
            first = null;
            last = null;
        }else { // shift the pointer from the first to the second
            first = first.next;
        }
        n--;
        return removeValue;
    } // TODO

    //9.1 (b)
    public E removeLast() {
        if (isEmpty()) throw new NoSuchElementException("list is empty");
        E removed = (E) last.data;
        if (first == last) {//if the list only have one element
            first = null;
            last = null;
        } else {
            Node current = first;
            while (current.next != last) {// check when the cur.next is at the end
                current = current.next;
            }
            last = current; // current is the new last item
            current.next = null;
        }
        n--;
        return removed;
    }
    //9.1 (d)
    public void delete(int k){
        Node cur = first;
        if(isEmpty()){ //check if the list is empty
            throw new NoSuchElementException("list is empty");
        }
        if(k > size()){// check if int k is greater than the size of the list
            System.out.println("k is too big");
        }

        if(k == 1){ // if k is at the first node, shift to the next node
            if(size() == 1){ // if the size is equal to one
                first = null;
                System.out.println("null");
                return;
            }else {
                first = first.next;
                return;
            }
        }
        for(int i = 1; cur != null && i < k-1; i++){ // check which node to remove
            cur = cur.next;
        }

        cur.next = cur.next.next; // remove the kth node
        n--;
    }
    //9.1 (f)
    public boolean find(Exercise<E> head,String key){
        Node cur = first;
        if(isEmpty()){ //check if the list is empty
            throw new NoSuchElementException("list is empty");
        }
        while(cur != null){
            if(cur.data == key){ // check if we found the key inside the node
                return true;
            }
            cur = cur.next;
        }
        return false;

    }

    public boolean isEmpty() {
        return n == 0;
    }

    /* returns the size of this list */
    public int size() {return n;}

    /* returns a String representation of this list */
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (isEmpty()) return "This list is empty ";
        Node current = first;
        while (current != null) {
            s.append(current.data + " -> ");
            current = current.next;
        }
        return s.toString();
    }
}
