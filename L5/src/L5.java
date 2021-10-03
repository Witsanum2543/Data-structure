public class L5 {
    public static void main(String[] args) {
        AList<Double> list = new AList();
        //long start = System.currentTimeMillis();
        for (Double i=0.0; i<32.410; i+=0.0123) {
            list.addFirst(i);
        }
        System.out.println(list.getFirst());
        //long end = System.currentTimeMillis();
        //System.out.println(end - start);

    }
}

class AList <T>{
    private int size;
    private T[] items;

    public AList() {
        items = (T[]) new Object[11];
        size = 0;
    }
    private void grow(int n) {
        // grow the array to capacity n
        T[] newItems = (T[]) new Object[n];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }
    private void growFirst(int n) {
        // grow the array to capacity n from front of list
        T[] newItems = (T[]) new Object[n];
        System.arraycopy(items, 0, newItems, 1, size);
        items = newItems;
    }
    public void addLast(T x) {
        // Add x to the rear end of this list
        if (size == items.length) { // check if list is full ?
            grow(size + 5);
        }
        /*
        items[size] = x;
        size++;
        */
        items[size++] = x; // before increment return size first then increment
    }
    public void addFirst(T x) {
        growFirst(size + 1);
        items[0] = x;
        size++;
    }

    public void removeLast() {
        // Delete item at the rear end
        size--;
        items[size] = null;
    }
    public T getFirst() {
        return items[0];
    }
    public T getLast() {
        return items[size-1]; // it is index so -1
    }

}