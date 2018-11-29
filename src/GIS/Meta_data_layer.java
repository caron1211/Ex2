package GIS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import Geom.Point3D;

public class Meta_data_layer implements Meta_data{

	ArrayList<GIS_element> elements;
	
	public Meta_data_layer(ArrayList<GIS_element> elements)
	{
		this.elements = elements;
	}
	
	/**
	 * return the time of creating this object
	 */
	@Override
	public long getUTC() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date layerDate = new Date();
			long millis = Date.UTC(layerDate.getYear(), layerDate.getMonth(), layerDate.getDate(), layerDate.getHours(), layerDate.getMinutes(), layerDate.getSeconds());
			return millis;
	}

	/**
	 * return collection of all elements meta data 
	 */
	@Override
	public String toString()
	{
		String allElementsMetaData = "";
		for(int i = 0 ; i < elements.size() ; i++)
		{
			allElementsMetaData +=  ((Meta_data_element)((CsvLine_Element)elements.get(i)).getData()).toString()+"\n";
		}
		return allElementsMetaData;
	}
	
	@Override
	public Point3D get_Orientation() {
		return null;
	}
}
