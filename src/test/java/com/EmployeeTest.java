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
        Integer empId = null;
        EmployeeCRUD employeeCRUD = EasyMock.createMock(EmployeeCRUD.class);

        Employee actual = new Employee();
        actual.setId(2);
        actual.setFirstName("Samson");
        actual.setLastName("Francis");
        actual.setExperience(2);

        EasyMock.expect(employeeCRUD.fetchEmployee(empId)).andReturn(actual);

        EmployeeAPI employeeAPI = new EmployeeAPI();
        Employee returned = employeeAPI.getEmployeeDetails(null);

        assertNotEquals(actual, returned);
        assertEquals(actual, returned);
    }


}
