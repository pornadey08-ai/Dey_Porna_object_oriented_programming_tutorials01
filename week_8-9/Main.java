import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // ===== ACTIVITY 1 =====
        System.out.println("===== ACTIVITY 1 =====");
        ArrayList<String> tasks1 = new ArrayList<>();
        
        System.out.println("===== ADD TASKS =====");
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter Task " + i + ": ");
            String task = scanner.nextLine();
            tasks1.add(task);
        }
        
        System.out.println("\n===== TASK LIST =====");
        for (int i = 0; i < tasks1.size(); i++) {
            System.out.println((i + 1) + ". " + tasks1.get(i));
        }
        
        // SAVE ACTIVITY 1 TO FILE (creates new file)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("task.txt"))) {
            writer.write("===== ACTIVITY 1 TASKS =====");
            writer.newLine();
            for (String task : tasks1) {
                writer.write(task);
                writer.newLine();
            }
            writer.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        // ===== ACTIVITY 2 =====
        System.out.println("\n===== ACTIVITY 2 =====");
        ArrayList<String> tasks2 = new ArrayList<>();
        
        System.out.println("===== ADD TASKS =====");
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter Task " + i + ": ");
            String task = scanner.nextLine();
            tasks2.add(task);
        }
        
        System.out.println("\n===== TASK LIST =====");
        for (int i = 0; i < tasks2.size(); i++) {
            System.out.println((i + 1) + ". " + tasks2.get(i));
        }
        
        // APPEND ACTIVITY 2 TO FILE (adds to existing file)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("task.txt", true))) {
            writer.write("===== ACTIVITY 2 TASKS =====");
            writer.newLine();
            for (String task : tasks2) {
                writer.write(task);
                writer.newLine();
            }
            System.out.println("\nTasks saved successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        // ===== READ FROM FILE =====
        System.out.println("\n===== TASKS LOADED FROM FILE =====");
        try (BufferedReader reader = new BufferedReader(new FileReader("task.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        scanner.close();
    }
}