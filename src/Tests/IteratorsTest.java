import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IteratorsTest {
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
    public void testArray2Iterator() {
        int[] arrayDims = {3, 3};
        Array2<Integer> array = new Array2<>(arrayDims);
        array.set(1, 0, 0);
        array.set(2, 0, 1);
        array.set(3, 0, 2);
        array.set(4, 1, 0);
        array.set(5, 1, 1);
        array.set(6, 1, 2);
        Iterator<Object> iterator = array.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(6, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testArray2SkipIterator() {
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
        Iterator<Object> iterator = array.iterator(3);
        assertTrue(iterator.hasNext());
        assertEquals(0, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(6, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(9, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testFibonacciIterator() {
        FibonacciIterator iterator = new FibonacciIterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(5, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(8, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(13, (int) iterator.next());
    }

    @Test
    public void testKthElementIterator() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> baseIterator = list.iterator();
        int k = 3;
        KthElementIterator<Integer> iterator = new KthElementIterator<>(baseIterator, k);
        assertTrue(iterator.hasNext());
        assertEquals(3, (int) iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testKthElementIteratorWithLargeK() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> baseIterator = list.iterator();
        int k = 10;
        KthElementIterator<Integer> iterator = new KthElementIterator<>(baseIterator, k);
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }

    @Test
    public void testKthElementIteratorWithEmptyList() {
        List<Integer> list = List.of();
        Iterator<Integer> baseIterator = list.iterator();
        int k = 1;
        KthElementIterator<Integer> iterator = new KthElementIterator<>(baseIterator, k);
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }

    @Test
    public void testPrimeIterator() {
        int limit = 20;
        PrimeIterator iterator = new PrimeIterator(limit);
        assertTrue(iterator.hasNext());
        assertEquals(2, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(5, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(7, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(11, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(13, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(17, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(19, (int) iterator.next());
        assertFalse(iterator.hasNext());
    }
    @Test
    public void testShuffleIterator() {
        List<Integer> firstList = Arrays.asList(1, 2, 3);
        List<Integer> secondList = Arrays.asList(4, 5, 6);
        Iterator<Integer> firstIterator = firstList.iterator();
        Iterator<Integer> secondIterator = secondList.iterator();
        ShuffleIterator<Integer> iterator = new ShuffleIterator<>(firstIterator, secondIterator);
        assertTrue(iterator.hasNext());
        assertEquals(1, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(4, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(5, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(6, (int) iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testShuffleIteratorWithEmptyFirstIterator() {
        List<Integer> firstList = List.of();
        List<Integer> secondList = Arrays.asList(4, 5, 6);
        Iterator<Integer> firstIterator = firstList.iterator();
        Iterator<Integer> secondIterator = secondList.iterator();
        ShuffleIterator<Integer> iterator = new ShuffleIterator<>(firstIterator, secondIterator);
        assertTrue(iterator.hasNext());
        assertEquals(4, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(5, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(6, (int) iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testShuffleIteratorWithEmptySecondIterator() {
        List<Integer> firstList = Arrays.asList(1, 2, 3);
        List<Integer> secondList = List.of();
        Iterator<Integer> firstIterator = firstList.iterator();
        Iterator<Integer> secondIterator = secondList.iterator();
        ShuffleIterator<Integer> iterator = new ShuffleIterator<>(firstIterator, secondIterator);
        assertTrue(iterator.hasNext());
        assertEquals(1, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, (int) iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testShuffleIteratorWithBothEmptyIterators() {
        List<Integer> firstList = List.of();
        List<Integer> secondList = List.of();
        Iterator<Integer> firstIterator = firstList.iterator();
        Iterator<Integer> secondIterator = secondList.iterator();
        ShuffleIterator<Integer> iterator = new ShuffleIterator<>(firstIterator, secondIterator);
        assertFalse(iterator.hasNext());
    }
}