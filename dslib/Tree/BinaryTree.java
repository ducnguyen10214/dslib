package dslib.Tree;

import java.util.ArrayDeque;
import java.util.Stack;

public class BinaryTree<T> {

    private static class Node<T> {
        private T val;
        private Node<T> left;
        private Node<T> right;
        Node(T val) {
            this.val = val;
        }
    }

    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    /**
     * level-order insertion to the binary tree.
     * @param val the new value to be inserted.
     */
    public void insert(T val) {
        Node<T> newNode = new Node<>(val);
        if (root == null) {
            root = newNode;
            return;
        }
        ArrayDeque<Node<T>> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int n = deque.size();
            for (int i = 0; i < n; i += 1) {
                Node<T> top = deque.pollFirst();
                if (top.left == null) {
                    top.left = newNode;
                    return;
                }
                if (top.right == null) {
                    top.right = newNode;
                    return;
                }
                deque.add(top.left);
                deque.add(top.right);
            }
        }
    }

    /**
     * return the preorder-traversal string of the tree.
     * @return String
     */
    public String toStringPreorder() {
        if (root == null) {
            return "Empty tree.";
        }
        ArrayDeque<Node<T>> deque = new ArrayDeque<>();
        deque.add(root);
        StringBuilder result = new StringBuilder("Preorder traversal: ");
        while (!deque.isEmpty()) {
            int n = deque.size();
            for (int i = 0; i < n; i += 1) {
                Node<T> top = deque.pollFirst();
                result.append(top.val).append(" ");
                if (top.left != null) {
                    deque.add(top.left);
                }
                if (top.right != null) {
                    deque.add(top.right);
                }
            }
        }
        return result.toString().trim();
    }

    /**
     * return the inorder-traversal string of the tree.
     * @return String
     */
    public String toStringInorder() {
        if (root == null) {
            return "Empty tree.";
        }
        Stack<Node<T>> stack = new Stack<>();
        Node<T> curr = root;
        StringBuilder result = new StringBuilder("Inorder traversal: ");
        while(!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                result.append(curr.val).append(" ");
                curr = curr.right;
            }
        }
        return result.toString().trim();
    }

    public String toStringPostorder() {
        if (root == null) {
            return "Empty tree.";
        }
        Stack<Node<T>> stack = new Stack<>();
        StringBuilder rs = new StringBuilder("Postorder traversal: ");
        Stack<T> elements = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> top = stack.pop();
            elements.push(top.val);
            if (top.left != null) {
                stack.push(top.left);
            }
            if (top.right != null) {
                stack.push(top.right);
            }
        }
        while (!elements.isEmpty()) {
            rs.append(elements.pop()).append(" ");
        }
        return rs.toString().trim();
    }
}
