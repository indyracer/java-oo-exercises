package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	/*
	 * Javagram has a list of available filters
	 * 1. List of available filters
	 * 2. Scanner Object used for accepting input
	 */


	private Scanner in;
	private static ArrayList<Filter> filters;

	public Javagram()
	//Constructor statements:  make sure instance variables have values.
	{
		in = new Scanner(System.in);
		filters = new ArrayList<Filter>();
	}


	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath;
		Picture picture = null;
		Scanner in = new Scanner(System.in);

		// prompt user for image to filter and validate input
		do {

			String imagePath = "path not set";

			// try to open the file
			try {

				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();

				//String[] relPathParts = relPath.split(File.separator);
				//imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				imagePath = (dir + "\\" + relPath);
				picture = new Picture(imagePath);

			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}

		} 
		
		while(picture == null);

		// TODO - prompt user for filter and validate input

		Javagram fm = new Javagram();
//		displayFilterMenu(in);

		//validate int is returned
		//set loop condition
		boolean valTest = true;
		Filter filter = null;
		do {
			try {

				//display menu
				int validate= displayFilterMenu(in);
				//getfilter
				filter = getFilter(validate);

				//loop condition
				valTest = false;

			}
			catch (Exception e ){
				//what happens when an exeption happens
				System.out.println("IndexOutOfBounds Exception");
			}
		}
		while(valTest);	
		
			




			// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
						

			// filter and display image
			Picture processed = filter.process(picture);
			processed.show();

			System.out.println("Image successfully filtered");

			// save image, if desired

			System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
			String fileName = in.next();

			// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original

			if (fileName.equals("exit")) {
				System.out.println("Image not saved");
			} else {
				String absFileName = dir + File.separator + fileName;
				processed.save(absFileName);
				System.out.println("Image saved to " + absFileName);
			}	

			// close input scanner
			in.close();
		
		
	}

	
	private static int displayFilterMenu(Scanner in)
	{
			//to clear array for each call
			filters = new ArrayList<Filter>();	
			Filter blue = new BlueFilter();
			Filter invert = new InvertFilter();
			Filter red = new RedFilter();
			Filter grayscale = new GrayscaleFilter();
			

		//ArrayList<Filter> menu = new ArrayList<Filter>();
		filters.add(blue);
		filters.add(invert);
		filters.add(red);
		filters.add(grayscale);

		System.out.println("Please chose the number of the filter to apply");
		for (int i = 0; i < filters.size(); i++)
		{
			System.out.println(i + " " + filters.get(i));
		}


		//takes in the selections
		int selection = in.nextInt();
		return selection;
	}

	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface




	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int selection) {
		
		int arrayIndex = selection;
		Filter selectFilter = filters.get(arrayIndex);
		return selectFilter;




		// TODO - create some more filters, and add logic to return the appropriate one
		//return new BlueFilter();

	}

}