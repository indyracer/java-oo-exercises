
public class TowTruckRobot extends Robots {

	boolean isAvail;


	public TowTruckRobot(String name, int posX, int posY, int speed, int orientation){
		super(name, posX, posY, speed, orientation);
		this.isAvail = true;

	}

	public void canTow()
	{
		this.isAvail = true; 
	}

	public void noTow()
	{
		this.isAvail = false;
	}


	public String moveRobot(Robots r)
	{
		//check if tow is avail
		if(this.isAvail == false)
		{
			return "Sorry, we can't tow you right now";
		}
		else
		{

			//to move robot, take TowTruck x and y post and add to r
			int towX = this.posX;
			int towY = this.posY;
			int newXpos= r.getPosX() + towX;
			int newYpos = r.getPosY() + towY;

			r.setPosX(newXpos);
			r.setPosY(newYpos);
			
			return "Robot was moved";
		}

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TowTruckRobot t = new TowTruckRobot("tow", 6, 6, 5, 90);
		Robots r = new Robots("test", 5, 6, 6, 90);
		
		
		
		t.moveRobot(r);
		
		t.noTow();
		
		t.moveRobot(r);
		


	}

}


