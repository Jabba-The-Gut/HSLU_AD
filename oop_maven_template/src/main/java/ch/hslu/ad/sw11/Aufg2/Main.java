package ch.hslu.ad.sw11.Aufg2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.ad.sw10.Aufg2.Sort;

import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);


    public static void main(final String[] args) {
        int sizeOfArray = 200_000;
        int TRESHOLD = 50_000_000;
        char[] a = ParallelQuickSortTask.randomChars(sizeOfArray);
        final ForkJoinPool pool = new ForkJoinPool();
        final ParallelQuickSortTask pQS = new ParallelQuickSortTask(a);

        long start = System.currentTimeMillis();
        pool.invoke(pQS);
        long finish = System.currentTimeMillis();
        LOG.info("Parallel Quicksort mit " + sizeOfArray + " Elementen: " + (finish - start) + " ms");

        long start2 = System.currentTimeMillis();
        Sort.quickSort(a);
        long finish2 = System.currentTimeMillis();
        LOG.info("Quicksort          mit " + sizeOfArray + " Elementen: " + (finish2 - start2) + " ms");

        long start3 = System.currentTimeMillis();
        long finish3 = System.currentTimeMillis();
        LOG.info("QuickInsertionSort mit " + sizeOfArray + " Elementen: " + (finish3 - start3) + " ms");




    }
}