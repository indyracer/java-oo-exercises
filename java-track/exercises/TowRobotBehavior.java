import java.util.Scanner;

public class TowRobotBehavior implements RobotBehavior {

	private String needTow;
	private String nextMove;
	private Robots r;



	public TowRobotBehavior(String needTow, String nextMove, Robots r){
		this.needTow = needTow;
		this.nextMove = nextMove;
		this.r = r;

	}

	public Robots setBehavior(RobotBehavior behavior){
		//don't understand what this method should take in or be constructed.
		

	}

	@Override
	public Robots doNextMove() {
		// TODO Auto-generated method stub
		//turn the robot to do the next move, change the orientation
		if(this.nextMove != "y"){
			return r;
		}
		else{
			r.getOrientation();

			Scanner in = new Scanner(System.in);
			System.out.println("Which way would you like to turn?  Left or Right?");
			String turn = in.next();
			if(turn != "Right" && turn != "Left")
			{
				System.out.println("Invalid selection.  Please input 'Left' or 'Right'");
				turn = in.next();
			}
			else{
				if(turn == "Right")
				{
					r.changeOrientation(90);
					System.out.println(r.toString());

				}
				else
				{
					r.changeOrientation(-90);
					System.out.println(r.toString());

				}
			} return r;

		}



	}

	@Override
	public Robots needTow() {
		// TODO Auto-generated method stub
		if(needTow != "y"){
			return r;
		}

		else
		{
			int speed = 0;
			r.move(speed);
			return r;
		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robots r = new Robots("test", 3, 4, 5, 90);
		r.doNextMove("n");


	}




}
