package JTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import File_format.Csv2kml;

class Csv2KmlTest {


	@Test
	void writeFileKML() {

		boolean ans = Csv2kml.writeFileKML("test\\1\\4566.txt");
		assertFalse(ans);

	}

	@Test
	void writeFileKML2() {
		boolean ans = Csv2kml.writeFileKML("test\\1\\WigleWifi_20171201110209.csv");
		assertTrue(ans);

	}

}
