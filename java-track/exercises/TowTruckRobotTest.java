import static org.junit.Assert.*;

import org.junit.Test;

public class TowTruckRobotTest {

	@Test
	public void testMoveRobot() {
		Robots r = new Robots("test", 5, 3, 5, 90);
		TowTruckRobot t = new TowTruckRobot("towtruck", 6, 9, 6, 90);
		t.moveRobot(r);
		assertEquals("The robot new x pos should be 11", 11, r.getPosX());
		assertEquals("The robot's new y pos should be 12", 12, r.getPosY());
		
	}
	
	@Test
	public void testMoveRobotNo() {
		Robots r = new Robots("test", 5, 3, 5, 90);
		TowTruckRobot t = new TowTruckRobot("towtruck", 6, 9, 6, 90);
		t.noTow();
		t.moveRobot(r);
		assertFalse("The tower is not available and r shouldn't move", false);
		
		
	}

}
