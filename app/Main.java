import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    String dept;
    String hostel;

    Student(int id, String name, String dept, String hostel) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.hostel = hostel;
    }

    public String toString() {
        return id + "," + name + "," + dept + "," + hostel;
    }
}

public class Main {
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student\n2. View Students\n3. Exit");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt(); sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Dept: ");
                String dept = sc.nextLine();

                System.out.print("Hostel: ");
                String hostel = sc.nextLine();

                Student s = new Student(id, name, dept, hostel);
                students.add(s);

                saveToFile(s);
            }
            else if (ch == 2) {
                readFromFile();
            }
            else break;
        }
    }

    static void saveToFile(Student s) throws Exception {
        FileWriter fw = new FileWriter("students.txt", true);
        fw.write(s.toString() + "\n");
        fw.close();
    }

    static void readFromFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}