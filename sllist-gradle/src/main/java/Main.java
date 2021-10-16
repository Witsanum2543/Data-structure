public class Main {
    public static void main(String[] args) {
        SLList list = new SLList();
        list.getFirst();
        list.addFirst(5);
        list.addFirst(10);
        list.addFirst(15);
        System.out.println(list.get(3));


    }
}
