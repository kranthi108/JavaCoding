package DesignPatterns.Proxy;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private List<EmployeeDo> employees = new ArrayList<>();

    @Override
    public List<EmployeeDo> getAllEmployees() {
        return employees;
    }

    @Override
    public EmployeeDo getEmployeeById(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addEmployee(EmployeeDo employee) {
        employees.add(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employees.removeIf(emp -> emp.getId() == id);
    }
}
