import java.util.ArrayList;
import java.util.Scanner;


public class RobotMenu {

	/*
	 * has a
	 * 1. list of Robots created
	 * 2. Scanner object used for accepting user input
	 * 
	 * Behaviors
	 * when menu starts, prints out list of available options
	 * menu can accept an input from the user indicating which option they would like to perform, account for invalid options
	 * once valid option accepted, menu to ask user which robot to manipulate
	 * 
	 */

	private ArrayList<Robots> robots;
	private Scanner s;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//bring up menu and asks for option
		int x = 0;
		RobotMenu rm = new RobotMenu();
		do {
			x = rm.startMenu();
			rm.processInput(x);
		} while (x != 6);
	}


	public RobotMenu()
	//Constructor statements:  make sure instance variables have values.
	{
		s = new Scanner(System.in);
		robots = new ArrayList<Robots>();
	}

	public int startMenu()
	//display menu
	{
		System.out.println("Welcome to the robots menu!");
		System.out.println("1. Create a Robot");
		System.out.println("2. Display the list of avialable robots");
		System.out.println("3. Move a robot");
		System.out.println("4. Rotate a robot");
		System.out.println("5. Compute the distance between two robots");
		System.out.println("6. Exit");
		System.out.println("Please select an option:  ");
		//takes in the selection
		int selection = s.nextInt();
		//validate input
		while(selection < 0 || selection > 6)

		{
			System.out.println("Invalid selection, please try again:  ");
			selection = s.nextInt();
		}

		return selection;
	}


	public void processInput(int selection){
		//processing of the input from the menu

		if(selection == 1)
		{
			createRobot();
		}
		else if(selection == 2)
		{
			displayRobots();
		}
		else if (selection == 3)
		{
			displayRobots();
			Robots c = selectRobots();
					
			c.move(c.getSpeed());
			System.out.println("The robot is now located at x position " + c.getPosX()+ " and y position " + c.getPosY());
			System.out.println();
		}
		else if (selection == 4)
		{
			displayRobots();
			Robots c = selectRobots();
			
			System.out.println("How much would you like to rotate (in multiples of 90)?  ");
			int rotate = s.nextInt();
			
			c.changeOrientation(rotate);
			
			System.out.println("The robot is now facing " + c.facing());
			System.out.println();
		}

	}

	public Robots selectRobots()
	{
		System.out.println("Please select a Robot:  ");
		int selection = s.nextInt();
		while(selection < 1 || selection > robots.size())
		{
			System.out.println("Invalid selection, please try again:  ");
			selection = s.nextInt();
		}
		return robots.get(selection - 1);
	}

	public void createRobot()
	{
		//creates new Robot		
		System.out.println("Enter a name for the robot: ");
		String name = s.next();

		System.out.println("Enter an x position for the robot:  ");
		int posX = s.nextInt();

		System.out.println("Enter a y position for the robot:  ");
		int posY = s.nextInt();

		System.out.println("Enter a speed for the robot:  ");
		int speed = s.nextInt();

		System.out.println("Enter an orientation for the robot(0 = North, 90 = East, 180 = South, 270 = West):  ");
		int orientation = s.nextInt();

		robots.add(new Robots(name, posX, posY, speed, orientation));

	}

	public void displayRobots()
	{
		for(int i = 0; i < robots.size(); i++)
		{
			System.out.println((i+1) + ".)" + robots.get(i));
			System.out.println();
		}
	}


}

