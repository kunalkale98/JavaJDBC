package com.javajdbc;

import java.time.LocalDate;

public class EmployeePayrollData {
    public int id;
    public String name;
    public double salary;
    public LocalDate date;
    public String gender;

    public EmployeePayrollData(int id, String name,double salary,String gender){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }

    public EmployeePayrollData(int id,String name,double salary,LocalDate date,String gender){
        this(id,name,salary,gender);
        this.date = date;
    }

    @Override
    public String toString(){
        return "id: "+id+", name: "+name+", salary: "+salary+", start_date: "+date+", gender: "+gender;
    }
}
