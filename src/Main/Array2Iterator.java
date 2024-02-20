import java.util.Iterator;

public class Array2Iterator<T> implements Iterator<T> {
    private final T[][] array;
    private int rowIndex = 0;
    private int columnIndex = 0;
    private final int maxColumnLength;
    private int maxColumnIndex;

    public Array2Iterator(T[][] array) {
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
        while (columnIndex >= array[rowIndex].length && rowIndex < array.length-1) {
            rowIndex++;
        }
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
    public T next() {
        moveToTheNextColumn();
        skipHoles();
        skipHoleAndMove();
        skipHoles();
        T result = array[rowIndex][columnIndex];
        rowIndex++;
        return result;
    }
}