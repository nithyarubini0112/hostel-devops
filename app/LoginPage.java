import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {
    JTextField user;
    JPasswordField pass;

    LoginPage() {
        setTitle("Login");
        setSize(300,200);
        setLayout(new GridLayout(3,2));

        add(new JLabel("Username"));
        user = new JTextField();
        add(user);

        add(new JLabel("Password"));
        pass = new JPasswordField();
        add(pass);

        JButton login = new JButton("Login");
        add(login);

        login.addActionListener(e -> {
            if(user.getText().equals("admin") &&
               new String(pass.getPassword()).equals("admin")) {
                new Dashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Invalid");
            }
        });

        setVisible(true);
    }
}