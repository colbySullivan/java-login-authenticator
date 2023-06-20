package login_window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

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
		
		//HashMap<String, String> credentials = new HashMap<String, String>();
		String Username = username.getText();
    	String Password1 = Password.getText();
    	HashMap credentials = check_credentials(Username, Password1);
		System.out.print(credentials);
		// Login button action
		login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String Username = username.getText();
            	String Password1 = Password.getText();
            	if(credentials.containsKey(Username) && credentials.get(Username).equals(Password1))
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
            	if(!credentials.containsKey(Username)) {
	            	try {
						create_account(Username, Password1);
						credentials.put(Username, Password1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	JOptionPane.showMessageDialog(null, "Account created");
	            }
            	else
            		JOptionPane.showMessageDialog(null, "Username already exist");
            }
        });
		frame.setVisible(true);
	 }

	  static HashMap check_credentials(String username, String password) {
		HashMap<String, String> credentials = new HashMap<String, String>();
		File loginf = new File("users.txt");
  		try (Scanner read = new Scanner(loginf)) {
  			while(read.hasNext()){
  			   String user = read.next();
  			   String pass = read.next();
  			   credentials.put(user, pass);
  			}
  		} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
  			System.out.print("File not found");
				//e1.printStackTrace();
			}
		return credentials;
	  }
	  static void create_account(String username, String password1) throws IOException {
		File fileName = new File("users.txt");
		FileWriter fw = new FileWriter(fileName, true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    String formatted = username + "\n" + password1;
	    bw.newLine();
	    bw.write(formatted);
	    bw.newLine();
	    bw.close();
	  }
	
}
