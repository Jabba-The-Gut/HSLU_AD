package ch.hslu.ad.sw04.D3.Aufg2;

/**
 * Klasse, welche Speicher-Allokations-Objekte repraesentiert.
 * 
 * @author jabbathegut
 *
 */
public final class Allocation {

	private int size;
	private int address;
	private boolean isTombstone;

	/**
	 * Konstruktor fuer Allokations-Objekte.Der Parameter tombstone soll immer auf
	 * false sein beim normalen Gebrauch, er wird nur in der remove()-Methode der
	 * CustomHashTable-Datenstruktur auf true gesetzt, falls das zu entfernende
	 * Element Teil einer Sondierungsreihe war.
	 * 
	 * @param address
	 *            Adresse des Allokations-Objekt
	 * @param size
	 *            Groesse des Allokations-Objekt
	 * @param tombstone
	 *            Normalerweise immer auf false, nur bei Verwendung in der
	 *            remove()-Methode der CustomHashTable-Klasse auf true
	 */
	public Allocation(final int address, final int size, boolean tombstone) {
		this.isTombstone = tombstone;
		this.size = size;
		this.address = address;
	}

	public int getSize() {
		return this.size;
	}

	public int getAddress() {
		return this.address;
	}

	public boolean isTombstone() {
		return this.isTombstone;
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
		return (Integer.hashCode(this.getAddress()));
	}

	/**
	 * Zwei Allocation-Objekte sind gleich, wenn sie die selben Objekte sind oder
	 * wenn sie vom selben Typ sind und die selbe Adresse haben
	 */
	@Override
	public boolean equals(Object obj) {
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
