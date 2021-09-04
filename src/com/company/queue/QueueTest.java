package com.company.queue;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


class QueueTest {

    public static Queue<Integer> queue1 = new Queue<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    public static Queue<Integer> queue2 = new Queue<>(213);
    public static Queue<Integer> queue3 = new Queue<>();

    @Test
    void getFront() {
        assertEquals(0, queue1.getFront());
        assertEquals(213, queue2.getFront());
        assertNull(queue3.getFront());
    }

    @Test
    void getRear() {
        assertEquals(9, queue1.getRear());
        assertEquals(213, queue2.getRear());
        assertNull(queue3.getRear());
    }

    @Test
    void getSize() {
        assertEquals(10, queue1.getSize());
        assertEquals(1, queue2.getSize());
        assertEquals(0, queue3.getSize());
    }

    @Test
    void enqueue() {
        Queue<Integer> example = new Queue<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        example.enqueue(10);
        assertEquals(10, example.getRear());
        example.enqueue(12);
        example.enqueue(13);
        assertEquals(13, example.getRear());
        IntStream.range(0, 1_000_000).forEach(example::enqueue);
        assertEquals(999_999, example.getRear());
        assertEquals(1_000_013, example.getSize());
    }

    @Test
    void contains() {
        assertTrue(queue1.contains(3));
        assertTrue(queue1.contains(9));
        assertTrue(queue1.contains(7));
        assertTrue(queue2.contains(213));
        assertFalse(queue1.contains(2333));
    }

    @Test
    void dequeue() {
        Queue<Integer> example1 = new Queue<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Queue<Integer> example2 = new Queue<>(213);
        example1.dequeue();
        example1.dequeue();
        example1.dequeue();
        assertEquals(3, example1.getFront());
        assertEquals(7, example1.getSize());
        example2.dequeue();
        assertNull(example2.getFront());
        assertEquals(0, example2.getSize());
    }
}