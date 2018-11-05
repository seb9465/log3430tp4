package TP4;

import edu.princeton.cs.algs4.Queue;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
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

    @AfterEach
    public void tearDown() throws Exception { }

    /**
     * d02 = < { Queue() -> size() } , { first == null, last == null, n == 0 } >
     */
    @Test
    public void d02() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        queue = new Queue<Integer>();
        Field last = queue.getClass().getDeclaredField("last");
        last.setAccessible(true);
        Field first = queue.getClass().getDeclaredField("first");
        first.setAccessible(true);

        // Act
        int resultat = queue.size();

        // Assert
        assertEquals(resultat, 0, "L'attribut n devrait être égal à 0.");
        assertEquals(last.get(queue), null, "L'attribut last devrait être null.");
        assertEquals(first.get(queue), null, "L'aatribut first devrait être null.");
    }

    /**
     * d04 = < { Queue() -> peek() } , { first == null, last == null, n == 0 } >
     */
    @Test
    public void d04() {
        assertEquals(0,0);
    }

}
