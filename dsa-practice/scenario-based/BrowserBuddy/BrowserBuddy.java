package BrowserBuddy;
import java.util.*;

public class BrowserBuddy {
	static int tabCounter = 1;
	static Tab currentTab = null;
	// stack to store closed tabs
	static Stack<Tab> closedTabs = new Stack<>();
	static List<Tab> openTabs = new ArrayList<>();
	// method to open new tab
	public static void openNewTab() {
		Tab newTab = new Tab(tabCounter++);
		openTabs.add(newTab);
		currentTab = newTab;

		System.out.println("New tab opened successfully!");
		System.out.println("------------------------------------------------");
	}

	// method to close current tab and save in stack
	public static void closeCurrentTab() {
		if (currentTab == null) {
			System.out.println("No tab to close!");
			System.out.println("------------------------------------------------");
			return;
		}
		openTabs.remove(currentTab);
		closedTabs.push(currentTab);
		System.out.println("Tab closed: Tab-" + currentTab.tabId);
		System.out.println("Saved in recently closed tabs.");

		currentTab = openTabs.isEmpty() ? null : openTabs.get(openTabs.size() - 1);

		if (currentTab != null)
			System.out.println("Now active: " + currentTab);
		else
			System.out.println("No open tabs left!");
		System.out.println("------------------------------------------------");
	}
	// method to restore closed tab
	public static void restoreClosedTab() {
		if (closedTabs.isEmpty()) {
			System.out.println("No closed tabs to restore!");
			System.out.println("------------------------------------------------");
			return;
		}
		Tab restored = closedTabs.pop();
		openTabs.add(restored);
		currentTab = restored;

		System.out.println("Restored tab successfully!");
		System.out.println("Now active: " + currentTab);
		System.out.println("------------------------------------------------");
	}

	// method to switch tabs
	public static void switchTab(int id) {
		for (Tab t : openTabs) {
			if (t.tabId == id) {
				currentTab = t;
				System.out.println("Switched successfully!");
				System.out.println("Now active: " + currentTab);
				System.out.println("------------------------------------------------");
				return;
			}
		}
		System.out.println("Tab not found!");
		System.out.println("------------------------------------------------");
	}

	// method to show open tabs
	public static void showTabs() {
		if (openTabs.isEmpty()) {
			System.out.println("No open tabs!");
			System.out.println("------------------------------------------------");
			return;
		}
		System.out.println("\nOpen Tabs (" + openTabs.size() + "):");
		for (Tab t : openTabs) {
			if (t == currentTab)
				System.out.println("-> " + t);
			else
				System.out.println("   " + t);
		}
		System.out.println("------------------------------------------------");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("------ BrowserBuddy – Tab History Manager ------");
		System.out.println("------------------------------------------------");

		openNewTab(); // default first tab

		while (true) {

			if (currentTab != null)
				System.out.println("Active Tab: Tab-" + currentTab.tabId + " | Page: " + currentTab.history.getCurrentPage());
			System.out.println("\n1- Open New Tab");
			System.out.println("2- Visit New Page");
			System.out.println("3- Back");
			System.out.println("4- Forward");
			System.out.println("5- Close Current Tab");
			System.out.println("6- Restore Recently Closed Tab");
			System.out.println("7- Switch Tab");
			System.out.println("8- Show Tabs");
			System.out.println("9- Show Current Tab History");
			System.out.println("10- Exit");
			System.out.println("------------------------------------------------");
			System.out.print("Enter choice: ");
			
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				openNewTab();
				break;

			case 2:
				if (currentTab == null) {
					System.out.println("No tab open! Please open a tab first.");
					System.out.println("------------------------------------------------");
					break;
				}
				System.out.print("Enter URL: ");
				String url = sc.nextLine();
				currentTab.history.visit(url);
				System.out.println("Page opened successfully!");
				System.out.println("Current page: " + currentTab.history.getCurrentPage());
				System.out.println("------------------------------------------------");
				break;

			case 3:
				if (currentTab != null) {
					currentTab.history.back();
					System.out.println("Current page: " + currentTab.history.getCurrentPage());
					System.out.println("------------------------------------------------");
				} else {
					System.out.println("No active tab!");
					System.out.println("------------------------------------------------");
				}
				break;

			case 4:
				if (currentTab != null) {
					currentTab.history.forward();
					System.out.println("Current page: " + currentTab.history.getCurrentPage());
					System.out.println("------------------------------------------------");
				} else {
					System.out.println("No active tab!");
					System.out.println("------------------------------------------------");
				}
				break;

			case 5:
				closeCurrentTab();
				break;

			case 6:
				restoreClosedTab();
				break;

			case 7:
				showTabs();
				System.out.print("Enter tab id: ");
				int id = sc.nextInt();
				sc.nextLine();
				switchTab(id);
				break;

			case 8:
				showTabs();
				break;

			case 9:
				if (currentTab != null) {
					System.out.println("\nHistory of Tab-" + currentTab.tabId + ":");
					currentTab.history.showHistory();
					System.out.println("------------------------------------------------");
				} else {
					System.out.println("No active tab!");
					System.out.println("------------------------------------------------");
				}
				break;

			case 10:
				System.out.println("BrowserBuddy Closed.");
				System.out.println("------------------------------------------------");
				System.out.println("Thank you for using BrowserBuddy!");
				return;

			default:
				System.out.println("Invalid choice!");
				System.out.println("------------------------------------------------");
			}
		}
	}
}
