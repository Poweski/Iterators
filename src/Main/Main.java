import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{ 4, 2, 3, 1 };
        Array2<Integer> array2 = new Array2<>(array);

        try {
            array2.set(0, 0, 0);
            array2.set(4, 0, 1);
            array2.set(7, 0, 2);
            array2.set(9, 0, 3);
            array2.set(1, 1, 0);
            array2.set(5, 1, 1);
            array2.set(2, 2, 0);
            array2.set(6, 2, 1);
            array2.set(8, 2, 2);
            array2.set(3, 3, 0);
        }
        catch (IndexOutOfBoundsException | NullPointerException e) {
            System.out.print(e.getMessage());
        }

        for (Object o : array2)
            System.out.println(o);

        System.out.println();

        Iterator<Object> iterator = array2.iterator(3);
        while (iterator.hasNext()) {
            Object x = iterator.next();
            System.out.println(x);
        }
    }
}