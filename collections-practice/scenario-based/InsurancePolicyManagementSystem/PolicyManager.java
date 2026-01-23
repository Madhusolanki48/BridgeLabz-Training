package InsurancePolicyManagementSystem;
import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    private Set<Policy> hashSet = new HashSet<>();                       
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();   // insertion order
    private Set<Policy> treeSet = new TreeSet<>(new PolicyExpiryComparator()); // sorted by expiry

    //method to store unique policy in all sets
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    //display all unique policies
    public void displayAllUniquePolicies() {
        System.out.println("\nAll Unique Policies (HashSet):");

        int count = 1;
        for (Policy p : hashSet) {
            System.out.println(count++ + ") " + p);
        }
    }


    //linkedHashSet- insertion order
    public void displayPoliciesInInsertionOrder() {
        System.out.println("\nPolicies in Insertion Order (LinkedHashSet):");

        int count = 1;
        for (Policy p : linkedHashSet) {
            System.out.println(count++ + ") " + p);
        }
    }


    //treeSet- sorted by expiry
    public void displayPoliciesSortedByExpiry() {
        System.out.println("\nPolicies Sorted by Expiry Date (TreeSet):");

        int count = 1;
        for (Policy p : treeSet) {
            System.out.println(count++ + ") " + p);
        }
    }


    //display Policies expiring soon,within 30 days
    public void displayPoliciesExpiringSoon() {
        System.out.println("\nPolicies Expiring Within Next 30 Days:");

        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        int count = 0;
        for (Policy p : hashSet) {
            if (!p.getExpiryDate().isBefore(today) && !p.getExpiryDate().isAfter(limit)) {
                System.out.println(++count + ") " + p);
            }
        }

        if (count == 0) System.out.println("No policies expiring within next 30 days.");
    }


    //display policies with a specific coverage type
    public void displayPoliciesByCoverageType(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);

        int count = 0;
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(++count + ") " + p);
            }
        }

        if (count == 0) System.out.println("No policies found for coverage type: " + coverageType);
    }


    //display duplicate policies based on policy numbers
    //sets will remove duplicates, so we detect duplicates from original input list
    public void displayDuplicatePolicies(List<Policy> inputList) {
        System.out.println("\n--- Duplicate Policies (based on policyNumber) ---");

        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (Policy p : inputList) {
            if (!seen.add(p.getPolicyNumber())) {
                duplicates.add(p.getPolicyNumber());
            }
        }

        if (duplicates.isEmpty()) System.out.println("No duplicate policy numbers found.");
        else System.out.println("Duplicate Policy Numbers: " + duplicates);
    }
}
