public class ArrayDeque<T> {
    int size;
    T[] items;
    int front;
    int rear;
    public ArrayDeque() {
        this.items = (T[]) new Object[8];
        this.size = 0;
        this.front = -1;
        this.rear = -1;
    }

    private void grow() {
        // grow the array to capacity n
        T[] newItems = (T[]) new Object[items.length*2];
        System.arraycopy(items, this.front, newItems, 0, size);
        items = newItems;
    }
    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        if ((front-1) % items.length == rear) {
            grow();
        } else if (front <= 0) {
            front = items.length - 1;
            items[front] = item;
            size++;
        } else {
            front = (front-1) % items.length;
            items[front] = item;
            size++;
        }
    }
    // Adds an item of type T to the back of the deque.
    public void addLast(T item){
        if ((rear+1) % items.length == front) { // if next rear is equal first, it mean circle is full
            grow();
        } else {
            rear = (rear+1) % items.length;
            items[rear] = item;
            size++;
        }
    }
//    // Returns true if deque is empty, false otherwise.
//    public boolean isEmpty()
//    // Returns the number of items in the deque.
//    public int size()
//    // Returns a string showing the items in the deque from first to last,
//// separated by a space.
//    public String toString()
//    // Removes and returns the item at the front of the deque.
//// If no such item exists, returns null.
//    public T removeFirst()
//    // Removes and returns the item at the back of the deque.
//// If no such item exists, returns null.
//    public T removeLast()
//    // Gets the item at the given index, where 0 is the front, 1 is the next item,
//// and so forth. If no such item exists, returns null. Must not alter the deque!
//    public T get(int index)

    public static void main(String[] args) {
//        ArrayDeque<Integer> list = new ArrayDeque<>();
//        list.addFirst(0);
//        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
//        list.addLast(5);
//        list.addLast(6);
//        list.addLast(7);
//        list.addLast(8);
//        list.addLast(9);
//        list.addLast(10);
//        list.addLast(11);
//        list.addLast(12);
    }
}
