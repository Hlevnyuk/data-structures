package com.luxsoft.datastructures.list;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ArrayListTest {
    @DisplayName("Test adding to the list")
    @Test
    void testAddItemToList() {
        ArrayList list = new ArrayList(1);
        list.add(1);
        int expectedIndex = list.size() - 1;
        assertEquals(expectedIndex, list.lastIndexOf(1));
    }
    @DisplayName("Test adding null to the end should throw IllegalStateException")
    @Test
    void testAddItemNullThrowsIllegalStateException() {
        ArrayList list = new ArrayList(1);
        assertThrows(IllegalStateException.class, () -> {
            list.add(null);
        });
    }
    @DisplayName("Test adding and removing to the list with resizing")
    @Test
    void testAddAndRemoveChangingSizeOfList() {
        ArrayList list = new ArrayList(2);
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
        list.add(3);
        Object actualFirstRemoved = list.remove(0);
        Object actualSecondRemoved = list.remove(1);
        Object actualThirdRemoved = list.remove(0);
        assertEquals(1, actualFirstRemoved);
        assertEquals(3, actualSecondRemoved);
        assertEquals(2, actualThirdRemoved);
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }
    @DisplayName("Test adding null element by index throws IllegalStateException")
    @Test
    void testAddByIndexNullElementThrowIllegalStateException() {
        ArrayList list = new ArrayList(1);
        list.add(2);
        assertThrows(IllegalStateException.class, () -> {
            list.add(null, 1);
        });
    }
    @DisplayName("Test adding element by index out of bound range")
    @Test
    void testAddByIndexOutOfBoundRange() {
        ArrayList list = new ArrayList(1);
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(5, -1);
            list.add(10, 2);
        });
    }
    @DisplayName("Test adding element in empty list throws IllegalStateException")
    @Test
    void testAddElementsByIndexToEmptyListThrowsIllegalStateException() {
        ArrayList listOne = new ArrayList(0);
        ArrayList listTwo = new ArrayList(5);
        assertThrows(IllegalStateException.class, () -> {
            listOne.add(2, 0);
            listTwo.add(2, 0);
        });
    }
    @DisplayName("Test adding element in index already with element")
    @Test
    void testAddElementInIndexAlreadyWithElement() {
        ArrayList list = new ArrayList(2);
        list.add(3);
        list.add(1, 0);
        list.add(2, 1);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(3, list.size());
    }
    @DisplayName("Test adding element to the end of the list by index equals to size")
    @Test
    void testAddElementToEndByIndexEqualsToSize() {
        ArrayList list = new ArrayList();
        list.add(3);
        list.add(10, 1);
        list.add(20, 2);
        assertEquals(3, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(20, list.get(2));
        assertEquals(3, list.size());
    }
    @DisplayName("Test removing element from out of bound range")
    @Test
    void testRemoveFromIndexThatIsOutOfBound() {
        ArrayList list = new ArrayList(1);
        list.add(1);
        assertNull(list.remove(-1));
        assertNull(list.remove(1));
    }
    @DisplayName("Test removing element from empty list")
    @Test
    void testRemoveElementFromEmptyList() {
        ArrayList list = new ArrayList(1);
        assertTrue(list.isEmpty());
        assertNull(list.remove(0));
    }
    @DisplayName("Test removing element from not empty list")
    @Test
    void testRemoveElementFromNotEmptyList() {
        ArrayList list = new ArrayList(3);
        list.add(2);
        list.add(5, 1);
        assertEquals(2, list.size());
        Object actualFirstRemoved = list.remove(0);
        Object actualSecondRemoved = list.remove(0);
        assertEquals(2, actualFirstRemoved);
        assertEquals(5, actualSecondRemoved);
        assertTrue(list.isEmpty());
    }
    @DisplayName("Test getting element from out of bound range")
    @Test
    void testGetElementFromIndexThatIsOutOfBound() {
        ArrayList list = new ArrayList(1);
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
            list.get(1);
        });
    }
    @DisplayName("Test getting element from empty list")
    @Test
    void testGetElementFromEmptyList() {
        ArrayList list = new ArrayList(1);
        assertNull(list.get(0));
    }
    @DisplayName("Test getting element from not empty list")
    @Test
    void testGetElementFromNotEmptyList() {
        ArrayList list = new ArrayList(1);
        list.add(2);
        Object expectedElement = list.get(0);
        assertEquals(2, expectedElement);
    }
    @DisplayName("Test not empty list contains element returns true")
    @Test
    void testNotEmptyListContainsElementReturnTrue() {
        ArrayList list = new ArrayList();
        list.add(1000);
        assertTrue(list.contains(1000));
    }
    @DisplayName("Test not empty list contains element returns false")
    @Test
    void testNotEmptyListContainsElementReturnFalse() {
        ArrayList list = new ArrayList();
        list.add(1000);
        assertFalse(list.contains(100));
    }
    @DisplayName("Test empty list contains element returns false")
    @Test
    void testEmptyListContainsElementReturnFalse() {
        ArrayList list = new ArrayList();
        assertFalse(list.contains(100));
    }
    @DisplayName("Test not empty list contains null returns false")
    @Test
    void testNotEmptyListContainsNullThrowsIllegalStateException() {
        ArrayList list = new ArrayList();
        assertFalse(list.contains(null));
    }
    @DisplayName("Test after clear list size should be 0 and elements null")
    @Test
    void testClearListSizeShouldBeZeroAndElementsNull() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(1);
        list.add(1);
        assertEquals(3, list.size());
        list.clear();
        assertTrue(list.isEmpty());
        assertNull(list.get(0));
        assertNull(list.get(1));
        assertNull(list.get(2));
    }
    @DisplayName("Test set element in empty list return null")
    @Test
    void testSetElementEmptyListThrowsIllegalStateException() {
        ArrayList list = new ArrayList();
        assertNull(list.set("2", 0));
    }
    @DisplayName("Test set null element in list throws IllegalStateException")
    @Test
    void testSetNullElementThrowsIllegalStateException() {
        ArrayList list = new ArrayList();
        list.add(2);
        assertThrows(IllegalStateException.class, () -> {
            list.set(null, 0);
        });
    }
    @DisplayName("Test set index out of bound in list throws IndexOutOfBoundsException")
    @Test
    void testSetOutOfBoundIndexThrowsIndexOutOfBoundsException() {
        ArrayList list = new ArrayList();
        list.add(22);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(2, -1);
            list.set(2, 1);
        });
    }
    @DisplayName("Test set new value by index in list")
    @Test
    void testSetNewValueByIndexInList() {
        ArrayList list = new ArrayList();
        list.add(100);
        Object toBeSet = list.set(10, 0);
        assertEquals(100, toBeSet);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }
    @DisplayName("Test index of null element throws IllegalStateException")
    @Test
    void testIndexOfNullValueThrowsIllegalStateException() {
        ArrayList list = new ArrayList();
        assertThrows(IllegalStateException.class, () -> {
            list.indexOf(null);
        });
    }
    @DisplayName("Test index of on empty list returns -1")
    @Test
    void testIndexOfEmptyOnListReturnsMinusOne() {
        ArrayList list = new ArrayList(0);
        assertEquals(0, list.size());
        assertEquals(-1, list.indexOf(2));
    }
    @DisplayName("Test index of on not empty list returns index")
    @Test
    void testIndexOfOnNotEmptyListReturnsIndex() {
        ArrayList list = new ArrayList();
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(4);
        assertEquals(0, list.indexOf(2));
        assertEquals(1, list.indexOf(4));
    }
    @DisplayName("Test index of returns -1 when element not found")
    @Test
    void testIndexOfOnNotEmptyListReturnsMinusOne() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(-1, list.indexOf(-1));
        assertEquals(-1, list.indexOf(7));
    }
    @DisplayName("Test last index of null element throws IllegalStateException")
    @Test
    void testLastIndexOfNullValueThrowsIllegalStateException() {
        ArrayList list = new ArrayList();
        assertThrows(IllegalStateException.class, () -> {
            list.lastIndexOf(null);
        });
    }
    @DisplayName("Test last index of on empty list returns -1")
    @Test
    void testLastIndexOfEmptyOnListReturnsMinusOne() {
        ArrayList list = new ArrayList(0);
        assertEquals(0, list.size());
        assertEquals(-1, list.lastIndexOf(2));
    }
    @DisplayName("Test last index of on not empty list returns index")
    @Test
    void testLastIndexOfOnNotEmptyListReturnsIndex() {
        ArrayList list = new ArrayList();
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(4);
        assertEquals(2, list.lastIndexOf(2));
        assertEquals(3, list.lastIndexOf(4));
    }
    @DisplayName("Test last index of returns -1 when element not found")
    @Test
    void testLastIndexOfOnNotEmptyListReturnsMinusOne() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(-1, list.indexOf(-1));
        assertEquals(-1, list.indexOf(7));
    }
}
