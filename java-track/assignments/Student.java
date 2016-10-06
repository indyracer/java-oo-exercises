
public class Student {
	
	/*
	 * Student has
	 * First Name
	 * Last Name
	 * Student ID
	 * Credits
	 * GPA
	 * 
	 * Student Behaviors
	 * Class Standing:  returns student's class standing based on credit hours
	 * Submit Grade:  takes a course grade, applies to number of credits for Quality score
	 * Compute Tuition:  returns total amount of tuition student has paid
	 * Create Legacy:  Take Student object and create a new Student with specific criteria
	 */
	
	private String firstName;
	private String lastName;
	private int studentID;
	private int credits;
	private double gpa;
	private double totalQualityScore;
	//private double qualityScore;
	
	
	public Student(String firstName, String lastName, int studentId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentId;
	}
	
	public int getCredits() {
		return this.credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
		}

	public double getGPA() {
		
		System.out.println((getCredits()*1000.0)/1000.0);
		System.out.println(totalQualityScore());
		this.gpa = Math.round(totalQualityScore() / (double)getCredits() * 1000.0) / 1000.0;
		//this.gpa = Math.round((this.gpa * 1000.0)/1000.0);
		return this.gpa;
	}

	public void setGPA(double gpa) {
		this.gpa = gpa;
		gpa = Math.round(gpa*1000)/1000;
	}


	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getName(){
		String name = firstName + " " + lastName;
		return name;
	}

	public int getStudentID() {
		return this.studentID;
	}
	
	public double totalQualityScore()
	{
		return this.totalQualityScore;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", studentId=" + studentID + ", credits="
				+ credits + ", gpa=" + gpa + "]";
	}
	
	public String getClassStanding()
	{
		if(getCredits() < 30)
		{
			return "Freshman";
		}
		
		else if(getCredits()>=30 && credits < 60)
		{
			return "Sophomore";
		}
		else if(getCredits()>= 60 && credits < 90)
		{
			return "Junior";
		}
		else
		{
			return "Senior";
		}
	}
	
	public void submitGrade(double grade, double credits)
	{
		double qualityScore = grade * credits;
		this.credits = (int) (this.credits + credits);
		this.totalQualityScore = this.totalQualityScore + (double)qualityScore;
		
	}
	
	public int computeTuition()
	{
		int fullSemCost = 20000;
		double proRate = 1333;
		//determine left over semester credits
		int leftOverSems = getCredits() % 15;
		//determine number of full semesters
		int fullSems = getCredits() / 15;
		
		int fullCost = fullSemCost * fullSems;
		double proRateCost = leftOverSems * proRate;
		
		return (int) (fullCost + proRateCost);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student bob = new Student("Bob", "Cohen", 1234);
		bob.submitGrade(3, 14);
		System.out.println(bob.getGPA());
		System.out.println(bob.getClassStanding());
		System.out.println(bob.computeTuition());
		
	}

}
