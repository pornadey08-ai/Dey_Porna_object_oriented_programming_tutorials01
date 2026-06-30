public class Employee {
    // Protected variables for inheritance
    protected String id;
    protected String name;
    protected String department;  // New variable added

    // Constructor
    public Employee(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getter for id
    public String getId() {
        return id;
    }

    // Setter for id
    public void setId(String id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for department
    public String getDepartment() {
        return department;
    }

    // Setter for department
    public void setDepartment(String department) {
        this.department = department;
    }

    // Display employee information
    public void displayInfo() {
        System.out.println("Employee ID : " + id);
        System.out.println("Name        : " + name);
    }
}