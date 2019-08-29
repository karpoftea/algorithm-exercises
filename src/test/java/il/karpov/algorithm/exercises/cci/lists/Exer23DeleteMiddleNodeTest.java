package il.karpov.algorithm.exercises.cci.lists;

import org.hamcrest.core.Is;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class Exer23DeleteMiddleNodeTest {

    private Exer23DeleteMiddleNode solution = new Exer23DeleteMiddleNode();

    @DataProvider
    public static Object[][] getLists() {
        // case 1
        Node n1 = new Node(1);
        Node n1_1 = new Node(2);
        Node n1_2 = new Node(3);
        n1.next = n1_1;
        n1_1.next = n1_2;
        // case 2
        Node n2 = new Node(1);
        Node n2_1 = new Node(2);
        Node n2_2 = new Node(3);
        Node n2_3 = new Node(4);
        Node n2_4 = new Node(5);
        n2.next = n2_1;
        n2_1.next = n2_2;
        n2_2.next = n2_3;
        n2_3.next = n2_4;
        return new Object[][] {
            {n1, n1_1, new int[] {1, 3}},
            {n2, n2_3, new int[] {1, 2, 3, 5}}
        };
    }

    @Test(dataProvider = "getLists")
    public void deleteMiddleNode_should_deleteSpecifiedElementFromTheList(Node list, Node middle, int[] expectedVals) {
        solution.deleteMiddleNode(middle);

        int listSize = 0;
        while (list != null) {
            assertThat(expectedVals[listSize], Is.is(list.val));
            listSize++;
            list = list.next;
        }

        assertThat(listSize, Is.is(expectedVals.length));
    }
}
