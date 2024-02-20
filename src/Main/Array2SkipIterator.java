import java.util.Iterator;

public class Array2SkipIterator<T> implements Iterator<T> {

    private final Array2Iterator<T> iter2;
    private final Array2Iterator<T> iter3;
    private final int n;
    private int counter = 0;

    public Array2SkipIterator(T[][] array, int n) {
        this.iter2 = new Array2Iterator<>(array);
        this.iter3 = new Array2Iterator<>(array);
        this.n = n;
    }

    @Override
    public boolean hasNext() {
        if (counter == 0) {
            return iter3.hasNext();
        }
        int hasNextCounter = 0;
        while (hasNextCounter<n) {
            if (iter3.hasNext()) {
                iter3.next();
                hasNextCounter++;
            }
            else {
                return false;
            }
        }
        return true;
    }

    @Override
    public T next() {
        T result = null;
        if (counter == 0 && iter2.hasNext()) {
            counter++;
            return iter2.next();
        }
        while (!(counter%n == 0)) {
            if (iter2.hasNext()) {
                iter2.next();
            }
            counter++;
        }
        if (iter2.hasNext()) {
            result = iter2.next();
        }
        counter++;
        return result;
    }
}