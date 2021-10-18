import java.util.function.BiFunction;
import java.util.function.Function;

interface IntUnaryFunction{
    int apply(int x);
}
// Any object that implement this interface is going to have the 'isLarger' method of this shape.
interface hasIsLarger<T>{
    boolean isLarger(T that);
}

class Cat implements hasIsLarger<Cat>{
    private String name;
    private int weight;
    private int age;

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean isLarger(Cat that) {
        // CAT SHOULD ONLY COMPARE BY WEIGHT!
        return this.getWeight() > that.getWeight();
    }
}


public class L7 {
    // return the index with the largest
    // if we want to make it work with other type rather than only int ??? because we cant just compare String to String
    static int maxIndex(int[] items){
        if (items.length == 0)
            return -1;
        int maxDex = 0;
        for (int i=1; i<items.length; i++)
            if (items[i] > items[maxDex])
                maxDex = i;
        return maxDex;
    }
    // idea #1
    // isLarger(x, y) --> true if x is larger than y (isLarger is built in function)
    // BiFunction<T, U, R> T=#1 input type, U=#2 input type, R = return type
    static<T> int maxIndex2(T[] items, BiFunction<T, T, Boolean> islarger){
        if (items.length == 0)
            return -1;
        int maxDex = 0;
        for (int i=1; i<items.length; i++)
            if (islarger.apply(items[i], items[maxDex]))
                maxDex = i;
        return maxDex;
    }
    // idea #2
    // we use T extend interface because we gonna restrict that T type should have isLarger method
    //     T where T satisfies hasIsLarger<T>
    static<T extends hasIsLarger<T>> int maxIndex3(T[] items){
        if (items.length == 0)
            return -1;
        int maxDex = 0;
        for (int i=1; i<items.length; i++)
            if (items[i].isLarger(items[maxDex]))
                maxDex = i;
        return maxDex;
    }


    // before java 8 this is how people do use interface to declare function type
    static int twice(IntUnaryFunction f, int x){
        return f.apply(f.apply(x));
    }
    static class TripleFun implements IntUnaryFunction{
        public int apply(int x) { return 3*x; }
    }
    // ----------------------------------------------------------------------------
    // Java +8 way to do
    // Function<T, R> T = input type, R = return type
    static int bettertwice(Function<Integer, Integer> f, int x){
        return f.apply(f.apply(x));
    }
    static int triple(int x) { return 3*x; }
    // ----------------------------------------------------------------------------

    public static void main(String[] args) {
        //(twice(triple, 2)) Java Old way
        IntUnaryFunction f = new TripleFun();
        int answer = twice(f ,2);

        // Java 8 way
        // L7::triple --> this thing mean, let go inside L7 class and let get address of triple method
        int answer2 = bettertwice(L7::triple, 2);

        Cat[] cats = {
                new Cat("cat1", 5, 7),
                new Cat("cat2", 1, 9),
                new Cat("cat3", 8, 19)
        };

        // standard syntax methods
//        int maxLocation = maxIndex2(cats, L7::isLargerWeight);

        // java 8 trick : annoymous function
        int maxLocation =
                maxIndex2(cats,
                        // we just declare function here without given it a name
                        (Cat x, Cat y) -> x.getWeight() > y.getWeight());

        // idea 2
        int answer3 = maxIndex3(cats);
    }
}
