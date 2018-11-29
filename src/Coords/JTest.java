package Coords;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Geom.Point3D;

class JTest {
	Point3D a = new Point3D(100,170,0); 
	Point3D b = new Point3D(150,120,0); 
	Point3D p = new Point3D(32.103315,35.209039,670); // 9
	Point3D p1 = new Point3D(32.106352,35.205225,650); // houmos
	Point3D v =  new Point3D(344,-400,0); // meter
	@Test
	void testAdd() {

		MyCoords c = new MyCoords();
		Point3D ans = c.add(p, v);
		System.out.println(ans);
		Point3D excepted = new Point3D(32.10640866632587,35.20599177041698,670.0);
		assertTrue(excepted.equals(ans));
	}

	@Test
	void testDistance()
	{
		MyCoords c = new MyCoords();
		int actual = (int)c.distance3d(p, p1);
		int excepted = 493;
		System.out.println(actual);
		assertEquals(excepted, actual);

	}

	@Test
	void Lon_Norm() {
		MyCoords c = new MyCoords();
		double actual =c.Lon_Norm(p.x());
		System.out.println("normal:"+actual);


	}
	
	@Test
	void  vector3D() {
		MyCoords c = new MyCoords();
		Point3D actual =c.vector3D(p,p1);
		System.out.println(actual);
		Point3D exceped = new Point3D(337.69899206128815,-359.24920693881893,-20.0);
		assertTrue(exceped.equals(actual));
		
	}
	
	@Test
	void  azimuth_elevation_dist() {
		MyCoords c = new MyCoords();
		double[] arr  = c.azimuth_elevation_dist(p, p1);
		System.out.println(Arrays.toString(arr));
		
	}
	@Test
	void toMeterGps()
	{
		MyCoords c = new MyCoords();
		Point3D ansMeter = c.toMeterGps(p1);
		System.out.println("meter:"+ansMeter);
	}

}
