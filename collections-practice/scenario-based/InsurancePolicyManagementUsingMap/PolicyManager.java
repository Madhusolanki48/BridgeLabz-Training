package InsurancePolicyManagementUsingMap;
import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    private Map<String, Policy> hashMapPolicies = new HashMap<>();
    private Map<String, Policy> linkedHashMapPolicies = new LinkedHashMap<>();

    //TreeMap sorted by expiry date
    private TreeMap<LocalDate, List<Policy>> treeMapPolicies = new TreeMap<>();

    //Add policy into all maps
    public void addPolicy(Policy policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);

        treeMapPolicies.putIfAbsent(policy.getExpiryDate(), new ArrayList<>());
        treeMapPolicies.get(policy.getExpiryDate()).add(policy);
    }

    //retrieve policy by number
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }

    //display policies expiring in next 30 days
    public void displayPoliciesExpiringSoon() {
        System.out.println("\nPolicies expiring within next 30 days:");

        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        int count = 0;
        for (Policy p : hashMapPolicies.values()) {
            if (!p.getExpiryDate().isBefore(today) && !p.getExpiryDate().isAfter(limit)) {
                System.out.println(++count + ") " + p);
            }
        }

        if (count == 0) System.out.println("No policies expiring soon.");
    }

    //display policies for specific policyholder
    public void displayPoliciesByPolicyHolder(String holderName) {
        System.out.println("\nPolicies for Policy Holder: " + holderName);

        int count = 0;
        for (Policy p : hashMapPolicies.values()) {
            if (p.getPolicyHolderName().equalsIgnoreCase(holderName)) {
                System.out.println(++count + ") " + p);
            }
        }

        if (count == 0) System.out.println("No policies found for " + holderName);
    }

    //remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<String, Policy>> iterator = hashMapPolicies.entrySet().iterator();
        while (iterator.hasNext()) {
            Policy p = iterator.next().getValue();
            if (p.getExpiryDate().isBefore(today)) {
                iterator.remove();
                linkedHashMapPolicies.remove(p.getPolicyNumber());
            }
        }

        // remove expired from treemap
        treeMapPolicies.headMap(today).clear();

        System.out.println("\nExpired policies removed successfully.");
    }

    //display all policies from HashMap
    public void displayAllPoliciesHashMap() {
        System.out.println("\nAll Policies (HashMap):");
        int count = 1;
        for (Policy p : hashMapPolicies.values()) {
            System.out.println(count++ + ") " + p);
        }
    }

    //display all policies in insertion order
    public void displayAllPoliciesLinkedHashMap() {
        System.out.println("\nAll Policies (LinkedHashMap - Insertion Order):");
        int count = 1;
        for (Policy p : linkedHashMapPolicies.values()) {
            System.out.println(count++ + ") " + p);
        }
    }

    //display policies sorted by expiry date (TreeMap)
    public void displayAllPoliciesTreeMap() {
        System.out.println("\nAll Policies Sorted by Expiry Date (TreeMap):");
        int count = 1;

        for (Map.Entry<LocalDate, List<Policy>> entry : treeMapPolicies.entrySet()) {
            for (Policy p : entry.getValue()) {
                System.out.println(count++ + ") " + p);
            }
        }
    }
}

