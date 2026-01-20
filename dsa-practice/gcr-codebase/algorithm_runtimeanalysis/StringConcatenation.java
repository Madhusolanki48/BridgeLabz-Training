package algorithm_runtimeanalysis;
import java.util.*;
public class StringConcatenation {
	public static void main(String[] args) {
        int N = 100000; // increase for big test
        long start, end;

        //string concat -> O(N^2)
        start = System.nanoTime();
        String s = "";
        for (int i = 0; i < N; i++)
        	s += "a"; // creates new object every time
        end = System.nanoTime();
        System.out.println("String Time when concatenating a million strings: " + (end - start) / 1_000_000.0 + " ms");

        //stringBuilder -> O(N)
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
        	sb.append("a"); // mutable fast
        end = System.nanoTime();
        System.out.println("StringBuilder Time when concatenating a million strings: " + (end - start) / 1_000_000.0 + " ms");

        //stringBuffer -> O(N)
        start = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < N; i++)
        	sf.append("a"); // thread-safe slower
        end = System.nanoTime();
        System.out.println("StringBuffer Time when concatenating a million strings: " + (end - start) / 1_000_000.0 + " ms");
    }
}
