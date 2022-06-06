import dslib.Tree.Trie;
import org.junit.Assert;
import org.junit.Test;

public class TrieTest {
    @Test
    public void test1() {
        Trie trie = new Trie();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));
        Assert.assertFalse(trie.search("app"));
        Assert.assertTrue(trie.startsWith("app"));
    }
}
