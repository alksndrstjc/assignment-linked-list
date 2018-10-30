
public class Main {

    // linked list's head
    public static Node head;
    // linked list has reference loop
    public static boolean loopPresent = false;
    // a pointer that moves one node at a time
    public static Node walker;
    // a pointer that moves two nodes at a time
    public static Node jumper;

    public static void main(String[] args) {

        // intializing linked list with a reference loop on the fifth node
        Node n1 = new Node(1);
        head = n1;
        Node n2 = new Node(2);
        n1.next = n2;
        Node n3 = new Node(3);
        n2.next = n3;
        Node n4 = new Node(4);
        n3.next = n4;
        Node n5 = new Node(5);
        n4.next = n5;
        Node n6 = new Node(6);
        n5.next = n6;
        Node n7 = new Node(7);
        n6.next = n7;
        Node n8 = new Node(8);
        n7.next = n8;
        Node n9 = new Node(9);
        n8.next = n9;
        n9.next = n5;
        // ending initialization (it's not as good but i only needed linked list implementation insofar as it helped me test the solution)

        // if there is a loop walker and jumper pointers are bound to meet at a certain point in the linked list's loop
        // this method simply sets the value of 'loopPresent'
        isLoopPresent();
        // 'loopLength' returns the length of the referential loop
        System.out.println(loopLength());

    }

    public static void isLoopPresent() {
        // pointers are set at the start of the list
        walker = head;
        jumper = head;

        // while neither of them haven't reached the end of the list
        while (walker != null && walker.next != null) {
            // make walker move one node
            walker = walker.next;
            // make walker move two nodes
            jumper = jumper.next.next;

            // if walker and jumper are pointing to the same node then there is a loop
            // we must make sure we break out of the loop for the rest of the solution to work!
            if (walker == jumper) {
                loopPresent = true;
                break;
            }
        }
    }

    public static int loopLength() {
        // loop must be present, else return -1 per problem specification
        if (!loopPresent) {
            return -1;
        }
        // we know there is a loop because the pointers have met
        // at that moment we only need one of the pointers to move one node at a time and count passes until the pointers meet again
        // to calculate the loop's length

        // note that we can calculate the loop's length without knowing where the head of the loop is
        int count = 0;
        do {
            walker = walker.next;
            count++;
        } while (walker != jumper);
        return count;
    }
}
