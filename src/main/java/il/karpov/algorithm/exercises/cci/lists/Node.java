package il.karpov.algorithm.exercises.cci.lists;

public class Node {

    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    String stringify() {
        StringBuilder sb = new StringBuilder(32);
        sb.append('[').append(String.valueOf(val));

        Node n = next;
        while (n != null) {
            sb.append(',').append(n.val);
            n = n.next;
        }
        return sb.append(']').toString();
    }
}
