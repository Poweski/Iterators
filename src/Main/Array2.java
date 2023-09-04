import java.util.Iterator;

public class Array2<T> implements Iterable<Object> {
    private final Object[][] array;

    public Array2(int[] dims) throws NullPointerException {
        if (dims == null)
            throw new NullPointerException();
        else {
            array = new Object[dims.length][];
            for (int i=0; i<dims.length; i++) {
                array[i] = new Object[dims[i]];
                for (int j=0; j<dims[i]; j++)
                    array[i][j] = null;
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

    private static class Array2Iterator<t> implements Iterator<t> {
        private final t[][] array;
        private int rowIndex = 0;
        private int columnIndex = 0;
        private final int maxColumnLength;
        private int maxColumnIndex;

        public Array2Iterator(t[][] array) {
            this.array = array;
            this.maxColumnLength = findMaxColumnLength();
        }

        public int findMaxColumnLength() {
            int max = 0;
            for (int i=0; i<array.length; i++) {
                if (array[i].length >= max) {
                    max = array[i].length;
                    maxColumnIndex = i;
                }
            }
            return max-1;
        }

        public void moveToTheNextColumn() {
            if (rowIndex == array.length && columnIndex != maxColumnLength) {
                columnIndex++;
                rowIndex = 0;
            }
        }

        public void skipHoles() {
            while (columnIndex >= array[rowIndex].length && rowIndex < array.length-1)
                rowIndex++;
        }

        private void skipHoleAndMove() {
            if (rowIndex == array.length-1 && columnIndex >= array[rowIndex].length && columnIndex < maxColumnLength) {
                rowIndex = 0;
                columnIndex++;
            }
        }

        @Override
        public boolean hasNext() {
            return rowIndex != maxColumnIndex+1 || columnIndex != maxColumnLength;
        }

        @Override
        public t next() {

            moveToTheNextColumn();
            skipHoles();
            skipHoleAndMove();
            skipHoles();

            t result = array[rowIndex][columnIndex];

            rowIndex++;

            return result;
        }
    }

    private static class Array2SkipIterator<t> implements Iterator<t> {

        private final Array2Iterator<t> iter2;
        private final Array2Iterator<t> iter3;
        private final int n;
        private int counter = 0;

        public Array2SkipIterator(t[][] array, int n) {
            this.iter2 = new Array2Iterator<>(array);
            this.iter3 = new Array2Iterator<>(array);
            this.n = n;
        }

        @Override
        public boolean hasNext() {
            if (counter == 0)
                return iter3.hasNext();
            int hasNextCounter = 0;
            while (hasNextCounter<n) {
                if (iter3.hasNext()) {
                    iter3.next();
                    hasNextCounter++;
                }
                else return false;
            }
            return true;
        }

        @Override
        public t next() {

            t result = null;

            if (counter == 0 && iter2.hasNext()) {
                counter++;
                return iter2.next();
            }

            while (!(counter%n == 0)) {
                if (iter2.hasNext())
                    iter2.next();
                counter++;
            }
            if (iter2.hasNext())
                result = iter2.next();
            counter++;

            return result;
        }
    }
}