package File_format;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Algorithms.MultiCSV;
import GIS.Project_LayersCollection;
/**
 * this class take csv file and convert it to kml file
 * 
 * @author Netanel
 * @author Carmel
 *
 */

public class Csv2kml {

	/**
	 * return true if success to create kml file, if the file it is csv file try to convert and return true if success.   
	 * @param file
	 * @return
	 */
	public static boolean writeFileKML(String file)
	{
		boolean ans = false;
		File _file = new File(file);
		if (_file.isFile() &&(_file.getName().contains(".csv")))
		{
			MultiCSV kml = new MultiCSV(file);
			Project_LayersCollection project = kml.getProject();
			convertTest xml = new convertTest (project);
			try {
				ans = true;
				xml.convert();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return ans;
	}
}
