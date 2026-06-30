public class Lecturer extends Employee {
    // Additional variable for Lecturer
    private String subject;

    // Constructor
    public Lecturer(String id, String name, String subject, String department) {
        super(id, name, department);
        this.subject = subject;
    }

    // Getter for subject
    public String getSubject() {
        return subject;
    }

    // Setter for subject
    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Display subject
    public void displaySubject() {
        System.out.println("Subject     : " + subject);
    }

    // Override displayInfo to show all details
    @Override
    public void displayInfo() {
        System.out.println("Employee ID : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Subject     : " + subject);
        System.out.println("Department  : " + department);
    }
}