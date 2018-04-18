package ch.hslu.ad.sw08.N3.Aufg2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class CarPark {
	private final int capacity;
	private final ArrayBlockingQueue<Object> parkingPlaces;
	private final long timeToReach;

	public CarPark(final int capacity, final long timeToReach) {
		this.capacity = capacity;
		this.timeToReach = timeToReach;
		this.parkingPlaces = new ArrayBlockingQueue<>(this.capacity, true);
	}
	
	public void tryToPark(final Object object) throws InterruptedException {
		parkingPlaces.offer(object);
	}

	public boolean tryToPark(final long timeout, final Object object) throws InterruptedException {
		return parkingPlaces.offer(object, timeout, TimeUnit.MILLISECONDS);
	}

	public void leaveParkingSpace() {
		parkingPlaces.poll();
	}
	
	public long getTimeToReach() {
		return this.timeToReach;
	}
	
	public boolean isFull() {
		return parkingPlaces.size() == this.capacity ? true : false;
	}
	
	public int getFreeSpaces(){
		return ((this.capacity - parkingPlaces.size()) < this.capacity ) ? (this.capacity - parkingPlaces.size()) : 0;
	}

}
