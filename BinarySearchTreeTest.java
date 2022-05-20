import dslib.Tree.BinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {
    @Test
    public void testPreorder() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(5);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(2);
        String testResult = new String("Preorder traversal: 5 1 6 2 7 8");
        Assert.assertEquals(testResult, tree.toStringPreorder());
    }

    @Test
    public void testInorder() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(5);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(2);
        String testResult = new String("Inorder traversal: 1 2 5 6 7 8");
        Assert.assertEquals(testResult, tree.toStringInorder());
    }

    @Test
    public void testPostorder() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(5);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(2);
        String testResult = new String("Postorder traversal: 2 1 8 7 6 5");
        Assert.assertEquals(testResult, tree.toStringPostorder());
    }

    @Test
    public void testContains() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(42);
        tree.insert(19);
        tree.insert(60);
        tree.insert(16);
        tree.insert(25);
        tree.insert(50);
        tree.insert(91);
        tree.insert(30);

        Assert.assertTrue(tree.contains(19));
        Assert.assertTrue(tree.contains(60));
        Assert.assertTrue(tree.contains(16));
        Assert.assertTrue(tree.contains(25));
        Assert.assertTrue(tree.contains(50));
        Assert.assertTrue(tree.contains(91));
        Assert.assertTrue(tree.contains(30));
        Assert.assertFalse(tree.contains(43));
        Assert.assertFalse(tree.contains(100));
    }

    @Test
    public void testDelete() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(42);
        tree.insert(19);
        tree.insert(60);
        tree.insert(16);
        tree.insert(50);
        tree.insert(91);
        tree.insert(30);

        tree.delete(42);
        String testResult = new String("Preorder traversal: 50 19 60 16 30 91");
        Assert.assertEquals(tree.toStringPreorder(), testResult);
    }
}
