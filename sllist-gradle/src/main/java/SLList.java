public class SLList {
    private class IntNode {
        int value; // an int data item
        IntNode rest; // ref to the next node

        public IntNode(int val, IntNode r) {
            this.value = val; this.rest = r;
        }
    }

    private IntNode first;
    int size;

    public SLList() { first = null; }


    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public int getFirst() {
        if (first == null){
            throw new IndexOutOfBoundsException();
        }
        return first.value;
    }

    public int get(int index) {

        int ans;
        IntNode cur = first;
        for (int i=0; i<index; i++){
            cur = cur.rest;
        }
        if (cur == null){
            throw new IndexOutOfBoundsException();
        }
        ans = cur.value;
        return ans;
    }
}
