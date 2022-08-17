
/**
 * Square.java
 * 
 * @version 1.0.0
 * @author Calum Johnston
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
*
* Square is a square shape that can be drawn to the screen, either filled with
* colour or opaque. Its position is determined by the upper left corner of the
* square's bounding rectangle
*/
public class Square extends ClosedShape {

	//The length of the sides of the square, the sides to shrink back to
	private int sides, initialSides;	
	private int multiplier = 1;
	
	
	/**
	 * Creates a square.
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
	 *            The sides of the square.
	 * @param colour
	 *            The line colour or fill colour.
	 * @param isFilled
	 *            True if the square is filled with colour, false if opaque.
	 * @param pulsing
	 * 			  True if the shape is going to pulse, false if it doesn't
	 */
	protected Square(int insertionTime, int x, int y, int vx, int vy, int sides, Color colour, boolean isFilled,
			boolean pulsing) {
		
		
		super(insertionTime, x, y, vx, vy, colour, isFilled, pulsing);
		this.sides = sides;
		this.initialSides = sides;

		
	}

	
	/**
	 * Method to convert a square to a string.
	 */
	public String toString() {
		
		
		String result = "This is a square\n";
		result += super.toString();
		result += "The length of it's sides are " + this.sides + "\n";
		return result;
		
		
	}

	
	/**
	 * @param Resets
	 *            the length of the sides.
	 */
	public void setSides(int sides) {
		
		
		this.sides = sides;
		
		
	}
	

	/**
	 * @return The sides of the square.
	 */
	public int getSides() {
		
		
		return sides;
		
		
	}
	
	
	/**
	 * @return The width of the square
	 */
	public int getWidth() {
		
		
		return sides;
		
		
	}

	
	/**
	 * @return The height of the square
	 */
	public int getHeight() {
		
		
		return sides;
	
	
	}
	

	/**
	 * Draw the square on the screen.
	 * 
	 * @param g
	 *            The graphics object of the scene component.
	 */
	public void draw(GraphicsContext g) {
		
		
		g.setFill(colour);
		g.setStroke(colour);
		
		if (isFilled) {
			g.fillRect(xPos, yPos, sides, sides);
		} 
		
		else {
			g.strokeRect(xPos, yPos, sides, sides);
		}
		
		
	}
	
	
	/**
	 * Method to ensure the shapes pulse, sets max variable for the shape to grow to,
	 * sets the min as the original length so when it inverts the multiplier it
	 * doesn't shrink past the size of the original size.
	 */
	public void pulse () {
		
		
		if (this.pulsing == true) {
			
			
		
			int maxSides = initialSides * 2;
			int minSides = initialSides;
			sides = sides + multiplier;
			
			
			//This allows the shape to shrink or grow depending on 
			//whether the sides has hit max or min.
			if ((sides >= maxSides) || (sides <= minSides)) {
				multiplier = -multiplier;
			}
			
			
		}
		
		
	}
	
	
}
