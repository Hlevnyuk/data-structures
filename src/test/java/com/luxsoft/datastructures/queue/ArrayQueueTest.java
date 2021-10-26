package com.luxsoft.datastructures.queue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
public class ArrayQueueTest {
    @Test
    public void testEnqueueAndDequeueWorkCorrectlyAndChangeSize() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        assertEquals(3, arrayQueue.size());
        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals("C", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }
    @Test
    public void testIsEmptyReturnsOnNewQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertTrue(arrayQueue.isEmpty());
    }
    @Test
    public void testIsEmptyReturnFalseOnStackWithData() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("C");
        assertFalse(arrayQueue.isEmpty());
    }
    @Test
    public void testIsEmptyReturnTrueOnStackAfterClear() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }
    @Test
    public void testEnqueueOverInitialCapacityAndDequeueWorkCorrectlyAndChangeSize() {
        ArrayQueue arrayQueue = new ArrayQueue(4);
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        arrayQueue.enqueue("D");
        assertEquals(4, arrayQueue.size());
        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals("C", arrayQueue.dequeue());
        assertEquals("D", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }
    @Test
    public void testEnqueueAndPeek() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        assertEquals(3, arrayQueue.size());
        assertEquals("A", arrayQueue.peek());
        assertEquals("A", arrayQueue.peek());
        assertEquals("A", arrayQueue.peek());
        assertEquals(3, arrayQueue.size());
    }
    @Test
    public void testContainsReturnTrue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("E");
        assertTrue(arrayQueue.contains(new String("E")));
    }
    @Test
    public void testContainsReturnFalse() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("E");
        assertFalse(arrayQueue.contains("F"));
    }
    @Test
    public void testContainsReturnFalseOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertFalse(arrayQueue.contains("F"));
    }
    @Test
    public void testThrowIllegalStateExceptionWhenDequeueOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.dequeue();
        });
    }
    @Test
    public void testToString(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        assertEquals("[A, B, C]", arrayQueue.toString());
    }
}
