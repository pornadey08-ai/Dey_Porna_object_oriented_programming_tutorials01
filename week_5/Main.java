public class Main {
    public static void main(String[] args) {
        // Create a student with the exact details from the PDF
        Student student = new Student("CU12345", "Ali", 3.75, "BIT");
        
        // Display student information
        System.out.println("Student ID : " + student.getStudentID());
        System.out.println("Name : " + student.getName());
        System.out.println("CGPA : " + student.getCGPA());
        System.out.println("Programme: " + student.getProgramme());
    }
}