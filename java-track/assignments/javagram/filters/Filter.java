package javagram.filters;

import javagram.Picture;

public interface Filter {
	
	public String getTitle();
	
	public Picture process(Picture original);

}
