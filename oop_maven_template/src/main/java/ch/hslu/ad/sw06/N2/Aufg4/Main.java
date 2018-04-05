package ch.hslu.ad.sw06.N2.Aufg4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static Semaphore semaphore;
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		semaphore = new Semaphore(6, 6);

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 6; i++) {
					try {
						semaphore.acquire();
						LOG.info("Aquired a Semaphore");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 6; i++) {
					semaphore.release();
					LOG.info("Released a Semaphore");
				}

			}
		});

		thread.start();
		thread2.start();

	}

}
