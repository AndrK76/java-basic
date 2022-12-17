package ru.otus.hw.les08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class SortComparer {
    static final int SAMPLE_SIZE = 2000000;
    static final boolean SHOW_RESULT = false;

    public static void main(String[] args) {
        int[] vals;
        ArraySorter sorter;
        System.out.println("Размер сэмпла: " + SAMPLE_SIZE);
        System.out.printf("Отладочный вывод %s\n", SHOW_RESULT ? "включен" : "выключен");
        if (SAMPLE_SIZE < 200000) {
            sorter = new BubleArraySorter();
            runTest(sorter);
        }

        sorter = new DefaultSorter();
        runTest(sorter);

        sorter = new HeapSorter();
        runTest(sorter);
    }

    static void runTest(ArraySorter sorter) {
        System.out.printf("\n%s\n", sorter.getName());
        System.out.printf(" start init sample...");
        int[] vals = ArrayIniter.getArray(SAMPLE_SIZE);
        System.out.printf(" sample inited, start sorting\n");
        long startTm = new Date().getTime();
        sorter.sort(vals);
        long endTm = new Date().getTime();
        System.out.printf("Sorting Complete, Sorting time: %d ms\n", endTm - startTm);
        if (SHOW_RESULT && SAMPLE_SIZE < 100) {
            ArrayIniter.printArray(vals);
        }
    }
}
