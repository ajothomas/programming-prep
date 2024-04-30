package com.atzeus.algotrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TreeTraversals {

  public static void main(String[] args) {
    int[] arr = {5, 3, 4, 2, 1, 7, 6, 8, 10, 11};
    BST bst = BST.create(arr);
    Node root = bst.getRoot();

    TreeTraversals.inorder(root);
    TreeTraversals.preorder(root);
    TreeTraversals.levelOrder(root);
  }

  public static void inorder(Node node) {
    System.out.print("\nInorder traversal:\t");
    doInorder(node);
  }

  private static void doInorder(Node node) {
    if (node == null) {
      return;
    }
    doInorder(node.left);
    System.out.print(node.val + ",");
    doInorder(node.right);
  }

  public static void preorder(Node node) {
    System.out.print("\nPreorder traversal:\t");
    doPreorder(node);
  }

  private static void doPreorder(Node node) {
    if (node == null) {
      return;
    }
    System.out.print(node.val + ",");
    doPreorder(node.left);
    doPreorder(node.right);
  }

  public static void levelOrder(Node node) {
    System.out.print("\nLevel order traversal:\t");
    System.out.print(doLevelOrder(node));
  }

  private static List<List<Integer>> doLevelOrder(Node root) {
    List<List<Integer>> answer = new ArrayList<>();
    if (root == null) {
      return answer;
    }
    LinkedList<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> levelList = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node temp = queue.removeFirst();
        levelList.add(temp.val);
        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
      answer.add(levelList);
    }
    return answer;
  }
}
