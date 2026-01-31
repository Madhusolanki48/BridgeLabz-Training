package com.bridgelabz.junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ListManagerTest {
    ListManager manager = new ListManager();
    List<Integer> list = new ArrayList<>();
 
    @Test
    void testAddElement() {
        manager.addElement(list, 10);
        assertTrue(list.contains(10)); //add check
    }

    @Test
    void testRemoveElement() {
        list.add(20);
        manager.removeElement(list, 20);
        assertFalse(list.contains(20)); //remove check
    }

    @Test
    void testSize() {
        list.add(1);
        list.add(2);
        assertEquals(2, manager.getSize(list)); //size check
    }
}
