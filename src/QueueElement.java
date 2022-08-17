
/**
 * Class to link queue elements together your queue will be composed of these links.
 *	@version 1.0.0
 * @author Calum Johnston
 */

public class QueueElement {
	private Object element; //the element contained in this linked list
	private QueueElement next; //the next element of the linked list
	
	public QueueElement (Object e, QueueElement n) {
		this.element = e;
		this.next = n;
	}
	
	/**
	 * Method to set the element
	 */
	public void setElement (Object element) {
		this.element = element;
	}
	
	/**
	 * Method to set the next linked list element
	 */
	public void setNext (QueueElement e) {
		this.next = e;
	}
	
	/**
	 * Method to get the element.
	 */
	public Object getElement () {
		return element;
	}
	
	/**
	 * Method to get the next linked list element
	 */
	public QueueElement getNext () {
		return next;
	}
	
}
