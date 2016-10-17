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
	private static ArrayList<Course> courseList = new ArrayList<Course>();
	
	public Course(String courseName, int credits, int numSeatsRemain) {
		super();
		this.courseName = courseName;
		this.credits = credits;
		this.numSeatsRemain = numSeatsRemain;
		this.classRoster = new ArrayList<Student>();
		courseList.add(this);
		
		
		}
	
	public static ArrayList getAllCourses(){
		return courseList;
	}
	
	
	public String getName() {
		return this.courseName;
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
	
	public void generateRoster(Course courseName)
	{
		//run through arraylist and print the names
		for(int i = 0; i < this.classRoster.size(); i++)
		{
			String name = this.classRoster.get(i).getName();
			System.out.println(name);
		}
		
	}
	
	public double averageGPA()
	{
		//need to get the GPA for each person in the course
		double totalGPA = 0;
		for(int i = 0; i < classRoster.size(); i++)
		{
			double studentGPA = this.classRoster.get(i).getGPA();
			totalGPA = totalGPA + studentGPA;
		}
		
		return totalGPA / classRoster.size();
	}
	
	
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", credits=" + credits + ", numSeatsRemain=" + numSeatsRemain
				+ ", classRoster=" + classRoster + "]";
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course test1 = new Course("english", 3, 20);
		Course test2 = new Course("math", 4, 20);
		
		System.out.println(courseList);
		
	}

}
