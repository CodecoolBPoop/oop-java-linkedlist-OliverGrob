package com.codecool.linkedlist;

public class DoublyLinkedList<E> {

    private Node head;
    private Node tail;
    private int length = 0;


    public DoublyLinkedList() {

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

        tail.setNext(newElement);
        newElement.setPrevious(tail);
        tail = newElement;

        length++;
    }

    public Object getItemAt(int index) {
        if (index >= length) {
            return "No such index!";
        }

        Node currentElement;
        if (length / 2 > index) {
            currentElement = head;
            for (int i = 0; i < index; i++) {
                currentElement = currentElement.getNext();
            }
        } else {
            currentElement = tail;
            for (int i = 0; i < length - index - 1; i++) {
                currentElement = currentElement.getPrevious();
            }
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
            head.setPrevious(newElement);
            head = newElement;
            return;
        } else if (index >= length) {
            this.add(data);
            return;
        }

        Node beforeElement;
        if (length / 2 >= index) {
            beforeElement = head;
            for (int i = 0; i < index - 1; i++) {
                beforeElement = beforeElement.getNext();
            }
        } else {
            beforeElement = tail;
            for (int i = 0; i < length - index; i++) {
                beforeElement = beforeElement.getPrevious();
            }
        }

        newElement.setNext(beforeElement.getNext());
        newElement.setPrevious(beforeElement);
        beforeElement.getNext().setPrevious(newElement);
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
            head.setPrevious(null);
            return;
        } else if (index == length - 1) {
            tail = tail.getPrevious();
            tail.setNext(null);
            return;
        }

        Node beforeElement;
        if (length / 2 >= index) {
            beforeElement = head;
            for (int i = 0; i < index - 1; i++) {
                beforeElement = beforeElement.getNext();
            }
            beforeElement.setNext(beforeElement.getNext().getNext());
            beforeElement.getNext().setPrevious(beforeElement);
        } else {
            beforeElement = tail;
            for (int i = 0; i < length - index; i++) {
                beforeElement = beforeElement.getPrevious();
            }
            beforeElement.setPrevious(beforeElement.getPrevious().getPrevious());
            beforeElement.getPrevious().setNext(beforeElement);
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
