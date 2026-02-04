package lambda_expression;
import java.util.*;
import java.util.stream.*;

class Invoice {
    int transactionId;
    //constructor
    Invoice(int transactionId) {
        this.transactionId = transactionId;
    }
}

public class InvoiceObjectCreation {
    public static void main(String[] args) {

        List<Integer> transactionIds = Arrays.asList(1001, 1002, 1003);

        //constructor reference
        List<Invoice> invoices =
                transactionIds.stream()
                              .map(Invoice::new)
                              .collect(Collectors.toList());

        invoices.forEach(i -> System.out.println(i.transactionId));
    }
}

