# Iterators

- **Array2<T>** - stores a two-dimensional array of elements of type T. The class constructor accepts an array of int numbers specifying how many elements each subsequent subarray should store. Elements are initialized with null. The class has methods T get(int i, int j), void set(T newElem, int i, int j) that allow you to retrieve and change the element at position (i, j).

- **Array2Iterator<T>** - implements an iterator traversing two-dimensional arrays of type T (T[][]). This iterator first goes through the subsequent elements with index 0 of all subarrays, then after the elements with index 1, etc. If any subarray does not have an element with index k, it is skipped.

- **KthElementIterator** - an iterator that takes another iterator as a base and returns each kth element from the collection.

- **FibonacciIterator** - implementation of the Fibbonaci number generator as an iterator.

- **ShuffleIterator** - an iterator that accepts two other iterators and shuffles the input data collections. Example: if the first collection contains the numbers 1, 2, 3, 4, 5 and the second contains the sequence 11, 12, 13, the iterator created will access the element in the order 1, 11, 2, 12, 3, 13, 4, 5.

- **PrimeIterator** - an iterator providing subsequent prime numbers smaller than the given N. The numbers are generated on an ongoing basis.
