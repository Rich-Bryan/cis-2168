/* A simplified implementation of the linked list data structure.
 *  This version allows clients to add or remove items from the
 *  beginning or the end of the list only.                          */
import javax.accessibility.AccessibleValue;
import java.util.NoSuchElementException;
import java.util.Iterator;
public class SLListSimple<E> implements Iterable<E>{
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

   }
    // add last in constant time
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

   /* removes and returns the first element from the list */
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

   /* removes and returns the last element from the list */
   public E removeLast() {
       if(isEmpty()) throw new NoSuchElementException("list is empty");
       E removed = (E) last.data;
       if (first == last) {//if the list only have one element
           first = null;
           last = null;
       }else{
           Node current = first;
           while(current.next != last){// check when the cur.next is at the end
               current = current.next;
           }
           last = current; // current is the new last item
           current.next = null;
       }
       n--;
       return removed;

   }

   /* returns true if the list is empty, false otherwise */
   public boolean isEmpty() {
       return n == 0;
   }

   /* returns the size of this list */
   public int size() {return n;}

    public Iterator<E> iterator() { return new LinkedIterator(); }
    private class LinkedIterator implements Iterator<E> {
       private Node current = first;
       public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException(); }
        public E next() {
        if (!hasNext()) throw new NoSuchElementException();
        E value = (E) current.data;
        current = current.next;
        return value;
       }
    }

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
