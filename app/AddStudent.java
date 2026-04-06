import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AddStudent extends JFrame {

    JTextField name, dept, hostel;

    AddStudent() {
        setTitle("Add Student");
        setSize(300,250);
        setLayout(new GridLayout(4,2));

        add(new JLabel("Name"));
        name = new JTextField();
        add(name);

        add(new JLabel("Department"));
        dept = new JTextField();
        add(dept);

        add(new JLabel("Hostel"));
        hostel = new JTextField();
        add(hostel);

        JButton save = new JButton("Save");
        add(save);

        save.addActionListener(e -> insert());

        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hostel_db",
                "root",
                "appaamma2203"
            );

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students(name,department,hostel) VALUES(?,?,?)"
            );

            ps.setString(1, name.getText());
            ps.setString(2, dept.getText());
            ps.setString(3, hostel.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,"Added");
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
} 