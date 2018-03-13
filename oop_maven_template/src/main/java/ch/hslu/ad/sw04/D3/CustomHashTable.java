package ch.hslu.ad.sw04.D3;

import javax.sound.sampled.Line;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomHashTable implements HashDataStructure<Allocation> {
	private Allocation[] store;
	private static final Logger LOG = LogManager.getLogger(CustomHashTable.class);

	public CustomHashTable(int size) {
		store = new Allocation[size];
	}

	@Override
	public void add(Allocation element) {
		store[this.generateIndexFromHash(element)] = element;
	}

	@Override
	public Allocation get(Allocation element) {
		if (store[this.generateIndexFromHash(element)] == null) {
			return null;
		} else {
			return store[this.generateIndexFromHash(element)];
		}

	}

	private int generateIndexFromHash(Allocation alloc) {
		return (alloc.hashCode() % store.length);
	}

	@Override
	public String toString() {
		StringBuilder contains = new StringBuilder();
		contains.append(System.getProperty("line.separator"));
		for (int i = 0; i < store.length; i++) {
			contains.append(store[i] != null ? "[Index: " + i + " , " + store[i].toString() + " ]"
					: "[Index: " + i + " , Leer ]");
			contains.append(System.getProperty("line.separator"));
		}
		return contains.toString();
	}

	@Override
	public boolean remove(Allocation element) {
		if(this.get(element) == null) {
			return false;
		} else {
			store[this.generateIndexFromHash(element)] = null;
			return true;
		}
	}

}
