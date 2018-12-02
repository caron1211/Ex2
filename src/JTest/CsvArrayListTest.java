package JTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import File_format.CsvArrayList;

class CsvArrayListTest {
	
	CsvArrayList array = new CsvArrayList("test\\1\\WigleWifi_20171201110209.csv");


	@Test
	void sizeOfArrayList() {
		
		ArrayList<String[]> temp = array.getLines();
		int excepted = 161;
		assertEquals(excepted,temp.size());
	}
	@Test
	void equals() {
		
		ArrayList<String[]> temp = array.getLines();
		String actual = temp.get(4)[1];
		String excepted ="love";
		assertEquals(excepted,actual);
		
	}

}
