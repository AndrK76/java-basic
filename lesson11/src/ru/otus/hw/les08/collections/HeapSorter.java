package ru.otus.hw.les08.collections;


import java.util.ArrayList;

public class HeapSorter implements CollectionSorter {
    @Override
    public void sort(ArrayList<Integer> array) {
        int n = array.size();

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array.get(0);
            array.set(0, array.get(i));
            array.set(i, temp);

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
    // индексом в arr[]. n - размер кучи
    void heapify(ArrayList<Integer> arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr.get(l) > arr.get(largest))
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr.get(r) > arr.get(largest))
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }


    @Override
    public String getName() {
        return "Пирамидальная сортировка";
    }
}
