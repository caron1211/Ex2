package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter{

	private final int RADIUS = 6371000;
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {

		double x =local_vector_in_meter.x();
		double y =local_vector_in_meter.y();
		double z =local_vector_in_meter.z();

		double x_radian = Math.asin(x/RADIUS);
		double x_degree =Math.toDegrees(x_radian);

		double y_radian = Math.asin(y/RADIUS*Lon_Norm(gps.x()));
		double y_degree =Math.toDegrees(y_radian);

		double x_new = x_degree+gps.x();
		double y_new = y_degree+gps.y();
		double z_new = z+gps.z();
		Point3D p = new Point3D(x_new,y_new,z_new);
		return p;

	}

	public double Lon_Norm (double x ) {

		double Lon_Norm = Math.cos(x*Math.PI/180);
		return Lon_Norm;

	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {

		double diff_lat = gps1.x()-gps0.x();
		double diff_lon = gps1.y()-gps0.y();

		double diff_lat_rad =Math.toRadians(diff_lat);
		double diff_lon_rad =Math.toRadians(diff_lon);

		double lat_meter = toMeterLat(diff_lat_rad);
		double lon_meter = toMeterLon(gps0,diff_lon_rad);

		double distance = Math.sqrt((lat_meter*lat_meter)+(lon_meter*lon_meter));


				return distance;
	}

	private double toMeterLat (double x ) {
		double ans;
		ans = Math.sin(x)*RADIUS;
		return ans;

	}

	private double toMeterLon (Point3D gps , double y) {
		double ans;
		ans = Math.sin(y)*RADIUS*Lon_Norm(gps.x());
		return ans;

	}

	public Point3D toMeterGps(Point3D gps) {
		Point3D zero = new Point3D(0,0,0);
		double x_rad = Math.toRadians(gps.x());
		double y_rad = Math.toRadians(gps.y());
		double x = toMeterLat(x_rad);
		double y = toMeterLon(zero,y_rad);
		Point3D ans = new Point3D(x,y,gps.z());
		return ans;
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		
		double diff_lat = gps1.x()-gps0.x();
		double diff_lon = gps1.y()-gps0.y();
		double diff_alt = gps1.z()-gps0.z();


		double diff_lat_rad =Math.toRadians(diff_lat);
		double diff_lon_rad =Math.toRadians(diff_lon);

		double lat_meter = toMeterLat(diff_lat_rad);
		double lon_meter = toMeterLon(gps0,diff_lon_rad);
		
		Point3D p = new Point3D(lat_meter,lon_meter,diff_alt);

		
		return p;
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		double[] arr = new double[3];
		
		double dis = distance3d(gps0,gps1);
		arr[2] = dis;
		
		//Azimuth
		double lat1 = Math.toRadians(gps0.x());
		double lat2 = Math.toRadians(gps1.x());
		double dy = Math.toRadians(gps1.y()-gps0.y());
		double y = Math.sin(dy) * Math.cos(lat2);
		double x = Math.cos(lat1)*Math.sin(lat2) -Math.sin(lat1)*Math.cos(lat2)*Math.cos(dy);
		double alpha = Math.atan2(y, x);
		double azimuth = (Math.toDegrees(alpha)+360)%360;
		arr[0] = azimuth;
		
		//Elevation
		double dx = lat2 - lat1;
		double dz = gps1.z() - gps0.z();
		double u = lat1*dx + Math.toRadians(gps0.y())*dy + gps0.z()*dz;
		double elevation = Math.atan(u/Math.sqrt(y*y+x*x));
		arr[1] = elevation;
		
		return arr;
	}
	
	
//	@Override
//	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
//		double[] arr = new double[3];
//		
//		double dis = distance3d(gps0,gps1);
//		arr[2] = dis;
//		
//		Point3D gps0_meter = toMeterGps(gps0);
//		Point3D gps1_meter = toMeterGps(gps1);
////		double dx = gps1_meter.x() - gps0_meter.x();
////		double dy = gps1_meter.y() - gps0_meter.y();
//		double dx = gps1.x() - gps0.x();
//		double dy = gps1.y() - gps0.y();;
//		double dz = gps1.z() - gps0.z();
//		
//		double azimuth=Math.atan2(Math.sin(dy)*Math.cos(gps1.x()),(Math.cos(gps0.x())*Math.sin(gps1.x())) 
//				-(Math.sin(gps0.x())*Math.cos(gps1.x())*Math.cos(dy)));
//
//		
////		double alph = Math.atan(Math.abs(dy/dx));
////		System.out.println("alph"+alph);
////		double azimuth = Integer.MAX_VALUE;
////		
////		if ( dx > 0 && dy >0)
////			   azimuth= alph;
////		else if ( dx >0 && dy<0)
////			azimuth= 360-alph;
////		else if ( dx <0 && dy >0)
////			azimuth= 180-alph;
////		else if ( dx<0 && dy<0)
////			azimuth= 180+alph;
////		
//		
//		arr[0] = Math.toDegrees(azimuth);
//
////
////		double temp = (gps0.x()*dx + gps0.y()*dy + gps0.z()*dz);
////		double deno = Math.sqrt( (gps0.x()*gps0.x()+ gps0.y()*gps0.y()+ gps0.z()*gps0.z() )*( dx*dx+dy*dy+dz*dz)) ;
////		double elevation = Math.acos(temp/deno);
////		
//		
//		
//		arr[1] = 0;
//		return arr;
//	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		
		if ( p.x() > 90 || p.x() < -90)
		return false;
		
		if ( p.y() > 180 || p.y() < -180)
			return false;

		if ( p.y() > 9000 || p.y() < -450)
			return false;

		
		return true;
	}


}
