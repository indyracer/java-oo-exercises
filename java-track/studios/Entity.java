import java.util.ArrayList;

public abstract class Entity {


	private final int uid;
	private static ArrayList<Integer> userIds = new ArrayList();

	public Entity(int uid){
		//validate that uid is not a negative number
		int valUid = uid;
		if(valUid < 0){
			//assign new positive int by multiply by -1
			valUid = valUid * -1;
			}
		
		//validate uid is unique, run through arrayList looking for uid value, if uid value is found, assign new uid 
		int newUid = 0;
		for(int i = 0; i < userIds.size(); i++)
		{
			if(userIds.get(i) == valUid)
			{
				newUid = userIds.size() + 1;
			}
		}
		
		if(newUid > 0)
		{
			this.uid = newUid;
		}
		else
		{
			this.uid = valUid;
		}
		
		

	}


	public int getUid() {
		return this.uid;
	}



}
