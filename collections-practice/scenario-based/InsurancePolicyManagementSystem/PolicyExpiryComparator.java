package InsurancePolicyManagementSystem;
import java.util.Comparator;

public class PolicyExpiryComparator implements Comparator<Policy> {
    @Override
    public int compare(Policy p1, Policy p2) {
        int cmp = p1.getExpiryDate().compareTo(p2.getExpiryDate());
        if (cmp != 0) return cmp;

        //avoid treating same expiry as duplicate
        return p1.getPolicyNumber().compareTo(p2.getPolicyNumber());
    }
}

