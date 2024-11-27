package DesignPatterns.Proxy;

import java.util.List;

public class Proxy {
    public static void main(String[] args) {
        // Real DAO
        EmployeeDaoImpl realDao = new EmployeeDaoImpl();

        // Proxy for the DAO
        EmployeeDao proxy = new EmployeeDaoProxy(realDao);

        // Add some employees
        proxy.addEmployee(new EmployeeDo(1, "Alice", "Engineering"));
        proxy.addEmployee(new EmployeeDo(2, "Bob", "Marketing"));

        // Fetch all employees
        List<EmployeeDo> employees = proxy.getAllEmployees();
        System.out.println("Employees: " + employees);

        // Fetch a specific employee
        EmployeeDo employee = proxy.getEmployeeById(1);
        System.out.println("Employee with ID 1: " + employee);

        // Delete an employee
        proxy.deleteEmployee(2);

        // Fetch all employees again
        employees = proxy.getAllEmployees();
        System.out.println("Employees after deletion: " + employees);
    }
}

