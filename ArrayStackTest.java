package DataStructures;

import Exceptions.*;
import ADTs.StackADT;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayStackTest {
  StackADT<Integer> stack = new ArrayStack<Integer>(10);

  @Test
  public void testArrayStack() {
    assertEquals(0, stack.size());

    stack = new ArrayStack<Integer>();
    assertEquals(0, stack.size());
  }

  @Test
  public void testIsEmpty() {
    assertTrue(stack.isEmpty());
  }

  @Test
  public void testSize() {
    assertEquals(0, stack.size());

    try {
      stack.push(1);
      assertEquals(1, stack.size());
      stack.push(2);
      assertEquals(2, stack.size());
    } catch (StackOverflowException e) {
      fail("StackOverflowException should not be thrown");
    }

    try {
      stack.pop();
      assertEquals(1, stack.size());
      stack.pop();
      assertEquals(0, stack.size());
    } catch (EmptyCollectionException e) {
      fail("EmptyCollectionException should not be thrown here.");
    }
  }

  @Test
  public void testPush() {

    try {
      stack.push(1);
    } catch (StackOverflowException e) {
      fail("StackOverflowException should not be thrown");
    }
    assertEquals(1, stack.size());
    try {
      assertEquals(1, stack.peek().intValue());
    } catch (Exception e) {
      fail("Exception should not be thrown here.");
    }

    try {
      stack.push(2);
    } catch (StackOverflowException e) {
      fail("StackOverflowException should not be thrown");
    }
    assertEquals(2, stack.size());
    try {
      assertEquals(2, stack.peek().intValue());
    } catch (Exception e) {
      fail("Exception should not be thrown here.");
    }
  }

  @Test
  public void testPop() {

    try {
      stack.push(3);
      stack.push(2);
      stack.push(1);
    } catch (StackOverflowException e) {
      fail("StackOverflowException should not be thrown");
    }
    try {
      assertEquals(3, stack.size());
      Integer out = stack.pop();
      assertEquals(out.intValue(), 1);
      assertEquals(2, stack.size());
    } catch (Exception e) {
      fail("Exception should not be thrown here.");
    }

    try {
      assertEquals(2, stack.size());
      Integer out = stack.pop();
      assertEquals(out.intValue(), 2);
      assertEquals(1, stack.size());
    } catch (Exception e) {
      fail("Exception should not be thrown here.");
    }

    try {
      Integer out = stack.pop();
      assertEquals(out.intValue(), 3);
    } catch (Exception e) {
      fail("Exception should not be thrown here.");
    }

    try {
      stack.pop();
    } catch (Exception e) {
      assertTrue("EmptyCollectionException should be thrown here.", e instanceof EmptyCollectionException);
    }
  }

  @Test
  public void testPeek() {

    try {
      stack.push(1);
    } catch (StackOverflowException e) {
      fail("StackOverflowException should not be thrown");
    }
    try {
      assertEquals(1, stack.size());
      assertEquals(1, stack.peek().intValue());
    } catch (Exception e) {
      fail("Exception should not be thrown here.");
    }

    try {
      stack.push(2);
    } catch (StackOverflowException e) {
      fail("StackOverflowException should not be thrown");
    }

    try {
      assertEquals(2, stack.size());
      assertEquals(2, stack.peek().intValue());
    } catch (Exception e) {
      fail("Exception should not be thrown here.");
    }

    try {
      stack.pop();
      stack.pop();
    } catch (Exception e) {
      fail("Exception should not be thrown here.");
    }

    try {
      stack.peek();
    } catch (Exception e) {
      assertTrue("EmptyCollectionException should be thrown here.", e instanceof EmptyCollectionException);
    }
  }

}
