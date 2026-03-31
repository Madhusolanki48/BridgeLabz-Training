package com.bridgelabz.junit;
import java.util.List;

public class ListManager {
	//method to add element to a list
	public void addElement(List<Integer> list, int element) {
		list.add(element);
		}
	//method to remove element to a list
	public void removeElement(List<Integer> list, int element) {
		list.remove(Integer.valueOf(element));
	}
	//method to get size
	public int getSize(List<Integer> list) {
        return list.size();
    }
	

}
