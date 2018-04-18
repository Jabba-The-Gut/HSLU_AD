package ch.hslu.ad.sw08.N3.Aufg2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Auto, welches vom einten zum anderen Parkhaus geht, wenn das jeweilige voll
 * ist und wieder wegfaehrt wenn alle 3 voll sind, wobei es bei den Parkhaeusern
 * ein bisschen wartet.
 * 
 * @author jabbathegut
 *
 */
public class ImALittleBitPatientCar implements Runnable {
	private final CarPark[] carParks;
	private final ParameterAndStats paramsAndStats;
	private final static Logger LOG = LogManager.getFormatterLogger(ImALittleBitPatientCar.class);

	public ImALittleBitPatientCar(final long minimumParkingTime, final CarPark[] carPark,
			final ParameterAndStats paramAndStats) {
		this.carParks = carPark;
		this.paramsAndStats = paramAndStats;
	}

	@Override
	public void run() {
		try {
			Thread.currentThread().sleep(carParks[0].getTimeToReach());
			if (carParks[0].isFull()) {
				if (carParks[0].tryToPark(5, new Object())) {
					paramsAndStats.addParkedCar();
					carParks[0].leaveParkingSpace();
				} else {
					Thread.currentThread().sleep(carParks[1].getTimeToReach());
					if (carParks[1].tryToPark(5, new Object())) {
						paramsAndStats.addParkedCar();
						carParks[1].leaveParkingSpace();
					} else {
						Thread.currentThread().sleep(carParks[2].getTimeToReach());
						if (carParks[2].tryToPark(5, new Object())) {
							paramsAndStats.addParkedCar();
							carParks[2].leaveParkingSpace();
						} else {
							paramsAndStats.addCarThatLef();
						}
					}
				}
			} else {
				carParks[0].tryToPark(new Object());
				paramsAndStats.addParkedCar();
			}

		} catch (Exception e) {
			paramsAndStats.addCarThatLef();
			LOG.error(e);
		}

	}

}
