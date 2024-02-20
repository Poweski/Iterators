import java.util.Iterator;

public class Array2<T> implements Iterable<Object> {
    private final Object[][] array;

    public Array2(int[] dims) throws NullPointerException {
        if (dims == null) {
            throw new NullPointerException();
        } else {
            array = new Object[dims.length][];
            for (int i = 0; i < dims.length; i++) {
                array[i] = new Object[dims[i]];
                for (int j = 0; j < dims[i]; j++) {
                    array[i][j] = null;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int i, int j) throws IndexOutOfBoundsException {
        checkBounds(i, j);
        return (T) array[i][j];
    }

    public void set(T newElem, int i, int j) throws IndexOutOfBoundsException {
        checkBounds(i, j);
        array[i][j] = newElem;
    }

    private void checkBounds(int i, int j) throws IndexOutOfBoundsException {
        if (i < 0 || i >= array.length || j < 0 || j >= array[i].length) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new Array2Iterator<>(array);
    }

    public Iterator<Object> iterator(int n) {
        return new Array2SkipIterator<>(array, n);
    }
}