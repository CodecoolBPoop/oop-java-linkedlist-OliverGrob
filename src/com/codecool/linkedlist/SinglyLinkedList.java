package com.codecool.linkedlist;

public class SinglyLinkedList<E> {

    private Node head;
    private Node tail;
    private int length = 0;


    public SinglyLinkedList() {

    }


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void add(Object element) {
        Node newElement = new Node(element);

        if (head == null) {
            head = newElement;
            tail = newElement;
            length++;
            return;
        }

//        Node currentElement = head;
//        while (currentElement.getNext() != null) {
//            currentElement = currentElement.getNext();
//        }
//        currentElement.setNext(newElement);
        tail.setNext(newElement);
        tail = newElement;

        length++;
    }

    public Object getItemAt(int index) {
        if (index >= length) {
            return "No such index!";
        }

        Node currentElement = head;
        for (int i = 0; i < index; i++) {
            currentElement = currentElement.getNext();
        }

        return currentElement.getData();
    }

    public int size() {
        return length;
    }

    public void insert(int index, Object data) {
        Node newElement = new Node(data);

        if (index == 0) {
            newElement.setNext(head);
            head = newElement;
            return;
        } else if (index >= length) {
            this.add(data);
            return;
        }

        Node beforeElement = head;
        for (int i = 0; i < index - 1; i++) {
            beforeElement = beforeElement.getNext();
        }
        newElement.setNext(beforeElement.getNext());
        beforeElement.setNext(newElement);
        length++;
    }

    public void remove(int index) {
        if (index >= length) {
            System.out.println("No such index!");
            return;
        }
        if (index == 0) {
            head = head.getNext();
            return;
        }

        Node beforeElement = head;
        for (int i = 0; i < index - 1; i++) {
            beforeElement = beforeElement.getNext();
        }

        if (beforeElement.getNext().getNext() != null) {
            Node afterElement = beforeElement.getNext().getNext();
            beforeElement.setNext(afterElement);
        } else {
            beforeElement.setNext(null);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        if (head != null) {
            Node currentElement = head;
            while (currentElement.getNext() != null) {
                result.append(currentElement.getData()).append(", ");
                currentElement = currentElement.getNext();
            }
            result.append(currentElement.getData());
        }

        result.append("]");

        return result.toString();
    }

}
