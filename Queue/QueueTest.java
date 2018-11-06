import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;

public class QueueTest
{
   public static void main(String[] args)
   {
      org.junit.runner.JUnitCore.main("QueueTest");
   }
   
   @Test
   public void testQueueConstructor()
   {
      Queue<Integer> i = new Queue<>();
      Queue<String> s = new Queue<>();
      
      assertThat(i, notNullValue());
      assertThat(i, instanceOf(Queue.class));
      assertThat(s, notNullValue());
      assertThat(s, instanceOf(Queue.class));
   }
   
   @Test
   public void testEnqueue()  // inserting at tail
   {
      Queue<Integer> i = new Queue<>();
      i.enqueue(1);
      i.enqueue(2);
      i.enqueue(3);
      assertThat(i.depth(), equalTo(3));
   }
   
   // Takes forever. Should work, in theory.
   /*@Test (expected = OutOfMemoryError.class)
   public void testOutOfMemoryError()
   {
      Queue<Integer> i = new Queue<>();
      for (int j = 0; j <= Integer.MAX_VALUE; j++)
      {
         i.enqueue(j);
         if (j % 1000000 == 0)
            System.out.println(String.format("%.2f%%", (j / (float)Integer.MAX_VALUE) * 100.0f));
      }
      i.enqueue(0);
   }*/
   
   @Test
   public void testEnqueueAndDequeue()
   {
      Queue<Integer> i = new Queue<>();
      for (int j = 0; j < 11; j++)
      {
         i.enqueue(j);
      }
      for (int k = 0; k < 11; k++)
      {
         assertThat(i.dequeue(), equalTo(k));
      }
      assertThat(i.depth(), equalTo(0));
   }
   
   @Test
   public void testEnqueueAll()
   {
      Queue<Integer> i = new Queue<>();
      ArrayList<Integer> iterable = new ArrayList<>();
      for (int k = 0; k <= 10; k++)
      {
         iterable.add(k);
      }
      i.enqueueAll(iterable);
      assertThat(i.depth(), equalTo(11));
   }
   
   @Test
   public void testEnqueueAllAndDequeue()
   {
      Queue<Integer> i = new Queue<>();
      ArrayList<Integer> iterable = new ArrayList<>();
      for (int k = 0; k <= 10; k++)
      {
         iterable.add(k);
      }
      i.enqueueAll(iterable);
      i.dequeue();
      i.dequeue();
      assertThat(i.depth(), equalTo(9));
   }
   
   @Test
   public void testHeadandEnqueue()
   {
      Queue<Integer> i = new Queue<>();
      i.enqueue(10);
      i.enqueue(500);
      i.enqueue(8);
      assertThat(i.head(), equalTo(10));
   }
   
   @Test
   public void testHeadandDequeue()
   {
      Queue<Integer> i = new Queue<>();
      for (int k = 0; k <= 10; k++)
      {
         i.enqueue(k);
      }
      for (int j = 0; j <= 3; j++)
      {
         i.dequeue();
      }
      assertThat(i.head(), equalTo(4));
   }
   
   @Test (expected = NoSuchElementException.class)
   public void testHeadEmpty()
   {
      Queue<Integer> i = new Queue<>();
      assertThat(i.head(), equalTo(null));
   }
   
   @Test
   public void testDequeue()
   {
      Queue<Integer> i = new Queue<>();
      for (int j = 0; j < 11; j++)
      {
         i.enqueue(j);
      }
      assertThat(i.dequeue(), equalTo(0));
      assertThat(i.depth(), equalTo(10));
   }
   
   
   @Test (expected = NoSuchElementException.class)
   public void testDequeueNoSuchElementException()
   {
      Queue<Integer> i = new Queue<>();
      for (int j = 0; j < 11; j++)
      {
         i.enqueue(j);
      }
      for (int k = 0; k < 12; k++)
      {
         i.dequeue();
      }
   }
   
   @Test
   public void testClear()
   {
      Queue<Integer> i = new Queue<>();
      for (int j = 0; j < 11; j++)
      {
         i.enqueue(j);
      }
      i.clear();
      assertThat(i.depth(), equalTo(0));
   }
   
   @Test
   public void testDepth()
   {
      Queue<Integer> i = new Queue<>();
      for (int j = 0; j <= 3; j++)
      {
         i.enqueue(j);
      }
      i.dequeue();
      assertThat(i.depth(), equalTo(3));
   }
   
   @Test
   public void isEmptyTrue()
   {
      Queue<Integer> i = new Queue<>();
      assertThat(i.isEmpty(), equalTo(true));
   }
   
   @Test
   public void isEmptyFalse()
   {
      Queue<Integer> i = new Queue<>();
      for (int j = 0; j < 11; j++)
      {
         i.enqueue(j);
      }
      assertThat(i.isEmpty(), equalTo(false));
   }
   
   @Test
   public void testIterator()
   {
      Queue<Integer> i = new Queue<>();
      for (int j = 0; j < 11; j++)
      {
         i.enqueue(j);
      }
      
      int k = 0;
      for (Integer integer : i)
      {
         assertThat(integer, equalTo(k));
         k++;
      }
      
      assertThat(i.depth(), equalTo(0));
   }
   
   @Test
   public void testIteratorHasNextAndNext1()
   {
      Queue<Integer> i = new Queue<>();
      Iterator<Integer> iterator = i.iterator();
      
      assertThat(iterator.hasNext(), equalTo(false));
      
      for (int j = 0; j < 11; j++)
      {
         i.enqueue(j);
      }
      for (int j = 0; j < 11; j++)
      {
         assertThat(iterator.hasNext(), equalTo(true));
         assertThat(iterator.next(), equalTo(j));
      }
      assertThat(iterator.hasNext(), equalTo(false));
   }
}
