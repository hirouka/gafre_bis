import general.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaseTest {
        
	@Test
	public void test1() {
		Case c = new Case(1,2);
		assertEquals("getX marche pas", c.getX(), 1);
	}
	
	@Test
	public void test2() {
		Case c = new Case(1,2);
		assertEquals("getY marche pas", c.getY(), 2);
	}
	
	

}
