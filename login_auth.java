package login_window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public abstract class main implements ActionListener{
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
		
		// Username label
		JLabel label = new JLabel("Username");
		label.setBounds(100, 8, 70, 20);
		panel.add(label);
		
		// Username TextField
		JTextField username = new JTextField();
		username.setBounds(100, 27, 193, 28);
		panel.add(username);
		
		// Password Label
		JLabel password1 = new JLabel("Password");
		password1.setBounds(100, 55, 70, 20);
		panel.add(password1);
		
		// Password TextField
		JTextField Password = new JPasswordField();
		Password.setBounds(100, 75, 193, 28);
		panel.add(Password);
		
		// Login button
		JButton login = new JButton("Login");
		login.setBounds(100, 110, 90, 25);
		login.setForeground(Color.WHITE);
		login.setBackground(Color.BLUE);
		panel.add(login);
		
		// Register button
		JButton register = new JButton("Sign up");
		register.setBounds(200, 110, 90, 25);
		register.setForeground(Color.WHITE);
		register.setBackground(Color.BLUE);
		panel.add(register);
		
		// Login button action
		login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String Username = username.getText();
            	String Password1 = Password.getText();
            	boolean login = check_credentials(Username, Password1);
            	if(login)
            		JOptionPane.showMessageDialog(null, "Login correct");
            	else
            		JOptionPane.showMessageDialog(null, "Login incorrect");
            }
        });
		
		// Register button action
		register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String Username = username.getText();
            	String Password1 = Password.getText();
            	create_account(Username, Password1);
            	JOptionPane.showMessageDialog(null, "Account created");
            }
        });
		frame.setVisible(true);
	 }

	  static boolean check_credentials(String username, String password) {
		File loginf = new File("users.txt");
		boolean login = false;
  		try (Scanner read = new Scanner(loginf)) {
  			read.useDelimiter("\\n|,");
  			while(read.hasNext()){
  			   String user = read.next();
  			   String pass = read.next();
  			   if(user.equals(username) && pass.equals(password))
  				   login = true;
  			}
  		} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
  			System.out.print("File not found");
				//e1.printStackTrace();
			}
		return login;
	}
	  static void create_account(String username, String password1) {
		  
	  }
	
}
