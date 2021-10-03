public class L3 {
    public static void main(String[] args) {
        // [7, 11, 9]
        IntNode list = null;
        list = new IntNode(9, list);
        list = new IntNode(11, list);
        list = new IntNode(7, list);
        IntNode newList = list.incrList(5);
        System.out.println(list.iterativeToString());
        System.out.println(newList.iterativeToString());
    }
}

class IntNode {
    int head;
    IntNode rest;

    public IntNode  (int head, IntNode rest) {
        this.head = head;
        this.rest = rest;
    }

    // method to print out string
//    public String toString() {
//        if (this.rest == null)
//            return "" + this.head; // change this.head type to String
//        else
//            return "" + this.head + ", " + this.rest.toString();
//    }

    public String iterativeToString() {
        String ans = "";
        IntNode curr = this;
        while (curr.rest != null) {
            ans += "" + curr.head + ", ";
            curr = curr.rest;
        }
        ans += "" + curr.head;
        return ans;
    }

    public int get(int i) {
        IntNode curr = this;
        for (int j=0; j<i; j++) {
            curr = curr.rest;
        }
        return curr.head;
    }

    public void set(int i, int newValue) {
        IntNode curr = this;
        for (int j=0; j<i; j++) {
            curr = curr.rest;
        }
        curr.head = newValue;
    }

    public IntNode incrList(int delta) {
        if (this.rest == null)
            return new IntNode(this.head + delta, null);
        else
            return new IntNode(this.head + delta, this.rest.incrList(delta));
    }

    public int size() {
        if (this.rest == null)
            return 1;
        else
            return 1 + this.rest.size();
    }

    public int iterativeSize() {
        IntNode current = this; // i = 0
        int count = 0;

        while (current != null) {
            current = current.rest;
            count++;
        }
        return count;
    }
}