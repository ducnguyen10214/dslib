import dslib.Tree.BinaryTree;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testLevelOrder() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(2);
        String testResult = new String("Level-order traversal: 5 1 6 7 8 2");
        Assert.assertEquals(tree.toStringLevelOrder(), testResult);
    }

    @Test
    public void testPreorder() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(2);
        String testResult = new String("Preorder traversal: 5 1 7 8 6 2");
        Assert.assertEquals(tree.toStringPreorder(), testResult);
    }

    @Test
    public void testInorder() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(2);
        String testResult = new String("Inorder traversal: 7 1 8 5 2 6");
        Assert.assertEquals(tree.toStringInorder(), testResult);
    }

    @Test
    public void testPostorder() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(2);
        String testResult = new String("Postorder traversal: 7 8 1 2 6 5");
        Assert.assertEquals(tree.toStringPostorder(), testResult);
    }
}