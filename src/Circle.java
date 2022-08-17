
/**
 * Circle.java
 * 
 * @version 1.0.0
 * @author Calum Johnston
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Circle is a shape that can be drawn to the screen, either filled with colour
 * or opaque. Its position is determined by the upper left corner of the
 * circle's bounding rectangle.
 */

public class Circle extends ClosedShape {
	// The diameter of the circle, the diameter to shrink back to
	private int diameter, initialDiameter;
	private int multiplier = 1;

	/**
	 * Creates a circle.
	 * 
	 * @param x
	 *            The display component's x position.
	 * @param y
	 *            The display component's y position.
	 * @param vx
	 *            The display component's x velocity.
	 * @param vy
	 *            The display component's y velocity.
	 * @param diameter
	 *            The diameter of the circle.
	 * @param colour
	 *            The line colour or fill colour.
	 * @param isFilled
	 *            True if the circle is filled with colour, false if opaque.
	 * @param pulsing
	 * 			  True if the shape is going to pulse, false if it doesn't
	 */
	public Circle(int insertionTime, int x, int y, int vx, int vy, int diameter, Color colour, boolean isFilled, boolean pulsing) {
		super(insertionTime, x, y, vx, vy, colour, isFilled, pulsing);
		this.diameter = diameter;
		this.initialDiameter = diameter;
	}

	/**
	 * Method to convert a circle to a string.
	 */
	public String toString() {
		String result = "This is a circle\n";
		result += super.toString();
		result += "Its diameter is " + this.diameter + "\n";
		return result;
	}

	/**
	 * @param Resets
	 *            the diameter.
	 */
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	/**
	 * @return The diameter of the circle.
	 */
	public int getDiameter() {
		return diameter;
	}

	/**
	 * @return The width of the circle
	 */
	public int getWidth() {
		return diameter;
	}

	/**
	 * @return The height of the circle
	 */
	public int getHeight() {
		return diameter;
	}
	
	

	/**
	 * Draw the circle on the screen.
	 * 
	 * @param g
	 *            The graphics object of the scene component.
	 */
	public void draw(GraphicsContext g) {
		g.setFill(colour);
		g.setStroke(colour);
		if (isFilled) {
			g.fillOval(xPos, yPos, diameter, diameter);
		} else {
			g.strokeOval(xPos, yPos, diameter, diameter);
		}
	}
	
	
	/**
	 * Method to ensure the shapes pulse, sets max variable for the shape to grow to,
	 * sets the min as the original length so when it inverts the multiplier it
	 * doesn't shrink past the size of the original size.
	 */
	public void pulse () {
		
		
		if (this.pulsing == true) {
			
			
			int maxDiameter = initialDiameter * 2;
			int minDiameter = initialDiameter;
			diameter = diameter + multiplier;
			
			
			//This allows the shape to shrink or grow depending on 
			//whether the diameter has hit max or min.
			if ((diameter >= maxDiameter) || (diameter <= minDiameter)) {
				multiplier = -multiplier;
			}
			
			
		}
		
		
	}
	
	
}
