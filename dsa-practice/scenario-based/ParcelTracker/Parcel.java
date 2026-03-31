package ParcelTracker;
import java.util.*;

public class Parcel {
	//attributes
	String parcelId;
	StageNode head;

	//constructor
	Parcel(String parcelId) {
		this.parcelId = parcelId;

		//default stages
		head = new StageNode("Packed");
		head.next = new StageNode("Shipped");
		head.next.next = new StageNode("In Transit");
		head.next.next.next = new StageNode("Delivered");
	}

	//method for forward tracking through stages
	public void trackStages() {
		if (head == null) {
			System.out.println("Parcel lost/missing! Tracking chain is null.");
			System.out.println("-------------------------------------------------------------");
			return;
		}

		System.out.println("\nTracking Parcel: " + parcelId);
		StageNode temp = head;

		while (temp != null) {
			System.out.print(temp.stage);
			if (temp.next != null)
				System.out.print(" -> ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("-------------------------------------------------------------");
	}

	//method to add custom intermediate checkpoints
	public void addCheckpoint(String afterStage, String newStage) {
		if (head == null) {
			System.out.println("Parcel lost/missing! Cannot add checkpoint.");
			System.out.println("-------------------------------------------------------------");
			return;
		}

		StageNode temp = head;

		while (temp != null) {
			if (temp.stage.equalsIgnoreCase(afterStage)) {

				StageNode node = new StageNode(newStage);
				node.next = temp.next;
				temp.next = node;

				System.out.println("Checkpoint added: " + newStage + " after " + afterStage);
				System.out.println("-------------------------------------------------------------");
				return;
			}
			temp = temp.next;
		}

		System.out.println("Stage not found: " + afterStage);
		System.out.println("-------------------------------------------------------------");
	}

	//method to handle lost/missing parcels, null pointer
	public void markLost() {
		head = null;
		System.out.println("Parcel marked as LOST! Tracking stopped.");
		System.out.println("-------------------------------------------------------------");
	}
}

