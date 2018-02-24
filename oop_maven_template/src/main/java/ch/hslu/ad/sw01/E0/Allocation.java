package ch.hslu.ad.sw01.E0;

public final class Allocation {

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
	
	
}
