package GIS;

import java.util.ArrayList;
/**
 * this class represent a gis layer, collection of element of type GIS_element.
 * 
 * @author Netanel
 * @author Carmel
 *
 */
public class Layer_ElementsCollection extends ArrayList<GIS_element> implements GIS_layer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<GIS_element> elements;
	/**
	 * constructor, initialize this .
	 */
	public Layer_ElementsCollection()
	{
		this.elements = new ArrayList<GIS_element>();
	}
	
	/**
	 * return Meta_data of this layer
	 */
	@Override
	public Meta_data get_Meta_data() {
		Meta_data meta_data = new Meta_data_layer(elements);
		return meta_data;
	}
	public ArrayList<GIS_element> getElements()
	{
		return this.elements;
	}
}
