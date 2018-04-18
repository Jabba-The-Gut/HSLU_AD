package ch.hslu.ad.sw08.N3.Aufg2;

import java.util.concurrent.atomic.AtomicInteger;

public class ParameterAndStats {
	private AtomicInteger carsThatParked;
	private AtomicInteger carsThatLeft;
	private final int nbrOfCars;
	private final long duration;
	private final long minimalParkingTime;

	public ParameterAndStats(final int nbrOfCars, final int durationHours, final long minimalParkingTime) {
		this.carsThatLeft = new AtomicInteger(0);
		this.carsThatParked = new AtomicInteger(0);
		this.nbrOfCars = nbrOfCars;
		this.duration = (durationHours * 600);
		this.minimalParkingTime = minimalParkingTime;
	}

	public int getNbrOfCars() {
		return this.nbrOfCars;
	}

	public long getDuration() {
		return this.duration;
	}
	
	public int getCarsThatParked() {
		return this.carsThatParked.get();
	}
	
	public int getCarsThatLeft() {
		return this.carsThatLeft.get();
	}
	
	public long getMimimalParkingTime() {
		return this.minimalParkingTime;
	}

	public void addParkedCar() {
		carsThatParked.incrementAndGet();
	}

	public void addCarThatLef() {
		carsThatLeft.incrementAndGet();
	}

}
