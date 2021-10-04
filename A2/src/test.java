public class test<T> {
    int size;
    T[] items;
    int front;
    int rear;
    public test() {
        this.items = (T[]) new Object[8];
        this.size = 0;
        this.front = -1;
        this.rear = -1;
    }
    private boolean isFull(){
        return ((rear+1) == front || (front==0 && rear==items.length-1));
    }
    private void grow() {
        T[] newItems = (T[]) new Object[items.length*2];
        int i =0;
        int j =front;
        do{
            newItems[i] = items[j];
            i++;
            j = (j+1) % items.length;
        } while(j != front);

        front = 0;
        rear = items.length -1;
        items = newItems;
    }
    private void shrink() {
        T[] newItems = (T[]) new Object[items.length/2];
        int i =0;
        int j =front;
        do{
            newItems[i] = items[j];
            i++;
            j = (j+1) % items.length;
        } while(j != rear+1); // มีปัญหาตรงนี้ +1 ไม่ได้

        front = 0;
        rear = size-1;
        items = newItems;
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        if (front == -1) {front=0; rear=0;}
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
        if (rear == -1) {front=0; rear=0;}
        if (isFull()) {grow();}

        if (rear == items.length-1){
            rear = 0;
        } else if (rear ==0 && items[0]==null){
            items[rear] = item;
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
        if (front > rear){
            for (int i=front; i<items.length; i++){
                if (items[i] == null){ break;}
                ans += "" + items[i] + " ";
            }
            for (int i=0; i<=rear; i++){
                if (items[i] == null){ break;}
                ans += "" + items[i] + " ";
            }
        } else {
            for (int i=front; i<size; i++){
                ans += "" + items[i] + " ";
            }
        }
        return ans;
    }

    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        if (size==0){return null;}

        if (front == items.length-1){
            T hold = items[front];
            items[front] = null;
            front = 0;
            size--;
            if (size < items.length/2 && items.length >= 16) {shrink();}
            if (size==0){front = -1;rear = -1;}
            return hold;
        } else {
            T hold = items[front];
            items[front] = null;
            front++;
            size--;
            if (size < items.length/2 && items.length >= 16) {shrink();}
            if (size==0){front = -1;rear = -1;}
            return hold;
        }

    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast(){
        if(size==0){return null;}

        if (rear == 0){
            T hold = items[rear];
            items[rear] = null;
            rear = items.length - 1;
            size--;
            if (size==0){front = -1;rear = -1;}
            return hold;
        } else {
            T hold = items[rear];
            items[rear] = null;
            rear--;
            size--;
            if (size==0){front = -1;rear = -1;}
            return hold;
        }
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
        test<Integer> list = new test<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        list.addLast(11);
        list.addLast(12);
        list.addLast(13);
        list.addLast(14);
        list.addLast(15);
        list.addLast(16);
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.addFirst(50);
        list.addLast(60);
        System.out.println(list.toString());
    }
}