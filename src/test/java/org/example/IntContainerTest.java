package org.example;

import org.example.IntContainer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntContainerTest {

    @Test
    void testNewContainerIsEmpty() {
        IntContainer c = new IntContainer();
        assertTrue(c.isEmpty());
        assertEquals(0, c.size());
    }

    @Test
    void testAddOneElement() {
        IntContainer c = new IntContainer();
        c.add(42);
        assertEquals("[42]", c.toString());
        assertEquals(1, c.size());
    }

    @Test
    void testAddMultipleElements() {
        IntContainer c = new IntContainer();
        c.add(1);
        c.add(2);
        c.add(3);
        assertEquals("[1, 2, 3]", c.toString());
    }

    @Test
    void testAddByIndexMiddle() {
        IntContainer c = new IntContainer();
        c.add(10);
        c.add(30);
        c.add(1, 20);
        assertEquals("[10, 20, 30]", c.toString());
    }

    @Test
    void testGet() {
        IntContainer c = new IntContainer();
        c.add(10);
        c.add(20);
        assertEquals(10, c.get(0));
        assertEquals(20, c.get(1));
    }

    @Test
    void testGetThrowsException() {
        IntContainer c = new IntContainer();
        c.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> c.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> c.get(-1));
    }

    @Test
    void testRemoveByIndex() {
        IntContainer c = new IntContainer();
        c.add(10);
        c.add(20);
        c.add(30);
        int removed = c.remove(1);
        assertEquals(20, removed);
        assertEquals("[10, 30]", c.toString());
    }

    @Test
    void testRemoveLast() {
        IntContainer c = new IntContainer();
        c.add(1);
        c.add(2);
        c.add(3);
        int removed = c.removeLast();
        assertEquals(3, removed);
        assertEquals("[1, 2]", c.toString());
    }

    @Test
    void testRemoveLastThrowsOnEmpty() {
        IntContainer c = new IntContainer();
        assertThrows(RuntimeException.class, () -> c.removeLast());
    }

    @Test
    void testRemoveByValue() {
        IntContainer c = new IntContainer();
        c.add(5);
        c.add(3);
        c.add(5);
        c.add(7);
        boolean result = c.removeByValue(5);
        assertTrue(result);
        assertEquals("[3, 7]", c.toString());
    }

    @Test
    void testRemoveByValueNotFound() {
        IntContainer c = new IntContainer();
        c.add(1);
        boolean result = c.removeByValue(99);
        assertFalse(result);
    }

    @Test
    void testToStringEmpty() {
        IntContainer c = new IntContainer();
        assertEquals("[]", c.toString());
    }

    @Test
    void testSizeChanges() {
        IntContainer c = new IntContainer();
        assertEquals(0, c.size());
        c.add(1);
        c.add(2);
        assertEquals(2, c.size());
        c.removeLast();
        assertEquals(1, c.size());
    }
}