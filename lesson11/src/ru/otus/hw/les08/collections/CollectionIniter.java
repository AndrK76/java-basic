package ru.otus.hw.les08.collections;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CollectionIniter {

    public static ArrayList<Integer> getArray(int capacity) {
        var ret = new ArrayList<Integer>(capacity);
        for (int i =0;i<capacity;i++) {
            ret.add( ThreadLocalRandom.current().nextInt());
        }
        return ret;
    }

    public static void printArray(ArrayList<Integer> array)
    {
        for (int val : array) {
            System.out.println(val);
        }
    }
}
