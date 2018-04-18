package ch.hslu.ad.sw08.N3.Aufg2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Auto, welches vom einten zum anderen Parkhaus geht, wenn das jeweilige voll
 * ist und wieder wegfaehrt wenn alle 3 voll sind, wobei es nicht wartet, wenn
 * ein Parkhaus voll ist.
 * 
 * @author jabbathegut
 *
 */
public class ImNotPatientCar implements Runnable {
	private final CarPark[] carParks;
	private final ParameterAndStats paramsAndStats;
	private final static Logger LOG = LogManager.getFormatterLogger(ImNotPatientCar.class);

	public ImNotPatientCar(final long minimumParkingTime, final CarPark[] carPark,
			final ParameterAndStats paramAndStats) {
		this.carParks = carPark;
		this.paramsAndStats = paramAndStats;
	}

	@Override
	public void run() {
		try {
			Thread.currentThread().sleep(carParks[0].getTimeToReach());
			if (carParks[0].isFull()) {
				Thread.currentThread().sleep(carParks[1].getTimeToReach());
				if (carParks[1].isFull()) {
					Thread.currentThread().sleep(carParks[2].getTimeToReach());
					if (carParks[2].isFull()) {
						paramsAndStats.addCarThatLef();
					} else {
						carParks[2].tryToPark(new Object());
						paramsAndStats.addParkedCar();
						Thread.currentThread().sleep(paramsAndStats.getMimimalParkingTime());
						carParks[2].leaveParkingSpace();
					}
				} else {
					carParks[1].tryToPark(new Object());
					paramsAndStats.addParkedCar();
					Thread.currentThread().sleep(paramsAndStats.getMimimalParkingTime());
					carParks[1].leaveParkingSpace();
				}
			} else {
				carParks[0].tryToPark(new Object());
				paramsAndStats.addParkedCar();
				Thread.currentThread().sleep(paramsAndStats.getMimimalParkingTime());
				carParks[0].leaveParkingSpace();
			}

		} catch (Exception e) {
			paramsAndStats.addCarThatLef();
			LOG.error(e);
		}

	}

}
