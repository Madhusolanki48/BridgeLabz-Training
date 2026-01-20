package BrowserBuddy;
import java.util.*;

public class HistoryNode {
	//attributes
	String url;
	HistoryNode prev;
	HistoryNode next;
    //constructor
	HistoryNode(String url) {
		this.url = url;
		this.prev = null;
		this.next = null;
	}
}
