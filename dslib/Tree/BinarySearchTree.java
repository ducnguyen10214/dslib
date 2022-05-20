package dslib.Tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>{
    private Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public Node<T> getRoot() {
        return root;
    }

    @Override
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /**
     * Insertion into the BST.
     * @param val the new value to be inserted.
     */
    @Override
    public void insert(T val) {
        Node<T> newNode = new Node<>(val);
        boolean duplicate = false;
        Node<T> parent = null;
        Node<T> tmp = getRoot();
        while (tmp != null && !duplicate) {
            parent = tmp;
            if (val.compareTo(tmp.getVal()) == 0) {
                duplicate = true;
            } else if (val.compareTo(tmp.getVal()) < 0) {
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        if (!duplicate) {
            if (parent == null) {
                root = newNode;
            } else if (parent.getVal().compareTo(val) > 0) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
        }
    }

    /**
     * Check if an element is contained in the BST.
     * @param val the value to check.
     * @return true if the element is contained, otherwise false.
     */
    public boolean contains(T val) {
        if (root == null) {
            return false;
        }
        Node<T> tmp = getRoot();
        while (tmp != null) {
            if (tmp.getVal().compareTo(val) == 0) {
                return true;
            } else if (tmp.getVal().compareTo(val) > 0) {
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        return false;
    }

    public void delete(T val) {
        if (getRoot() == null) {
            System.out.println("Empty tree, cannot delete!");
            return;
        }
        if (!contains(val)) {
            System.out.println("Element not in the tree, cannot delete!");
            return;
        }
        setRoot(deleteHelper(root, val));
    }

    private Node<T> deleteHelper(Node<T> node, T val) {
        if (node == null) {
            return null;
        }
        if (node.getVal().compareTo(val) == 0) {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                Node<T> smallest = minNode(node.getRight());
                node.setVal(smallest.getVal());
                node.setRight(deleteHelper(node.getRight(), smallest.getVal()));
            }
        } else if (node.getVal().compareTo(val) > 0) {
            node.setLeft(deleteHelper(node.getLeft(), val));
        } else {
            node.setRight(deleteHelper(node.getRight(), val));
        }
        return node;
    }

    private Node<T> minNode(Node<T> node) {
        if (node == null) {
            return null;
        }
        Node<T> tmp = node;
        while (tmp.getLeft() != null) {
            tmp = tmp.getLeft();
        }
        return tmp;
    }
}
