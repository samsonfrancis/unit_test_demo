package com.sam;

import java.sql.*;

public class EmployeeCRUD {
    public Employee fetchEmployee(Integer employeeId) {
        if(employeeId == null){
            return null;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }

        try {
            Connection con = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
            PreparedStatement ps = con.prepareStatement("select * from employee where id=?");

            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();

            Employee employee = new Employee();
            employee.setId(employeeId);

            while (rs.next()) {
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setExperience(rs.getInt("experience"));
            }
            return employee;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return null;
    }
}
