package il.karpov.algorithm.exercises.cci.lists;

//  2.1
//  Write code to remove duplicates from an unsorted linked list.
//  How would you solve this problem if a temporary buffer is not allowed?
public class Exer21RemoveDups {

    // O(n^2) - time complexity
    // O(1) - space complexity (no external buffer precondition)
    public void removeDups(Node list) {
        Node slow = list;
        while (slow != null) {
            Node prev = slow, cur = slow.next;
            while (cur != null) {
                if (slow.val == cur.val) {
                    prev.next = null;
                } else {
                    prev.next = cur;
                    prev = cur;
                }
                cur = cur.next;
            }
            slow = slow.next;
        }
    }
}
