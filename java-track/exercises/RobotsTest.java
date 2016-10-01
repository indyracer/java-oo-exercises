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
	
	@Test
	public void testChangeOrient1() {
		Robots c = new Robots("c", 3, 2, 5, 0);
		assertTrue(c.getOrientation() == 0);
		c.changeOrientation(90);
		assertTrue("The new orientation is " + c.getOrientation() + " while it should be 90", c.getOrientation() == 90);
	}

	@Test
	public void testChangeOrient2() {
		Robots c = new Robots("c", 3, 2, 5, 270);
		assertTrue(c.getOrientation() == 270);
		c.changeOrientation(90);
		assertTrue("The new orientation is " + c.getOrientation() + " while it should be 0", c.getOrientation() == 0);
	}
	
	@Test
	public void testChangeOrient3() {
		Robots c = new Robots("c", 3, 2, 5, 0);
		assertTrue(c.getOrientation() == 0);
		c.changeOrientation(-90);
		assertTrue("The new orientation is " + c.getOrientation() + " while it should be 270", c.getOrientation() == 270);
	}
	
	@Test
	public void testChangeOrient4() {
		Robots c = new Robots("c", 3, 2, 5, 180);
		assertTrue(c.getOrientation() == 180);
		c.changeOrientation(-90);
		assertTrue("The new orientation is " + c.getOrientation() + " while it should be 90", c.getOrientation() == 90);
	}
	
	@Test
	public void testFacing1() {
		Robots c = new Robots("c", 3, 2, 5, 0);
		assertTrue("Facing is " + c.facing() + " while it should be North",c.facing() == "North");
		}
	
	@Test
	public void testFacing2() {
		Robots c = new Robots("c", 3, 2, 5, 90);
		assertTrue("Facing is " + c.facing() + " while it should be East",c.facing() == "East");
		}
	
	@Test
	public void testFacing3() {
		Robots c = new Robots("c", 3, 2, 5, 180);
		assertTrue("Facing is " + c.facing() + " while it should be South", c.facing() == "South");
		}
	
	@Test
	public void testFacing4() {
		Robots c = new Robots("c", 3, 2, 5, 270);
		assertTrue("Facing is " + c.facing() + " while it should be West",c.facing() == "West");
		}
}
