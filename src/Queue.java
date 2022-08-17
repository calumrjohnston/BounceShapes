
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by LinkedListElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * 
 * @version 1.0.0
 * @author Calum Johnston
 *
 */

import java.util.NoSuchElementException;


public class Queue {
	
	
	//Declaring the end and beginning variables
	private QueueElement end;
	private QueueElement beginning;

	
	/**
	 * Constructs an empty Queue.
	 */
	public Queue() {
		
		
		//Initialising the variables.
		end = null;
		beginning = null;
		
		
	}

	
	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty() {
		
		
		//Empty will be true only if end and beginning of the queue are
		//null.
		boolean empty = ((end == null) && (beginning == null));
		return empty;
	
	
	}

	
	/**
	 * Returns the element at the head of the queue
	 */
	public Object peek() throws NoSuchElementException {
		
		
		//If the queue is empty then throw the exception and output a 
		//message to close more gracefully.
		if (isEmpty()) {
			throw new NoSuchElementException("Underflow in queue");
		}
		return beginning.getElement();
		
		
	}

	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue() throws NoSuchElementException {

		
		//If the queue is empty then throw the exception and output a 
		//message to close more gracefully.
		if (isEmpty()) {
			throw new NoSuchElementException("Underflow in queue");
		}
		
		//If the beginning is empty then so is the end. (i.e. the
		//queue is empty).
		if (beginning == null) {
			end = null;
		} 
		
		//Set the element at the beginning of the queue as the next 
		//element (Queues work in a FIFO basis).
		else {
			beginning = beginning.getNext();
		}

		
	}

	
	/**
	 * Puts an element on the back of the queue.
	 * 
	 * @param element The element attempted to being added to the back of the queue.
	 */
	public void enqueue(Object element) {

		
		//If the beginning of the queue is empty then place the current element at the 
		//start of the queue.
		if (beginning == null) {
			beginning = new QueueElement(element, null);
		} 
		
		//Otherwise place the new element at the end of the queue.
		else {
			QueueElement currentElem = beginning;
			QueueElement newElem = new QueueElement(element, null);
			while (currentElem.getNext() != null) {
				currentElem = currentElem.getNext();
			}
			
			
			currentElem.setNext(newElem);
			
			
		}
		
		
	}

	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print() {
		
		
		//If the queue is empty then say the queue is empty and then return so the
		//following code isn't run.
		if (isEmpty()) {
			System.out.println("The queue is empty");
			return;
		}
		
		//Creating the print statement for the queue tester.
		QueueElement currentElem = beginning;
		String resultOut = currentElem.getElement().toString() + ",\n";
		
		//Until it's empty then keep adding to the line.
		while (currentElem.getNext() != null) {
			currentElem = currentElem.getNext();
			resultOut += currentElem.getElement().toString() + ",\n";
		}

		
		System.out.println(resultOut);

		
	}
	
	
}
