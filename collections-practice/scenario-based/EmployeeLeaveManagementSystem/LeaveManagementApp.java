package EmployeeLeaveManagementSystem;

public class LeaveManagementApp {

    public static void main(String[] args) {

        System.out.println("-------------------------------------");
        System.out.println("   EMPLOYEE LEAVE MANAGEMENT SYSTEM  ");
        System.out.println("-------------------------------------");

        LeaveManagementService service = new LeaveManagementService();

        //Add Employees (Map)
        Employee emp1 = new Employee(101, "Andrew", 10);
        Employee emp2 = new Employee(102, "Bella", 2);

        service.addEmployee(emp1);
        service.addEmployee(emp2);

        //Apply Leave (List + Validation)
        try {
            service.applyLeave(101, 5); // valid
            service.applyLeave(102, 5); // invalid
        } catch (InsufficientLeaveBalanceException e) {
            System.out.println("\nLeave Rejected (Exception)");
            System.out.println("Reason : " + e.getMessage());
        }

        //Approve / Reject
        for (LeaveRequest request : service.leaveRequests) {

            if (request.empId == 101) {
                service.approveLeave(request); // approve
            } else {
                service.rejectLeave(request); // reject
            }

            // 4️⃣ Track Status
            System.out.println("\n----- Leave Decision -----");
            System.out.println("Employee ID : " + request.empId);
            System.out.println("Days        : " + request.days);
            System.out.println("Status      : " + request.status);
        }

        // 5️⃣ Final Leave Balance
        System.out.println("\n----- Final Leave Balances -----");
        System.out.println("Andrew : " + emp1.leaveBalance);
        System.out.println("Bella  : " + emp2.leaveBalance);

        System.out.println("-------------------------------------");
    }
}
