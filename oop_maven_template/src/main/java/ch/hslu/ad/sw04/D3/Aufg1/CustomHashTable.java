package ch.hslu.ad.sw04.D3.Aufg1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Eigene Implementation eines HashTables. So implementiert, dass er nicht mit
 * Kollisionen beim selben Index umgehen kann!
 * 
 * @author jabbathegut
 *
 */

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

	/**
	 * Berechnet den Index fuer das einzufuegende Element, in dem der Hash des
	 * Elements verteilt an die Groesse der Datenstruktur gerechnet wird -->
	 * eindeutiger Index wenn nicht zweimal ein Element mit gleichem Hash eingefuegt
	 * wird
	 * 
	 * @param alloc
	 *            Objekt dass eingefuegt werden soll
	 * @return Index des alloc-Objekts basierend auf dem Hash
	 */
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
		if (this.get(element) == null) {
			return false;
		} else {
			store[this.generateIndexFromHash(element)] = null;
			return true;
		}
	}
}
