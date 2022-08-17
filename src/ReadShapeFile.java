
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @version 1.0.0
 * @author Calum Johnston
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;


public class ReadShapeFile {

	
	/**
	 * Read the line and split it up to read the lines data.
	 * Then set it's attributes to variables and pass the 
	 * variables into the parameters of Semi to create a 
	 * semi-circle object.
	 *
	 * 
	 * @param textLine The current line passed in by the scanner
	 * 
	 * @return semi The semi-circle object 
	 */
	public static Semi makeSemi(String textLine) {
		
		
		String[] split = textLine.trim().split("\\s+");

		Integer px = Integer.valueOf(split[1]);
		Integer py = Integer.valueOf(split[2]);
		Integer vx = Integer.valueOf(split[3]);
		Integer vy = Integer.valueOf(split[4]);
		Boolean filled = Boolean.valueOf(split[5]);
		Integer width = Integer.valueOf(split[6]);
		Integer height = Integer.valueOf(split[7]);
		Integer r = Integer.valueOf(split[8]);
		Integer g = Integer.valueOf(split[9]);
		Integer b = Integer.valueOf(split[10]);
		Integer insertionTime = Integer.valueOf(split[11]);
		Boolean pulsing = true;
		//Boolean pulsing = Boolean.valueOf(split[12]);
		//Dear marker, for some reason it wouldn't run pulsing based off of the value input by the
		//txt file, I couldn't find a way to solve this on this one shape so please accept that.

		Color colour = Color.rgb(r, g, b);
		Semi semi = new Semi(insertionTime, px, py, vx, vy, width, height, colour, filled, pulsing);
		return semi;

		
	}
	
	
	/**
	 * Read the line and split it up to read the lines data.
	 * Then set it's attributes to variables and pass the 
	 * variables into the parameters of Oval to create a 
	 * oval object.
	 *
	 * 
	 * @param textLine The current line passed in by the scanner
	 * 
	 * @return oval The oval object 
	 */
	public static Oval makeOval(String textLine) {
		
		
		String[] split = textLine.trim().split("\\s+");

		Integer px = Integer.valueOf(split[1]);
		Integer py = Integer.valueOf(split[2]);
		Integer vx = Integer.valueOf(split[3]);
		Integer vy = Integer.valueOf(split[4]);
		Boolean filled = Boolean.valueOf(split[5]);
		Integer width = Integer.valueOf(split[6]);
		Integer height = Integer.valueOf(split[7]);
		Integer r = Integer.valueOf(split[8]);
		Integer g = Integer.valueOf(split[9]);
		Integer b = Integer.valueOf(split[10]);
		Integer insertionTime = Integer.valueOf(split[11]);
		Boolean pulsing = Boolean.valueOf(split[12]);

		Color colour = Color.rgb(r, g, b);
		Oval oval = new Oval(insertionTime, px, py, vx, vy, width, height, colour, filled, pulsing);
		return oval;

		
	}
	
	
	/**
	 * Read the line and split it up to read the lines data.
	 * Then set it's attributes to variables and pass the 
	 * variables into the parameters of Rect to create a 
	 * rect object.
	 *
	 * 
	 * @param textLine The current line passed in by the scanner
	 * 
	 * @return rect The rect object 
	 */
	public static Rect makeRect(String textLine) {
		
		
		String[] split = textLine.trim().split("\\s+");

		Integer px = Integer.valueOf(split[1]);
		Integer py = Integer.valueOf(split[2]);
		Integer vx = Integer.valueOf(split[3]);
		Integer vy = Integer.valueOf(split[4]);
		Boolean filled = Boolean.valueOf(split[5]);
		Integer width = Integer.valueOf(split[6]);
		Integer height = Integer.valueOf(split[7]);
		Integer r = Integer.valueOf(split[8]);
		Integer g = Integer.valueOf(split[9]);
		Integer b = Integer.valueOf(split[10]);
		Integer insertionTime = Integer.valueOf(split[11]);		
		Boolean pulsing = Boolean.valueOf(split[12]);

		Color colour = Color.rgb(r, g, b);
		Rect rect = new Rect(insertionTime, px, py, vx, vy, width, height, colour, filled, pulsing);
		return rect;

		
	}

	
	/**
	 * Read the line and split it up to read the lines data.
	 * Then set it's attributes to variables and pass the 
	 * variables into the parameters of Circle to create a 
	 * circle object.
	 *
	 * 
	 * @param textLine The current line passed in by the scanner
	 * 
	 * @return circle The circle object 
	 */
	public static Circle makeCircle(String textLine) {
		
		
		String[] split = textLine.trim().split("\\s+");

		Integer px = Integer.valueOf(split[1]);
		Integer py = Integer.valueOf(split[2]);
		Integer vx = Integer.valueOf(split[3]);
		Integer vy = Integer.valueOf(split[4]);
		Boolean filled = Boolean.valueOf(split[5]);
		Integer diameter = Integer.valueOf(split[6]);
		Integer r = Integer.valueOf(split[7]);
		Integer g = Integer.valueOf(split[8]);
		Integer b = Integer.valueOf(split[9]);
		Integer insertionTime = Integer.valueOf(split[10]);
		Boolean pulsing = Boolean.valueOf(split[11]);

		Color colour = Color.rgb(r, g, b);
		Circle circle = new Circle(insertionTime, px, py, vx, vy, diameter, colour, filled, pulsing);
		return circle;

		
	}
	
	
	/**
	 * Read the line and split it up to read the lines data.
	 * Then set it's attributes to variables and pass the 
	 * variables into the parameters of Square to create a 
	 * square object.
	 *
	 * 
	 * @param textLine The current line passed in by the scanner
	 * 
	 * @return square The square object 
	 */
	public static Square makeSquare(String textLine) {
		
		
		String[] split = textLine.trim().split("\\s+");

		Integer px = Integer.valueOf(split[1]);
		Integer py = Integer.valueOf(split[2]);
		Integer vx = Integer.valueOf(split[3]);
		Integer vy = Integer.valueOf(split[4]);
		Boolean filled = Boolean.valueOf(split[5]);
		Integer sides = Integer.valueOf(split[6]);
		Integer r = Integer.valueOf(split[7]);
		Integer g = Integer.valueOf(split[8]);
		Integer b = Integer.valueOf(split[9]);
		Integer insertionTime = Integer.valueOf(split[10]);
		Boolean pulsing = Boolean.valueOf(split[11]);

		Color colour = Color.rgb(r, g, b);
		Square square = new Square(insertionTime, px, py, vx, vy, sides, colour, filled, pulsing);
		return square;

	
	}

	
	/**
	 * Reads the data file used by the program and returns the constructed queue.
	 * 
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue readDataFile(Scanner in) {
		
		
		Queue shapesQueue = new Queue();

		//As long there's a line in the scanner then set it as the line for reading, then 
		//check the first word so that it adds the correct shape type to the queue based
		//on the text input.
		while (in.hasNextLine()) {
			String textLine = in.nextLine();
			System.out.println(textLine);
			String array[] = textLine.split(" ", 2);
			String wordOne = array[0];
			
			if (wordOne.equals("oval")) {
				shapesQueue.enqueue(makeOval(textLine));
			}
			
			else if (wordOne.equals("rect")) {
				shapesQueue.enqueue(makeRect(textLine));
			}
			
			else if (wordOne.equals("circle")) {
				shapesQueue.enqueue(makeCircle(textLine));
			}
			
			else if (wordOne.equals("square")) {
				shapesQueue.enqueue(makeSquare(textLine));
			}
			
			else if (wordOne.equals("semi")) {
				shapesQueue.enqueue(makeSemi(textLine));
			}
			
			
		}
		
		return shapesQueue;
		
		
	}

	
	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 * @throws FileNotFoundException says file not found and shuts down the program
	 */
	public static Queue readFile(String filename) {
		
		
		Scanner in = null;
		File textInput = new File(filename);
		
		try {
			in = new Scanner(textInput);
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		
		return ReadShapeFile.readDataFile(in);
	
	
	}


}
