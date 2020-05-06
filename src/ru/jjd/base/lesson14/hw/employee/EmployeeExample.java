package ru.jjd.base.lesson14.hw.employee;

import java.util.List;

public class EmployeeExample {
    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(20);
        employees.sort(new EmployeeNameComparator());
        System.out.println(employees);
        employees.sort(new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator()));
        System.out.println(employees);
        employees.sort(new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator()).
                thenComparing(new EmployeeAgeComparator()).thenComparing(new EmployeeCompanyComparator()));
        System.out.println(employees);
    }
}
