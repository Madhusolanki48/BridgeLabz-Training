package InsurancePolicyManagementSystem;
import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManagement {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();
        //input list (contains duplicates)
        List<Policy> inputPolicies = new ArrayList<>();

        inputPolicies.add(new Policy("P101", "Mavrick", LocalDate.now().plusDays(15), "Health", 5000));
        inputPolicies.add(new Policy("P102", "Rachid", LocalDate.now().plusDays(60), "Auto", 3000));
        inputPolicies.add(new Policy("P103", "Samren", LocalDate.now().plusDays(10), "Home", 4500));

        //duplicate (same policy number)
        inputPolicies.add(new Policy("P101", "Mavrick Duplicate", LocalDate.now().plusDays(20), "Health", 5200));

        //store policies in sets
        for (Policy p : inputPolicies) manager.addPolicy(p);

        manager.displayAllUniquePolicies();
        manager.displayPoliciesInInsertionOrder();
        manager.displayPoliciesSortedByExpiry();

        manager.displayPoliciesExpiringSoon();
        manager.displayPoliciesByCoverageType("Health");
        manager.displayDuplicatePolicies(inputPolicies);

        // performance comparison
        System.out.println("\n------------- PERFORMANCE COMPARISON -------------");
        PerformanceTest.compareSetsPerformance();
    }
}

