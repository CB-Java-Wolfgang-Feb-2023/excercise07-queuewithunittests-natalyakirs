package HW7;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class QueueWithUnitTest {
    QueueToTests queue1 = new QueueToTests();

    @BeforeAll
    static void setUpBeforeAll() {
        System.out.println("Test Queue is starting");
    }

        @BeforeEach
        void setUp() {
            System.out.println("test method is starting");
        }

        @AfterEach
        void tearDown() {
            System.out.println("test method is finished");
        }

    @AfterAll
    static void tearDownAll() {
        System.out.println("testClassIsDone");
    }



    @Test
    @DisplayName("TestDequeue on an empty queue throws IllegalArgumentException")
    void testDequeue() {
        // GIVEN :queue1

        // WHEN: use dequeue method on an empty queue to get IllegalArgumentException
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> queue1.dequeue());

        // THEN: make sure exceptions(both dequeue and IsEmpty) are thrown with messages
        assertEquals("Queue is empty, you can't delete an element.", exception.getMessage());
        assertTrue(queue1.isEmpty(), "Queue should still be empty after using method dequeue on an empty queue.");
    }


    @Test
    @DisplayName("Test enqueue")
    void testEnqueue() {
        // GIVEN: queue1

        // WHEN: use the method enqueue
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        // THEN: Check the size of the queue after using enqueue method
        assertEquals(3, queue1.size(), "Queue size should be 3 after enqueuing 3 elements");

        //THEN: also, checking the method isFull
        assertTrue(queue1.isFull(), "Queue should not be full after using enqueue method");
    }


    @Test
    @DisplayName("Test method isEmpty")
    void testIsEmpty() {
        // GIVEN: queue1

        // WHEN: make sure queue is not empty after using enqueue method
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        // THEN
        assertFalse(queue1.isEmpty(), "Queue should not be empty after using enqueue method");

    }

    @Test
    @DisplayName("Test method getRear")
    void testGetRear() {
        // GIVEN: queue1

        // WHEN
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        // THEN
        assertEquals(2, queue1.getRear());

    }

    @Test
    @DisplayName("Test method getFront")
    void testGetFront() {
        //GIVEN: queue1

        //WHEN: if queue1 is empty-> front ==-1

        //THEN
        assertEquals(-1,queue1.getFront());
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    @DisplayName("Test enqueue with different values")
    void testEnqueueWithDifferentValues(int value) {
        // GIVEN: enqueue1

        // WHEN: Enqueue the given value
        queue1.enqueue(value);

        //Then: check if enqueued values are the same as dequeued values
        assertEquals(value, queue1.dequeue(), "Dequeued value should match the enqueued value");
    }

}
