package ru.otus.hw.les08.collections;


import java.util.ArrayList;

public class BubleCollectionSorter implements CollectionSorter {
    @Override
    public void sort(ArrayList<Integer> array) {
        int temp;
        for (int k = array.size() - 1; k > 0; k--) {
            for (int i = 0; i < k; i++) {
                if (array.get(i) > array.get(i + 1)) {
                    temp = array.get(i);
                    array.set(i, array.get(i + 1));
                    array.set(i + 1, temp);
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Сортировка \"Пузырьком\"";
    }
}
