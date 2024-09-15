package DataStructures;

import ADTs.StackADT;
import Exceptions.EmptyCollectionException;
import Exceptions.StackOverflowException;

/**
 * ArrayStack is an array-based implementation of the StackADT interface.
 * This class provides methods to perform typical stack operations such as 
 * push, pop, peek, and utility methods like isEmpty, size, and toString.
 * @param <T> the type of elements in this stack
 */
public class ArrayStack<T> implements StackADT<T> {
    /** The index of where the top of the stack is */
    int top;
    /** The array that holds the stack */
    T[] buffer;

    /**
     * Creates an empty stack
     */
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        top = -1;
        buffer = (T[]) new Object[10];
    }

    /**
     * Creates an empty stack with the specified initial capacity
     * @param initialCapacity the initial capacity of the stack
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        top = -1;
        buffer = (T[]) new Object[initialCapacity];
    }


    public void push(T element) throws StackOverflowException {
        if (size() == buffer.length) {
            throw new StackOverflowException();
        }
        buffer[++top] = element;
    }


    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        T result = buffer[top];
        buffer[top--] = null;
        return result;
    }


    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        return buffer[top];
    }


    public boolean isEmpty() {
        return top == -1;
    }


    public int size() {
        return top + 1;
    }


    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            result.append(buffer[i]);
            if (i < top) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
