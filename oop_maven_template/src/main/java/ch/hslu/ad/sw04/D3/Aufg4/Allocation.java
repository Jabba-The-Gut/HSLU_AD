package ch.hslu.ad.sw04.D3.Aufg4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.ad.sw04.D3.Aufg5.Main;

/**
 * Klasse, welche Speicher-Allokations-Objekte repraesentiert.
 * 
 * @author jabbathegut
 *
 */
public final class Allocation {
	private static final Logger LOG = LogManager.getLogger(Allocation.class);
	private int size;
	private int address;

	/**
	 * Konstruktor fuer Allokations-Objekte.
	 * 
	 * @param address
	 *            Adresse des Allokations-Objekt
	 * @param size
	 *            Groesse des Allokations-Objekt
	 * 
	 */
	public Allocation(final int address, final int size) {
		this.size = size;
		this.address = address;
	}

	public int getSize() {
		return this.size;
	}

	public int getAddress() {
		return this.address;
	}

	@Override
	public String toString() {
		return "Allocation [Address: " + this.getAddress() + "; Size: " + this.getSize() + "]";
	}

	/**
	 * Der Hash-Code wird aufgrund der Adresse generiert
	 */
	@Override
	public int hashCode() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage());
		}
		LOG.info("hashCode-Methode aufgerufen");
		return (Integer.hashCode(this.getAddress()));
	}

	/**
	 * Zwei Allocation-Objekte sind gleich, wenn sie die selben Objekte sind oder
	 * wenn sie vom selben Typ sind und die selbe Adresse haben
	 */
	@Override
	public boolean equals(Object obj) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage());
		}
		LOG.info("equals-Methode aufgerufen");
		if (obj == this) {
			return true;
		}
		if (obj instanceof Allocation) {
			final Allocation alloc = (Allocation) obj;
			if (alloc.getAddress() == this.getAddress()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
