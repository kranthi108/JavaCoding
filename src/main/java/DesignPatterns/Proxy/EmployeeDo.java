package DesignPatterns.Proxy;

public class EmployeeDo {
    private int id;
    private String name;
    private String department;

    // Constructor
    public EmployeeDo(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDo [id=" + id + ", name=" + name + ", department=" + department + "]";
    }
}
