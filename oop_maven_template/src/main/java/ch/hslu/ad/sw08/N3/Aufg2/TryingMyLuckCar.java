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
public class TryingMyLuckCar implements Runnable {
	private final CarPark[] carParks;
	private final ParameterAndStats paramsAndStats;
	private final static Logger LOG = LogManager.getFormatterLogger(TryingMyLuckCar.class);

	public TryingMyLuckCar(final long minimumParkingTime, final CarPark[] carPark,
			final ParameterAndStats paramAndStats) {
		this.carParks = carPark;
		this.paramsAndStats = paramAndStats;
	}

	@Override
	public void run() {
		try {
			int carPark1Size = carParks[0].getFreeSpaces();
			int carPark2Size = carParks[1].getFreeSpaces();
			int carPark3Size = carParks[2].getFreeSpaces();

			if (carPark1Size > carPark2Size && carPark1Size > carPark3Size) {
				if (carParks[0].isFull()) {
					paramsAndStats.addCarThatLef();
				} else {
					Thread.currentThread().sleep(carParks[0].getTimeToReach());
					carParks[0].tryToPark(new Object());
					paramsAndStats.addParkedCar();
					carParks[0].leaveParkingSpace();
				}

			}

			if (carPark2Size > carPark1Size && carPark2Size > carPark3Size) {
				if (carParks[1].isFull()) {
					paramsAndStats.addCarThatLef();
				} else {
					Thread.currentThread().sleep(carParks[1].getTimeToReach());
					carParks[1].tryToPark(new Object());
					paramsAndStats.addParkedCar();
					carParks[1].leaveParkingSpace();
				}
			}
			if (carPark3Size > carPark2Size && carPark3Size > carPark1Size) {
				if (carParks[2].isFull()) {
					paramsAndStats.addCarThatLef();
				} else {
					Thread.currentThread().sleep(carParks[3].getTimeToReach());
					carParks[2].tryToPark(new Object());
					paramsAndStats.addParkedCar();
					carParks[2].leaveParkingSpace();
				}
			}
		} catch (Exception e) {
			paramsAndStats.addCarThatLef();
			LOG.error(e);
		}

	}

}
