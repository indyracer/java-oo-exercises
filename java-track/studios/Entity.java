import java.util.ArrayList;

public abstract class Entity {


	private final int uid;
	private static ArrayList<Entity> userIds = new ArrayList<Entity>();

	public Entity(){
	/*	//validate that uid is not a negative number
		
		
		if(valUid < 0){
			//assign new positive int by multiply by -1
			valUid = valUid * -1;
			}
		
		//validate uid is unique, run through arrayList looking for uid value, if uid value is found, assign new uid 
		int newUid = 0;
		for(int i = 0; i < userIds.size(); i++)
		{
			if(userIds.get(i).equals(valUid))
			{
				newUid = userIds.size() + 1;
			}
		}
		//means that dup number has been found
		if(newUid > 0)
		{
			uid = newUid;
		}
		else
		//means number wasn't not found in arrayList and sets the uid	
		{
			uid = valUid;
		}
		
		userIds.add(this);*/
		
		uid = userIds.size() + 1;
		userIds.add(this);
		
		

	}

	public int getUid() {
		return uid;
	}
	
	public static int nextId()
	{
		return userIds.size() + 1;
	}



}
