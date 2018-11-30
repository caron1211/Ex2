package File_format;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Algorithms.MultiCSV;
import GIS.Project_LayersCollection;


public class Csv2kml {

	public static void writeFileKML( String file)
	{
		File _file = new File(file);
		if (_file.isFile() &&(_file.getName().contains(".csv")))
		{
			MultiCSV kml = new MultiCSV(file);
			Project_LayersCollection project = kml.getProject();
			convertTest xml = new convertTest (project);
			try {
				xml.convert();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
}
