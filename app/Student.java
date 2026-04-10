public class Student {
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