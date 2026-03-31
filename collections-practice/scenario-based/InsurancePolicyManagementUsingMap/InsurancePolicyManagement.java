package InsurancePolicyManagementUsingMap;
import java.time.LocalDate;

public class InsurancePolicyManagement {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        //add policies
        manager.addPolicy(new Policy("P101", "Mavrick", LocalDate.now().plusDays(15), "Health", 5000));
        manager.addPolicy(new Policy("P102", "Rachid", LocalDate.now().plusDays(60), "Auto", 3000));
        manager.addPolicy(new Policy("P103", "Samren", LocalDate.now().plusDays(10), "Home", 4500));

        //expired policy
        manager.addPolicy(new Policy("P104", "Mavrick", LocalDate.now().minusDays(5), "Auto", 2500));

        //display stored policies
        manager.displayAllPoliciesHashMap();
        manager.displayAllPoliciesLinkedHashMap();
        manager.displayAllPoliciesTreeMap();

        //retrieve by policy number
        System.out.println("\nRetrieve Policy P102:");
        System.out.println(manager.getPolicyByNumber("P102"));

        //policies expiring within next 30 days
        manager.displayPoliciesExpiringSoon();

        //policies by policyholder name
        manager.displayPoliciesByPolicyHolder("Mavrick");

        //remove expired policies
        manager.removeExpiredPolicies();

        //display again after removal
        manager.displayAllPoliciesHashMap();
    }
}
