package File_format;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import GIS.GIS_layer;
import GIS.GIS_project;
import GIS.CsvLine_Element;
import GIS.GIS_element;

import GIS.Layer_ElementsCollection;
import GIS.Meta_data_element;
import GIS.Project_LayersCollection;
import Geom.Point3D;
import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Icon;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Point;
import de.micromata.opengis.kml.v_2_2_0.Style;


public class convertTest {

	private Project_LayersCollection project;

	public convertTest ( Project_LayersCollection project) {
		this.project = project;
	}

	public void convert () throws FileNotFoundException {

		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument().withName("project").withOpen(true);

		Folder folder = doc.createAndAddFolder();
		folder.withName("Continents with Earth's surface").withOpen(true);

		for (int i=0; i<project.size(); i++)	{
			Layer_ElementsCollection layer = (Layer_ElementsCollection) project.get(i);

			for (int j=0; j<layer.size(); j++) {
				CsvLine_Element element = (CsvLine_Element) layer.get(j);

				long t = ((Meta_data_element)element.getData()).getUTC();
				    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.SSSXXX");
				    String dateString = formatter.format(new Date(t));
				
				String name = ((Meta_data_element)element.getData()).getSSID();
			//	String time = ((Meta_data_element)element.getData()).getFirstSeen();
				Point3D point = (Point3D) element.getGeom();

				createPlacemark(doc,folder,name,dateString,point);
				
				kml.marshal(new File("project.kml"));


			}
		}

	}


	private static void createPlacemark(Document document, Folder folder,String name,String time, Point3D point ) {

		Placemark placemark = folder.createAndAddPlacemark();
		placemark.withName(name);
		placemark.createAndSetPoint().addToCoordinates(point.y(),point.x(),point.z());
		placemark.createAndSetTimeStamp().withWhen(time);
	}
}