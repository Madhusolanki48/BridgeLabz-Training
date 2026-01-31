package com.bridgelabz.junit;

public class PerformanceTask {
	//method that takes 3 seconds to execute
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); 
//        Thread.sleep(1000);
        return "Task Completed";
    }

}
