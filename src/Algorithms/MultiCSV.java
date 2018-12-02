package Algorithms;

import java.io.File;
import java.io.FileNotFoundException;

import File_format.CsvArrayList;
import File_format.convertTest;
import GIS.CsvLine_Element;
import GIS.GIS_element;
import GIS.Layer_ElementsCollection;
import GIS.Project_LayersCollection;
/**
 * this class create object that contain project(any project is collection of layers) and create kml file.
 * 
 * @author Netanel
 * @author Carmel
 *
 */
public class MultiCSV {

	Project_LayersCollection project;
	
	/**
	 * this constructor accept file name and build kml file. the file or the folder may contain various type
	 * of files so that create kml file then consist from csv file we should scan only csv file, after that 
	 * any csv file passing convert to layer. finally, all layers that created add to project(of this).
	 * 
	 * @param fileName
	 */
	public MultiCSV(String fileName)
	{
		this.project = new Project_LayersCollection(); 
		File file = new File(fileName);
		fillFilesRecursively(file);
	}
	
	public Project_LayersCollection getProject() {
		return project;
	}

	/**
	 * 
	 * @param file
	 */
	private void fillFilesRecursively(File file) {
		if (file.isFile() ) {
			if(file.getName().contains(".csv"))
			{
				Layer_ElementsCollection layer = new Layer_ElementsCollection();
				CsvArrayList csv = new CsvArrayList (file.getPath());
				for ( int i=2; i<csv.getLines().size() ; i++)
				{
					GIS_element el = new CsvLine_Element(csv.getLines().get(i));
					layer.add(el);
				}
			    this.project.add(layer);
			}
			else
				System.out.println();
		} 
		else
		{
			for (File child : file.listFiles()) {
				fillFilesRecursively(child);
			}
		}
}
	/**
	 * 
	 * @return true   if success to create kml file
	 */
	public boolean writeFileKML()
	{
		boolean ans = false;
		Project_LayersCollection project = this.project;
		convertTest xml = new convertTest(project);
		try {
			xml.convert();
			ans = true; 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ans;
	}
}