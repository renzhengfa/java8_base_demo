package com.kn20210406.collection;

import java.util.ArrayList;

/*
并发修改异常(加强for循环使用的迭代器遍历集合)
private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size;   // 1,2,3,4,5  length: 5  cursor==5
        }

        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
 */
public class ConCurrentModifyException1 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("11");
        list.add("11");
        list.add("22");
        list.add("22");
        list.add("33");
        list.add("33");
        for (Object o : list) {
            if (o.equals("33")){
                list.remove(o);
            }
        }

//        for (Object o : list) {
//            if (o.equals("22")){
//                list.remove(o);
//            }
//        }
    }

}
