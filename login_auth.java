package login_window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public abstract class login_auth implements ActionListener{
	public static void main(String[] args){
		// creating a JPanel class
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
		JLabel label = new JLabel("Username");
		label.setBounds(100, 8, 70, 20);
		panel.add(label);
		
		// Username TextField constructor
		JTextField username = new JTextField();
		username.setBounds(100, 27, 193, 28);
		panel.add(username);
		
		// Password Label constructor
		JLabel password1 = new JLabel("Password");
		password1.setBounds(100, 55, 70, 20);
		panel.add(password1);
		
		// Password TextField
		JPasswordField Password = new JPasswordField();
		Password.setBounds(100, 75, 193, 28);
		panel.add(Password);
		
		// Button constructor
		JButton login = new JButton("Login");
		login.setBounds(100, 110, 90, 25);
		login.setForeground(Color.WHITE);
		login.setBackground(Color.BLUE);
		//login.addActionListener((ActionListener) new Java_GUI());
		panel.add(login);
		login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String Username = username.getText();
            	String Password1 = Password.getText();
            	if (Username.equals("section.io") && Password1.equals("123"))
            		JOptionPane.showMessageDialog(null, "Login Successful");
            	else
            		JOptionPane.showMessageDialog(null, "Username or Password mismatch");
            }
        });
		
		JButton register = new JButton("Sign up");
		register.setBounds(200, 110, 90, 25);
		register.setForeground(Color.WHITE);
		register.setBackground(Color.BLUE);
		panel.add(register);
		register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String Username = username.getText();
            	String Password1 = Password.getText();
            	JOptionPane.showMessageDialog(null, "Account created");
            }
        });
		
		frame.setVisible(true);
		

	 }
	
}
