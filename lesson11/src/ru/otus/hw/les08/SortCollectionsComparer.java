package ru.otus.hw.les08;

import ru.otus.hw.les08.collections.*;

import java.util.Date;

public class SortCollectionsComparer {
    static final int SAMPLE_SIZE = 2000000;
    static final boolean SHOW_RESULT = false;

    public static void main(String[] args) {
        CollectionSorter sorter;
        System.out.println("Размер сэмпла: " + SAMPLE_SIZE);
        System.out.printf("Отладочный вывод %s\n", SHOW_RESULT ? "включен" : "выключен");
        if (SAMPLE_SIZE < 200000) {
            sorter = new BubleCollectionSorter();
            runTest(sorter);
        }

        sorter = new DefaultSorter();
        runTest(sorter);

        sorter = new HeapSorter();
        runTest(sorter);
    }

    static void runTest(CollectionSorter sorter) {
        System.out.printf("\n%s\n", sorter.getName());
        System.out.printf(" start init sample...");
        var vals = CollectionIniter.getArray(SAMPLE_SIZE);
        System.out.printf(" sample invited, start sorting\n");
        long startTm = new Date().getTime();
        sorter.sort(vals);
        long endTm = new Date().getTime();
        System.out.printf("Sorting Complete, Sorting time: %d ms\n", endTm - startTm);
        if (SHOW_RESULT && SAMPLE_SIZE < 100) {
            CollectionIniter.printArray(vals);
        }
    }
}
