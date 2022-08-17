
/**
 * Semi.java
 * 
 * @version 1.0.0
 * @author Calum Johnston
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;


/**
 * Semi is a semi-circular shape that can be drawn to the screen, either filled
 * with colour or opaque. Its position is determined by the upper left corner of
 * the semi-circle's bounding rectangle
 */
public class Semi extends ClosedShape {

	
	// the width and height of the semi-circle, the initials are kept for shrinking
	// back later. Multiplier is the speed that it multiplies at.
	private int width, height, initialWidth, initialHeight;
	private final int INITIAL_ANGLE = 0;
	private final int CIRC_ANGLE = 180;
	private int multiplier = 1;

	/**
	 * Creates a semi-circle.
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
	 *            True if the semi-circle is filled with colour, false if opaque.
	 * @param pulsing
	 * 			  True if the shape is going to pulse, false if it doesn't
	 */
	public Semi(int insertionTime, int x, int y, int vx, int vy, int width, int height, javafx.scene.paint.Color colour,
			boolean isFilled, boolean pulsing) {

		
		super(insertionTime, x, y, vx, vy, colour, isFilled, pulsing);
		this.width = width;
		this.height = height;
		this.initialWidth = width;
		this.initialHeight = height;

		
	}

	/**
	 * Method to convert a semi-circle to a string.
	 */
	public String toString() {

		
		String result = "This is a semicircle\n";
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
	 * @return The width of the semi-circle
	 */
	public int getWidth() {

		
		return width;

		
	}

	
	/**
	 * @return The height of the semi-circle
	 */
	public int getHeight() {

		
		return (height / 2);

		
	}

	
	/**
	 * Draw the semi-circle.
	 *
	 * @param g
	 *            The graphics object of the drawable component.
	 */
	public void draw(GraphicsContext g) {

		
		int newHeight;
		newHeight = yPos + getHeight();

		g.setFill(colour);
		g.setStroke(colour);

		if (isFilled) {
			g.fillArc(xPos, yPos, width, height, INITIAL_ANGLE, CIRC_ANGLE, ArcType.CHORD);
		}

		else {
			g.strokeArc(xPos, yPos, width, height, INITIAL_ANGLE, CIRC_ANGLE, ArcType.CHORD);
			g.strokeLine(xPos, newHeight, xPos + width, newHeight);
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