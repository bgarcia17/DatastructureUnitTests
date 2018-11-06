import org.junit.runner.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class DequeTest
{
   public static void main(String[] args)
   {
      org.junit.runner.JUnitCore.main("DequeTest");
   }
   
   @Test
   public void testConstructor()
   {
      Deque<String> d = new Deque<>();
      assertThat(d.depth(), equalTo(0));
      assertThat(d.isEmpty(), equalTo(true));
   }
   
   @Test
   public void testEnqueueDepth()
   {
      Deque<String> d = new Deque<>();
      
      for (int i = 0; i < 10; i++)
      {
         d.enqueue("Item " + i);
         assertThat(d.depth(), equalTo(i + 1));
      }
   }
   
   @Test
   public void testEnqueueAllDequeue()
   {
      ArrayList<String> initList = new ArrayList<>();
      for (int i = 0; i < 10; i++)
      {
         initList.add("Item " + i);
      }
      
      Deque<String> d = new Deque<>();
      d.enqueueAll(initList);
      
      for (int i = 0; i < 10; i++)
      {
         assertThat(d.dequeue(), equalTo("Item " + i));
         assertThat(d.depth(), equalTo(9 - i));
      }
      
      assertThat(d.isEmpty(), equalTo(true));
   }
   
   @Test
   public void testEnqueueHeadDequeue()
   {
      Deque<String> d = new Deque<>();
      for (int i = 0; i < 10; i++) 
      {
         d.enqueue("Item " + i);
      }
      d.enqueueHead("New Head Item");
      assertThat(d.dequeue(), equalTo("New Head Item"));
      
      for (int i = 0; i < 10; i++)
      {
         assertThat(d.dequeue(), equalTo("Item " + i));
         assertThat(d.depth(), equalTo(9 - i));
      }
      
      assertThat(d.isEmpty(), equalTo(true));
   }
   
   @Test
   public void testDequeueDepth()
   {
      Deque<String> d = new Deque<>();
      
      for (int i = 0; i < 10; i++)
      {
         d.enqueue("Item " + i);
         assertThat(d.depth(), equalTo(i + 1));
      }
      
      for (int i = 0; i < 10; i++)
      {
         assertThat(d.dequeue(), equalTo("Item " + i));
         assertThat(d.depth(), equalTo(9 - i));
      }
      
      assertThat(d.isEmpty(), equalTo(true));
   }
   
   @Test
   public void testHead()
   {
      Deque<String> d = new Deque<>();
      
      for (int i = 0; i < 10; i++)
      {
         d.enqueue("Item " + i);
         assertThat(d.depth(), equalTo(i + 1));
      }
      
      assertThat(d.head(), equalTo("Item 0"));
      assertThat(d.head(), equalTo("Item 0"));
      assertThat(d.dequeue(), equalTo("Item 0"));
      assertThat(d.head(), equalTo("Item 1"));
   }
   
   @Test
   public void testTail()
   {
      Deque<String> d = new Deque<>();
      
      for (int i = 0; i < 10; i++)
      {
         d.enqueue("Item " + i);
         assertThat(d.depth(), equalTo(i + 1));
      }
      
      assertThat(d.tail(), equalTo("Item 9"));
      assertThat(d.tail(), equalTo("Item 9"));
      assertThat(d.dequeueTail(), equalTo("Item 9"));
      assertThat(d.tail(), equalTo("Item 8"));
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testHeadBad()
   {
      Deque<String> d = new Deque<>();
      d.head(); // Throws NoSuchElementException
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testTailBad()
   {
      Deque<String> d = new Deque<>();
      d.tail(); // Throws NoSuchElementException
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testDequeueBad()
   {
      Deque<String> d = new Deque<>();
      d.dequeue(); // Throws NoSuchElementException
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testDequeueBad2()
   {
      Deque<String> d = new Deque<>();
      d.enqueue("Item 0");
      assertThat(d.dequeue(), equalTo("Item 0"));
      d.dequeue(); // Throws NoSuchElementException
   }
   
   @Test
   public void testDequeueTail()
   {
      Deque<String> d = new Deque<>();
      for (int i = 0; i < 10; i++)
      {
         d.enqueue("Item " + i);
      }
      
      for (int i = 0; i < 10; i++)
      {
         assertThat(d.dequeueTail(), equalTo("Item " + (9 - i)));
         assertThat(d.depth(), equalTo(9 - i));
      }
      assertThat(d.isEmpty(), equalTo(true));
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testDequeueTailBad()
   {
      Deque<String> d = new Deque<>();
      d.dequeueTail(); // Throws NoSuchElementException
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testDequeueTailBad2()
   {
      Deque<String> d = new Deque<>();
      d.enqueue("Item 0");
      d.enqueue("Item 1");
      assertThat(d.dequeueTail(), equalTo("Item 1"));
      assertThat(d.dequeueTail(), equalTo("Item 0"));
      d.dequeueTail(); // Throws NoSuchElementException
   }
   
   @Test
   public void testClear()
   {
      Deque<String> d = new Deque<>();
      assertThat(d.depth(), equalTo(0));
      assertThat(d.isEmpty(), equalTo(true));
      d.enqueue("Item 0");
      assertThat(d.depth(), equalTo(1));
      assertThat(d.isEmpty(), equalTo(false));
      d.enqueue("Item 1");
      assertThat(d.depth(), equalTo(2));
      assertThat(d.isEmpty(), equalTo(false));
      d.clear();
      assertThat(d.depth(), equalTo(0));
      assertThat(d.isEmpty(), equalTo(true));
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testClearResetHead()
   {
      Deque<String> d = new Deque<>();
      d.enqueue("Item 0");
      d.dequeue();
      d.head(); // Throws NoSuchElementException
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testClearResetTail()
   {
      Deque<String> d = new Deque<>();
      d.enqueue("Item 0");
      d.dequeue();
      d.tail(); // Throws NoSuchElementException
   }
   
   @Test
   public void testIterator()
   {
      Deque<String> d = new Deque<>();
      for (int i = 0; i < 10; i++)
      {
         d.enqueue("Item " + i);
      }
      Iterator<String> i = d.iterator();
      
      int x = 0;
      while (i.hasNext())
      {
         assertThat(i.next(), equalTo("Item " + x));
         assertThat(d.depth(), equalTo(9 - x));
         x++;
      }
      
      assertThat(d.isEmpty(), equalTo(true));
      assertThat(x, equalTo(10));
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testIteratorOverdraw()
   {
      Deque<String> d = new Deque<>();
      d.enqueue("Item 0");
      d.enqueue("Item 1");
      Iterator<String> i = d.iterator();
      i.next();
      i.next();
      i.next(); // Throws NoSuchElementException
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testIteratorOverdrawEmpty()
   {
      Deque<String> d = new Deque<>();
      Iterator<String> i = d.iterator();
      i.next(); // Throws NoSuchElementException
   }
   
   @Test
   public void testReverseIterator()
   {
      Deque<String> d = new Deque<>();
      for (int i = 0; i < 10; i++)
      {
         d.enqueue("Item " + i);
      }
      Iterator<String> i = d.reverseIterator();
      
      int x = 0;
      while (i.hasNext())
      {
         assertThat(i.next(), equalTo("Item " + (9 - x)));
         assertThat(d.depth(), equalTo(9 - x));
         x++;
      }
      
      assertThat(d.isEmpty(), equalTo(true));
      assertThat(x, equalTo(10));
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testReverseIteratorOverdraw()
   {
      Deque<String> d = new Deque<>();
      d.enqueue("Item 0");
      d.enqueue("Item 1");
      Iterator<String> i = d.reverseIterator();
      i.next();
      i.next();
      i.next(); // Throws NoSuchElementException
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testReverseIteratorOverdrawEmpty()
   {
      Deque<String> d = new Deque<>();
      Iterator<String> i = d.reverseIterator();
      i.next(); // Throws NoSuchElementException
   }

}
