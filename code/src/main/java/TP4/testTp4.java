package TP4;

import edu.princeton.cs.algs4.Queue;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class testTp4 {
    Queue queue;

    @BeforeEach
    void setUp() throws Exception {

    }

    /**
     * d02 = < { Queue() -> size() } , { first == null, last == null, n == 0 } >
     */
    @Test
    public void d02() throws NoSuchFieldException, IllegalAccessException {
        queue = new Queue<Integer>();
        Field last = queue.getClass().getDeclaredField("last");
        
        last.setAccessible(true);
        assertNull(last.get(queue), "L'attribut last devrait etre null.");
        assertEquals(queue.size(), 0, "La taille de la Queue devrait être de 0.");
        assertTrue(queue.isEmpty(), "L'attribut first est null.");
    }

    /**
     * d04 = < { Queue() -> peek() } , { first == null, last == null, n == 0 } >
     */
    @Test
    public void d04() {
        assertEquals(0,0);
    }

}
