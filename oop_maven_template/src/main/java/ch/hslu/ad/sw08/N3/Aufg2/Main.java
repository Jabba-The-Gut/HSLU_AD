package ch.hslu.ad.sw08.N3.Aufg2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private final static Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws InterruptedException {
		// Definiere Parameter fuer Simulation
		ParameterAndStats paramAndStats = new ParameterAndStats(2000, 6, 10);
		final ExecutorService service = Executors.newCachedThreadPool();

		// Erstelle die 3 Parkhaeuser
		CarPark carpark1 = new CarPark(1000, 10);
		CarPark carpark2 = new CarPark(1000, 15);
		CarPark carpark3 = new CarPark(1000, 17);

		// Erstelle 4 Threads, die die ExecutorServices erstellen und Tasks uebergeben
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 500; i++) {
					service.submit(new TakeTheCarParkAtTheHighwayCar(paramAndStats.getMimimalParkingTime(), carpark1,
							paramAndStats));
					service.submit(new ImNotPatientCar(paramAndStats.getMimimalParkingTime(),
							new CarPark[] { carpark1, carpark2, carpark3 }, paramAndStats));
					service.submit(new ImALittleBitPatientCar(paramAndStats.getMimimalParkingTime(),
							new CarPark[] { carpark1, carpark2, carpark3 }, paramAndStats));
					service.submit(new TryingMyLuckCar(paramAndStats.getMimimalParkingTime(),
							new CarPark[] { carpark1, carpark2, carpark3 }, paramAndStats));
				}

			}
		});
		
		// Starte Threads und damit Services
		thread1.start();

		// Warte dauer der Simulation
		Thread.currentThread().sleep(paramAndStats.getDuration());

		service.shutdownNow();

		LOG.info("Autos total: " + paramAndStats.getNbrOfCars());
		LOG.info("Autos parkeirt: " + paramAndStats.getCarsThatParked());
		LOG.info("Autos welche theorethisch wieder wegfahren muessten: "
				+ (paramAndStats.getNbrOfCars() - paramAndStats.getCarsThatParked()));
		LOG.info("Autos wieder weggefahren: " + paramAndStats.getCarsThatLeft());

	}

}
