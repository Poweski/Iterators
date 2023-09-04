# Iterators
Second assignment for algorithms and data structures lab.

a. Napisz klasę Array2<T> przechowującą tablicę dwuwymiarową (tablicę
tablic) elementów typu T. Konstruktor klasy ma przyjmować tablicę liczb
typu int określającą ile elementów ma przechowywać każda kolejna
podtablica. Elementy inicjalizować wartością null. Klasa ma posiadać
metody T get(int i, int j) oraz void set(T newElem, int i, int j) pozwalające
na pobranie i zmianę elementu na pozycji (i, j). W przypadku błędu
zwracać odpowiednie wyjątki,

Wskazówka: JAVA nie pozwala na tworzenie tablic typów generycznych
tzn. instrukcja T[] array = new T[N]; zakończy się błędem. W tym
przypadku należy zastosować rzutowanie: T[] array = (T[]) new Object[N];
powodujące jednak zgłoszenie ostrzeżenia. Ostrzeżenie można uciszyć
zapisując przed powyższą linijką: @SuppressWarnings(„unchecked”).

b. Zdefiniuj klasę Array2Iterator<T> implementującą iterator przechodzący
po tablicach dwuwymiarowych typu T (T[][]). Iterator ten ma przechodzić
najpierw po kolejnych elementach o indeksie 0 wszystkich podtablic,
potem po elementach o indeksie 1, itd. Jeżeli jakaś podtablica nie posiada
elementu o indeksie k, to jest pomijana,

c. Zmodyfikować klasę Array2<T> tak, aby umożliwiała iterowanie po
elementach z wykorzystaniem pętli foreach.
