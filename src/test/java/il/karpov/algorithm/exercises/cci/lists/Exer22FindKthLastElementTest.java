package il.karpov.algorithm.exercises.cci.lists;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exer22FindKthLastElementTest {

    private Exer22FindKthLastElement solution = new Exer22FindKthLastElement();

    @DataProvider
    public static Object[][] getLists() {
        // case 1
        Node n1 = new Node(1);
        // case 2
        Node n2 = new Node(1);
        Node n2_1 = new Node(1);
        n2.next = n2_1;
        // case 3
        Node n3 = new Node(1);
        Node n3_1 = new Node(2);
        Node n3_2 = new Node(3);
        Node n3_3 = new Node(3);
        n3.next = n3_1;
        n3_1.next = n3_2;
        n3_2.next = n3_3;


        return new Object[][] {
            {null, 0, null},
            {n1, 0, n1},
            {n1, 1, null},
            {n1, 100, null},
            {n2, 1, n2},
            {n3, 2, n3_1},
        };
    }

    @Test(dataProvider = "getLists")
    public void findKthLastElement_should_returnKthLastElement(Node list, int k, Node expectedNode) {
        Node actualNode = solution.findKthLastElement(list, k);
        MatcherAssert.assertThat(actualNode, Is.is(expectedNode));
    }
}
