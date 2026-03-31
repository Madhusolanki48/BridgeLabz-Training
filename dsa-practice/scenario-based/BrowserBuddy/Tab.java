package BrowserBuddy;
import java.util.*;

public class Tab {
	//attributes
	int tabId;
	BrowserHistory history;
    //constructor
	Tab(int tabId) {
		this.tabId = tabId;
		this.history = new BrowserHistory();
		history.visit("Home Page");
	}

	public String toString() {
		return "Tab-" + tabId + " | Current Page: " + history.getCurrentPage();
	}
}
