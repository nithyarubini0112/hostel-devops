import java.io.*;
import java.util.*;

public class ConsoleMain {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        while (true) {
            System.out.println("\n--- Hostel Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search by ID");
            System.out.println("4. Delete by ID");
            System.out.println("5. Filter by Hostel");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: deleteStudent(); break;
                case 5: filterHostel(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid Choice!");
            }
        }
    }

    static void addStudent() throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Dept: ");
        String dept = sc.nextLine();

        System.out.print("Hostel: ");
        String hostel = sc.nextLine();

        Student s = new Student(id, name, dept, hostel);

        FileWriter fw = new FileWriter("students.txt", true);
        fw.write(s.toString() + "\n");
        fw.close();

        System.out.println("Student Added!");
    }

    static void viewStudents() throws Exception {
        File file = new File("students.txt");
        if (!file.exists()) {
            System.out.println("No records found.");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    static void searchStudent() throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        File file = new File("students.txt");
        if (!file.exists()) {
            System.out.println("No records found.");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.startsWith(id + ",")) {
                System.out.println("Found: " + line);
                br.close();
                return;
            }
        }
        br.close();
        System.out.println("Not Found");
    }

    static void deleteStudent() throws Exception {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        File input = new File("students.txt");
        File temp = new File("temp.txt");

        if (!input.exists()) {
            System.out.println("No records found.");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(input));
        BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

        String line;
        while ((line = br.readLine()) != null) {
            if (!line.startsWith(id + ",")) {
                bw.write(line + "\n");
            }
        }

        br.close();
        bw.close();

        input.delete();
        temp.renameTo(input);

        System.out.println("Deleted Successfully");
    }

    static void filterHostel() throws Exception {
        System.out.print("Enter Hostel Name: ");
        sc.nextLine();
        String hostel = sc.nextLine();

        File file = new File("students.txt");
        if (!file.exists()) {
            System.out.println("No records found.");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.endsWith("," + hostel)) {
                System.out.println(line);
            }
        }

        br.close();
    }
}