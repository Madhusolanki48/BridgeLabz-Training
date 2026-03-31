package queue_interface;
import java.util.*;

class CircularBufferQueue {
    private int[] buffer;
    private int size;
    private int index = 0;       //points to next insert position
    private boolean isFull = false;

    public CircularBufferQueue(int size) {
        this.size = size;
        buffer = new int[size];
    }

    //insert element, overwrite oldest if buffer is full
    public void insert(int value) {
        buffer[index] = value;
        index = (index + 1) % size;

        if (index == 0) isFull = true;
    }

    //return buffer elements in correct order (oldest -> newest)
    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();

        if (!isFull) {
            for (int i = 0; i < index; i++) {
                result.add(buffer[i]);
            }
        } else {
            for (int i = index; i < size; i++) {
                result.add(buffer[i]);
            }
            for (int i = 0; i < index; i++) {
                result.add(buffer[i]);
            }
        }

        return result;
    }
}

public class CircularBuffer {
    public static void main(String[] args) {
        CircularBufferQueue cb = new CircularBufferQueue(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println("Buffer after 1,2,3: " + cb.getBuffer());
        cb.insert(4);
        System.out.println("Buffer after insert 4: " + cb.getBuffer());
    }
}
