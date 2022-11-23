public class Exercise83 {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
    // adding node
    public static LinkedList addNode(LinkedList first, int val){
        LinkedList cur = first;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = new LinkedList(val);
        return first;
    }
    //remove duplicate from the linked-list
    //exercise 8.3
    public static LinkedList removeDu(LinkedList first){
        LinkedList cur = first;
        while(cur.next != null){
            if(cur.value == cur.next.value){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return first;
    }
    public static void print(LinkedList first){
        LinkedList cur = first;
        while(cur != null){
            System.out.print(cur.value + " -> ");
            cur = cur.next;
        }
        System.out.println("null");

    }


    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);

        addNode(head,1);
        addNode(head,2);
        addNode(head,3);
        addNode(head,3);
        addNode(head,5);

        print(head);
        removeDu(head);

        print(head);



    }

}
