package list_interface;
import java.util.*;

public class NthElementFromEnd {
	//Nth element from the end without calculating its size.
    public static String nthElementFromEnd(LinkedList<String> list, int n) {
        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();

        //move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                return "Invalid N-greater than list length";
            }
            fast.next();
        }

        //move both pointers until fast reaches the end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }
        return slow.next(); //points to nth element from end
    }
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;

        System.out.println("LinkedList: " + list);
        System.out.println(n+"th element from end : " + nthElementFromEnd(list, n));
    }
}
