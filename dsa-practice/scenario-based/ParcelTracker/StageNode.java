package ParcelTracker;
import java.util.*;

//singly linked list node
public class StageNode {
	//attributes
	String stage;
	StageNode next;
    //constructor
	StageNode(String stage) {
		this.stage = stage;
		this.next = null;
	}
}
