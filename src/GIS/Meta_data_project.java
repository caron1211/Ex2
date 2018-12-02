package GIS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import Geom.Point3D;
/**
*
* this class return the meta data of the project
* 
* @author Netanel
* @author Carmel
*
*/
public class Meta_data_project implements Meta_data{

	ArrayList<GIS_layer> layers;
	
	/**
	 * construcor
	 * @param layers
	 */
	public Meta_data_project(ArrayList<GIS_layer> layers)
	{
		this.layers = layers;
	}
	
	/**
	 *  return the time of creating this object
	 */
	@Override
	public long getUTC() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date projectDate = new Date();
			long millis = Date.UTC(projectDate.getYear(), projectDate.getMonth(), projectDate.getDate(), projectDate.getHours(), projectDate.getMinutes(), projectDate.getSeconds());
			return millis;
	}

	/**
	 * return collection of all layers meta data
	 */
	public String toString()
	{
		String allLayersMetaData = "";
		for(int i = 0 ; i < layers.size() ; i++)
		{
			allLayersMetaData += ((Meta_data_layer)((Layer_ElementsCollection)layers.get(i)).get_Meta_data()).toString()+"\n";
		}
		return allLayersMetaData;
	}
	@Override
	public Point3D get_Orientation() {
		return null;
	}
	

}
