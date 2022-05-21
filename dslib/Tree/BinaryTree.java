package dslib.Tree;

import java.util.ArrayDeque;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {

    public static class Node<T> {
        private T val;

        private Node<T> left;

        private Node<T> right;

        Node(T val) {
            this.val = val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public T getVal() {
            return this.val;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public Node<T> getLeft() {
            return this.left;
        }

        public Node<T> getRight() {
            return this.right;
        }
    }

    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    /**
     * Retrieve the root node of the tree.
     * @return root
     */
    public Node<T> getRoot() {
        return root;
    }

    /**
     * Set the root of the tree specifically.
     * @param root the node we want to assign to current root.
     */
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /**
     * Level-order insertion into the binary tree.
     * @param val the new value to be inserted.
     */
    public void insert(T val) {
        Node<T> newNode = new Node<>(val);
        if (getRoot() == null) {
            setRoot(newNode);
            return;
        }
        ArrayDeque<Node<T>> deque = new ArrayDeque<>();
        deque.add(getRoot());
        while (!deque.isEmpty()) {
            int n = deque.size();
            for (int i = 0; i < n; i += 1) {
                Node<T> top = deque.pollFirst();
                if (top.getLeft() == null) {
                    top.setLeft(newNode);
                    return;
                }
                if (top.getRight() == null) {
                    top.setRight(newNode);
                    return;
                }
                deque.add(top.getLeft());
                deque.add(top.getRight());
            }
        }
    }

    /**
     * Level-order traversal string of the tree.
     * @return String
     */
    public String toStringLevelOrder() {
        if (getRoot() == null) {
            return "Empty tree.";
        }
        ArrayDeque<Node<T>> deque = new ArrayDeque<>();
        deque.add(getRoot());
        StringBuilder result = new StringBuilder("Level-order traversal: ");
        while (!deque.isEmpty()) {
            int n = deque.size();
            for (int i = 0; i < n; i += 1) {
                Node<T> top = deque.pollFirst();
                result.append(top.getVal()).append(" ");
                if (top.getLeft() != null) {
                    deque.add(top.getLeft());
                }
                if (top.getRight() != null) {
                    deque.add(top.getRight());
                }
            }
        }
        return result.toString().trim();
    }

    /**
     * Preorder traversal string of the tree.
     * @return String
     */
    public String toStringPreorder() {
        if (getRoot() == null) {
            return "Empty tree.";
        }
        Stack<Node<T>> stack = new Stack<>();
        ArrayDeque<T> elements = new ArrayDeque<>();
        StringBuilder result = new StringBuilder("Preorder traversal: ");
        stack.push(getRoot());
        while (!stack.isEmpty()) {
            Node<T> top = stack.pop();
            elements.addLast(top.getVal());
            if (top.getRight() != null) {
                stack.push(top.getRight());
            }
            if (top.getLeft() != null) {
                stack.push(top.getLeft());
            }
        }
        while (!elements.isEmpty()) {
            result.append(elements.poll()).append(" ");
        }
        return result.toString().trim();
    }

    /**
     * Inorder-traversal string of the tree.
     * @return String
     */
    public String toStringInorder() {
        if (getRoot() == null) {
            return "Empty tree.";
        }
        Stack<Node<T>> stack = new Stack<>();
        Node<T> curr = getRoot();
        StringBuilder result = new StringBuilder("Inorder traversal: ");
        while(!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            } else {
                curr = stack.pop();
                result.append(curr.getVal()).append(" ");
                curr = curr.getRight();
            }
        }
        return result.toString().trim();
    }

    /**
     * Postorder-traversal string of the tree.
     * @return String
     */
    public String toStringPostorder() {
        if (getRoot() == null) {
            return "Empty tree.";
        }
        Stack<Node<T>> stack = new Stack<>();
        StringBuilder rs = new StringBuilder("Postorder traversal: ");
        Stack<T> elements = new Stack<>();
        stack.push(getRoot());
        while (!stack.isEmpty()) {
            Node<T> top = stack.pop();
            elements.push(top.getVal());
            if (top.getLeft() != null) {
                stack.push(top.getLeft());
            }
            if (top.getRight() != null) {
                stack.push(top.getRight());
            }
        }
        while (!elements.isEmpty()) {
            rs.append(elements.pop()).append(" ");
        }
        return rs.toString().trim();
    }
}
