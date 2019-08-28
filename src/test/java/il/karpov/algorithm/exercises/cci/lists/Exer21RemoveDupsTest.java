package il.karpov.algorithm.exercises.cci.lists;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.core.Is;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class Exer21RemoveDupsTest {

    Exer21RemoveDups solution = new Exer21RemoveDups();

    @DataProvider
    public static Object[][] getTestLists() {
        // case 1
        Node l1 = new Node(1);
        // case 2
        Node l2 = new Node(1);
        l2.next = new Node(1);
        // case 3
        Node l3 = new Node(1);
        Node l3_1 = new Node(1);
        Node l3_2 = new Node(2);
        Node l3_3 = new Node(2);
        Node l3_4 = new Node(1);
        l3.next = l3_1;
        l3_1.next = l3_2;
        l3_2.next = l3_3;
        l3_3.next = l3_4;
        // case 4
        Node l4 = new Node(1);
        Node l4_1 = new Node(2);
        Node l4_2 = new Node(1);
        Node l4_3 = new Node(3);
        Node l4_4 = new Node(4);
        l4.next = l4_1;
        l4_1.next = l4_2;
        l4_2.next = l4_3;
        l4_3.next = l4_4;

        return new Object[][] {
            {l1},
            {l2},
            {l3},
            {l4}
        };
    }

    @Test(dataProvider = "getTestLists")
    public void removeDups_should_retainUniqItems(Node list) {
        solution.removeDups(list);
        assertThat(noDuplicates(list), Is.is(true));
    }

    private boolean noDuplicates(Node list) {
        Map<Integer, Integer> hist = new HashMap<>();
        while (list != null) {
            Integer count = hist.get(list.val);
            if (count == null) {
                hist.put(list.val, 1);
            } else {
                return false;
            }
            list = list.next;
        }
        return true;
    }
}
