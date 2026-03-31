package stringbuilder_stringbuffer;
import java.util.*;
//StringBuffer Problem 2: Compare StringBuffer with StringBuilder for String Concatenation

public class BufferVsBuilder {
    public static void main(String[] args) {
        int n = 1000000;    //given

        long start1 = System.nanoTime();
        //StringBuffer object
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++)
        	buffer.append("hello"); // buffer append
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        //StringBuilder object
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++)
        	builder.append("hello"); // builder append
        long end2 = System.nanoTime();

        System.out.println("StringBuffer time for String Concatenation (in ns): " + (end1 - start1));
        System.out.println("StringBuilder time for String Concatenation (in ns): " + (end2 - start2));
    }
}


