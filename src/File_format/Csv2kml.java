package File_format;

import java.util.ArrayList;

public class Csv2kml {

	public static void writeFileKML(ArrayList<String[]> a, String output)
	{
		ArrayList<String> content = new ArrayList<String>();
		String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
		        "<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n"+
				"<Document>\n"+
		        "<Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style>\n"+
				"<Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style>\n"+
				"<Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style>\n"+
				"<Folder>\n<name>Wifi Networks</name>\n";
		
	}
}
