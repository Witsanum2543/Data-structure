import java.util.List;

interface Series {
    // Return the next number
    int next(); // <-- public by default

    // Restart thw series
    void reset();
}

// 0, 2, 4, 6, 8, 10, ...
class IncrByTwo implements Series {

    private int val=0;

    @Override
    public int next() {
        int curVal = val;
        val += 2;
        return curVal;
    }

    @Override
    public void reset() { val=0; }

    public int onlyForIncrByTwo() {return 5;} // In series interface, doesn't have this method.
}



public class L6 {
//    static int awesomesum(ArrayList<Integer> numbers){
//        int total = 0;
//        for (int num: numbers)
//            total += num;
//        return total;
//    }
//    static int awesomesum(LinkedList<Integer> numbers){
//        int total = 0;
//        for (int num: numbers)
//            total += num;
//        return total;
//    }
    static int awesomesum(List<Integer> numbers){ // so we doesn't need so many method to change type of list as above method
        int total = 0;                            // because all of this list is part of List(interface)
        for (int num: numbers)                    // make (List<> numbers) parameter give you freedom of list choice without making new method
            total += num;                         // just to pass in parameter
        return total;
    }
    public static void main(String[] args) {

        // Seen as an IncrByTwo
        IncrByTwo seq = new IncrByTwo();
        seq.onlyForIncrByTwo();

        // Polymorphism : IncrByTwo is not only an class but also a kind of Series
        // Seen as an Series (interface)
        Series poly_seq = new IncrByTwo();
        // poly_seq.onlyForIncrByTwo(); <-- poly_seq is series so cant use this method

    }
}
