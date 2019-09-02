package il.karpov.algorithm.exercises.cci.lists;

// 2.4
// Partition: Write code to partition a linked list around a value x,
// such that all nodes less than x come before all nodes greater than or equal to x.
// If x is contained within the list, the values of x only need to be after the elements less than x (see below).
// The partition element x can appear anywhere in the "right partition";
// it does not need to appear between the left and right partitions.
// EXAMPLE
// Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition=5]
// Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
public class Exer24Partition {

    public void partition(Node list, int val) {
        if (list == null || list.next == null) return;

        Node slow = list, fast = list.next;
        while (fast != null) {
            if (slow.val > val) {
                if (fast.val < val) {
                    int v = slow.val;
                    slow.val = fast.val;
                    fast.val = v;
                    fast = fast.next;
                    slow = slow.next;
                } else {
                    fast = fast.next;
                }
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
    }
}

