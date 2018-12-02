package GIS;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;
/**
 * 	This class convert one line of csv ArrayList to GIS_element.
 *  
 * @author Netanel
 * @author Carmel
 *
 */
public class CsvLine_Element implements GIS_element{
	String MAC;
	String SSID;
	String AuthMode;
	String FirstSeen;
	String Channel;
	String RSSI;
	String AccuracyMeters;
	String Type;
	Point3D p;

	/**
	 * This cnstructor accept String[] that represent data of one element.
	 * @param line
	 */
	public CsvLine_Element(String[] line)
	{
		double lat = Double.parseDouble(line[6]);
		double lon = Double.parseDouble(line[7]);
		double alt = Double.parseDouble(line[8]);
		this.p = new Point3D(lat,lon,alt);
		this.FirstSeen = line[3];
		this.MAC = line[0];
		this.SSID = line[1];
		this.AuthMode = line[2];
		this.Channel = line[4];
		this.RSSI = line[5];
		this.AccuracyMeters = line[9];
		this.Type = line[10];	
	}

	@Override
	public Geom_element getGeom() {
		return p;
	}

	/**
	 * return Meta_data of this element 
	 */
	@Override
	public Meta_data getData() {
		Meta_data meta_data = new Meta_data_element(MAC,SSID,AuthMode,FirstSeen,Channel,RSSI,AccuracyMeters,Type);
		return meta_data;
	}

	/**
	 * move this point3D according vec
	 */
	@Override
	public void translate(Point3D vec) {
		MyCoords mc = new MyCoords(); 
		p = mc.add(p, vec);
	}


}
