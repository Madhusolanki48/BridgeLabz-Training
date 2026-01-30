package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 706
// Design a HashMap using array implementation.
public class DesignHashMap {
    static class MyHashMap {
        int size = (int) Math.pow(10, 6) + 1;
        int[] map;
        //constructor
        public MyHashMap() {
            map = new int[size];
            Arrays.fill(map, -1);
        }
        //put key-value pair
        public void put(int key, int value) {
            map[key] = value;
        }
        //get value
        public int get(int key) {
            return map[key];
        }

        // remove key
        public void remove(int key) {
            map[key] = -1;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 10);
        myHashMap.put(2, 20);

        System.out.println(myHashMap.get(1)); // 10
        System.out.println(myHashMap.get(3)); // -1
        myHashMap.put(2, 30);
        System.out.println(myHashMap.get(2)); // 30
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2)); // -1
    }
}

