package ch.hslu.ad.sw04.D3;

public class CustomHashTable implements HashDataStructure<Allocation> {
	private Allocation[] store;

	public CustomHashTable(int size) {
		store = new Allocation[size];
	}

	@Override
	public void add(Allocation element) {
		store[this.generateIndexFromHash(element)] = element;
	}

	@Override
	public void get(Allocation element) {
		// TODO Auto-generated method stub

	}

	private int generateIndexFromHash(Allocation alloc) {
		return (alloc.hashCode() % store.length);
	}

}
