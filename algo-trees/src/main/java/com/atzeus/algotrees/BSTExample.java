package com.atzeus.algotrees;

public class BSTExample {
  public static void main(String[] args) {
    int[] arr = {5, 3, 4, 2, 1, 7, 6, 8, 10};
    BST bst = BST.create(arr);
    TreeNode root = bst.getRoot();

    TreeTraversals.inorder(root);
    bst.delete(5);
    root = bst.getRoot();
    TreeTraversals.inorder(root);
  }
}
