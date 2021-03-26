package com.javajdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class EmployeePayrollService {
    public Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String username = "root";
        String password = "kunal@123";
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver", e);
        }
        listDrivers();
        System.out.println("Connecting to database: "+jdbcURL);
        connection = DriverManager.getConnection(jdbcURL,username,password);
        System.out.println("Connection Successful!! "+connection);
        return connection;
    }
    public static void listDrivers(){
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while(driverList.hasMoreElements()){
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(driverClass.getClass().getName());
        }
    }
    public List<EmployeePayrollData> readData(){
        String sqlQuery = "SELECT * FROM employee_payroll;";
        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlQuery);
            while (result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                double salary = result.getDouble("salary");
                LocalDate start_date = result.getDate("start_date").toLocalDate();
                String gender = result.getString("gender");
                employeePayrollList.add(new EmployeePayrollData(id,name,salary,start_date,gender));
            }
            connection.close();
        }catch (SQLException e){
            throw new IllegalStateException("Unable to retrieve data",e);
        }
        return employeePayrollList;
    }
}
