import static org.junit.Assert.*;

import org.junit.Test;

public class RobotsTest {

	@Test
	public void testMove1() {
		Robots c = new Robots("c", 3, 2, 5, 0);
		assertTrue(c.getPosY() == 2);
		c.move(6);
		assertTrue("The Y pos is " + c.getPosY() + " while it should be 8", c.getPosY() == 8);
	}
	
	@Test
	public void testMove2(){
		Robots c = new Robots("c", 3, 2, 5, 90);
		assertTrue(c.getPosX() == 3);
		c.move(7);
		assertTrue("The X pos is " + c.getPosX() + " while it should be 10", c.getPosX() == 10);
	}
	
	@Test
	public void testMove3(){
		Robots c = new Robots("c", 3, 2, 5, 270);
		assertTrue(c.getPosX() == 3);
		c.move(7);
		assertTrue("The X pos is " + c.getPosX() + " while it should be -4", c.getPosX() == -4);
	}
	
	@Test
	public void testMove4() {
		Robots c = new Robots("c", 3, 2, 5, 180);
		assertTrue(c.getPosY() == 2);
		c.move(6);
		assertTrue("The Y pos is " + c.getPosY() + " while it should be -4", c.getPosY() == -4);
	}

}
