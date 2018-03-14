package ch.hslu.ad.sw04.D3.Aufg2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Eigene Implementation eines HashTables. So implementiert, dass er bei
 * Kollisionen von Indexes aufgrund der Hash-Implementierung mittels Sondierung
 * umgehen kann!
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
	public boolean add(Allocation element) {
		final int hash = this.generateIndexFromHash(element);
		if (store[hash] == null) {
			store[hash] = element;
			return true;
		} else if (!store[hash].equals(element)) {
			int index = hash;
			while (index < store.length && store[index] != null) {
				index++;
			}
			if (index < store.length) {
				store[index] = element;
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public Allocation get(Allocation element) {
		final int hash = this.generateIndexFromHash(element);
		if (store[hash] == null) {
			return null;
		} else {
			if (!store[hash].equals(element)) {
				int index = hash;
				while (index < store.length && store[index] != null) {
					index++;
					if (index < store.length && store[index].equals(element) && !store[index].isTombstone()) {
						return store[index];
					}
				}
				return null;
			}
			if (!store[hash].isTombstone()) {
				return store[hash];
			}
			return null;
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

	/**
	 * Entfernt das uebergebene Element aus dem HashTable falls vorhanden. Falls das
	 * Element Teil einer Sondierungs-Reihe war, wird es durch ein neues
	 * Allokations-Element mit der isTombstone-Boolean auf True ersetzt.
	 */
	@Override
	public boolean remove(Allocation element) {
		if (this.get(element) == null) {
			return false;
		} else {
			int index = this.generateIndexFromHash(element);
			if (!store[this.generateIndexFromHash(element)].equals(element)) {
				while (store[index] != null) {
					index++;
					if (index < store.length && store[index] != null && store[index].equals(element)) {
						if (store[(index + 1)] == null) {
							store[index] = new Allocation(0, 0, false);
							return true;
						}
						store[index] = new Allocation(0, 0, true);
						return true;
					}
				}
				return false;
			}
			if (index < store.length && store[(index + 1)] != null) {
				store[this.generateIndexFromHash(element)] = new Allocation(0, 0, true);
				return true;
			} else {
				store[this.generateIndexFromHash(element)] = null;
				return true;
			}
		}
	}

	public boolean isFull() {
		boolean full = true;
		for (Allocation alloc : this.store) {
			if (alloc == null) {
				full = false;
			}
		}
		return full;
	}

}
