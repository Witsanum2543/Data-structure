public class LinkedListDeque<T> implements Deque<T>{
    // linked-list node implement
    private class Node<T> {
        T head;
        Node rest;
        Node prev;

        public Node(T head, Node rest, Node prev) {
            this.head = head;
            this.rest = rest;
            this.prev = prev;
        }
    }

    // -------------- Constant ---------------------
    // ---------------------------------------------
    Node<T> first;  // location pointer to first node
    Node<T> last;   // location pointer to last node
    int size;
    // ---------------------------------------------

    // declare mydeque with empty parameter = null (not create a node)
    public LinkedListDeque(){
        this.first = null;
        this.last = null;
    }
    // deepcopy
    public LinkedListDeque(LinkedListDeque<T> other) {
        Node<T> other_cur = other.first;
        for (int i=0; i<other.size; i++){
            this.addLast(other_cur.head);
            other_cur = other_cur.rest;
        }
    }

    // Adds an item of type T to the front of the deque.
    @Override
    public void addFirst(T item){
        if (size == 0){
            this.first = new Node<>(item,null, null);
            this.last = this.first;
            size++;
        } else {
            this.first = new Node<>(item, this.first, null); // create new first node "rest" --> previous of first node "prev" --> null (because it is first node)
            this.first.rest.prev = this.first; // update previous node to point "prev" to first node
            size++;
        }

    }

    @Override
    public void addLast(T item){
        if (size == 0){
            this.last = new Node<>(item, null, null);
            this.first = this.last;
            size ++;
        } else {
            this.last = new Node<>(item, null, this.last); // create new last node, "rest" --> null (because it is last node) "prev" --> previous of last node
            this.last.prev.rest = this.last; // update prev last node rest --> last node
            size++;
        }

    }

    // Returns true if deque is empty, false otherwise.
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    // Returns the number of items in the deque.
    @Override
    public int size(){
        return size;
    }

    // Returns a string showing the items in the deque from first to last,
    @Override
    public String toString(){
        if (size == 0){
            return null;
        }
        Node<T> cur = this.first;
        String ans = "";
        for (int i=0; i<size-1; i++){
            ans += "" + cur.head + " ";
            cur = cur.rest;
        }
        ans += "" + cur.head;
        return ans;
    }

    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    @Override
    public T removeFirst() {
        T ans = this.first.head;
        if (size == 0) {
            return null;
        } else if (size == 1) {
            this.first = null;
            this.last = null;
            size--;
        } else {
            this.first = this.first.rest;
            this.first.prev = null;
            size--;
        }
        return ans;
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    @Override
    public T removeLast(){
        T ans = this.last.head;
        if (size == 0) {
            return null;
        } else if (size == 1) {
            this.first = null;
            this.last = null;
            size--;
        } else {
            this.last = this.last.prev;
            this.last.rest = null;
            size--;
        }
        return ans;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item,
    // and so forth. If no such item exists, returns null. Must not alter the deque!
    @Override
    public T get(int index){
        if (index >= size) {
            return null;
        }
        Node<T> cur = this.first;
        for (int i=0; i<index; i++){
            cur = cur.rest;
        }
        return cur.head;
    }
}
