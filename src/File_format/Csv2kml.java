package File_format;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Algorithms.MultiCSV;
import GIS.Project_LayersCollection;


public class Csv2kml {

	public static boolean writeFileKML( String file)
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
	public static void main(String[] args) {

		System.out.println(Csv2kml.writeFileKML("test\\1\\WigleWifi_20171201110209.csv"));

	}
}
