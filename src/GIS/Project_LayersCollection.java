package GIS;

import java.util.ArrayList;
/**
 * this class represent gis project, collection of layers.
 * 
 * @author Netanel
 * @author Carmel
 *
 */
public class Project_LayersCollection extends ArrayList<GIS_layer> implements GIS_project {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    ArrayList<GIS_layer> layers;
    
    /**
	 * constructor, initialize this .
	 */
	public Project_LayersCollection()
	{
		this.layers = new ArrayList<GIS_layer>(); 
	}
	
	/**
	 * return Meta_data of this project
	 */
	@Override
	public Meta_data get_Meta_data() {
		Meta_data meta_data = new Meta_data_project(layers);
		return meta_data;
	}

}
