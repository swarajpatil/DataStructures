package main.java;

public class QueueOfItem<T> {
    Node first;
    private Node last;

    public void enqueue(T item) {
        if (first == null) {
            first = new Node(item);
            last = first;
        } else {
            Node oldLast = last;
            last = new Node(item);
            oldLast.next = last;
        }
    }

    public T dequeue() {
        T value = first.value;
        first = first.next;
        return value;
    }

    class Node {
        Node next;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }

    public Boolean isEmpty() {
        return first == null;
    }
}
