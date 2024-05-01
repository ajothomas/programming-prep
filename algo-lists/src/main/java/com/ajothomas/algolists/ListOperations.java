package com.ajothomas.algolists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListOperations {

  public static Node reverseList2(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    Node next = head.next;
    Node reversed = reverseList2(next);
    next.next = head;
    head.next = null;
    return reversed;
  }

  public static Node reserveList(Node head) {
    Node prev = null;
    Node curr = head;
    // 1 -> 2 -> 3 -> 4
    while (curr.next != null) {
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    curr.next = prev;
    return curr;
  }

  public static Node createList(int[] arr) {
    Node dummy = new Node(-1);
    Node curr = dummy;
    for (int val: arr) {
      curr.next = new Node(val);
      curr = curr.next;
    }
    return dummy.next;
  }

  public static Node deleteElement(int el, Node head) {
    Node curr = head;
    Node prev = null;
    while (curr != null) {
      if (curr.val == el) {
        // if found element is head
        if (curr == head) {
          head = curr.next;
          curr.next = null;
        } else {
          prev.next = curr.next;
          curr.next = null;
        }
        break;
      } else {
        prev = curr;
        curr = curr.next;
      }
    }

    if (curr == null) {
      System.out.print("Element to be deleted not found");
    }

    return head;
  }

  public static void printList(Node head) {
    List<Integer> list = new ArrayList<>();
    if (head == null) {
      System.out.print("\nList is empty");
      return;
    }
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    System.out.print("\nList : " + list);
  }

  public static void main(String[] args) {
    System.out.println("List operations");

    int[] arr = {1, 2, 3, 4, 5, 6};
    System.out.print("\nList created with arr : " + Arrays.toString(arr));
    Node head = ListOperations.createList(arr);
    printList(head);
    System.out.print("\nDelete element : 2");
    head = ListOperations.deleteElement(2, head);
    printList(head);
    System.out.print("\nDelete element at head: 1");
    head = ListOperations.deleteElement(1, head);
    printList(head);
    head = ListOperations.deleteElement(6, head);
    System.out.print("\nDelete element at end: 6");
    printList(head);

    System.out.print("\nRe-create list with arr : " + Arrays.toString(arr));
    head = ListOperations.createList(arr);
    System.out.print("\nReversing list");
    head = ListOperations.reserveList(head);
    printList(head);
    System.out.print("\nReversing list again");
    head = ListOperations.reserveList(head);
    printList(head);
  }
}
