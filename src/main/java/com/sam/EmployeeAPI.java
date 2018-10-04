package com.sam;

import lombok.Getter;
import lombok.Setter;

public class EmployeeAPI {
    @Getter@Setter
    private EmployeeCRUD employeeCRUD = null;

    public Employee getEmployeeDetails(Integer empId) {
        if (empId == null) {
            return null;
        }

        return employeeCRUD.fetchEmployee(empId);
    }
}
