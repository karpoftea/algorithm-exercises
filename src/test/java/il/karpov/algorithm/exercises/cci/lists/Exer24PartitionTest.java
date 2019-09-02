package il.karpov.algorithm.exercises.cci.lists;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exer24PartitionTest {

    private Exer24Partition solution = new Exer24Partition();

    @DataProvider
    public static Object[][] getLists() {
        // case 1
        Node n1 = new Node(10);
        Node n1_1 = new Node(1);
        n1.next = n1_1;
        // case 2
        Node n2 = new Node(10);
        Node n2_1 = new Node(1);
        Node n2_2 = new Node(3);
        n2.next = n2_1;
        n2_1.next = n2_2;
        // case 3
        Node n3 = new Node(1);
        Node n3_1 = new Node(10);
        n3.next = n3_1;
        // case 4
        Node n4 = new Node(1);
        Node n4_1 = new Node(6);
        Node n4_2 = new Node(7);
        Node n4_3 = new Node(8);
        Node n4_4 = new Node(3);
        Node n4_5 = new Node(4);
        Node n4_6 = new Node(10);
        Node n4_7 = new Node(2);
        Node n4_8 = new Node(4);
        Node n4_9 = new Node(5);
        Node n4_10 = new Node(2);
        n4.next = n4_1;
        n4_1.next = n4_2;
        n4_2.next = n4_3;
        n4_3.next = n4_4;
        n4_4.next = n4_5;
        n4_5.next = n4_6;
        n4_6.next = n4_7;
        n4_7.next = n4_8;
        n4_8.next = n4_9;
        n4_9.next = n4_10;
        return new Object[][]{
                {n1, 5},
                {n2, 5},
                {n3, 5},
                {n4, 4},
        };
    }

    @Test(dataProvider = "getLists")
    public void partition_should_partitionListUsingSpecifiedElement(Node list, int val) {
        System.out.println("Before partition:" + list.stringify());
        solution.partition(list, val);
        System.out.println("After partition:" + list.stringify());

        MatcherAssert.assertThat(isPartitioned(list, val), Is.is(true));
    }

    private boolean isPartitioned(Node list, int val) {
        boolean canBeLessThenVal = true;
        while (list != null) {
            if (list.val >= val) {
                if (canBeLessThenVal) {
                    canBeLessThenVal = false;
                }
            } else {
                if (!canBeLessThenVal) {
                    return false;
                }
            }
            list = list.next;
        }
        return true;
    }
}
