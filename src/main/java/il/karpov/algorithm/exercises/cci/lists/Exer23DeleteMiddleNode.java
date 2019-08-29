package il.karpov.algorithm.exercises.cci.lists;

// 2.3
// Delete Middle Node: Implement an algorithm to delete a node in the middle
// (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list,
// given only access to that node.
// EXAMPLE
// input:the node c from the linked lista->b->c->d->e->f
// result: nothing is returned, but the new linked list looks likea->b->d->e- >f
public class Exer23DeleteMiddleNode {

    public void deleteMiddleNode(Node middle) {
        if (middle == null || middle.next == null) {
            throw new IllegalArgumentException();
        }

        Node cur = middle.next, prev = middle;
        while (cur != null) {
            prev.val = cur.val;
            if (cur.next != null) {
                prev = cur;
            }
            cur = cur.next;
        }

        prev.next = null;
    }
}
