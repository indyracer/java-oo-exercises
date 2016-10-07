import java.util.ArrayList;
public class Course {
	
	//Course has
	/*
	 * course name
	 * credits
	 * Number of seats remaining
	 * Roster of Students
	 */
	
	private String courseName;
	private int credits;
	private int numSeatsRemain;
	private ArrayList<Student> classRoster;	
	
	public Course(String courseName, int credits, int numSeatsRemain) {
		super();
		this.courseName = courseName;
		this.credits = credits;
		this.numSeatsRemain = numSeatsRemain;
		this.classRoster = new ArrayList<Student>();
		}
	
	
	
	public String getName() {
		return courseName;
	}

	public int getCredits() {
		return credits;
	}

	public int getRemainingSeats() {
		return numSeatsRemain;
	}

	
	//add student to course, make sure there is space, returns a boolean
	
	public boolean addStudent(Student s)
	{
	//check there is space
		if(getRemainingSeats() < 1)
		{
			return false;
		}
		
	//check if student is already on class roster, return false
		if(classRoster.contains(s))
		{
			return false;
		}
		
		//add student to roster
		classRoster.add(s);
		//decrement remaining seats
		this.numSeatsRemain = this.numSeatsRemain - 1;
		
		return true;

	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
