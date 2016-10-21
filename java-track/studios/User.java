import java.util.ArrayList;
import java.util.regex.Pattern;

public class User {
	
	/*
	 * User has
	 * username
	 * password
	 */
	
	private String username;
	private String password;
	private static ArrayList<User> userList = new ArrayList<User>();
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = hashPassword(password);
		userList.add(this);
	}
	
	private static String hashPassword(String password)
	{
		String hashPassword = password;
		return hashPassword;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean isValidPassword(String password)
	{
		if(this.password != hashPassword(password))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static Boolean isValidUsername(String username)
	{
		String regex = "[a-zA-Z][a-zA-Z0-9_-]{4,11}";
		Boolean test = Pattern.matches(regex, username);
		
		if(test == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getArraySize()
	{
		return userList.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
