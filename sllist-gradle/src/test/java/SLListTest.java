import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SLListTest {


    @Test
    void getFirst() {
        SLList list1 = new SLList();
        SLList list2 = new SLList();
        SLList list3 = new SLList();
        SLList list4 = new SLList();
        SLList list5 = new SLList();
        list1.addFirst(5);
        list2.addFirst(10);
        list3.addFirst(15);
        list4.addFirst(20);
        assertEquals(5, list1.getFirst());
        assertEquals(10, list2.getFirst());
        assertEquals(15, list3.getFirst());
        assertEquals(20, list4.getFirst());
        assertThrows(IndexOutOfBoundsException.class, () -> list5.getFirst());

    }

    @Test
    void get() {
        SLList list = new SLList();
        list.addFirst(5);
        list.addFirst(10);
        list.addFirst(15);
        assertEquals(15, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(5, list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }
}