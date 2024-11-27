package DesignPatterns.Proxy;
import java.util.List;

public class EmployeeDaoProxy implements EmployeeDao {
    private EmployeeDaoImpl realDao;

    public EmployeeDaoProxy(EmployeeDaoImpl realDao) {
        this.realDao = realDao;
    }

    @Override
    public List<EmployeeDo> getAllEmployees() {
        System.out.println("Proxy: Fetching all employees...");
        return realDao.getAllEmployees();
    }

    @Override
    public EmployeeDo getEmployeeById(int id) {
        System.out.println("Proxy: Fetching employee with ID " + id);
        return realDao.getEmployeeById(id);
    }

    @Override
    public void addEmployee(EmployeeDo employee) {
        System.out.println("Proxy: Adding employee " + employee.getName());
        realDao.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        System.out.println("Proxy: Deleting employee with ID " + id);
        realDao.deleteEmployee(id);
    }
}
