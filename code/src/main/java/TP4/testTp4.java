package TP4;

import edu.princeton.cs.algs4.Queue;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class testTp4 {
    private Queue<Integer> queue;

    /**
     * d01 = < { Queue() -> isEmpty() } , { first == null, last == null, n == 0 } >
     */
    @Test
    public void d01() {
        // Arrange
        queue = new Queue<>();

        // Act
        final boolean resultat = queue.isEmpty();

        // Assert
        assertTrue(resultat, "L'attribut n devrait être égal à 0.");
        assertThrows(NoSuchElementException.class, () -> queue.getLast(), "L'attribut last devrait être null.");
        assertThrows(NoSuchElementException.class, () -> queue.peek(), "L'attribut first devrait être null.");
    }

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
        assertEquals(0, resultat, "L'attribut n devrait être égal à 0.");
        assertThrows(NoSuchElementException.class, () -> queue.getLast(), "L'attribut last devrait être null.");
        assertThrows(NoSuchElementException.class, () -> queue.peek(), "L'attribut first devrait être null.");
    }

    /**
     * d03 = < { Queue() -> dequeue() } , { first == null, last == null, n == 0 } >
     */
    @Test
    public void d03() {
        // Arrange
        queue = new Queue<>();

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> queue.dequeue(), "Un appel à la fonction dequeue devrait lancer une exception lorsque la Queue est vide.");
        assertThrows(NoSuchElementException.class, () -> queue.peek(), "L'attribut first devrait être null.");
        assertThrows(NoSuchElementException.class, () -> queue.getLast(), "L'attribut last devrait être null.");
        assertEquals(0, queue.size(), "L'attribut n devrait être égal à 0.");
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
        assertEquals(0, queue.size(), "L'attribut n devrait être égal à 0.");
    }

    /**
     * d05 = < { Queue() -> enqueue(1) -> isEmpty() } , { first == 1, last == 1, n == 1 } >
     */
    @Test
    public void d05() {
        // Arrange
        queue = new Queue<>();

        // Act
        queue.enqueue(1);
        final boolean resultat = queue.isEmpty();

        // Assert
        assertFalse(resultat, "La queue ne devrait pas être vide.");
        assertNotNull(queue.peek(), "L'attribut first ne devrait pas être null.");
        assertNotNull(queue.getLast(), "L'attribut last ne devrait pas être null.");
        assertEquals(1, (int)queue.peek(), "L'attribut first devrait avoir une valeur de 1.");
        assertEquals(1, (int)queue.getLast(), "L'attribut first devrait avoir une valeur de 1.");
        assertEquals(queue.peek(), queue.getLast(), "Les attributs first et last devraient être égaux.");
    }

    /**
     * d06 = < { Queue() -> enqueue(1) -> size() } , { first == 1, last == 1, n == 1  } >
     */
    @Test
    public void d06() {
        // Arrange
        queue = new Queue<>();

        // Act
        queue.enqueue(1);
        final int taille = queue.size();

        // Assert
        assertEquals(1, taille, "La taille de la queue devrait être de 1.");
        assertNotNull(queue.peek(), "L'attribut first ne devrait pas être null.");
        assertNotNull(queue.getLast(), "L'attribut last ne devrait pas être null.");
        assertEquals(1, (int)queue.peek(), "L'attribut first devrait avoir une valeur de 1.");
        assertEquals(1, (int)queue.getLast(), "L'attribut first devrait avoir une valeur de 1.");
        assertEquals(queue.peek(), queue.getLast(), "Les attributs first et last devraient être égaux.");
    }

    /**
     * d07 = < { Queue() -> enqueue(1) -> peek() } , { first == 1, last == 1, n == 1 } >
     */
    @Test
    public void d07() {
        // Arrange
        queue = new Queue<>();

        // Act
        queue.enqueue(1);
        final int elem = queue.peek();

        // Assert
        assertEquals(1, elem, "Un appel à la fonciton peek devrait retourner la valeur 1.");
        assertNotNull(queue.getLast(), "L'attribut last ne devrait pas être null.");
        assertEquals(1, (int)queue.getLast(), "L'attribut first devrait avoir une valeur de 1.");
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
        assertEquals(0, queue.size(), "L'attribut n devrait être égal à 0.");
    }

    /**
     * d10 = < { Queue() -> enqueue(1) -> enqueue(2) -> size() } ,
               { first == 1, last == 2, n == 2 } >
     */
    @Test
    public void d10() {
        // Arrange
        queue = new Queue<>();

        // Act
        queue.enqueue(1);
        queue.enqueue(2);
        final int taille = queue.size();

        // Assert
        assertEquals(2, taille, "La taille de la queue devrait être de 2.");
        assertNotNull(queue.peek(), "L'attribut first ne devrait pas être null.");
        assertNotNull(queue.getLast(), "L'attribut last ne devrait pas être null.");
        assertEquals(1, (int)queue.peek(), "L'attribut first devrait avoir une valeur de 1.");
        assertEquals(2, (int)queue.getLast(), "L'attribut first devrait avoir une valeur de 2.");
        assertNotEquals(queue.peek(), queue.getLast(), "L'attribut first et l'attribut last devrait être différent.");
    }

    /**
     * d12 = < { Queue() -> enqueue(1) -> enqueue(2) -> enqueue(3) } ,
               { first == 1, last == 3, n == 3  } >
     */
    @Test
    public void d12() {
        // Arrange
        queue = new Queue<>();

        // Act
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Assert
        assertEquals(3, queue.size(), "La taille de la queue devrait être de 3.");
        assertNotNull(queue.peek(), "L'attribut first ne devrait pas être null.");
        assertNotNull(queue.getLast(), "L'attribut last ne devrait pas être null.");
        assertEquals(1, (int)queue.peek(), "L'attribut first devrait avoir une valeur de 1.");
        assertEquals(3, (int)queue.getLast(), "L'attribut first devrait avoir une valeur de 3.");
        assertNotEquals(queue.peek(), queue.getLast(), "L'attribut first et l'attribut last devrait être différent.");
    }


    /**
     * d14 = < { Queue() -> enqueue(1) -> enqueue(2) -> dequeue() } ,
     *         { first == 2, last == 2, n == 1 } >
     */
    @Test
    public void d14() {
        // Arrange
        queue = new Queue<>();

        // Act
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();

        // Assert
        assertEquals(1, queue.size(), "La taille de la queue devrait être de 1.");
        assertNotNull(queue.peek(), "L'attribut first ne devrait pas être null.");
        assertNotNull(queue.getLast(), "L'attribut last ne devrait pas être null.");
        assertEquals(2, (int)queue.peek(), "L'attribut first devrait avoir une valeur de 2.");
        assertEquals(2, (int)queue.getLast(), "L'attribut first devrait avoir une valeur de 2.");
        assertEquals(queue.peek(), queue.getLast(), "Les attributs first et last devraient être égaux.");
    }
}
