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
    private boolean isFull(){
        return size == items.length;
    }

    private T[] array_resize(int size){
        T[] tempArr = (T[]) new Object[size];
        int cur = front;
        for (int i=0; i<size; i++){
            tempArr[i] = items[cur];
            cur = (cur+1) % items.length;
        }
        return tempArr;
    }

    private void grow() {
        items = array_resize(items.length*2);
        front = 0;
        rear = size-1;
    }
    private void shrink() {
        items = array_resize(items.length/2);
        front = 0;
        rear = size-1;
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        if (front == -1) {front=0; rear=0; items[front] = item; size++; return;} // special case when list is empty
        if (isFull()) {grow();}

        if (front == 0){
            front = items.length-1;
        } else {
            front--;
        }
        items[front] = item;
        size++;
    }
    // Adds an item of type T to the back of the deque.
    public void addLast(T item){
        if (rear == -1) {front=0; rear=0; items[rear] = item; size++; return;}
        if (isFull()) {grow();}

        if (rear == items.length-1){
            rear = 0;
        } else {
            rear++;
        }
        items[rear] = item;
        size++;
    }

    // Returns true if deque is empty, false otherwise.
    // complete
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the number of items in the deque.
    // comeplete
    public int size() {
        return size;
    }

    // Returns a string showing the items in the deque from first to last,
    // separated by a space.
    public String toString() {
        String ans = "";
        int cur =front;
        for (int i=0; i<size; i++){
            ans += "" + items[cur] + " ";
            cur = (cur +1)% items.length;
        }
        return ans;
    }

    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        if (size==0){return null;}
        T ans = items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        size--;

        if (size < items.length/2 && items.length > 8) {shrink();}
        if (size==0){front = -1;rear = -1;}
        return ans;

    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast(){
        if (size==0){return null;}
        T ans = items[rear];
        items[rear] = null;
        rear--;
        size--;
        if (rear < 0) { rear = items.length - 1;}

        if (size < items.length/2 && items.length > 8) {shrink();}
        if (size==0){front = -1;rear = -1;}
        return ans;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item,
    // and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index){
        if (index >= items.length){
            return null;
        }
        return items[index];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        list.addFirst(5);
        list.addFirst(5);
        list.addFirst(5);
        list.addFirst(5);
        list.addFirst(5);

        System.out.println(list.toString());
    }
}