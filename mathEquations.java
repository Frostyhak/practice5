import java.util.Arrays;

public class lab06 {

    public static void main(String[] args) {
        System.out.println("=== Тестування сортування вибором (Selection Sort) ===");
        testSelectionSort();

        System.out.println("\n=== Тестування сортування вставкою (Insertion Sort) ===");
        testInsertionSort();
    }

    /**
     * Сортування вибором (Selection Sort) для double[] за зростанням.
     *
     * @param array масив для сортування
     * @throws NullPointerException     якщо array null
     * @throws IllegalArgumentException якщо array порожній
     */
    public static void selectionSort(double[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                double temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * Сортування вставкою (Insertion Sort) для double[] за зростанням.
     *
     * @param array масив для сортування
     * @throws NullPointerException     якщо array null
     * @throws IllegalArgumentException якщо array порожній
     */
    public static void insertionSort(double[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        int n = array.length;
        for (int i = 1; i < n; i++) {
            double key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private static void testSelectionSort() {
        // Коректні дані
        try {
            double[] arr1 = {3.5, -2.1, 10.0, 0.0, -8.4, 7.2};
            System.out.println("Вхідний:  " + Arrays.toString(arr1));
            selectionSort(arr1);
            System.out.println("Відсортований: " + Arrays.toString(arr1));

            double[] arr2 = {5.0};
            System.out.println("Один елемент: " + Arrays.toString(arr2));
            selectionSort(arr2);
            System.out.println("Результат:     " + Arrays.toString(arr2));
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // Перевірка винятків
        try {
            System.out.print("Тест null: ");
            selectionSort(null);
        } catch (NullPointerException e) {
            System.out.println("Спіймано: " + e.getMessage());
        }

        try {
            System.out.print("Тест порожній: ");
            selectionSort(new double[]{});
        } catch (IllegalArgumentException e) {
            System.out.println("Спіймано: " + e.getMessage());
        }
    }

    private static void testInsertionSort() {
        // Коректні дані
        try {
            double[] arr1 = {12.4, -3.0, 5.5, 5.5, 0.1, -10.0};
            System.out.println("Вхідний:  " + Arrays.toString(arr1));
            insertionSort(arr1);
            System.out.println("Відсортований: " + Arrays.toString(arr1));
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // Перевірка винятків
        try {
            System.out.print("Тест null: ");
            insertionSort(null);
        } catch (NullPointerException e) {
            System.out.println("Спіймано: " + e.getMessage());
        }

        try {
            System.out.print("Тест порожній: ");
            insertionSort(new double[]{});
        } catch (IllegalArgumentException e) {
            System.out.println("Спіймано: " + e.getMessage());
        }
    }
}