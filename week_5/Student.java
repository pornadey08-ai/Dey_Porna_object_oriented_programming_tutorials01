public class Student {
    // Private variables (encapsulation)
    private String studentID;
    private String name;
    private double cgpa;
    private String programme;  // New variable added

    // Constructor
    public Student(String studentID, String name, double cgpa, String programme) {
        this.studentID = studentID;
        this.name = name;
        this.cgpa = cgpa;
        this.programme = programme;
    }

    // Getter for studentID
    public String getStudentID() {
        return studentID;
    }

    // Setter for studentID
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for cgpa
    public double getCGPA() {
        return cgpa;
    }

    // Setter for cgpa
    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }

    // Getter for programme
    public String getProgramme() {
        return programme;
    }

    // Setter for programme
    public void setProgramme(String programme) {
        this.programme = programme;
    }
}