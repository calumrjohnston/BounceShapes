
/**
 * Ovl.java
 * 
 * @version 1.0.0
 * @author Calum Johnston
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Oval is an oval shape that can be drawn to the screen, either filled with
 * colour or opaque. Its position is determined by the upper left corner of the
 * oval's bounding rectangle
 */
public class Oval extends ClosedShape {
	// The width and height of the oval (major and minor axis)
	// the width and height of the semi-circle, the initials are kept for shrinking
	// back later. Multiplier is the speed that it multiplies at.
	private int width, height, initialWidth, initialHeight;
	private int multiplier = 1;

	/**
	 * Creates an oval.
	 * 
	 * @param x
	 *            The display component's x position.
	 * @param y
	 *            The display component's y position.
	 * @param vx
	 *            The display component's x velocity.
	 * @param vy
	 *            The display component's y velocity.
	 * @param width
	 *            The width of the oval (in pixels).
	 * @param height
	 *            The height of the oval (in pixels).
	 * @param colour
	 *            The line colour or fill colour.
	 * @param isFilled
	 *            True if the oval is filled with colour, false if opaque.
	 * @param pulsing
	 * 			  True if the shape is going to pulse, false if it doesn't
	 */
	public Oval(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled,
			boolean pulsing) {
		super(insertionTime, x, y, vx, vy, colour, isFilled, pulsing);
		this.width = width;
		this.height = height;
		this.initialWidth = width;
		this.initialHeight = height;
	}

	/**
	 * Method to convert an oval to a string.
	 */
	public String toString() {
		String result = "This is an oval\n";
		result += super.toString();
		result += "Its width is " + this.width + " and its height is " + this.height + "\n";
		return result;
	}

	/**
	 * @param width
	 *            Resets the width.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @param height
	 *            Resets the height.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return The width of the oval.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return The height of the oval.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Draw the oval.
	 * 
	 * @param g
	 *            The graphics object of the drawable component.
	 */
	public void draw(GraphicsContext g) {
		g.setFill(colour);
		g.setStroke(colour);
		if (isFilled) {
			g.fillOval(xPos, yPos, width, height);
		} else {
			g.strokeOval(xPos, yPos, width, height);
		}
	}

	
	/**
	 * Method to ensure the shapes pulse, sets max variable for the shape to grow to,
	 * sets the min as the original length so when it inverts the multiplier it
	 * doesn't shrink past the size of the original size.
	 */
	public void pulse() {

		
		if (this.pulsing == true) {
				
				
			int maxWidth = initialWidth * 2;
			int minWidth = initialWidth;
			int maxHeight = initialHeight * 2;
			int minHeight = initialHeight;
			width = width + multiplier;
			height = height + multiplier;
	
			// This allows the shape to shrink or grow depending on
			// whether the width or height has hit max or min
			if ((width >= maxWidth) || (width <= minWidth) || (height >= maxHeight) || (height <= minHeight)) {
				multiplier = -multiplier;
			}
			
			
		}

		
	}

}
