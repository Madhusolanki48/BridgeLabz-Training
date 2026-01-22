package queue_interface;
import java.util.*;

class Patient {
	//attributes
    String name;
    int severity;
    //constructor
    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    @Override
    public String toString() {
        return name + "(" + severity + ")";
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> pq = new PriorityQueue<>(
                (p1, p2) -> Integer.compare(p2.severity, p1.severity) //higher severity first
        );

        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.remove().name);
        }
    }
}
