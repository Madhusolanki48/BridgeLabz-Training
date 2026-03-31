package multithreading;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

class FileDownloadTask implements Runnable {
	private final String fileName;
	private final String threadName;
	private final Random random = new Random();
	private final CountDownLatch latch;

	public FileDownloadTask(String fileName, CountDownLatch latch) {
		this.fileName = fileName;
		this.threadName = "Downloader-" + fileName.split("\\.")[0];
		this.latch = latch;
	}

	@Override
	public void run() {
		Thread.currentThread().setName(threadName);

		System.out.println("[" + threadName + "] Started: " + fileName);

		for (int percent = 0; percent <= 100; percent += 5) {
			try {
				Thread.sleep(50 + random.nextInt(400));
			} catch (InterruptedException e) {
				System.out.println("[" + threadName + "] Interrupted!");
				latch.countDown();
				return;
			}

			System.out.printf("[%s] %s: %d%%\n", threadName, fileName, percent);
		}

		System.out.println("[" + threadName + "] Finished: " + fileName);
		latch.countDown();
	}
}

public class DownloadManagerRunnable {
	public static void main(String[] args) {
		System.out.println("Main thread started: " + Thread.currentThread().getName());

		String[] files = { "Document.pdf", "Image.jpg", "Video.mp4" };
		CountDownLatch latch = new CountDownLatch(files.length);

		for (String file : files) {
			Thread t = new Thread(new FileDownloadTask(file, latch));
			t.start();
		}

		try {
			latch.await(); // waits until all latches are counted down to 0
			System.out.println("\nAll downloads complete!");
		} catch (InterruptedException e) {
			System.out.println("Main interrupted while waiting for downloads");
		}

		System.out.println("Main thread finished.");
	}
}