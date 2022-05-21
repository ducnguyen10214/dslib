# dslib
 A Java library of common data structures that are not included in the Java Collection Framework.
## Binary Trees
- `BinaryTree()`: constructor with `root` set to null.<br>
- `getRoot()`: retrieve the root node of the tree.<br>
- `setRoot()`: set the root of the tree specifically.<br>
- `insert(T val)`: level-order insertion into the binary tree.<br>
- `toStringLevelOrder()`: the level-order traversal string of the tree.<br>
- `toStringPreorder()`: the preorder-traversal string of the tree.<br>
- `toStringInorder()`: the inorder-traversal string of the tree.<br>
- `toStringPostorder()`: the postorder-traversal string of the tree.<br>
## Binary Search Trees
- All functions of **Binary Trees** as described above, except for `insert(T val)`.
- `insert(T val)`: insertion into the BST based on the principles of BST.
- `contains(T val)`: check if an element is contained in the BST.
- `delete(T val)`: delete a value in the BST.
