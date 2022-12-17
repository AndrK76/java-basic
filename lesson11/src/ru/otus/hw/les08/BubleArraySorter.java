package ru.otus.hw.les08;

public class BubleArraySorter implements ArraySorter {
    @Override
    public void sort(int[] array) {
        int temp;
        for (int k = array.length - 1; k > 0; k--) {
            for (int i = 0; i < k; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Сортировка \"Пузырьком\"";
    }
}
