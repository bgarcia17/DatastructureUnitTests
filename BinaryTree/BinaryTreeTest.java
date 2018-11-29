import org.junit.runner.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class BinaryTreeTest
{
   @BeforeClass
   public static void setUpClass() {
      BinaryTree<String> tree = new BinaryTree<>("a");
   }
   
   public static void main(String[] args)
   {
      org.junit.runner.JUnitCore.main("BinaryTreeTest");
   }
   
   //
   // BEN
   //
   private static BinaryTree<Integer> createEmptyTree(int value)
   {
      return new BinaryTree<Integer>(value);
   }
   
   private static BinaryTree<Integer> createFull2Tree()
   {
      BinaryTree<Integer> result = new BinaryTree<>(10);
      result.setLeftChild(new BinaryTree<>(7));
      result.setRightChild(new BinaryTree<>(15));
      return result;
   }
   
   private static BinaryTree<Integer> createComplete2Tree()
   {
      BinaryTree<Integer> result = new BinaryTree<>(10);
      result.setLeftChild(new BinaryTree<>(100));
      return result;
   }
   
   private static BinaryTree<Integer> createFull3Tree()
   {
      BinaryTree<Integer> result = new BinaryTree<>(10);
      result.setLeftChild(new BinaryTree<>(5));
      result.getLeftChild().setLeftChild(new BinaryTree<>(3));
      result.getLeftChild().setRightChild(new BinaryTree<>(7));
      result.setRightChild(new BinaryTree<>(15));
      result.getRightChild().setLeftChild(new BinaryTree<>(12));
      result.getRightChild().setRightChild(new BinaryTree<>(17));
      return result;
   }
   
   private static BinaryTree<Integer> createComplete3Tree1()
   {
      BinaryTree<Integer> result = new BinaryTree<>(10);
      result.setLeftChild(new BinaryTree<>(5));
      result.getLeftChild().setLeftChild(new BinaryTree<>(3));
      result.getLeftChild().setRightChild(new BinaryTree<>(7));
      result.setRightChild(new BinaryTree<>(15));
      result.getRightChild().setLeftChild(new BinaryTree<>(12));
      return result;
   }
   
   private static BinaryTree<Integer> createComplete3Tree2()
   {
      BinaryTree<Integer> result = new BinaryTree<>(10);
      result.setLeftChild(new BinaryTree<>(5));
      result.getLeftChild().setLeftChild(new BinaryTree<>(3));
      result.getLeftChild().setRightChild(new BinaryTree<>(7));
      result.setRightChild(new BinaryTree<>(15));
      return result;
   }
   
   private static BinaryTree<Integer> createComplete3Tree3()
   {
      BinaryTree<Integer> result = new BinaryTree<>(10);
      result.setLeftChild(new BinaryTree<>(5));
      result.getLeftChild().setLeftChild(new BinaryTree<>(3));
      result.setRightChild(new BinaryTree<>(15));
      return result;
   }
   
   private static ArrayList<BinaryTree<Integer>> createDegenerate2Trees()
   {
      ArrayList<BinaryTree<Integer>> result = new ArrayList<>();
      BinaryTree<Integer> result1 = new BinaryTree<>(10);
      result1.setLeftChild(new BinaryTree<>(5));
      result.add(result1);
      BinaryTree<Integer> result2 = new BinaryTree<>(15);
      result2.setRightChild(new BinaryTree<>(20));
      result.add(result2);
      return result;
   }
   
   private static ArrayList<BinaryTree<Integer>> createDegenerate3Trees()
   {
      ArrayList<BinaryTree<Integer>> result = new ArrayList<>();
      BinaryTree<Integer> result1 = new BinaryTree<>(10);
      result1.setLeftChild(new BinaryTree<>(5));
      result1.getLeftChild().setLeftChild(new BinaryTree<>(2));
      result.add(result1);
      BinaryTree<Integer> result2 = new BinaryTree<>(10);
      result2.setLeftChild(new BinaryTree<>(5));
      result2.getLeftChild().setRightChild(new BinaryTree<>(7));
      result.add(result2);
      BinaryTree<Integer> result3 = new BinaryTree<>(10);
      result3.setRightChild(new BinaryTree<>(15));
      result3.getRightChild().setLeftChild(new BinaryTree<>(12));
      result.add(result3);
      BinaryTree<Integer> result4 = new BinaryTree<>(10);
      result4.setRightChild(new BinaryTree<>(15));
      result4.getRightChild().setRightChild(new BinaryTree<>(17));
      result.add(result4);
      return result;
   }
   
   @Test
   public void testGetElement()
   {
      assertThat(createEmptyTree(5).getElement(), equalTo(5));
      assertThat(createFull2Tree().getElement(), equalTo(10));
      assertThat(createComplete2Tree().getLeftChild().getElement(), equalTo(100));
   }
   
   @Test
   public void testSetElement()
   {
      BinaryTree<Integer> t = createEmptyTree(5);
      assertThat(t.getElement(), equalTo(5));
      t.setElement(10);
      assertThat(t.getElement(), equalTo(10));
      
      t.setElement(null);
      assertThat(t.getElement(), equalTo(null));
   }
   
   @Test
   public void testHasLeftChild()
   {
      BinaryTree<Integer> i = createEmptyTree(100);
      assertThat(i.hasLeftChild(), equalTo(false));
      i.setLeftChild(new BinaryTree<>(10));
      assertThat(i.hasLeftChild(), equalTo(true));
      i.setLeftChild(null);
      assertThat(i.hasLeftChild(), equalTo(false));
   }
   
   @Test
   public void testGetSetLeftChild()
   {
      BinaryTree<Integer> t = createEmptyTree(100);
      BinaryTree<Integer> ch = createEmptyTree(50);
      assertThat(t.getLeftChild(), equalTo(null));
      t.setLeftChild(ch);
      assertThat(t.getLeftChild(), equalTo(ch));
      t.setLeftChild(null);
      assertThat(t.getLeftChild(), equalTo(null));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void testSetLeftChildSelf()
   {
      BinaryTree<Integer> t = new BinaryTree<Integer>(1);
      t.setLeftChild(t);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void testSetLeftChildParent()
   {
      BinaryTree<Integer> t = new BinaryTree<>(1);
      BinaryTree<Integer> ch = new BinaryTree<>(2);
      t.setLeftChild(ch);
      ch.setRightChild(t);
   }
   
   @Test
   public void testHasRightChild()
   {
      BinaryTree<Integer> t = createEmptyTree(100);
      assertThat(t.hasRightChild(), equalTo(false));
      t.setRightChild(new BinaryTree<>(50));
      assertThat(t.hasRightChild(), equalTo(true));
      t.setRightChild(null);
      assertThat(t.hasRightChild(), equalTo(false));
   }
   
   @Test
   public void testGetSetRightChild()
   {
      BinaryTree<Integer> t = createEmptyTree(100);
      BinaryTree<Integer> ch = createEmptyTree(50);
      assertThat(t.getRightChild(), equalTo(null));
      t.setRightChild(ch);
      assertThat(t.getRightChild(), equalTo(ch));
      t.setRightChild(null);
      assertThat(t.getRightChild(), equalTo(null));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void testSetRightChildSelf()
   {
      BinaryTree<Integer> t = new BinaryTree<>(1);
      t.setRightChild(t);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void testSetRightChildParent()
   {
      BinaryTree<Integer> t = new BinaryTree<>(1);
      BinaryTree<Integer> ch = new BinaryTree<>(2);
      t.setRightChild(ch);
      ch.setRightChild(t);
   }
   
   @Test
   public void testGetRoot()
   {
      BinaryTree<Integer> t = createFull3Tree();
      BinaryTree<Integer> ch = t.getLeftChild().getLeftChild();
      assertThat(ch.getRoot(), equalTo(t));
      assertThat(t.getRoot(), equalTo(t));
      t.setLeftChild(null);
      assertThat(ch.getRoot(), not(equalTo(t)));
      assertThat(ch.getRoot(), not(equalTo(ch)));
   }
   
   @Test
   public void testGetParent()
   {
      BinaryTree<Integer> t = createFull2Tree();
      BinaryTree<Integer> ch = t.getLeftChild();
      
      assertThat(ch.getParent(), equalTo(t));
      assertThat(t.getParent(), equalTo(null));
      t.setLeftChild(null);
      assertThat(ch.getParent(), equalTo(null));
      assertThat(t.getRightChild().getParent(), equalTo(t));
      t.setRightChild(ch);
      assertThat(ch.getParent(), equalTo(t));
   }
   
   @Test
   public void testSize()
   {
      assertThat(createEmptyTree(5).size(), equalTo(1));
      assertThat(createFull2Tree().size(), equalTo(3));
      assertThat(createComplete2Tree().size(), equalTo(2));
      assertThat(createDegenerate3Trees().get(0).size(), equalTo(3));
   }
   
   @Test
   public void testHeight()
   {
      assertThat(createEmptyTree(5).height(), equalTo(0));
      assertThat(createFull2Tree().height(), equalTo(1));
      assertThat(createComplete2Tree().height(), equalTo(1));
      assertThat(createDegenerate3Trees().get(0).height(), equalTo(2));
   }
   
   @Test
   public void testLevel()
   {
      BinaryTree<Integer> t = createFull3Tree();
      assertThat(t.level(), equalTo(0));
      assertThat(t.getLeftChild().level(), equalTo(1));
      assertThat(t.getRightChild().level(), equalTo(1));
      assertThat(t.getLeftChild().getLeftChild().level(), equalTo(2));
      assertThat(t.getLeftChild().getRightChild().level(), equalTo(2));
      assertThat(t.getRightChild().getLeftChild().level(), equalTo(2));
      assertThat(t.getRightChild().getRightChild().level(), equalTo(2));
      BinaryTree<Integer> ch = t.getLeftChild().getLeftChild();
      t.getLeftChild().setLeftChild(null);
      assertThat(ch.level(), equalTo(0));
   }
   
   @Test
   public void testDegree()
   {
      BinaryTree<Integer> t = new BinaryTree<>(10);
      assertThat(t.degree(), equalTo(0));
      t.setLeftChild(new BinaryTree<>(5));
      assertThat(t.degree(), equalTo(1));
      t.setRightChild(new BinaryTree<>(15));
      assertThat(t.degree(), equalTo(2));
      t.setLeftChild(null);
      assertThat(t.degree(), equalTo(1));
      t.setRightChild(null);
      assertThat(t.degree(), equalTo(0));
   }
   
   @Test
   public void testIsRoot()
   {
      BinaryTree<Integer> t = new BinaryTree<>(10);
      BinaryTree<Integer> ch = new BinaryTree<>(5);
      assertThat(t.isRoot(), equalTo(true));
      assertThat(ch.isRoot(), equalTo(true));
      t.setRightChild(ch);
      assertThat(t.isRoot(), equalTo(true));
      assertThat(ch.isRoot(), equalTo(false));
      t.setRightChild(null);
      assertThat(t.isRoot(), equalTo(true));
      assertThat(ch.isRoot(), equalTo(true));
   }
   
   @Test
   public void testIsParent()
   {
      BinaryTree<Integer> t = new BinaryTree<>(10);
      BinaryTree<Integer> ch = new BinaryTree<>(5);
      assertThat(t.isParent(), equalTo(false));
      assertThat(ch.isParent(), equalTo(false));
      t.setRightChild(ch);
      assertThat(t.isParent(), equalTo(true));
      assertThat(ch.isParent(), equalTo(false));
      t.setRightChild(null);
      assertThat(t.isParent(), equalTo(false));
      assertThat(ch.isParent(), equalTo(false));
   }
   
   @Test
   public void testIsChild()
   {
      BinaryTree<Integer> t = new BinaryTree<>(10);
      BinaryTree<Integer> ch = new BinaryTree<>(5);
      assertThat(t.isChild(), equalTo(false));
      assertThat(ch.isChild(), equalTo(false));
      t.setRightChild(ch);
      assertThat(t.isChild(), equalTo(false));
      assertThat(ch.isChild(), equalTo(true));
      t.setRightChild(null);
      assertThat(t.isChild(), equalTo(false));
      assertThat(ch.isChild(), equalTo(false));
   }
   
   @Test
   public void testIsLeaf()
   {
      BinaryTree<Integer> t = new BinaryTree<>(10);
      BinaryTree<Integer> ch = new BinaryTree<>(5);
      assertThat(t.isLeaf(), equalTo(true));
      assertThat(ch.isLeaf(), equalTo(true));
      t.setRightChild(ch);
      assertThat(t.isLeaf(), equalTo(false));
      assertThat(ch.isLeaf(), equalTo(true));
      t.setRightChild(null);
      assertThat(t.isLeaf(), equalTo(true));
      assertThat(ch.isLeaf(), equalTo(true));
   }
   
   @Test
   public void testIsFull()
   {
      assertThat(createEmptyTree(10).isFull(), equalTo(true));
      assertThat(createFull2Tree().isFull(), equalTo(true));
      assertThat(createComplete2Tree().isFull(), equalTo(false));
      BinaryTree<Integer> t = new BinaryTree<>(10);
      t.setRightChild(new BinaryTree<>(15));
      assertThat(t.isFull(), equalTo(false));
      for (BinaryTree<Integer> degenerate : createDegenerate3Trees())
      {
         assertThat(degenerate.isFull(), equalTo(false));
      }
   }
   
   @Test
   public void testIsComplete()
   {
      assertThat(createEmptyTree(10).isComplete(), equalTo(true));
      assertThat(createFull2Tree().isComplete(), equalTo(true));
      assertThat(createComplete2Tree().isComplete(), equalTo(true));
      BinaryTree<Integer> t = new BinaryTree<>(10);
      t.setRightChild(new BinaryTree<>(15));
      assertThat(t.isComplete(), equalTo(false));
      for (BinaryTree<Integer> degenerate : createDegenerate3Trees())
      {
         assertThat(degenerate.isComplete(), equalTo(false));
      }
      assertThat(createComplete3Tree1().isComplete(), equalTo(true));
      assertThat(createComplete3Tree2().isComplete(), equalTo(true));
      assertThat(createComplete3Tree3().isComplete(), equalTo(true));
   }
   
   @Test
   public void testIsDegenerate()
   {
      assertThat(createEmptyTree(10).isDegenerate(), equalTo(true));
      assertThat(createFull2Tree().isDegenerate(), equalTo(false));
      assertThat(createComplete3Tree1().isDegenerate(), equalTo(false));
      assertThat(createComplete3Tree2().isDegenerate(), equalTo(false));
      assertThat(createComplete3Tree3().isDegenerate(), equalTo(false));
      assertThat(createComplete2Tree().isDegenerate(), equalTo(true));
      for (BinaryTree<Integer> degenerate : createDegenerate3Trees())
      {
         assertThat(degenerate.isDegenerate(), equalTo(true));
      }
   }
   
   @Test
   public void testIsAncestorOf()
   {
      // Cases for argument:
      // Self -> false
      // Ancestor -> true
      // Descendant -> false
      // Unrelated -> false
      // Null -> exception (next test)
      BinaryTree<Integer> t = new BinaryTree<>(10); // ancestor
      BinaryTree<Integer> ch = new BinaryTree<>(15); // self
      BinaryTree<Integer> ch2 = new BinaryTree<>(12); // descendant
      BinaryTree<Integer> other = new BinaryTree<>(1000); // unrelated
      assertThat(ch.isAncestorOf(t), equalTo(false));
      assertThat(ch.isAncestorOf(ch), equalTo(false));
      assertThat(ch.isAncestorOf(ch2), equalTo(false));
      assertThat(ch.isAncestorOf(other), equalTo(false));
      t.setRightChild(ch);
      ch.setLeftChild(ch2);
      ch2.setLeftChild(new BinaryTree<>(11)); // check more than one height away
      assertThat(ch.isAncestorOf(t), equalTo(false));
      assertThat(ch.isAncestorOf(ch), equalTo(false));
      assertThat(ch.isAncestorOf(ch2), equalTo(true));
      assertThat(ch.isAncestorOf(ch2.getLeftChild()), equalTo(true));
      assertThat(ch.isAncestorOf(other), equalTo(false));
      ch.setLeftChild(null);
      assertThat(ch.isAncestorOf(t), equalTo(false));
      assertThat(ch.isAncestorOf(ch), equalTo(false));
      assertThat(ch.isAncestorOf(ch2), equalTo(false));
      assertThat(ch.isAncestorOf(other), equalTo(false));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void testIsAncestorOfNull()
   {
      new BinaryTree<Integer>(10).isAncestorOf(null);
   }

   @Test
   public void testIsParentOf()
   {
      // Cases for argument:
      // Self -> false
      // Ancestor -> true if immediate child
      // Descendant -> false
      // Unrelated -> false
      // Null -> exception (next test)
      BinaryTree<Integer> t = new BinaryTree<>(10); // ancestor
      BinaryTree<Integer> ch = new BinaryTree<>(15); // self
      BinaryTree<Integer> ch2 = new BinaryTree<>(12); // descendant
      BinaryTree<Integer> other = new BinaryTree<>(1000); // unrelated
      assertThat(ch.isParentOf(t), equalTo(false));
      assertThat(ch.isParentOf(ch), equalTo(false));
      assertThat(ch.isParentOf(ch2), equalTo(false));
      assertThat(ch.isParentOf(other), equalTo(false));
      t.setRightChild(ch);
      ch.setLeftChild(ch2);
      ch2.setLeftChild(new BinaryTree<>(11)); // check more than one height away
      assertThat(ch.isParentOf(t), equalTo(false));
      assertThat(ch.isParentOf(ch), equalTo(false));
      assertThat(ch.isParentOf(ch2), equalTo(true));
      assertThat(ch.isParentOf(ch2.getLeftChild()), equalTo(false));
      assertThat(ch.isParentOf(other), equalTo(false));
      ch.setLeftChild(null);
      assertThat(ch.isParentOf(t), equalTo(false));
      assertThat(ch.isParentOf(ch), equalTo(false));
      assertThat(ch.isParentOf(ch2), equalTo(false));
      assertThat(ch.isParentOf(other), equalTo(false));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void testIsParentOfNull()
   {
      new BinaryTree<Integer>(10).isParentOf(null);
   }
   
   @Test
   public void testIsSiblingOf()
   {
      // Cases for argument:
      // Self -> false
      // Ancestor -> false
      // Descendant -> false
      // Sibling -> true
      // Null -> exception (next test)
      BinaryTree<Integer> t = new BinaryTree<>(10); // ancestor
      BinaryTree<Integer> ch = new BinaryTree<>(15); // self
      BinaryTree<Integer> ch2 = new BinaryTree<>(12); // sibling
      BinaryTree<Integer> other = new BinaryTree<>(1000); // unrelated
      assertThat(ch.isSiblingOf(t), equalTo(false));
      assertThat(ch.isSiblingOf(ch), equalTo(false));
      assertThat(ch.isSiblingOf(ch2), equalTo(false));
      assertThat(ch.isSiblingOf(other), equalTo(false));
      t.setRightChild(ch);
      t.setLeftChild(ch2);
      ch2.setLeftChild(new BinaryTree<>(11)); // check more than one height away
      assertThat(ch.isSiblingOf(t), equalTo(false));
      assertThat(ch.isSiblingOf(ch), equalTo(false));
      assertThat(ch.isSiblingOf(ch2), equalTo(true));
      assertThat(ch.isSiblingOf(ch2.getLeftChild()), equalTo(false));
      assertThat(ch.isSiblingOf(other), equalTo(false));
      t.setLeftChild(null);
      assertThat(ch.isSiblingOf(t), equalTo(false));
      assertThat(ch.isSiblingOf(ch), equalTo(false));
      assertThat(ch.isSiblingOf(ch2), equalTo(false));
      assertThat(ch.isSiblingOf(other), equalTo(false));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void testIsSiblingOfNull()
   {
      new BinaryTree<Integer>(10).isSiblingOf(null);
   }
   
   @Test
   public void testIsChildOf()
   {
      // Cases for argument:
      // Self -> false
      // Ancestor -> true if immediate parent
      // Descendant -> false
      // Sibling -> false
      // Null -> exception (next test)
      BinaryTree<Integer> t = new BinaryTree<>(10); // ancestor
      BinaryTree<Integer> ch = new BinaryTree<>(15); // self
      BinaryTree<Integer> ch2 = new BinaryTree<>(12); // descendant
      BinaryTree<Integer> other = new BinaryTree<>(1000); // unrelated
      assertThat(ch.isChildOf(t), equalTo(false));
      assertThat(ch.isChildOf(ch), equalTo(false));
      assertThat(ch.isChildOf(ch2), equalTo(false));
      assertThat(ch.isChildOf(other), equalTo(false));
      t.setRightChild(ch);
      ch.setLeftChild(ch2);
      ch2.setLeftChild(new BinaryTree<>(11)); // check more than one height away
      assertThat(ch.isChildOf(t), equalTo(true));
      assertThat(ch.isChildOf(ch), equalTo(false));
      assertThat(ch.isChildOf(ch2), equalTo(false));
      assertThat(ch.isChildOf(ch2.getLeftChild()), equalTo(false));
      assertThat(ch.isChildOf(other), equalTo(false));
      t.setRightChild(null);
      assertThat(ch.isChildOf(t), equalTo(false));
      assertThat(ch.isChildOf(ch), equalTo(false));
      assertThat(ch.isChildOf(ch2), equalTo(false));
      assertThat(ch.isChildOf(other), equalTo(false));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void testIsChildOfNull()
   {
      new BinaryTree<Integer>(10).isChildOf(null);
   }
   
   @Test
   public void testIsDescendantOf()
   {
      // Cases for argument:
      // Self -> false
      // Ancestor -> true
      // Descendant -> false
      // Sibling -> false
      // Null -> exception (next test)
      BinaryTree<Integer> t = new BinaryTree<>(10); // ancestor
      BinaryTree<Integer> ch = new BinaryTree<>(15); // self
      BinaryTree<Integer> ch2 = new BinaryTree<>(12); // sibling
      BinaryTree<Integer> other = new BinaryTree<>(1000); // unrelated
      assertThat(ch.isDescendantOf(t), equalTo(false));
      assertThat(ch.isDescendantOf(ch), equalTo(false));
      assertThat(ch.isDescendantOf(ch2), equalTo(false));
      assertThat(ch.isDescendantOf(other), equalTo(false));
      t.setRightChild(ch);
      ch.setLeftChild(ch2);
      ch2.setLeftChild(new BinaryTree<>(11)); // check more than one height away
      assertThat(ch.isDescendantOf(t), equalTo(true));
      assertThat(ch.isDescendantOf(ch), equalTo(false));
      assertThat(ch2.isDescendantOf(t), equalTo(true));
      assertThat(ch.isDescendantOf(ch2.getLeftChild()), equalTo(false));
      assertThat(ch.isDescendantOf(other), equalTo(false));
      t.setRightChild(null);
      assertThat(ch.isDescendantOf(t), equalTo(false));
      assertThat(ch.isDescendantOf(ch), equalTo(false));
      assertThat(ch2.isDescendantOf(t), equalTo(false));
      assertThat(ch.isDescendantOf(other), equalTo(false));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void testIsDescendantOfNull()
   {
      new BinaryTree<Integer>(10).isDescendantOf(null);
   }
   
   @Test
   public void testPreOrderIterator()
   {
      int[] expected = { 10, 5, 3, 7, 15, 12, 17 };
      Iterator<Integer> it = createFull3Tree().preOrderIterator();
      int i = 0;
      while (it.hasNext())
      {
         assertThat(it.next(), equalTo(expected[i]));
         i++;
      }
   }
   
   @Test
   public void testInOrderIterator()
   {
      int[] expected = { 3, 5, 7, 10, 12, 15, 17 };
      Iterator<Integer> it = createFull3Tree().inOrderIterator();
      int i = 0;
      while (it.hasNext())
      {
         assertThat(it.next(), equalTo(expected[i]));
         i++;
      }
   }
   
   @Test
   public void testPostOrderIterator()
   {
      int[] expected = { 3, 7, 5, 12, 17, 15, 10 };
      Iterator<Integer> it = createFull3Tree().postOrderIterator();
      int i = 0;
      while (it.hasNext())
      {
         int k = it.next();
         assertThat(k, equalTo(expected[i]));
         i++;
      }
   }
   
   @Test
   public void testLevelOrderIterator()
   {
      int[] expected = { 10, 5, 15, 3, 7, 12, 17 };
      Iterator<Integer> it = createFull3Tree().levelOrderIterator();
      int i = 0;
      while (it.hasNext())
      {
         int k = it.next();
         assertThat(k, equalTo(expected[i]));
         i++;
      }
   }
   
   //
   // MATT
   //
   @Test
    public void mtestConstructor() {
    BinaryTree<String> tree = new BinaryTree<>("a");
        assertThat(tree, notNullValue());
    }

    @Test
    public void mtestGetElement() {
    BinaryTree<String> root = new BinaryTree<>("a");
        assertThat(root.getElement(), equalTo("a"));
    }

    @Test
    public void mtestSetElement() {
        BinaryTree<String> root = new BinaryTree<>("a");
        root.setElement("b");
        assertThat(root.getElement(), equalTo("b"));
    }

    @Test
    public void mtestSetLeftChild() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        root.setLeftChild(leftChild);
        assertThat(root.getLeftChild(), equalTo(leftChild));
    }

    @Test
    public void mtestHasLeftChild() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        root.setLeftChild(leftChild);
        assertThat(root.hasLeftChild(), equalTo(true));
    }

    @Test
    public void mtestIsAncestorOf() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        root.setLeftChild(leftChild);
        assertThat(root.isAncestorOf(leftChild), equalTo(true));
    }

    @Test (expected = IllegalArgumentException.class)
    public void mtestSetLeftChildToAncestor() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> leftLeftChild = new BinaryTree<>("b");
        root.setLeftChild(leftChild);
        leftChild.setLeftChild(leftLeftChild);
        leftLeftChild.setLeftChild(leftChild);
    }

    @Test (expected = IllegalArgumentException.class)
    public void mtestSetLeftChildToRoot() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> leftLeftChild = new BinaryTree<>("b");
        root.setLeftChild(leftChild);
        leftChild.setLeftChild(leftLeftChild);
        leftLeftChild.setLeftChild(root);
    }

    @Test
    public void mtestSetLeftChildToRightBranch() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> rightChild = new BinaryTree<>("c");
        BinaryTree<String> leftsLeftChild = new BinaryTree<>("d");
        BinaryTree<String> leftsRightChild = new BinaryTree<>("e");
        BinaryTree<String> rightsLeftChild = new BinaryTree<>("f");
        BinaryTree<String> rightsRightChild = new BinaryTree<>("g");

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setLeftChild(leftsLeftChild);
        leftChild.setRightChild(leftsRightChild);
        rightChild.setLeftChild(rightsLeftChild);
        rightChild.setRightChild(rightsRightChild);
        //
        rightsRightChild.setRightChild(leftsLeftChild);

        assertNull(leftChild.getLeftChild());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void mtestSetRightChild() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> rightChild = new BinaryTree<>("c");
        BinaryTree<String> leftsLeftChild = new BinaryTree<>("d");
        BinaryTree<String> leftsRightChild = new BinaryTree<>("e");
        BinaryTree<String> rightsLeftChild = new BinaryTree<>("f");
        BinaryTree<String> rightsRightChild = new BinaryTree<>("g");

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setLeftChild(leftsLeftChild);
        leftChild.setRightChild(leftsRightChild);
        rightChild.setLeftChild(rightsLeftChild);
        rightChild.setRightChild(rightsRightChild);
        
        rightsRightChild.setLeftChild(rightChild);
    }

    @Test
    public void mtestSize() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> rightChild = new BinaryTree<>("c");
        BinaryTree<String> leftsLeftChild = new BinaryTree<>("d");
        BinaryTree<String> leftsRightChild = new BinaryTree<>("e");
        BinaryTree<String> rightsLeftChild = new BinaryTree<>("f");
        BinaryTree<String> rightsRightChild = new BinaryTree<>("g");

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setLeftChild(leftsLeftChild);
        leftChild.setRightChild(leftsRightChild);
        rightChild.setLeftChild(rightsLeftChild);
        rightChild.setRightChild(rightsRightChild);

        assertThat(root.size(),equalTo(7));
    }

    @Test
    public void mtestGetRoot() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> rightChild = new BinaryTree<>("c");
        BinaryTree<String> leftsLeftChild = new BinaryTree<>("d");
        BinaryTree<String> leftsRightChild = new BinaryTree<>("e");
        BinaryTree<String> rightsLeftChild = new BinaryTree<>("f");
        BinaryTree<String> rightsRightChild = new BinaryTree<>("g");

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setLeftChild(leftsLeftChild);
        leftChild.setRightChild(leftsRightChild);
        rightChild.setLeftChild(rightsLeftChild);
        rightChild.setRightChild(rightsRightChild);

        assertThat(rightsRightChild.getRoot().getElement(), equalTo("a"));
    }

    @Test
    public void mtestHeight() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> rightChild = new BinaryTree<>("c");
        BinaryTree<String> leftsLeftChild = new BinaryTree<>("d");
        BinaryTree<String> leftsRightChild = new BinaryTree<>("e");
        BinaryTree<String> rightsLeftChild = new BinaryTree<>("f");
        BinaryTree<String> rightsRightChild = new BinaryTree<>("g");

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setLeftChild(leftsLeftChild);
        leftChild.setRightChild(leftsRightChild);
        rightChild.setLeftChild(rightsLeftChild);
        rightChild.setRightChild(rightsRightChild);

        assertThat(root.height(), equalTo(2));
    }
    
    @Test
    public void mtestHeightAfterChange() {
        BinaryTree<String> a = new BinaryTree<>("0");
        BinaryTree<String> b = new BinaryTree<>("1");
        BinaryTree<String> d = new BinaryTree<>("3");
        BinaryTree<String> e = new BinaryTree<>("4");
        BinaryTree<String> f = new BinaryTree<>("5");
        BinaryTree<String> g = new BinaryTree<>("6");
        BinaryTree<String> h = new BinaryTree<>("0");
        BinaryTree<String> i = new BinaryTree<>("1");
        BinaryTree<String> j = new BinaryTree<>("3");
        BinaryTree<String> k = new BinaryTree<>("4");
        BinaryTree<String> l = new BinaryTree<>("5");
        BinaryTree<String> m = new BinaryTree<>("6");
        BinaryTree<String> n = new BinaryTree<>("0");
        BinaryTree<String> o = new BinaryTree<>("1");
        BinaryTree<String> p = new BinaryTree<>("3");
        BinaryTree<String> q = new BinaryTree<>("4");
        BinaryTree<String> r = new BinaryTree<>("5");
        BinaryTree<String> s = new BinaryTree<>("6");
        BinaryTree<String> t = new BinaryTree<>("0");
        BinaryTree<String> u = new BinaryTree<>("1");
        BinaryTree<String> v = new BinaryTree<>("3");
        BinaryTree<String> w = new BinaryTree<>("4");
        BinaryTree<String> x = new BinaryTree<>("5");
        BinaryTree<String> y = new BinaryTree<>("6");
        BinaryTree<String> c = new BinaryTree<>("6");

        a.setLeftChild(b);
        b.setLeftChild(d);
        d.setLeftChild(e);
        e.setLeftChild(f);
        f.setLeftChild(g);
        g.setLeftChild(h);
        h.setLeftChild(i);
        i.setLeftChild(j);
        j.setLeftChild(k);
        k.setLeftChild(l);
        l.setLeftChild(m);
        m.setLeftChild(n);
        n.setLeftChild(o);
        o.setLeftChild(p);
        p.setLeftChild(q);
        q.setLeftChild(r);
        r.setLeftChild(s);
        s.setLeftChild(t);
        t.setLeftChild(u);
        u.setLeftChild(v);
        v.setLeftChild(w);
        w.setLeftChild(x);
        x.setLeftChild(y);
        y.setLeftChild(c);
        
        assertThat(a.height(), equalTo(24));
    }

    @Test
    public void mtestDegree() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> leftsLeftChild = new BinaryTree<>("d");
        BinaryTree<String> rightChild = new BinaryTree<>("c");

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setRightChild(leftsLeftChild);

        assertThat(root.degree(), equalTo(2));
        assertThat(leftChild.degree(), equalTo(1));
        assertThat(leftsLeftChild.degree(), equalTo(0));
    }

    @Test
    public void mtestIsRoot () {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> rightChild = new BinaryTree<>("c");

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);

        assertThat(root.isRoot(), equalTo(true));
        assertThat(leftChild.isRoot(), equalTo(false));
    }

    @Test
    public void mtestIsParent () {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> rightChild = new BinaryTree<>("c");

        root.setRightChild(rightChild);

        assertThat(root.isParent(), equalTo(true));
        assertThat(leftChild.isParent(), equalTo(false));
    }

    @Test
    public void mtestIsChild () {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> rightChild = new BinaryTree<>("c");

        root.setRightChild(rightChild);

        assertThat(root.isChild(), equalTo(false));
        assertThat(leftChild.isChild(), equalTo(false));
        assertThat(rightChild.isChild(), equalTo(true));
    }

    @Test
    public void mtestIsLeaf () {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> rightChild = new BinaryTree<>("c");

        root.setRightChild(rightChild);

        assertThat(root.isLeaf(), equalTo(false));
        assertThat(leftChild.isLeaf(), equalTo(true));
        assertThat(rightChild.isLeaf(), equalTo(true));
    }

    @Test
    public void mtestIsFull() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> rightChild = new BinaryTree<>("c");
        BinaryTree<String> leftsLeftChild = new BinaryTree<>("d");
        BinaryTree<String> leftsRightChild = new BinaryTree<>("e");
        BinaryTree<String> rightsLeftChild = new BinaryTree<>("f");
        BinaryTree<String> rightsRightChild = new BinaryTree<>("g");

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setLeftChild(leftsLeftChild);
        leftChild.setRightChild(leftsRightChild);
        rightChild.setLeftChild(rightsLeftChild);
        rightChild.setRightChild(rightsRightChild);

        assertTrue(root.isFull());
    }

    @Test
    public void mtestIsFull2() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> rightChild = new BinaryTree<>("c");
        BinaryTree<String> leftsLeftChild = new BinaryTree<>("d");
        BinaryTree<String> leftsRightChild = new BinaryTree<>("e");
        BinaryTree<String> rightsLeftChild = new BinaryTree<>("f");
        BinaryTree<String> rightsRightChild = new BinaryTree<>("g");

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setLeftChild(leftsLeftChild);
        leftChild.setRightChild(leftsRightChild);
        rightChild.setLeftChild(rightsLeftChild);
        //rightChild.setRightChild(rightsRightChild);

        assertFalse(root.isFull());
    }
    
    @Test
    public void mtestIsComplete() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> rightChild = new BinaryTree<>("c");
        BinaryTree<String> leftsLeftChild = new BinaryTree<>("d");
        BinaryTree<String> leftsRightChild = new BinaryTree<>("e");
        BinaryTree<String> rightsLeftChild = new BinaryTree<>("f");
        BinaryTree<String> rightsRightChild = new BinaryTree<>("g");

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setLeftChild(leftsLeftChild);
        leftChild.setRightChild(leftsRightChild);
        rightChild.setLeftChild(rightsLeftChild);
        //rightChild.setRightChild(rightsRightChild);

        assertTrue(root.isComplete());
    }
    
    @Test
    public void mtestIsComplete2() {
        BinaryTree<String> root = new BinaryTree<>("a");
        BinaryTree<String> leftChild = new BinaryTree<>("b");
        BinaryTree<String> rightChild = new BinaryTree<>("c");
        BinaryTree<String> leftsLeftChild = new BinaryTree<>("d");
        BinaryTree<String> leftsRightChild = new BinaryTree<>("e");
        BinaryTree<String> rightsLeftChild = new BinaryTree<>("f");
        BinaryTree<String> rightsRightChild = new BinaryTree<>("g");

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setLeftChild(leftsLeftChild);
        //leftChild.setRightChild(leftsRightChild);
        rightChild.setLeftChild(rightsLeftChild);
        rightChild.setRightChild(rightsRightChild);

        assertFalse(root.isComplete());
    }
    
    //
    // CARLEE
    //
    @Test
    public void ctestConstructor()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        assertThat(tree, notNullValue());

        assertThat(tree, instanceOf(BinaryTree.class));
    }

    @Test
    public void ctestGetElement()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        assertThat(tree.getElement(), equalTo(1));
    }

    @Test
    public void ctestSetElement()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.setElement(2);

        assertThat(tree.getElement(), equalTo(2));
    }

    @Test
    public void ctestHasLeftChild()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        assertThat(tree.hasLeftChild(), equalTo(false));
    }

    @Test
    public void ctestGetLeftChild()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        assertThat(tree.getLeftChild(), equalTo(null));
    }

    @Test
    public void ctestSetLeftChild()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        BinaryTree<Integer> addLeft2 = new BinaryTree<>(4);
        BinaryTree<Integer> addLeft3 = new BinaryTree<>(5);
        tree.setLeftChild(addLeft);

        assertThat(tree.getLeftChild().getElement(), equalTo(2));
        assertThat(tree.hasLeftChild(), equalTo(true));
        assertThat(tree.size(), equalTo(2));

        tree.setRightChild(addRight);
        addLeft.setLeftChild(addLeft2);
        addRight.setLeftChild(addLeft3);
        tree.setLeftChild(null);

        //assertThat(
    }

    @Test (expected = IllegalArgumentException.class)
    public void ctestSetLeftChild_IllegalArgumentException_SettingToItself()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        tree.setLeftChild(addLeft);
        addLeft.setLeftChild(addLeft);      // should fail, setting to itself
    }

    @Test (expected = IllegalArgumentException.class)
    public void ctestSetLeftChild_IllegalArgumentExceptionAgain_SettingToAncestor()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addLeft2 = new BinaryTree<>(3);
        tree.setLeftChild(addLeft);
        addLeft.setLeftChild(addLeft2);
        addLeft2.setLeftChild(tree);
    }

    @Test
    public void ctestHasRightChild()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        assertThat(tree.hasRightChild(), equalTo(false));
    }

    @Test
    public void ctestGetRightChild()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        assertThat(tree.getRightChild(), equalTo(null));
    }

    @Test
    public void ctestSetRightChild()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addRight = new BinaryTree<>(5);
        tree.setRightChild(addRight);

        assertThat(tree.getRightChild().getElement(), equalTo(5));
        assertThat(tree.hasRightChild(), equalTo(true));
        assertThat(tree.size(), equalTo(2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void ctestSetRightChild_IllegalArgumentException_SettingToItself()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.setRightChild(tree);        // should fail, setting to itself
    }

    @Test (expected = IllegalArgumentException.class)
    public void ctestSetRightChild_IllegalArgumentExceptionAgain_SettingToAncestor()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addLeft2 = new BinaryTree<>(3);
        tree.setRightChild(addLeft);
        addLeft.setRightChild(addLeft2);
        addLeft2.setRightChild(tree);       // should fail, setting to ancestor
    }

    @Test
    public void ctestGetRoot()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);

        assertThat(tree.getRoot().getElement(), equalTo(1));
    }

    @Test
    public void ctestGetParent()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        tree.setLeftChild(addLeft);

        assertThat(addLeft.getParent().getElement(), equalTo(1));
    }

    @Test
    public void ctestSize()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        BinaryTree<Integer> addLeft2 = new BinaryTree<>(4);
        BinaryTree<Integer> addRight2 = new BinaryTree<>(5);
        BinaryTree<Integer> addLeft3 = new BinaryTree<>(6);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);
        addLeft.setLeftChild(addLeft2);
        addLeft.setRightChild(addRight2);
        addRight2.setLeftChild(addLeft3);

        assertThat(tree.size(), equalTo(6));
    }

    @Test
    public void ctestHeight()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        //tree.toString();
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        BinaryTree<Integer> addLeft2 = new BinaryTree<>(4);
        BinaryTree<Integer> addRight2 = new BinaryTree<>(5);
        BinaryTree<Integer> addLeft3 = new BinaryTree<>(6);
        BinaryTree<Integer> addRight3 = new BinaryTree<>(7);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);
        addLeft.setLeftChild(addLeft2);
        addLeft.setRightChild(addRight2);
        addRight2.setLeftChild(addLeft3);
        addLeft3.setRightChild(addRight3);

        assertThat(tree.height(), equalTo(4));
    }

    @Test
    public void ctestLevel()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        BinaryTree<Integer> addLeft2 = new BinaryTree<>(4);
        BinaryTree<Integer> addRight2 = new BinaryTree<>(5);
        BinaryTree<Integer> addLeft3 = new BinaryTree<>(6);
        BinaryTree<Integer> addRight3 = new BinaryTree<>(7);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);
        addLeft.setLeftChild(addLeft2);
        addLeft.setRightChild(addRight2);
        addRight2.setLeftChild(addLeft3);
        addLeft3.setRightChild(addRight3);

        assertThat(addRight3.level(), equalTo(4));
        assertThat(addLeft2.level(), equalTo(2));
        assertThat(addRight.level(), equalTo(1));
    }

    @Test
    public void ctestDegree()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        BinaryTree<Integer> addLeft2 = new BinaryTree<>(4);
        BinaryTree<Integer> addRight2 = new BinaryTree<>(5);
        BinaryTree<Integer> addLeft3 = new BinaryTree<>(6);
        BinaryTree<Integer> addRight3 = new BinaryTree<>(7);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);
        addLeft.setLeftChild(addLeft2);
        addLeft.setRightChild(addRight2);
        addRight2.setLeftChild(addLeft3);
        addLeft3.setRightChild(addRight3);

        assertThat(addLeft.degree(), equalTo(2));
        assertThat(addLeft2.degree(), equalTo(0));
        assertThat(addRight2.degree(), equalTo(1));
    }

    @Test
    public void ctestIsRoot()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);

        assertThat(addLeft.isRoot(), equalTo(false));
        assertThat(tree.isRoot(), equalTo(true));
    }

    @Test
    public void ctestIsParent()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);

        assertThat(tree.isParent(), equalTo(true));
        assertThat(addLeft.isParent(), equalTo(false));
    }

    @Test
    public void ctestIsChild()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);

        assertThat(addLeft.isChild(), equalTo(true));
        assertThat(tree.isChild(), equalTo(false));
    }

    @Test
    public void ctestIsLeaf()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);

        assertThat(addLeft.isLeaf(), equalTo(true));
        assertThat(tree.isLeaf(), equalTo(false));
    }


    @Test
    public void ctestIsFull()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);

        assertThat(tree.isFull(), equalTo(true));
    }

    @Test
    public void ctestIsComplete()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        BinaryTree<Integer> addLeft2 = new BinaryTree<>(4);
        BinaryTree<Integer> addLeft3 = new BinaryTree<>(5);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);
        addLeft.setLeftChild(addLeft2);
        addLeft2.setLeftChild(addLeft3);

        assertThat(tree.isComplete(), equalTo(false));
    }

    /*@Test
    public void ctestIsComplete2()       //TODO should not pass if left is null??
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(null);
        BinaryTree<Integer> addRight = new BinaryTree<>(2);
        BinaryTree<Integer> addRight2 = new BinaryTree<>(3);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);
        //addRight.setRightChild(addRight2);

        assertThat(tree.isComplete(), equalTo(false));
    } */

    @Test
    public void ctestIsDegenerate()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addLeft2 = new BinaryTree<>(3);
        BinaryTree<Integer> addLeft3 = new BinaryTree<>(4);
        BinaryTree<Integer> addRight = new BinaryTree<>(5);
        tree.setLeftChild(addLeft);
        addLeft.setLeftChild(addLeft2);
        addLeft2.setLeftChild(addLeft3);
        tree.setRightChild(addRight);

        assertThat(tree.isDegenerate(), equalTo(false));
        assertThat(addLeft.isDegenerate(), equalTo(true));
    }

    @Test
    public void ctestIsDegenerate_False()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        BinaryTree<Integer> addLeft2 = new BinaryTree<>(4);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);
        addLeft.setLeftChild(addLeft2);

        assertThat(tree.isDegenerate(), equalTo(false));
    }

    @Test
    public void ctestIsAncestorOf()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        BinaryTree<Integer> addLeft2 = new BinaryTree<>(4);
        BinaryTree<Integer> addRight2 = new BinaryTree<>(5);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);
        addLeft.setLeftChild(addLeft2);
        addLeft.setRightChild(addRight2);

        assertThat(tree.isAncestorOf(addLeft), equalTo(true));
        assertThat(tree.isAncestorOf(addRight2), equalTo(true));
        assertThat(tree.isAncestorOf(tree), equalTo(false));
        assertThat(addLeft.isAncestorOf(tree), equalTo(false));
    }

    @Test
    public void ctestIsParentOf()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        tree.setLeftChild(addLeft);

        assertThat(tree.isParentOf(addLeft), equalTo(true));
        assertThat(tree.isParentOf(tree), equalTo(false));
    }

    @Test
    public void ctestIsSiblingOf()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        BinaryTree<Integer> addLeft2 = new BinaryTree<>(4);
        BinaryTree<Integer> addRight2 = new BinaryTree<>(5);
        BinaryTree<Integer> addLeft3 = new BinaryTree<>(6);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);
        addLeft.setLeftChild(addLeft2);
        addLeft.setRightChild(addRight2);
        addRight.setLeftChild(addLeft3);

        assertThat(addLeft2.isSiblingOf(addRight2), equalTo(true));
        assertThat(addLeft2.isSiblingOf(addLeft3), equalTo(false));
    }

    @Test
    public void ctestIsChildOf()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);

        assertThat(addLeft.isChildOf(tree), equalTo(true));
        assertThat(addLeft.isChildOf(addRight), equalTo(false));
        assertThat(tree.isChildOf(tree), equalTo(false));
        assertThat(tree.isChildOf(addLeft), equalTo(false));
    }

    @Test
    public void ctestIsDescendantOf()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> addLeft = new BinaryTree<>(2);
        BinaryTree<Integer> addRight = new BinaryTree<>(3);
        BinaryTree<Integer> addLeft2 = new BinaryTree<>(4);
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);
        addLeft.setLeftChild(addLeft2);

        assertThat(addLeft2.isDescendantOf(tree), equalTo(true));
    }

    @Test
    public void ctestPreOrderIterator()
    {
        BinaryTree<String> tree = new BinaryTree<>("A");
        BinaryTree<String> addLeft = new BinaryTree<>("B");
        BinaryTree<String> addRight = new BinaryTree<>("C");
        BinaryTree<String> addLeft2 = new BinaryTree<>("D");
        BinaryTree<String> addRight2 = new BinaryTree<>("E");
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);
        addLeft.setLeftChild(addLeft2);
        addLeft.setRightChild(addRight2);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("A");
        expected.add("B");
        expected.add("D");
        expected.add("E");
        expected.add("C");

        int i = 0;
        Iterator<String> preOrder = tree.preOrderIterator();

        while (preOrder.hasNext())
        {
            String value = preOrder.next();

            assertThat(value, equalTo(expected.get(i)));

            i++;
        }
        System.out.println("Pre-Order Traversal: " + expected.toString());
    }

    @Test
    public void ctestInOrderIterator()
    {
        BinaryTree<String> tree = new BinaryTree<>("A");
        BinaryTree<String> addLeft = new BinaryTree<>("B");
        BinaryTree<String> addRight = new BinaryTree<>("C");
        BinaryTree<String> addLeft2 = new BinaryTree<>("D");
        BinaryTree<String> addRight2 = new BinaryTree<>("E");
        tree.setLeftChild(addLeft);
        tree.setRightChild(addRight);
        addLeft.setLeftChild(addLeft2);
        addLeft.setRightChild(addRight2);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("D");
        expected.add("B");
        expected.add("E");
        expected.add("A");
        expected.add("C");

        int i = 0;
        Iterator<String> inOrder = tree.inOrderIterator();

        while (inOrder.hasNext())
        {
            String value = inOrder.next();

            assertThat(value, equalTo(expected.get(i)));

            i++;
        }
        System.out.println("In-Order Traversal: " + expected.toString());
    }
}
