package TP4;

import edu.princeton.cs.algs4.Queue;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

public class testTp4 {
    private Queue<Integer> queue;

    /**
     * d02 = < { Queue() -> size() } , { first == null, last == null, n == 0 } >
     */
    @Test
    public void d02() {
        // Arrange
        queue = new Queue<>();

        // Act
        final int resultat = queue.size();

        // Assert
        assertEquals(resultat, 0, "L'attribut n devrait être égal à 0.");
        assertThrows(NoSuchElementException.class, () -> queue.getLast(), "L'attribut last devrait être null.");
        assertThrows(NoSuchElementException.class, () -> queue.peek(), "L'attribut first devrait être null.");

    }

    /**
     * d04 = < { Queue() -> peek() } , { first == null, last == null, n == 0 } >
     */
    @Test
    public void d04() {
        // Arrange
        queue = new Queue<>();

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> queue.peek(), "L'attribut first devrait être null.");
        assertThrows(NoSuchElementException.class, () -> queue.getLast(), "L'attribut last devrait être null.");
        assertEquals(queue.size(), 0, "L'attribut n devrait être égal à 0.");
    }

    /**
     * d06 = < { Queue() -> enqueue(1) -> size() } , { first == node1, last == node1, n == 1 } >
     */
    @Test
    public void d06() {
        // Arrange
        queue = new Queue<>();

        // Act
        queue.enqueue(1);
        final int taille = queue.size();

        // Assert
        assertEquals(taille, 1, "La taille de la queue devrait être de 1.");
        assertNotNull(queue.peek(), "L'attribut first ne devrait pas être null.");
        assertNotNull(queue.getLast(), "L'attribut last ne devrait pas être null.");
        assertEquals(queue.peek(), queue.getLast(), "Les attributs first et last devraient être égaux.");
    }

    /**
     * d08 = < { Queue() -> enqueue(1) -> dequeue() } , { first == null, last == null, n == 0 } >
     */
    @Test
    public void d08() {
        // Arrange
        queue = new Queue<>();

        // Act
        queue.enqueue(1);
        queue.dequeue();

        // Assert
        assertThrows(NoSuchElementException.class, () -> queue.peek(), "L'attribut first devrait être null.");
        assertThrows(NoSuchElementException.class, () -> queue.getLast(), "L'attribut last devrait être null.");
        assertEquals(queue.size(), 0, "L'attribut n devrait être égal à 0.");
    }

    /**
     * d10 = < { Queue() -> enqueue(1) -> enqueue(2) -> size() } ,
               { first == node1, last == node2, n > 1 } >
     */
    @Test
    public void d10() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        queue = new Queue<>();

        // Act
        queue.enqueue(1);
        queue.enqueue(2);
        final int taille = queue.size();

        // Assert
        assertEquals(taille, 2, "La taille de la queue devrait être de 2.");
        assertNotNull(queue.peek(), "L'attribut first ne devrait pas être null.");
        assertNotNull(queue.getLast(), "L'attribut last ne devrait pas être null.");
        assertNotEquals(queue.peek(), queue.getLast(), "L'attribut first et l'attribut last devrait être différent.");
    }

    /**
     * d12 = < { Queue() -> enqueue(1) -> enqueue(2) -> enqueue(3) } ,
               { first == node1, last == node2, n > 1 } >
     */
    @Test
    public void d12() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        queue = new Queue<>();
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
        assertTrue((int)n.get(queue) > 1, "L'attribut n devrait être supérieur à 1.");
    }


    /**
     * d14 = < { Queue() -> enqueue(1) -> enqueue(2) -> dequeue() } ,
     *         { first == node1, last == node1, n == 1 } >
     */
    @Test
    public void d14() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        queue = new Queue<>();
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
        assertEquals(first.get(queue), last.get(queue), "Les attributs first et last devraient être égaux.");
        assertEquals((int)n.get(queue), 1, "L'attribut n devrait être égal à 1.");
    }
}
