package com.javajdbc;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class EmployeePayrollTest {

    @Test
    public void givenDBData_WhenRetrieve_ShouldMatchListSize() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollList = employeePayrollService.readData();
        Assert.assertEquals(5,employeePayrollList.size());
    }

    @Test
    public void givenData_WhenUpdated_ShouldMatchTheSalaryEntered() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        String name = "Ben";
        double salary = 25000.00;
        double updatedSalary = employeePayrollService.updateEmployeeSalary(name,salary);
        boolean result = false;
        if(salary == updatedSalary){
            result = true;
        }
        Assert.assertTrue(result);
    }
}
