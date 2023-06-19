import javax.swing.*;
import java.awt.*;
import java.awt.event;

public class login_auth{
    public static void main(String[] args){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        // JFrame class
        JFrame frame = new JFrame();
        frame.setTitle("LOGIN PAGE");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Username label constructor
        label = new JLabel("Username");
        label.setBounds(100, 8, 70, 20);
        panel.add(label);

        // Username TextField constructor
        username = new JTextField();
        username.setBounds(100, 27, 193, 28);
        panel.add(username);

        // Password Label constructor
        password1 = new JLabel("Password");
        password1.setBounds(100, 55, 70, 20);
        panel.add(password1);

        // Password TextField
        Password = new JPasswordField();
        Password.setBounds(100, 75, 193, 28);
        panel.add(Password);

        // Button constructor
        button = new JButton("Login");
        button.setBounds(100, 110, 90, 25);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.addActionListener((ActionListener) new Java_GUI());
        panel.add(button);
    }
    public class Java_GUI implements ActionListener {
        private static JLabel password1, label;
        private static JTextField username;
        private static JButton button;
        private static JPasswordField Password;

    }
    // Imlementing an action event listener class with conditional statement
    @Override
    public void actionPerformed(ActionEvent e) {
        String Username = username.getText();
        String Password1 = Password.getText();

        if (Username.equals("section.io") && Password1.equals("123"))
            JOptionPane.showMessageDialog(null, "Login Successful");
        else
            JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
    }
}