package EmployeeLeaveManagementSystem;
import java.util.*;

//service class to manage leave logic
public class LeaveManagementService {

    //map to store employees by ID
    Map<Integer, Employee> employeeMap = new HashMap<>();

    //list to store leave requests
    List<LeaveRequest> leaveRequests = new ArrayList<>();

    //method to add employee
    public void addEmployee(Employee emp) {
        employeeMap.put(emp.empId, emp);
    }

    //method to apply leave with validation
    public void applyLeave(int empId, int days)
            throws InsufficientLeaveBalanceException {

        Employee emp = employeeMap.get(empId);

        if (emp.leaveBalance < days) {
            throw new InsufficientLeaveBalanceException(
                    "Insufficient leave balance");
        }

        leaveRequests.add(new LeaveRequest(empId, days));
    }

    //method to approve leave
    public void approveLeave(LeaveRequest request) {
        Employee emp = employeeMap.get(request.empId);
        emp.leaveBalance -= request.days;
        request.status = "APPROVED";
    }

    //method to reject leave
    public void rejectLeave(LeaveRequest request) {
        request.status = "REJECTED";
    }
}
