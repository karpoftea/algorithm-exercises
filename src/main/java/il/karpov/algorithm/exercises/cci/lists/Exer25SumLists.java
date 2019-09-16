package il.karpov.algorithm.exercises.cci.lists;

// Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
// The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
// Write a function that adds the two numbers and returns the sum as a linked list.
// EXAMPLE
// Input:(7-> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295. Output:2 -> 1 -> 9. That is, 912.
// FOLLOW UP
// Suppose the digits are stored in forward order. Repeat the above problem.
// EXAMPLE
// Input:(6 -> 1 -> 7) + (2 -> 9 -> 5). That is,617 + 295. Output:9 -> 1 -> 2. That is, 912.
public class Exer25SumLists {

    // todo add FOLLOW UP solution
    public Node sumLists(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        Node r = null, rHead = null;
        boolean overflow = false;
        while (l1 != null || l2 != null) {
            int l1v = l1 == null ? 0 : l1.val;
            int l2v = l2 == null ? 0 : l2.val;
            int s = l1v + l2v + (overflow ? 1 : 0);
            overflow = s >= 10;

            if (r == null) {
                r = new Node(s % 10);
                rHead = r;
            } else {
                r.next = new Node(s % 10);
                r = r.next;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }


        if (overflow) {
            r.next = new Node(1);
        }

        return rHead;
    }

}
