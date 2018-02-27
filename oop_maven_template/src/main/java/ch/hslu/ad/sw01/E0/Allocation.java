package ch.hslu.ad.sw01.E0;

import java.util.Objects;

public final class Allocation implements Comparable<Allocation> {

	private int size;
	private int address;

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
		return "Allocation[Address: " + this.getAddress() + "; Size: " + this.getSize() + "]";
	}

	/**
	 * Der Hash-Code wird aufgrund der Adresse generiert
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.getAddress());
	}

	/**
	 * Zwei Allocation-Objekte sind gleich, wenn sie von der selben Klasse und die
	 * selbe Adresse haben
	 */
	@Override
	public boolean equals(Object obj) {
		final Allocation alloc = (Allocation) obj;
		if (obj instanceof Allocation) {
			if (alloc.getAddress() == this.getAddress()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Zwei Allocation-Objekte werden aufgrund ihrer Groesse verglichen
	 */
	@Override
	public int compareTo(Allocation o) {
		return Integer.compare(this.size, o.getSize());
	}
}
