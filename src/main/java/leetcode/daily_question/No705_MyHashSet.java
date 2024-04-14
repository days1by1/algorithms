package leetcode.daily_question;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 * 难度：简单
 * 方法一：链地址法
 *
 * @author wangbo
 * @created 2024年04月14日 22:35
 */
public class No705_MyHashSet {

    private static final int BASE = 769;
    private LinkedList<Integer>[] data;

    @SuppressWarnings("unchecked")
    public No705_MyHashSet() {
        data = new LinkedList[BASE];
        Arrays.setAll(data, s -> new LinkedList<>());
    }

    public static void main(String[] args) {
        No705_MyHashSet myHashSet = new No705_MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }

    public void add(int key) {
        int h = hash(key);
        /*Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == key) return;
        }*/
        for (Integer next : data[h]) {
            if (next == key) return;
        }
        // data[h].offerLast(key);
        data[h].add(key);
    }

    public void remove(int key) {
        int h = hash(key);
        // 注意：LinkedList有remove(Object o)和remove(int index)之分，此处如果写成
        // `for (int e : data[h])` 就会按照索引来移除，可能会出现索引越界
        for (Integer e : data[h]) {
            if (e == key) {
                data[h].remove(e);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        for (Integer e : data[h]) {
            if (e == key) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    private static int hash(int key) {
        return key % BASE;
    }

}
