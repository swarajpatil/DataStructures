package main.java;

public class StackOfItem<T> {
    Node first;

    public void push(T item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst);
    }

    public T pop() {
        T value = first.value;
        first = first.node;
        return value;
    }

    public boolean empty() {
        return first == null;
    }

    class Node {
        Node node;
        T value;

        Node(T value, Node node) {
            this.value = value;
            this.node = node;
        }
    }
}
