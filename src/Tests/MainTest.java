import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testSet() {
        int[] array = new int[]{ 4, 2, 3 };
        Array2<Integer> array2 = new Array2<>(array);

        array2.set(0, 0, 0);
        assertEquals(0, (int) array2.get(0, 0));
        array2.set(5, 0, 1);
        assertEquals(5, (int) array2.get(0, 1));
        array2.set(6, 0, 2);
        assertEquals(6, (int) array2.get(0, 2));
        array2.set(7, 0, 3);
        assertEquals(7, (int) array2.get(0, 3));
        array2.set(1, 1, 0);
        assertEquals(1, (int) array2.get(1, 0));
        array2.set(8, 1, 1);
        assertEquals(8, (int) array2.get(1, 1));
        array2.set(2, 2, 0);
        assertEquals(2, (int) array2.get(2, 0));
        array2.set(9, 2, 1);
        assertEquals(9, (int) array2.get(2, 1));
        array2.set(10, 2, 2);
        assertEquals(10, (int) array2.get(2, 2));

        try {
            array2.set(11, 3, 0);
            fail("Expected IndexOutOfBoundsException was not thrown.");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Invalid index.", e.getMessage());
        }
    }
}