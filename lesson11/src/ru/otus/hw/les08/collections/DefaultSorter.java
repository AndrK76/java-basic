package ru.otus.hw.les08.collections;

import ru.otus.hw.les08.arrays.ArraySorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DefaultSorter implements CollectionSorter {
    @Override
    public void sort(ArrayList<Integer> array) {
        Collections.sort(array);
    }

    @Override
    public String getName() {
        return "Встроенный алгоритм сортировки";
    }
}
