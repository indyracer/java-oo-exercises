
public class Robots {
	
	/*
	 * robot has
	 * name, String
	 * position x, int
	 * position y, int
	 * speed, int
	 * orientation, int (N = 0, E = 90, S = 180, W = 270)
	*/
	
	private String name;
	protected int posX;
	protected int posY;
	private int speed;
	private int orientation;
	
	/*
	 * behaviors
	 * create robot
	 * move based on current position, orientation and speed
	 * rotate changes orientation by 90 degrees
	 * determine distance from another Robot object
	 *to String contains name, position, speed and orientation
	 **/
	
	public Robots(String name, int posX, int posY, int speed, int orientation){
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
		this.orientation = orientation;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getSpeed(){
		return this.speed;
	}
	
	public int getOrientation(){
		return this.orientation;
	}
	
	//do I need this????
	/*public void Position(int x, int y){
		x = this.posX;
		y = this.posY;
	}*/
	
	public int getPosX(){
		return this.posX;
	}
	
	public int getPosY(){
		return this.posY;
	}
	
	
	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int move (int speed){
		if(this.orientation == 0){
			//add speed to y position
			return this.posY = this.posY + speed;
		}
		else if(this.orientation == 180){
			//Subtract speed from y position
			return this.posY = this.posY - speed;
		}
		else if(this.orientation == 90){
			//add speed to x position
			return this.posX = this.posX + speed;
		}
		else{
			//assume orientation is 270, subtract speed from x position
			return this.posX = this.posX - speed;
		}
		
	}
	
	public void setBehavior(doNextMove()){
		
	}
	
	public void changeOrientation(int rotate){
		if(rotate == 90 && this.orientation == 270){
			this.orientation = 0;
		}
		else if (rotate == -90 && this.orientation == 0){
			this.orientation = 270;
		}
		else{
			this.orientation = this.orientation + rotate;
		}
	}
	
	public String facing(){
		if(this.orientation == 0){
			return "North";
		}
		else if(this.orientation == 90){
			return "East";
		}
		else if(this.orientation == 180){
			return "South";
		}
		else{
			return "West";
		}
	}
	
	//use distance formula "distance[i]=(Math.sqrt(Math.pow(intPos[i][0] - intPos[j][0], 2))+(Math.pow(intPos[i][1] - intPos[j][1], 2)));"
	
	/*public void distance(double x2, double y2){
		double dist = (Math.sqrt(Math.pow(this.posX - x2, 2))+(Math.pow(this.posY - y2, 2)));
	}*/
	
	public Double distance(double x2, double y2){
		double dist = (Math.sqrt(Math.pow(this.posX - x2, 2))+(Math.pow(this.posY - y2,2)));
		return dist;
	}
	
	public String toString(){
		return "The robot " + name + " is at position (" + this.getPosX() + "," + this.getPosY() +"), and is facing " + facing();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robots bob = new Robots("bob", 3, 2, 5, 0);
		
		System.out.println(bob.toString());
		
		
		
		System.out.println(bob.toString());
		System.out.println("Bob will no change orientation to face South and move at a speed of 7");
		
		
		System.out.println("distance is " + bob.distance(5, 9));
		
	}

}
