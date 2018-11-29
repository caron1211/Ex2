package GIS;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import Geom.Point3D;

public class Meta_data_element implements Meta_data {

	String MAC;
	String SSID;
	String AuthMode;
	String FirstSeen;
	String Channel;
	String RSSI;
	String AccuracyMeters;
	String Type;
	
	public Meta_data_element(String MAC,String SSID,String AuthMode,String FirstSeen,String Channel,String RSSI,String AccuracyMeters,String Type)
	{
		this.MAC = MAC;
		this.SSID = SSID;
		this.AuthMode = AuthMode;
		this.FirstSeen = FirstSeen;
		this.Channel = Channel;
		this.RSSI = RSSI;
		this.AccuracyMeters = AccuracyMeters;
		this.Type = Type; 
	}
	@Override
	public long getUTC() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date;
		try {
			date = format.parse(FirstSeen);
			long millis = date.getTime();
			return millis;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public Point3D get_Orientation() {
		return null;
	}
	@Override
	public String toString()
	{
		return MAC+","+SSID+","+AuthMode+","+FirstSeen+","+Channel+","+RSSI+","+AccuracyMeters+","+Type;
	}
}
