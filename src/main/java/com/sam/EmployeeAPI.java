package com.sam;

public class EmployeeAPI {
    private EmployeeCRUD employeeCRUD = new EmployeeCRUD();

    public Employee getEmployeeDetails(Integer empId) {
        if (empId == null) {
            return null;
        }

        return employeeCRUD.fetchEmployee(empId);
    }
}
