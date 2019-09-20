package il.karpov.algorithm.exercises.cci.lists;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Exer25SumListsTest {

    Exer25SumLists solution = new Exer25SumLists();

    @DataProvider
    public static Object[][] getReversedLists() {
        //case 1
        Node e1_l1_0 = new Node(7);
        Node e1_l1_1 = new Node(1);
        Node e1_l1_2 = new Node(6);
        e1_l1_0.next = e1_l1_1;
        e1_l1_1.next = e1_l1_2;

        Node e1_l2_0 = new Node(5);
        Node e1_l2_1 = new Node(9);
        Node e1_l2_2 = new Node(2);
        e1_l2_0.next = e1_l2_1;
        e1_l2_1.next = e1_l2_2;

        Node e1_r_0 = new Node(2);
        Node e1_r_1 = new Node(1);
        Node e1_r_2 = new Node(9);
        e1_r_0.next = e1_r_1;
        e1_r_1.next = e1_r_2;

        //case2
        Node e2_l1_0 = new Node(0);
        Node e2_l1_1 = new Node(1);
        Node e2_l1_2 = new Node(2);
        e2_l1_0.next = e2_l1_1;
        e2_l1_1.next = e2_l1_2;

        Node e2_l2_0 = new Node(2);
        Node e2_l2_1 = new Node(3);
        Node e2_l2_2 = new Node(7);
        e2_l2_0.next = e2_l2_1;
        e2_l2_1.next = e2_l2_2;

        Node e2_r_0 = new Node(2);
        Node e2_r_1 = new Node(4);
        Node e2_r_2 = new Node(9);
        e2_r_0.next = e2_r_1;
        e2_r_1.next = e2_r_2;

        //case3
        Node e3_l1_0 = new Node(1);
        Node e3_l1_1 = new Node(0);
        Node e3_l1_2 = new Node(0);
        e3_l1_0.next = e3_l1_1;
        e3_l1_1.next = e3_l1_2;

        Node e3_l2_0 = new Node(9);
        Node e3_l2_1 = new Node(9);
        Node e3_l2_2 = new Node(9);
        e3_l2_0.next = e3_l2_1;
        e3_l2_1.next = e3_l2_2;

        Node e3_r_0 = new Node(0);
        Node e3_r_1 = new Node(0);
        Node e3_r_2 = new Node(0);
        Node e3_r_3 = new Node(1);
        e3_r_0.next = e3_r_1;
        e3_r_1.next = e3_r_2;
        e3_r_2.next = e3_r_3;

        //case4
        Node e4_l1_0 = new Node(1);

        Node e4_l2_0 = new Node(9);

        Node e4_r_0 = new Node(0);
        e4_r_0.next = new Node(1);

        return new Object[][] {
            {
                e1_l1_0, e1_l2_0, e1_r_0
            },
            {
                e2_l1_0, e2_l2_0, e2_r_0
            },
            {
                e3_l1_0, e3_l2_0, e3_r_0
            },
            {
                e4_l1_0, e4_l2_0, e4_r_0
            }
        };
    }

    @DataProvider
    public static Object[][] getLists() {
        //case 1
        Node e1_l1_0 = new Node(6);
        Node e1_l1_1 = new Node(1);
        Node e1_l1_2 = new Node(7);
        e1_l1_0.next = e1_l1_1;
        e1_l1_1.next = e1_l1_2;

        Node e1_l2_0 = new Node(2);
        Node e1_l2_1 = new Node(9);
        Node e1_l2_2 = new Node(5);
        e1_l2_0.next = e1_l2_1;
        e1_l2_1.next = e1_l2_2;

        Node e1_r_0 = new Node(9);
        Node e1_r_1 = new Node(1);
        Node e1_r_2 = new Node(2);
        e1_r_0.next = e1_r_1;
        e1_r_1.next = e1_r_2;

        //case2
        Node e2_l1_0 = new Node(2);
        Node e2_l1_1 = new Node(1);
        Node e2_l1_2 = new Node(0);
        e2_l1_0.next = e2_l1_1;
        e2_l1_1.next = e2_l1_2;

        Node e2_l2_0 = new Node(7);
        Node e2_l2_1 = new Node(3);
        Node e2_l2_2 = new Node(2);
        e2_l2_0.next = e2_l2_1;
        e2_l2_1.next = e2_l2_2;

        Node e2_r_0 = new Node(9);
        Node e2_r_1 = new Node(4);
        Node e2_r_2 = new Node(2);
        e2_r_0.next = e2_r_1;
        e2_r_1.next = e2_r_2;

        //case3
        Node e3_l1_0 = new Node(0);
        Node e3_l1_1 = new Node(0);
        Node e3_l1_2 = new Node(1);
        e3_l1_0.next = e3_l1_1;
        e3_l1_1.next = e3_l1_2;

        Node e3_l2_0 = new Node(9);
        Node e3_l2_1 = new Node(9);
        Node e3_l2_2 = new Node(9);
        e3_l2_0.next = e3_l2_1;
        e3_l2_1.next = e3_l2_2;

        Node e3_r_0 = new Node(1);
        Node e3_r_1 = new Node(0);
        Node e3_r_2 = new Node(0);
        Node e3_r_3 = new Node(0);
        e3_r_0.next = e3_r_1;
        e3_r_1.next = e3_r_2;
        e3_r_2.next = e3_r_3;

        //case4
        Node e4_l1_0 = new Node(1);

        Node e4_l2_0 = new Node(9);

        Node e4_r_0 = new Node(1);
        e4_r_0.next = new Node(0);

        return new Object[][] {
            {
                e1_l1_0, e1_l2_0, e1_r_0
            },
            {
                e2_l1_0, e2_l2_0, e2_r_0
            },
            {
                e3_l1_0, e3_l2_0, e3_r_0
            },
            {
                e4_l1_0, e4_l2_0, e4_r_0
            }
        };
    }

    @Test(dataProvider = "getReversedLists")
    public void sumReversedLists_should_sumTwoNumbersRepresentedInReverseOrder(Node l1, Node l2, Node result) {
        Node actual = solution.sumReversedLists(l1, l2);
        System.out.println(actual.stringify());

        assertThat(hasEqualVals(actual, result), is(true));
    }

    @Test(dataProvider = "getLists")
    public void sumLists_should_sumTwoNumbers(Node l1, Node l2, Node result) {
        Node actual = solution.sumLists(l1, l2);
        System.out.println(actual.stringify());

        assertThat(hasEqualVals(actual, result), is(true));
    }

    private boolean hasEqualVals(Node actual, Node result) {
        while (actual != null || result != null) {
            if (actual == null || result == null) {
                return false;
            }

            if (actual.val != result.val) {
                return false;
            }

            actual = actual.next;
            result = result.next;
        }
        return true;
    }
}
