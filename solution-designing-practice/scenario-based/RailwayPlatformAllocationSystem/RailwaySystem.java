package RailwayPlatformAllocationSystem;
import java.util.*;

public class RailwaySystem {

	//allocate nearest free platform
	public static void allocatePlatform(Map<Integer, Platform> platforms, Train train)
			throws PlatformUnavailableException {

		for (Platform p : platforms.values()) {
			if (!p.isOccupied) {
				p.isOccupied = true;
				System.out.println("Train " + train.name + " allocated to Platform " + p.platformNumber);
				return;
			}
		}

		throw new PlatformUnavailableException("No platform available for train " + train.name);
	}

	public static void main(String[] args) {

		Map<Integer, Platform> platforms = new LinkedHashMap<>();
		platforms.put(1, new Platform(1));
		platforms.put(2, new Platform(2));

		PriorityQueue<Train> pq = new PriorityQueue<>();
		pq.add(new Train("Train1", 900));
		pq.add(new Train("Train2", 850));
		pq.add(new Train("Train3", 920));

		while (!pq.isEmpty()) {
			Train t = pq.poll();
			try {
				allocatePlatform(platforms, t);
			} catch (PlatformUnavailableException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}