package functional_interface;

public class BackgroundJobExecution {
    public static void main(String[] args) {

    	//runnable task for background execution
        Runnable job = () -> {
            System.out.println("Background task running...");
        };

        //start task in a new thread
        Thread thread = new Thread(job);
        thread.start();
    }
}

