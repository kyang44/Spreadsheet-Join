package join;

import join.LList;
import join.SLinkedList;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedAnnotationTypes;

import static org.junit.jupiter.api.Assertions.*;

public class SLinkedListTest {
    @Test
    void emptyList() {
        LList<Integer> lst0 = new SLinkedList<>();
        assertEquals(0, lst0.size());
    }

    @Test
    void toString1(){
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(21);
        l1.append(44);
        l1.append(13);
        assertEquals("[21, 44, 13]",l1.toString());
    }

    @Test
    void toString2(){
        LList<String> l1 = new SLinkedList<>();
        l1.append("");
        l1.append("");
        assertEquals("[, ]",l1.toString());

    }
    @Test
    void toString3(){
        LList<Integer> l1 = new SLinkedList<>();
        assertEquals("[]",l1.toString());
    }

    @Test
    void append1() {
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(42);
        assertEquals(1,l1.size());
        assertEquals(42,l1.head());
        assertEquals(42,l1.tail());
        l1.append(21);
        assertEquals(2,l1.size());
        assertEquals(42,l1.head());
        assertEquals(21,l1.tail());
    }

    @Test
    void append2(){
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(42);
        assertEquals(1,l1.size());
        assertEquals(42,l1.head());
        assertEquals(42,l1.tail());
        l1.append(21);
        assertEquals(2,l1.size());
        assertEquals(42,l1.head());
        assertEquals(21,l1.tail());
        l1.append(33);
        assertEquals(3,l1.size());
        assertEquals(42,l1.head());
        assertEquals(33,l1.tail());
        assertEquals("[42, 21, 33]",l1.toString());
    }

    @Test
    void append3(){
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(42);
        assertEquals(1,l1.size());
        assertEquals(42,l1.head());
        assertEquals(42,l1.tail());
        l1.append(21);
        assertEquals(2,l1.size());
        assertEquals(42,l1.head());
        assertEquals(21,l1.tail());
        l1.append(33);
        assertEquals(3,l1.size());
        assertEquals(42,l1.head());
        assertEquals(33,l1.tail());
        l1.append(5);
        assertEquals(4,l1.size());
        assertEquals(42,l1.head());
        assertEquals(5,l1.tail());
    }

    @Test
    void prepend12() {
        LList<Integer> l1 = new SLinkedList<Integer>();
        l1.prepend(42);
        assertEquals(1,l1.size());
        assertEquals(42,l1.head());
        assertEquals(42,l1.tail());
        l1.prepend(21);
        assertEquals(2,l1.size());
        assertEquals(21,l1.head());
        assertEquals(42,l1.tail());
    }
    @Test
    void testInsert1(){
        LList<Integer> l1 = new SLinkedList<Integer>();
        l1.append(3);
        l1.append(8);
        l1.append(2);
        l1.append(4);
        l1.insertBefore(5,2);
        assertEquals(5,l1.size());
        assertEquals(3,l1.head());
        assertEquals(4,l1.tail());
        assertEquals("[3, 8, 5, 2, 4]", l1.toString());
    }

    @Test
    void testInsert2(){
        LList<Integer> l1 = new SLinkedList<Integer>();
        l1.append(3);
        l1.append(8);
        l1.append(2);
        l1.append(4);
        l1.insertBefore(5, 3);
        assertEquals(5,l1.size());
        assertEquals(5,l1.head());
        assertEquals(4,l1.tail());
        assertEquals("[5, 3, 8, 2, 4]", l1.toString());
    }

    @Test
    void testInsert3(){
        LList<Integer> l1 = new SLinkedList<Integer>();
        l1.append(3);
        l1.append(8);
        l1.append(2);
        l1.append(4);
        l1.append(8);
        l1.insertBefore(5,8);
        assertEquals("[3, 5, 8, 2, 4, 8]",l1.toString());
        assertEquals(6,l1.size());
        assertEquals(3,l1.head());
        assertEquals(8, l1.tail());
    }
    @Test
    void testInsert4(){
        LList<Integer> l1 = new SLinkedList<Integer>();
        l1.append(3);
        l1.append(8);
        l1.append(2);
        l1.append(4);
        l1.insertBefore(5,4);
        assertEquals("[3, 8, 2, 5, 4]",l1.toString());
        assertEquals(5,l1.size());
        assertEquals(3,l1.head());
        assertEquals(4, l1.tail());
    }


    @Test
    void test_get() {
        LList<Integer> lst = new SLinkedList<>();
        for (int i = 0; i < 5; i++) lst.append(i);
        assertEquals(5,lst.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(i, lst.get(i));
            lst.append(i);
        }
    }

    @Test
    void testGet1(){
        LList<Integer> l1 = new SLinkedList<>();
        for (int i = 0; i < 5; i++) l1.append(i);
        assertEquals(5,l1.size());
        assertEquals(l1.head(), l1.get(0));
    }

    @Test
    void testGet2() {
        LList<Integer> l1 = new SLinkedList<>();
        for (int i = 0; i < 5; i++) l1.append(i);
        assertEquals(5,l1.size());
        assertEquals(l1.tail(),l1.get(l1.size()-1));
    }

    @Test
    void testGet3(){
        LList<Integer> l1 = new SLinkedList<>();
        for (int i = 0; i < 5; i++) l1.append(i);
        assertEquals(5,l1.size());
        assertEquals(2,l1.get(2));
    }

    @Test
    void testContains1(){
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(33);
        l1.append(21);
        assertEquals(true,l1.contains(21));
    }
    @Test
    void testContains2(){
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(33);
        l1.append(21);
        assertEquals(false,l1.contains(5));
    }
    @Test
    void testContains3(){
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(33);
        l1.append(21);
        l1.remove(21);
        assertEquals(false,l1.contains(21));
    }

    @Test
    void testRemove1() {
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(13);
        l1.append(21);
        l1.append(33);
        assertEquals(true,l1.remove(21));
        assertEquals("[13, 33]", l1.toString());
        assertEquals(2, l1.size());
        assertEquals(13, l1.head());
        assertEquals(33, l1.tail());
    }

    @Test
    void testRemove2(){
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(13);
        l1.append(21);
        l1.append(33);
        assertEquals(true, l1.remove(13));
        assertEquals("[21, 33]",l1.toString());
        assertEquals(2, l1.size());
        assertEquals(21, l1.head());
        assertEquals(33, l1.tail());
    }
    @Test
    void testRemove3(){
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(13);
        l1.append(21);
        l1.append(33);
        assertEquals(false,l1.remove(5));
        assertEquals(true, l1.remove(33));
        assertEquals(false,l1.remove(33));
        assertEquals("[13, 21]",l1.toString());
        assertEquals(2, l1.size());
        assertEquals(13, l1.head());
        assertEquals(21, l1.tail());
    }

    @Test
    void testRemove4(){
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(13);
        l1.append(21);
        l1.append(33);
        l1.append(21);
        l1.remove(21);
        assertEquals("[13, 33, 21]",l1.toString());
    }


}