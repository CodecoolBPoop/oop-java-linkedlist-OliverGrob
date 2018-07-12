package com.codecool.linkedlist;

public class LinkedListTest {

    public static void main(String[] args) {
        System.out.println("--------  Singly Linked List Test  --------\n");
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(5);

        singlyLinkedList.insert(1, 10);
        singlyLinkedList.remove(3);
        System.out.println(singlyLinkedList.getItemAt(2));
        System.out.println(singlyLinkedList);

        System.out.println("\n--------  Doubly Linked List Test  --------\n");
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.add(5);

        doublyLinkedList.insert(1, 10);
        doublyLinkedList.remove(3);
        System.out.println(doublyLinkedList.getItemAt(2));
        System.out.println(doublyLinkedList);
    }

}
