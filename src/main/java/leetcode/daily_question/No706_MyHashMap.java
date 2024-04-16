package leetcode.daily_question;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 706. 设计哈希映射
 * 难度：简单
 * 标签：数组、哈希表、链表、哈希函数
 *
 * @author wangbo
 * @created 2024年04月15日 19:49
 */
public class No706_MyHashMap {

    private static final int BASE = 769;
    private final LinkedList<Pair>[] data;

    @SuppressWarnings("unchecked")
    public No706_MyHashMap() {
        data = new LinkedList[BASE];
        Arrays.setAll(data, s -> new LinkedList<Pair>());
    }

    public static void main(String[] args) {
        No706_MyHashMap myHashMap = new No706_MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println("myHashMap: " + myHashMap);
        System.out.println("myHashMap.get(1): " + myHashMap.get(1));
        System.out.println("myHashMap.get(3): " + myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println("myHashMap.get(2): " + myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println("myHashMap.get(2): " + myHashMap.get(2));
    }

    public void put(int key, int value) {
        int h = hash(key);
        for (Pair e : data[h]) {
            if (e.getKey() == key) {
                e.setValue(value);
                return;
            }
        }
        data[h].offerLast(new Pair(key, value));
    }

    public int get(int key) {
        int h = hash(key);
        for (Pair e : data[h]) {
            if (e.getKey() == key) {
                return e.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        for (Pair e : data[h]) {
            if (e.getKey() == key) {
                data[h].remove(e);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    private static int hash(int key) {
        return key % BASE;
    }

    private class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.key + "=" + this.value;
        }
    }

}
