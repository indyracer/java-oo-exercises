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
	
	@


}
