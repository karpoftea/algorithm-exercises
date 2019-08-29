package il.karpov.algorithm.exercises.cci.lists;

// 2.2
// Implement an algorithm to find the kth to last element of a singly linked list.
public class Exer22FindKthLastElement {

    public Node findKthLastElement(Node list, int k) {
        if (k < 0) {
            throw new IllegalArgumentException();
        }

        int count = 0;
        Node kThLast = null, cur = list;
        while (cur != null) {
            if (count == k) {
                kThLast = list;
            } else if (count > k) {
                kThLast = kThLast.next;
            }
            cur = cur.next;
            count++;
        }

        return kThLast;
    }
}

