import javax.swing.*;

public class Dashboard extends JFrame {

    Dashboard() {
        setTitle("Dashboard");
        setSize(300,200);

        JButton add = new JButton("Add Student");
        add(add);

        add.addActionListener(e -> new AddStudent());

        setVisible(true);
    }
}
