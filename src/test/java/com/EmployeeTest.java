package com;

import com.sam.Employee;
import com.sam.EmployeeAPI;
import com.sam.EmployeeCRUD;
import org.easymock.EasyMock;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;
import static org.testng.AssertJUnit.assertEquals;

public class EmployeeTest {

    @Test
    public void testFetchEmployeeNull() {
        EmployeeAPI employeeAPI = new EmployeeAPI();
        Employee returned = employeeAPI.getEmployeeDetails(null);

        assertNull(returned);
    }

    @Test
    public void testFetchEmployee() {
        Employee actual = new Employee();
        actual.setId(2);
        actual.setFirstName("Samson");
        actual.setLastName("Francis");
        actual.setExperience(2);

        Integer empId = 2;
        EmployeeCRUD employeeCRUD = EasyMock.createMock(EmployeeCRUD.class);
        Employee mockEmployee = new Employee();
        mockEmployee.setId(empId);
        mockEmployee.setFirstName("Name:Samson");
        mockEmployee.setLastName("Francis");
        mockEmployee.setExperience(2);
        EasyMock.expect(employeeCRUD.fetchEmployee(EasyMock.isA(Integer.class))).andReturn(mockEmployee);
        EasyMock.replay(employeeCRUD);

        EmployeeAPI employeeAPI = new EmployeeAPI();
        employeeAPI.setEmployeeCRUD(employeeCRUD);
        Employee returned = employeeAPI.getEmployeeDetails(empId);

//        assertNotEquals(actual, returned);
//        assertEquals(actual, returned);
    }


    @Test
    public void testMathOp(){

        EmployeeCRUD employeeCRUD = new EmployeeCRUD();
        int rval = employeeCRUD.mathOp(1,2);
        assertEquals(3,rval);


    }
}
