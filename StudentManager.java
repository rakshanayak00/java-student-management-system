import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
System.out.println("1. Add Student");
System.out.println("2. View Students");
System.out.println("3. Search Student by ID");
System.out.println("4. Delete Student by ID");
System.out.println("5. Exit");
System.out.print("Enter your choice: ");

            choice = sc.nextInt();

          switch (choice) {

    case 1:
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        students.add(new Student(id, name));
        System.out.println("Student added successfully!");
        break;

    case 2:
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("\nStudent List:");
            for (Student s : students) {
                s.display();
                System.out.println("------");
            }
        }
        break;

    case 3:
        System.out.print("Enter ID to search: ");
        int searchId = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.id == searchId) {
                System.out.println("Student Found:");
                s.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
        break;

    case 4:
        System.out.print("Enter ID to delete: ");
        int deleteId = sc.nextInt();
        boolean removed = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == deleteId) {
                students.remove(i);
                removed = true;
                System.out.println("Student deleted successfully!");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student not found.");
        }
        break;

    case 5:
        System.out.println("Exiting program...");
        break;

    default:
        System.out.println("Invalid choice. Try again.");
}

        } while (choice != 5);

        sc.close();
    }
}
