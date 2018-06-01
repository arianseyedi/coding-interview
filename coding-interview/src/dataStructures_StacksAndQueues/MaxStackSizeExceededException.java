package dataStructures_StacksAndQueues;

/**
 * Raised when the stack size requested goes beyond a certain threshold.
 * 
 * @author Arian Seyedi
 *
 */
public class MaxStackSizeExceededException extends Exception {

	private static final long serialVersionUID = 1L;

	public MaxStackSizeExceededException() {
		super();
	}

	public MaxStackSizeExceededException(String message) {
		super(message);
	}
}
