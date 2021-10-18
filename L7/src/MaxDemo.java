import java.util.function.BiFunction;


interface hasIsLarger<T>{
    boolean isLarger(T that);
}


public class MaxDemo {

    static<T> T maxValue(T[] items, BiFunction<T, T, Boolean> isLarger){
        int maxDex = 0;
        for (int i=1; i<items.length; i++){
            if (isLarger.apply(items[i], items[maxDex]))
                maxDex = i;
        }
        return items[maxDex];
    }

    static<T extends hasIsLarger<T>> T maxValue2(T[] items){
        int maxDex = 0;
        for(int i=0; i<items.length; i++){
            if (items[i].isLarger(items[maxDex])){
                maxDex = i;
            }
        }
        return items[maxDex];
    }
}
