package DesignPatterns.Proxy;

import java.util.List;

import java.util.List;

public interface EmployeeDao {
    List<EmployeeDo> getAllEmployees();
    EmployeeDo getEmployeeById(int id);
    void addEmployee(EmployeeDo employee);
    void deleteEmployee(int id);
}
