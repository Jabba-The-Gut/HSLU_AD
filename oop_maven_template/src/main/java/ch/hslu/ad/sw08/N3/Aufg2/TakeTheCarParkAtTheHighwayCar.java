package ch.hslu.ad.sw08.N3.Aufg2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Auto, welches das Parkhaus an der Autobahn nimmt, egal wie lange es warten
 * muss.
 * 
 * @author jabbathegut
 *
 */
public class TakeTheCarParkAtTheHighwayCar implements Runnable {
	private final CarPark carPark;
	private final ParameterAndStats paramsAndStats;
	private final static Logger LOG = LogManager.getFormatterLogger(TakeTheCarParkAtTheHighwayCar.class);

	public TakeTheCarParkAtTheHighwayCar(final long minimumParkingTime, final CarPark carPark,
			final ParameterAndStats paramAndStats) {
		this.carPark = carPark;
		this.paramsAndStats = paramAndStats;
	}

	@Override
	public void run() {
		try {
			Thread.currentThread().sleep(carPark.getTimeToReach());
			carPark.tryToPark(new Object());
			paramsAndStats.addParkedCar();
			Thread.currentThread().sleep(paramsAndStats.getMimimalParkingTime());
			carPark.leaveParkingSpace();
		} catch (Exception e) {
			LOG.error(e);
		}

	}

}
