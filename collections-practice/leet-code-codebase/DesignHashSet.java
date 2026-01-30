package leet_code_codebase;
import java.util.*;

// LeetCode Problem: 705
// Design a HashSet using Java Collections.
public class DesignHashSet {
    static class MyHashSet {
        Set<Integer> set;
        //constructor
        public MyHashSet() {
            set = new HashSet<>();
        }

        //add key
        public void add(int key) {
            set.add(key);
        }

        //remove key
        public void remove(int key) {
            set.remove(key);
        }

        //method to check if key exists
        public boolean contains(int key) {
            return set.contains(key);
        }
    }
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1)); // true
        System.out.println(myHashSet.contains(3)); // false
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2)); // true
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2)); // false
    }
}
