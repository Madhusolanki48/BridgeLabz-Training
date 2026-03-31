package com.bridgelabz.junit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceTaskTest {
    //test fails if execution exceeds 2 seconds
    @Test
    @Timeout(2) //timeout in seconds
    void testLongRunningTaskTimeout() throws InterruptedException {
        PerformanceTask task = new PerformanceTask();
        assertEquals("Task Completed", task.longRunningTask());
        
    }
}

