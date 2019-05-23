package il.karpov.algorithm.exercises;

public class MergeSort {

    static int[] mergeRcr(int[] a, int[] b) {
        if (a.length == 0) {
            return b;
        }

        if (b.length == 0) {
            return a;
        }

        if (a[0] < b[0]) {
            return concat(a[0], mergeRcr(tail(a), b));
        } else {
            return concat(b[0], mergeRcr(tail(b), a));
        }
    }

    private static int[] tail(int[] a) {
        if (a.length == 0) throw new IllegalArgumentException();

        int[] arr = new int[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            arr[i - 1] = a[i];
        }
        return arr;
    }

    private static  int[] concat(int element, int[] arr) {
        int[] a = new int[arr.length + 1];
        a[0] = element;

        for (int i = 0; i < arr.length; i++) {
            a[i + 1] = arr[i];
        }

        return a;
    }


    int[] mergeIter(int[] a, int[] b) {
        return null;
    }
}
