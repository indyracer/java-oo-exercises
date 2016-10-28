package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
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
		String imagePath = "path not set";
		String relPath;
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		String absFileName = null;

		// prompt user for image to filter and validate input
		do {

			imagePath = "path not set";

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
			catch (InputMismatchException string ){
				//what happens when an exeption happens invalid input
				
				System.out.println("InputMismatchException, please input a number");
				in.next();
				
			}
			
			catch (Exception e ){
				//what happens when an exeption happens invalid int
				System.out.println("IndexOutOfBounds Exception");
				
			}
			
			
		}
		while(valTest);	






		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 


		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();

		System.out.println("Image successfully filtered");



		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original

		boolean saveVal = true;
		do{
			// save image, if desired

			System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
			String fileName = in.next();

			if (fileName.equals("exit")) {
				System.out.println("Image not saved");
				saveVal = false;


			} else {
				absFileName = dir + File.separator + fileName;


				if(absFileName.equals(imagePath))
				{
					System.out.println("That file already exists, do you want to overwrite? Y or N:  ");
					String overWrite = in.next();
					if(overWrite == "Y" || overWrite == "y")
					{
						processed.save(absFileName);
						System.out.println("File has been saved to " + absFileName);
						saveVal = false;
					}

				}
				else
				{
					processed.save(absFileName);
					System.out.println("File has been saved to " + absFileName);
					saveVal = false;
				}
			}
		}
		while(saveVal);




		/*if(absFileName == imagePath)
		{
			System.out.println("There is already an image with that name.  Do you want to overwrite with the new image?  Y/N: ");
			String overwrite = in.next();

			if(overwrite == "Y" || overwrite == "y")
			{
				processed.save(absFileName);
				System.out.println("Image saved to " + absFileName);
			} else
			{
				System.out.println("Please rename your file");
				fileName = in.next();
				processed.save(absFileName);
				System.out.println("Image saved to " + absFileName);
			}
		} else{
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}*/
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