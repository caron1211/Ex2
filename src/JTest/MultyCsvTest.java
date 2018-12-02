package JTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Algorithms.MultiCSV;

class MultyCsvTest {

	MultiCSV t = new MultiCSV("test");
	@Test
	void testSize() {
		
		int actual = t.getProject().size();
		assertEquals(2,actual);
	}
	
	@Test
	void writeFileKMLTest()
	{
		boolean ans = t.writeFileKML();
		assertTrue(ans);
	}

}
