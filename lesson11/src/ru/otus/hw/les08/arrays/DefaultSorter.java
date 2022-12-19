package ru.otus.hw.les08.arrays;

import java.util.Arrays;

public class DefaultSorter implements ArraySorter {
    @Override
    public void sort(int[] array) {
        Arrays.sort(array);
    }

    @Override
    public String getName() {
        return "Встроенный алгоритм сортировки";
    }
}
