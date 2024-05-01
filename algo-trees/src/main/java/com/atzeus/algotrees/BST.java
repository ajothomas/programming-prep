package com.atzeus.algotrees;

/**
 * Binary search tree.
 * */
public class BST {
  TreeNode root;

  public static BST create(int[] arr) {
    BST bst = new BST();
    for (int el: arr) {
      bst.insert(el);
    }
    return bst;
  }

  BST() {
    root = null;
  }

  public TreeNode getRoot() {
    return root;
  }

  public TreeNode insert(int el) {
    root = insert(el, root);
    return root;
  }

  private TreeNode insert(int el, TreeNode root) {
    if (root == null) {
      return new TreeNode(el);
    } else if (el < root.val) {
      root.left = insert(el, root.left);
    } else {
      root.right = insert(el, root.right);
    }
    return root;
  }

  public void delete(int el) {
    System.out.print("\nDeleting node : " + el);
    doDelete(el, this.root);
  }

  private int findMin(TreeNode root) {
    TreeNode curr = root;
    while (curr.left != null) {
      curr = curr.left;
    }
    return curr.val;
  }
  private TreeNode doDelete(int el, TreeNode root) {
    if (root == null) {
      return null;
    }

    if (el == root.val) {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }

      root.val = findMin(root.right);
      root.right = doDelete(root.val, root.right);
      return root;
    } else if (el < root.val) {
      root.left = doDelete(el, root.left);
    } else {
      root.right = doDelete(el, root.right);
    }
    return root;
  }
}
