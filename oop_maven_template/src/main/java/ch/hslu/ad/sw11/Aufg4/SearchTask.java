package ch.hslu.ad.sw11.Aufg4;

import java.io.File;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchTask extends CountedCompleter<Integer> {
	private final String filename;
	private final File[] array;
	private final int min;
	private final int max;
	private final AtomicInteger result;
	private static final int THRESHOLD = 5;

	public SearchTask(final String filename, final File dir) {
		this(null, filename, dir.listFiles(), 0, dir.listFiles().length, new AtomicInteger(-1));
	}

	private SearchTask(final CountedCompleter<?> parent, final String filename, final File[] array, final int min,
			final int max, final AtomicInteger result) {
		super(parent);
		this.filename = filename;
		this.array = array;
		this.min = min;
		this.max = max;
		this.result = result;
	}

	@Override
	public void compute() {
		if ((max - min) <= THRESHOLD) {
			for (int i = min; i < max; i++) {
				if (array[i].isDirectory()) {
					this.findFile(filename, array[i], result);
				} else if(filename.equalsIgnoreCase(array[i].getName()) && result.compareAndSet(-1, i)) {
					this.quietlyCompleteRoot();
					break;
				}
			}
		} else {
			final int mid = min + (max - min) / 2;
			this.addToPendingCount(2);
			final SearchTask taskLeft = new SearchTask(this, filename, array, min, mid, result);
			taskLeft.fork();
			final SearchTask taskRight = new SearchTask(this, filename, array, mid, max, result);
			taskRight.fork();
		}
		this.tryComplete();
	}

	@Override
	public Integer getRawResult() {
		return result.get();
	}

	public void findFile(final String name, final File dir, final AtomicInteger result) {
		final File[] list = dir.listFiles();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory()) {
					findFile(name, list[i], result);
				} else if (name.equalsIgnoreCase(list[i].getName()) && result.compareAndSet(-1, i)) {
					this.quietlyCompleteRoot();
					break;
				}
			}
		}
	}

}
