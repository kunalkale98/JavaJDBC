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
}
