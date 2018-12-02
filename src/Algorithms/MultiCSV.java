package Algorithms;

import java.io.File;
import java.io.FileNotFoundException;

import File_format.CsvArrayList;
import File_format.convertTest;
import GIS.CsvLine_Element;
import GIS.GIS_element;
import GIS.Layer_ElementsCollection;
import GIS.Project_LayersCollection;

public class MultiCSV {

	Project_LayersCollection project;
	
	public MultiCSV(String fileName)
	{
		this.project = new Project_LayersCollection(); 
		File file = new File(fileName);
		fillFilesRecursively(file);
	}
	
	public Project_LayersCollection getProject() {
		return project;
	}

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