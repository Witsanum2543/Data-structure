import java.util.*;

class ArraySet<T> implements Iterable<T>{

    private List<T> items;
    public ArraySet() { items = new ArrayList<>(); }

    public void add(T value) {
        if (!contains(value)) {items.add(value);}
    }
    public boolean contains(T value) {return items.contains(value);}
    public int size() { return items.size(); }

// --------------------------------------------------------------------------------//

    private class ArraySetIterator implements Iterator<T> {

        private int pos;
        public ArraySetIterator() { pos = 0;}
        @Override
        public boolean hasNext() {
            return pos < items.size();
        }

        @Override
        public T next() {
            T toReturn = items.get(pos);
            pos++;
            return toReturn;
        }
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }
}

public class L10 {
    public static void main(String[] args) {

        // use java.set
//        Set<Integer> hashset = new HashSet<>();
//        hashset.add(5);
//        hashset.add(11);
//        for (Integer e : hashset){ System.out.println(e);}


        // use our own implement Set class
        ArraySet<Integer> arrayset = new ArraySet<>();
        arrayset.add(5);
        arrayset.add(11);
        // Manual way of iterationc
        Iterator<Integer> iterator = arrayset.iterator();  // give reference to the start of a list but not a first element
        while (iterator.hasNext()){
            int i = iterator.next(); // we use .next() before printout first element because .iterator() it not really point at first element of list.
            System.out.println(i);
        }
//        for(Integer e: arrayset){
//            System.out.println(e);
//        }
    }
}
