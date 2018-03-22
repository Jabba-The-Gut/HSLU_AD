package ch.hslu.ad.sw05.N1.Aufg2;

import java.util.ArrayList;
import java.util.List;

public class DemoAppThreads {

	public static void main(String[] args) {
		final List<AdditionTask> listOfTask = new ArrayList<>();
		listOfTask.add(new AdditionTask(0, 1000000));
		listOfTask.add(new AdditionTask(10000, 1000000000));
		listOfTask.add(new AdditionTask(10, 1000));
		listOfTask.add(new AdditionTask(0, 1000000000));
		final List<Thread> threads = new ArrayList<>();
		
		for(int i = 0; i < listOfTask.size(); i++) {
			threads.add(new Thread(listOfTask.get(i)));
			threads.get(i).setName("Thread " + i);
			threads.get(i).start();
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < listOfTask.size(); i++) {
			threads.get(i).interrupt();
		}
	}

}
