package RailwayPlatformAllocationSystem;

//train sorted by arrival time
public class Train implements Comparable<Train> {
	// attribute
	String name;
	int arrivalTime;

	// constructor
	public Train(String name, int arrivalTime) {
		this.name = name;
		this.arrivalTime = arrivalTime;
	}

	@Override
	public int compareTo(Train other) {
		return Integer.compare(this.arrivalTime, other.arrivalTime);
	}
}