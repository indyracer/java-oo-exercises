package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class InvertFilter implements Filter {

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Inverted Black and White";
	}

	@Override
	public Picture process(Picture original) {
		// TODO Auto-generated method stub
		Picture processed = new Picture(original.width(), original.height());

		//get each pixel one by one
		for (int i = 0; i < original.width(); i++) {
			for (int j = 0; j < original.height(); j++) {

				Color c = original.get(i, j);

				//get color components from each pixel
				int r = c.getRed();
				int g = c.getGreen();
				int b = c.getBlue();

				//check for black and white pixels.  if found, invert rbg

				
					r = 255 - r;
					g = 255 - g;
					b = 255 - b;
					processed.set(i, j, new Color(r, g, b));


			}
		}

		return processed;
	}

}
