package il.karpov.algorithm.exercises;

public class MergeSort {

    static int[] mergeSort(int[] a) {
        if (a == null) return null;
        if (a.length < 2) return a;

        int middle = a.length / 2;
        return mergeIter(mergeSort(slice(a, 0, middle)), mergeSort(slice(a, middle, a.length)));
    }

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

    private static int[] slice(int[] a, int startInclusive, int endExclusive) {
        int[] arr = new int[endExclusive - startInclusive];
        for (int i = startInclusive, j = 0; i < endExclusive; i++, j++) {
            arr[j] = a[i];
        }

        return arr;
    }

    private static int[] tail(int[] a) {
        if (a.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] arr = new int[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            arr[i - 1] = a[i];
        }
        return arr;
    }

    private static int[] concat(int element, int[] arr) {
        int[] a = new int[arr.length + 1];
        a[0] = element;

        for (int i = 0; i < arr.length; i++) {
            a[i + 1] = arr[i];
        }

        return a;
    }


    static int[] mergeIter(int[] a, int[] b) {
        if (a.length == 0) {
            return b;
        }

        if (b.length == 0) {
            return a;
        }

        int size = a.length + b.length;
        int[] arr = new int[size];

        for (int i = 0, ai = 0, bi = 0; i < size; i++) {
            if (ai < a.length && bi < b.length) {
                if (a[ai] < b[bi]) {
                    arr[i] = a[ai];
                    ai++;
                } else {
                    arr[i] = b[bi];
                    bi++;
                }
            } else {
                if (ai < a.length) {
                    arr[i] = a[ai];
                    ai++;
                } else {
                    arr[i] = b[bi];
                    bi++;
                }
            }
        }

        return arr;
    }
}
