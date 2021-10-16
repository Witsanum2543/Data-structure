import java.util.*;

class ArraySet<T> implements Iterable<T>{

    private List<T> items;

    public ArraySet() { items = new ArrayList<>(); }

    public void add(T value) {
        if (!contains(value)) {
            items.add(value);
        }
    }

    public boolean contains(T value) {
       return items.contains(value);
    }

    public int size() { return items.size(); }

        // inner class
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
//        Set<Integer> hs = new HashSet<>();
//        hs.add(5);
//        hs.add(11);
//        for (Integer e : hs){
//            System.out.println(e);
//        }

        // use our own implement set
        // manual mode
        ArraySet<Integer> as = new ArraySet<>();
        as.add(5);
        as.add(11);
//        Iterator<Integer> it = as.iterator();
//        while (it.hasNext()){
//            Integer e = it.next();
//            System.out.println(e);
//        }
        for(Integer e: as){
            System.out.println(e);
        }
    }
}
