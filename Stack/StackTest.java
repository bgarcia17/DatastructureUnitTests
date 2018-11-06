import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;

public class StackTest {
    private static Stack<Integer> stack;
    
    @BeforeClass
    public static void setUpClass() {
        stack = new Stack<Integer>();
    }
    public static void main(String[] args) {
        System.out.format("Unit test:%n%n");
        org.junit.runner.JUnitCore.main("StackTest");
    }

    @Test
    public void testConstructor() {
        assertThat(stack, notNullValue());
    }
    @Test
    public void testPush() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        assertThat(stack.peek(), equalTo(0));
    }
    @Test
    public void testPush2() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.peek(), equalTo(3));
    }
    @Test
    public void testPushAll() {
        Stack<Integer> stack = new Stack<Integer>();
        // create an arraylist to push
        ArrayList<Integer> elements = new ArrayList<>();
        elements.add(0);
        elements.add(1);
        elements.add(2);
        stack.pushAll(elements);
        assertThat(stack.peek(), equalTo(2));
    }
    @Test
    public void testPeek() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(3);
        stack.push(45);
        assertThat(stack.peek(), equalTo(45));
    }
    @Test
    public void testPop() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(3);
        stack.push(45);
        stack.pop();
        assertThat(stack.peek(), equalTo(3));
    }
    @Test
    public void testClear() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(3);
        stack.push(45);
        stack.clear();
        assertThat(stack.isEmpty(), equalTo(true));
    }
    @Test
    public void testDepth() {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        assertThat(stack.depth(), equalTo(100));
    }
    @Test
    public void testIsEmpty() {
        Stack<Integer> stack = new Stack<Integer>();
        assertThat(stack.isEmpty(), equalTo(true));
    }
    @Test
    public void testIterator() {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        // call the iterator 
        for (Integer i : stack) {
            
        }
        //assertThat(stack.peek(), equalTo(99));
        assertThat(stack.isEmpty(), equalTo(true));
    }
}
