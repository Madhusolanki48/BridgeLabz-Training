package lambda_expression;
import java.util.*;

public class HospitalPatientIDPrinting {
    public static void main(String[] args) {

        List<Integer> patientIds = Arrays.asList(101, 102, 103);

        //method reference instead of lambda
        patientIds.forEach(System.out::println);
    }
}
