import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Hostel Management Backend Running...");

        int counter = 1;

        while (true) {

            Student s = new Student(counter, "Student" + counter, "CSE", "SRR");
            saveToFile(s);
            System.out.println("Added: " + s);

            System.out.println("\n--- Dashboard ---");
            readFromFile();

            counter++;

            Thread.sleep(5000);
        }
    }

    static void saveToFile(Student s) throws Exception {
        FileWriter fw = new FileWriter("students.txt", true);
        fw.write(s.toString() + "\n");
        fw.close();
    }

    static void readFromFile() throws Exception {
        File file = new File("students.txt");
        if (!file.exists()) return;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}