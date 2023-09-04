import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Array2Test {
    @Test
    public void testConstructorWithNullDims() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Array2<>(null);
        });
    }

    @Test
    public void testGet() {
        int[] dims = { 3, 3 };
        Array2<Integer> array2 = new Array2<>(dims);

        array2.set(1, 0, 0);
        array2.set(2, 0, 1);
        array2.set(3, 0, 2);
        array2.set(4, 1, 0);
        array2.set(5, 1, 1);
        array2.set(6, 1, 2);

        Assertions.assertEquals(1, array2.get(0, 0));
        Assertions.assertEquals(2, array2.get(0, 1));
        Assertions.assertEquals(3, array2.get(0, 2));
        Assertions.assertEquals(4, array2.get(1, 0));
        Assertions.assertEquals(5, array2.get(1, 1));
        Assertions.assertEquals(6, array2.get(1, 2));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array2.get(-1, 0);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array2.get(0, -1);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array2.get(2, 0);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array2.get(0, 3);
        });
    }

    @Test
    public void testSet() {
        int[] dims = { 3, 3 };
        Array2<Integer> array2 = new Array2<>(dims);

        array2.set(1, 0, 0);
        array2.set(2, 0, 1);
        array2.set(3, 0, 2);
        array2.set(4, 1, 0);
        array2.set(5, 1, 1);
        array2.set(6, 1, 2);

        Assertions.assertEquals(1, array2.get(0, 0));
        Assertions.assertEquals(2, array2.get(0, 1));
        Assertions.assertEquals(3, array2.get(0, 2));
        Assertions.assertEquals(4, array2.get(1, 0));
        Assertions.assertEquals(5, array2.get(1, 1));
        Assertions.assertEquals(6, array2.get(1, 2));

        array2.set(7, 0, 1);
        Assertions.assertEquals(7, array2.get(0, 1));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array2.set(8, -1, 0);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array2.set(9, 0, -1);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array2.set(10, 2, 0);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array2.set(11, 0, 3);
        });
    }

    @Test
    public void testIterator() {

        int[] arrayDims = {3, 3};
        Array2<Integer> array = new Array2<>(arrayDims);
        array.set(1, 0, 0);
        array.set(2, 0, 1);
        array.set(3, 0, 2);
        array.set(4, 1, 0);
        array.set(5, 1, 1);
        array.set(6, 1, 2);

        Iterator<Object> iter = array.iterator();

        assertTrue(iter.hasNext());
        assertEquals(1, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(4, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(2, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(5, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(3, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(6, iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    public void testSkipIterator() {
        int[] arrayDims = new int[]{ 4, 2, 3, 1 };
        Array2<Integer> array = new Array2<>(arrayDims);
        array.set(0, 0, 0);
        array.set(4, 0, 1);
        array.set(7, 0, 2);
        array.set(9, 0, 3);
        array.set(1, 1, 0);
        array.set(5, 1, 1);
        array.set(2, 2, 0);
        array.set(6, 2, 1);
        array.set(8, 2, 2);
        array.set(3, 3, 0);

        Iterator<Object> iter = array.iterator(3);

        assertTrue(iter.hasNext());
        assertEquals(0, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(3, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(6, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(9, iter.next());
        assertFalse(iter.hasNext());
    }
}