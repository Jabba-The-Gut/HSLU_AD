package ch.hslu.ad.sw01.E0;

import java.util.LinkedList;

public class MemorySimple implements Memory {

	private int totalSize;
	private LinkedList<Allocation> allocations;

	public MemorySimple(final int size) {
		allocations = new LinkedList<>();
		this.totalSize = size;
	}

	@Override
	public Allocation malloc(int size) {
		Allocation allocation = new Allocation(allocations.stream().mapToInt(i -> i.getSize()).sum(), size);
		allocations.add(allocation);
		return allocation;
	}

	@Override
	public void free(Allocation alloc) {
		allocations.remove(alloc);
	}

	@Override
	public String toString() {
		int sum = allocations.stream().mapToInt(i -> i.getSize()).sum();
		return "MemorySimple[Belegt: " + sum + "; Frei: " + (this.totalSize - sum) + "]";
	}

}
