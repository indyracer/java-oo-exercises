import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RobotsMenu2 {

	private JFrame frmRobot;
	private DefaultListModel<Robots> robots;
	private JList list;
	
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotsMenu2 window = new RobotsMenu2();
					window.frmRobot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RobotsMenu2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRobot = new JFrame();
		frmRobot.setTitle("Robot");
		frmRobot.setBounds(100, 100, 443, 300);
		frmRobot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRobot.getContentPane().setLayout(null);
		
		robots = new DefaultListModel<Robots>();
		list = new JList(robots);
		list.setBounds(169, 25, 248, 122);
		frmRobot.getContentPane().add(list);
		
		JButton btnCreateRobot= new JButton("Create Robot");
		btnCreateRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//this pulls in the selected robot, on top of each action event
				int selected = list.getSelectedIndex();
				//name
				String name = (String) JOptionPane.showInputDialog(frmRobot, "Name of Robot", "Name", JOptionPane.PLAIN_MESSAGE, null, null, "");
				//set x pos, bring in as string, then parse to int
				String xPos = (String) JOptionPane.showInputDialog(frmRobot, "Starting x position", "x Pos", JOptionPane.PLAIN_MESSAGE, null, null, "");
				int x = Integer.parseInt(xPos);
				//set y pos, bring in as string, then parse to int
				String yPos = (String) JOptionPane.showInputDialog(frmRobot, "Starting y position", "y Pos", JOptionPane.PLAIN_MESSAGE, null, null, "");
				int y = Integer.parseInt(yPos);
				//set speed
				int speed = (int)posNum("Starting Speed", "Starting Speed");
				
				//set orientation
				String startOrientation = (String) JOptionPane.showInputDialog(frmRobot, "Enter Number for Starting Orientation (0 = North; 90 = East; 180 = South; 270 = West)", "Starting Orientation", JOptionPane.PLAIN_MESSAGE, null, null, "");
				int orientation = Integer.parseInt(startOrientation);
				//use create method
				
				Robots r = new Robots(name, x, y, speed, orientation);
				robots.add(robots.size(), r);
				
			}
		});
		btnCreateRobot.setBounds(10, 22, 122, 23);
		frmRobot.getContentPane().add(btnCreateRobot);
		
		JButton btnNewButton = new JButton("Move Robot");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*int selected = list.getSelectedIndex();
				
				int moveSpeed = (int)posNum("How far do you want to move?", "How for do you want to move?");
				
				robots.getElementAt(selected).move(moveSpeed);*/
				
			}
		});
		btnNewButton.setBounds(10, 56, 122, 23);
		frmRobot.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rotate Robot");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 137, 89, 23);
		frmRobot.getContentPane().add(btnNewButton);
		
		JButton btnRotateRobot = new JButton("Rotate Robot");
		btnRotateRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRotateRobot.setBounds(10, 90, 122, 23);
		frmRobot.getContentPane().add(btnRotateRobot);
		
		JButton btnComputeDistance = new JButton("Compute Distance");
		btnComputeDistance.setBounds(10, 124, 122, 23);
		frmRobot.getContentPane().add(btnComputeDistance);
		
		
	}
	
	//do validation for positive values
	public double posNum(String prompt, String title)
	{
		String s = (String) JOptionPane.showInputDialog(frmRobot, prompt, title, JOptionPane.PLAIN_MESSAGE, null, null, "");
		double sInt = Double.parseDouble(s);
		
		while(sInt < 0)
		{
			s = (String)JOptionPane.showInputDialog(frmRobot, 
					prompt + "Please enter a positive number", 
					title, 
					JOptionPane.PLAIN_MESSAGE, 
					null, 
					null, 
					"");
			sInt = Double.parseDouble(s);
			
					 
		}
		return sInt;
	}
}
