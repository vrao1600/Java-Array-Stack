package Exceptions;

/**
 * A stack overflow exception class.
 * Is thrown when a stack is full, and cannot be added to.
 * 
 * @author dhruvdh
 */
public class StackOverflowException extends Exception {

    public StackOverflowException() {
        super("The stack is full.");
    }
}
