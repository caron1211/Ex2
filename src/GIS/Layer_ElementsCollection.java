package GIS;

import java.util.ArrayList;

public class Layer_ElementsCollection extends ArrayList<GIS_element> implements GIS_layer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<GIS_element> elements;
	
	public Layer_ElementsCollection()
	{
		this.elements = new ArrayList<GIS_element>();
	}
	
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
