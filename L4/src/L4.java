public class L4 {
    public static void main(String[] args) {
        SLList L = new SLList();
        L.addFirst(5);
        L.addFirst(10);
        L.addLast(10);
        L.addLast(20);
        L.addLast(30);
//        L.insert(50,3);
        System.out.println(L.toString());
    }
}



class SLList {
     private static class  IntNode {
        int head;
        IntNode rest;

        public IntNode(int head, IntNode rest) {
            this.head = head;
            this.rest = rest;
        }
    }
    private IntNode sen; // sentinel node
    private  int size;

    public SLList () {
        sen = new IntNode(-1, null);
        size = 0;
    }
    public SLList (int x) {
        this(); // call constructure SLList() to create sen first for assign first node later on.
        sen = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sen.rest = new IntNode(x, sen.rest);
        size++;
    }

    public void addLast(int x) {
        // for loop way
//        size++;
//        IntNode cur = sen;
//        for(cur = sen; cur.rest != null; cur = cur.rest){
//
//        }
//        cur.rest = new IntNode(x, null);

        // while loop way
        size++;
        IntNode cur = sen;
        while (cur.rest != null) {
            cur = cur.rest;
        }
        cur.rest = new IntNode(x, null);
    }

    public int getFirst() {
        return sen.rest.head;
    }

    public int getLast() {
        IntNode cur = sen;
        while (cur.rest != null) {
            cur = cur.rest;
        }
        return cur.head;
    }

    public int size() {
        return size;
    }

    public String toString() {
        IntNode cur = sen;
        String ans = "";
        while (cur.rest != null) {
            cur = cur.rest;
            ans += "" + cur.head + ", ";
        }
        return ans;
    }

    public void removeFirst() {
        if (size >= 1) {
            size--;
            sen.rest = sen.rest.rest;
        }
    }

    public void insert(int newValue, int k) {
        size++;
        IntNode cur = sen;
        for (int i=0; i<k; i++) {
            cur = cur.rest;
        }
        cur.rest = new IntNode(newValue,cur.rest);
    }
}