package ru.otus.hw.les08.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayIniter {

    public static int[] getArray(int capacity) {
        var ret = new int[capacity];
        for (int i =0;i<capacity;i++) {
            ret[i] = ThreadLocalRandom.current().nextInt();
        }
        return ret;
    }

    public static void printArray(int[] array)
    {
        for (int val : array) {
            System.out.println(val);
        }
    }
}
