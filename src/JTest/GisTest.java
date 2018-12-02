package JTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Algorithms.MultiCSV;
import File_format.CsvArrayList;
import GIS.CsvLine_Element;
import GIS.Layer_ElementsCollection;
import GIS.Project_LayersCollection;
import Geom.Point3D;

class GisTest {

	CsvArrayList c1 = new CsvArrayList("test\\1\\WigleWifi_20171201110209.csv");
	CsvLine_Element el = new CsvLine_Element(c1.getLines().get(4));
	@Test
	void gis_element_translate() {
		el.translate(new Point3D(100,0,90));
		Point3D p = new Point3D ( 32.17315019670903,34.81436692415887,115.86914312897468);
		boolean ans = p.equals((Point3D)el.getGeom());
		assertTrue(ans);
	}

	@Test
	void gis_element_metaData()
	{
		String actual = ((CsvLine_Element)el).getData().toString();
		String excepted = "14:ae:db:58:73:75,love,[WPA2-PSK-CCMP][ESS],2017-12-01 10:49:29,1,-78,4,WIFI";
		assertEquals(excepted, actual);
	}
}
