package com.company.queue;

public class Queue<T> {

    private Node<T> front, rear;
    private int size;

    public Queue(T... t) {
        addAll(t);
    }

    public T getFront() {
        if (size <= 0) return null;
        return front.value;
    }

    public T getRear() {
        if (size <= 0) {
            return null;
        } else if (size == 1) {
            return front.value;
        }
        return rear.value;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(T t) {
        if (t == null) throw new IllegalArgumentException("Element can't be null!");
        if (size < 0) throw new IndexOutOfBoundsException("size < 0");
        if (size == 0) {
            front = new Node<>(null, t, null);
        } else if (size == 1) {
            rear = new Node<>(front, t, null);
            front.nextNode = rear;
        } else {
            Node<T> prev = rear;
            rear = new Node<>(prev, t, null);
            prev.nextNode = rear;
        }
        size++;
    }

    @SafeVarargs
    public final void addAll(T... t) {
        for (T elem : t) {
            if (elem == null) throw new IllegalArgumentException("Element can't be null!");
            enqueue(elem);
        }
    }

    public boolean contains(T t) {
        if (size <= 0 || t == null) return false;
        else if (size == 1 && front.value.equals(t)) {
            return true;
        }
        Node<T> curElement = front.nextNode;
        for (int i = 1; i < size; i++) {
            curElement = curElement.nextNode;
            if (curElement == null) return false;
            else if (curElement.value == t) return true;
        }
        return false;
    }

    public T dequeue() {
        T result = null;
        if (size <= 0) return null;
        if (size == 1) {
            result = front.value;
            front = null;
        } else {
            result = front.value;
            front = front.nextNode;
            front.prevNode = null;
        }
        size--;
        return result;
    }

    private static class Node<T> {
        T value;
        Node<T> nextNode;
        Node<T> prevNode;

        public Node(Node<T> prevNode, T value, Node<T> nextNode) {
            this.prevNode = prevNode;
            this.value = value;
            this.nextNode = nextNode;
        }

    }
}
