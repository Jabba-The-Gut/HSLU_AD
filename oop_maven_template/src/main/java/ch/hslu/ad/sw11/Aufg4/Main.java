package ch.hslu.ad.sw11.Aufg4;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private final static Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		final File dir = new File("C:\\Users\\Dave\\Downloads");
		final ForkJoinPool pool = new ForkJoinPool();

		final SearchTask task = new SearchTask("copying.txt", dir);
		pool.invoke(task);
		// TODO: SearchTaks works correctly, but sets the wrong index as result
		LOG.info(task.getRawResult() == -1 ? "Datei nicht gefunden"
				: "Datei  in Verzeichnis: " + dir.listFiles()[task.getRawResult()].getParentFile());
	}

}
