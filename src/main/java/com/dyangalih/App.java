package com.dyangalih;

import com.dyangalih.employee.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Employee employee = new Employee();

        System.out.println("Delete employee table");
        employee.deleteAllEmployee();

        System.out.println("Add dummy data");
        employee.addEmployee();

        System.out.println("Display employee");
        employee.displayAllEmployee();

        System.out.println("Update Employee Data");
        employee.updateEmployee();
    }
}
