import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class UserAndBlogzTest {

	@Test
	public void hashPasswordtest() {
		User test = new User("userName", "test");
		assertEquals("The passwords isn't hashed", true, test.getPassword() == "test");

	}

	@Test
	public void validUserNameTest() {
		User test = new User("userName9595", "test");
		Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]{4,11}");
		Matcher m = p.matcher(test.getUsername());
		Boolean b = m.matches();
		assertTrue("The username isn't valid", b);

	}
	
	//users for equality testing
	User user1 = new User("test", "test");
	User user2 = new User("test", "test");
	User user3 = new User("test", "test");
	
	@Test
	public void testEqualsOperator(){
		assertTrue(user1 == user1);
		assertFalse(user1 == user2);
	}
	
	@Test
	public void testSelfEquals(){
		assertTrue(user1.equals(user1));
		assertTrue(user2.equals(user2));
		assertTrue(user3.equals(user3));
	}
	
	@Test
	public void testValuecheck(){
		//since checking UID, these should be false
		assertFalse(user1.equals(user2));
		assertFalse(user2.equals(user1));
	}
	
	@Test
	public void testTransivity(){
		//since checking UID, these should be false
		assertFalse(user1.equals(user2));
		assertFalse(user2.equals(user3));
		assertFalse(user3.equal(user1));
	}
	
	
	


}
