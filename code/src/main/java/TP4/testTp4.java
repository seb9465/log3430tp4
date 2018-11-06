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
        assertEquals(first.get(queue), null, "L'attribut first devrait être null.");
    }

    /**
     * d04 = < { Queue() -> peek() } , { first == null, last == null, n == 0 } >
     */
    @Test
    public void d04() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        queue = new Queue<Integer>();
        Field last = queue.getClass().getDeclaredField("last");
        last.setAccessible(true);
        Field first = queue.getClass().getDeclaredField("first");
        first.setAccessible(true);
        Field n = queue.getClass().getDeclaredField("n");
        n.setAccessible(true);

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> queue.peek());
        assertEquals(last.get(queue), null, "L'attribut last devrait être null.");
        assertEquals(first.get(queue), null, "L'aatribut first devrait être null.");
        assertEquals(n.get(queue), 0, "L'attribut n devrait être égal à 0.");
    }

    /**
     * d06 = < { Queue() -> enqueue(1) -> size() } , { first == node1, last == node1, n == 1 } >
     */
    @Test
    public void d06() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        queue = new Queue<Integer>();
        Field last = queue.getClass().getDeclaredField("last");
        last.setAccessible(true);
        Field first = queue.getClass().getDeclaredField("first");
        first.setAccessible(true);
        Field n = queue.getClass().getDeclaredField("n");
        n.setAccessible(true);

        // Act
        queue.enqueue(1);
        final int taille = queue.size();

        // Assert
        assertEquals(taille, 1, "La taille de la queue devrait être de 1.");
        assertNotNull(first.get(queue), "L'attribut first ne devrait pas être null.");
        assertNotNull(last.get(queue), "L'attribut last ne devrait pas être null.");
        assertEquals(n.get(queue), 1, "L'attribut n devrait être égal à 1.");
    }

    /**
     * d10 = < { Queue() -> enqueue(1) -> enqueue(2) -> size() } ,
               { first == node1, last == node2, n > 1 } >
     */
    @Test
    public void d10() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        queue = new Queue<Integer>();
        Field last = queue.getClass().getDeclaredField("last");
        last.setAccessible(true);
        Field first = queue.getClass().getDeclaredField("first");
        first.setAccessible(true);
        Field n = queue.getClass().getDeclaredField("n");
        n.setAccessible(true);

        // Act
        queue.enqueue(1);
        queue.enqueue(2);
        final int taille = queue.size();

        // Assert
        assertEquals(taille, 2, "La taille de la queue devrait être de 2.");
        assertNotNull(first.get(queue), "L'attribut first ne devrait pas être null.");
        assertNotNull(last.get(queue), "L'attribut last ne devrait pas être null.");
        assertNotEquals(first.get(queue), last.get(queue), "L'attribut first et l'attribut last devrait être différent.");
        assertEquals(n.get(queue), 2, "L'Attribut n devrait être égal à 2.");
    }

    /**
     * d12 = < { Queue() -> enqueue(1) -> enqueue(2) -> enqueue(3) } ,
               { first == node1, last == node2, n > 1 } >
     */
    @Test
    public void d12() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        queue = new Queue<Integer>();
        Field last = queue.getClass().getDeclaredField("last");
        last.setAccessible(true);
        Field first = queue.getClass().getDeclaredField("first");
        first.setAccessible(true);
        Field n = queue.getClass().getDeclaredField("n");
        n.setAccessible(true);

        // Act
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Assert
        assertNotNull(first.get(queue), "L'attribut first ne devrait pas être null.");
        assertNotNull(last.get(queue), "L'attribut last ne devrait pas être null.");
        assertNotEquals(first.get(queue), last.get(queue), "L'attribut first et l'attribut last devrait être différent.");
        assertTrue((int)n.get(queue) >= 2, "L'attribut n devrait être supérieur à 2.");
    }


    /**
     * d14 = < { Queue() -> enqueue(1) -> enqueue(2) -> dequeue() } ,
     *         { first == node1, last == node1, n == 1 } >
     */
    @Test
    public void d14() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        queue = new Queue<Integer>();
        Field last = queue.getClass().getDeclaredField("last");
        last.setAccessible(true);
        Field first = queue.getClass().getDeclaredField("first");
        first.setAccessible(true);
        Field n = queue.getClass().getDeclaredField("n");
        n.setAccessible(true);

        // Act
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();

        // Assert
        assertNotNull(first.get(queue), "L'attribut first ne devrait pas être null.");
        assertNotNull(last.get(queue), "L'attribut last ne devrait pas être null.");
        assertTrue((int)n.get(queue) == 1, "L'Attribut n devrait être égal à 1.");
    }
}
