package InsurancePolicyManagementSystem;
import java.time.LocalDate;
import java.util.*;

public class PerformanceTest {
    public static void compareSetsPerformance() {
        int n = 100000;
        List<Policy> policies = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            policies.add(new Policy(
                    "P" + i,
                    "User" + i,
                    LocalDate.now().plusDays(i % 365),
                    (i % 2 == 0) ? "Health" : "Auto",
                    1000 + i
            ));
        }

        Policy searchPolicy = new Policy("P50000", "Test", LocalDate.now(), "Health", 2000);

        testSet(new HashSet<>(), policies, searchPolicy, "HashSet");
        testSet(new LinkedHashSet<>(), policies, searchPolicy, "LinkedHashSet");
        testSet(new TreeSet<>(new PolicyExpiryComparator()), policies, searchPolicy, "TreeSet");
    }

    private static void testSet(Set<Policy> set, List<Policy> policies, Policy searchPolicy, String name) {
        long start, end;
        //add
        start = System.nanoTime();
        for (Policy p : policies) set.add(p);
        end = System.nanoTime();
        long addTime = end - start;

        //search
        start = System.nanoTime();
        set.contains(searchPolicy);
        end = System.nanoTime();
        long searchTime = end - start;

        //remove
        start = System.nanoTime();
        set.remove(searchPolicy);
        end = System.nanoTime();
        long removeTime = end - start;

        System.out.println("\nPerformance Comparison:");
        System.out.println(name + " -> Add: " + addTime / 1_000_000 + " ms, Search: " + searchTime + " ns, Remove: " + removeTime + " ns");

    }
}

