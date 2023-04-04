import java.util.Random;

public class Lab1_2_a_b {
    //QuickSort
    // Допоміжна функція для обміну місцями двох елементів

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* Ця функція бере останній елемент як опору, розміщує
      поворотний елемент у правильному положенні відсортовано
      масив і розміщує всі менші розміри (менше опорної точки)
      ліворуч від опори, а всі більші елементи – праворуч
      опори */
    static int partition(int[] arr, int low, int high)
    {

        // опорний елемент
        int pivot = arr[high];

        // Індекс меншого елемента
        // вказує правильну позицію
        // опорної точки, знайденої на даний момент
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // Якщо поточний елемент менший
            // ніж опорний
            if (arr[j] < pivot) {


                // Індекс збільшення
                // менший елемент
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* Основна функція, яка реалізує QuickSort
              arr[] --> Масив для сортування,
              low --> Початковий індекс,
              high --> Кінцевий індекс
      */
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
            // pi - індекс поділу, arr[p]
            // зараз у потрібному місці
            int pi = partition(arr, low, high);
            // Окремо сортувати елементи раніше
            // розділ і після розділу
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    //MergeSort
    // Об’єднує два підмасиви arr[].
    // Перший підмасив arr[l..m]
    // Другий підмасив arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // Знаходить розміри двох підмасивів, які потрібно об’єднати
        int n1 = m - l + 1;
        int n2 = r - m;

        //Створити тимчасові масиви
        int[] L = new int[n1];
        int[] R = new int[n2];

        //Копіювати дані до тимчасових масивів
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        //Об’єднайте тимчасові масиви

        // Початковий індекс першого та другого підмасивів
        int i = 0, j = 0;

        // Початковий індекс об’єднаного масиву підмасиву
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //Скопіює решту елементів L[], якщо такі є
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        //Скопіює решту елементів R[], якщо такі є
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Основна функція, яка сортує arr[l..r] за допомогою
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Знаходить середню точку
            int m = l + (r - l) / 2;

            // Розсортовує першу та другу половинки
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // З’єднує відсортовані половинки
            merge(arr, l, m, r);
        }
    }








    public static void main(String[] args) {
        long[] time_quicksort = new long[3];
        long[] time_mergesort = new long[3];
        int[] n_i = {10000, 100000, 1000000};

        for (int i_n = 0; i_n < n_i.length; i_n++ ){
            long count_time_guick = 0;
            long count_time_merge = 0;
            for (int pos = 0; pos < 100; pos++) {
                int n = n_i[i_n];
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = i + 1;
                }

                Random rnd = new Random();
                for (int i = 0; i < arr.length; i++) {
                    int index = rnd.nextInt(i + 1);
                    int a = arr[index];
                    arr[index] = arr[i];
                    arr[i] = a;
                }
                int[] arr1 = new int[n];
                for (int i = 0; i < n; i++){
                    arr1[i] = arr[i];
                }

                long start1 = System.nanoTime();
                int low = 0;
                int high = arr.length - 1;
                quickSort(arr, low, high);
                long end1 = System.nanoTime();
                long time1 = end1 - start1;
                count_time_guick += time1;


                if(pos == 99){
                    time_quicksort[i_n] = count_time_guick;
                }




                long start2 = System.nanoTime();
                MergeSort ob = new MergeSort();
                ob.sort(arr1, 0, arr1.length - 1);
                long end2 = System.nanoTime();
                long time2 = end2 - start2;
                count_time_merge += time2;
                if(pos == 99){
                    time_mergesort[i_n] = count_time_merge;
                }


            }
        }

        System.out.println("QuickSort: ");
        for (int p = 0; p < n_i.length; p++){
            System.out.println("Time in nanoseconds for n = " + n_i[p] + " equals to " + time_quicksort[p] + " for 100 arrays");
            System.out.println("Average time in nanoseconds for 1 array equals to " + time_quicksort[p] / 100 + " for n = " + n_i[p]);
            System.out.println("Average time in nanoseconds for one element when n = " + n_i[p] + " equals to " + time_quicksort[p] / ( 100 * n_i[p]));
            System.out.println("\n");

        }

        System.out.println("MergeSort: ");
        for (int p = 0; p < n_i.length; p++){
            System.out.println("Time in nanoseconds for n = " + n_i[p] + " equals  to " + time_mergesort[p] + " for 100 arrays");
            System.out.println("Average time in nanoseconds for 1 array equals to " + time_mergesort[p] / 100 + " for n = " + n_i[p]);
            System.out.println("Average time in nanoseconds for one element when n = " + n_i[p] + " equals to " + time_mergesort[p] / ( 100 * n_i[p]));
            System.out.println("\n");
        }


        int n_b = 100000;
        double log1 =  Math.log(n_b);
        double n_b_quick = time_quicksort[1] / (n_b * log1);
        double n_b_merge = time_mergesort[1] / (n_b * log1);
        System.out.println("Cq = " + n_b_quick);
        System.out.println("Cm = " + n_b_merge);

        int[] n_n = {1000000, 10000000};

        double[] n_b_quick_new_array = new double[2];
        double[] n_b_merge_new_array = new double[2];
        for (int i = 0; i < n_n.length; i++){
            double n_b_quick_new = n_b_quick * n_n[i] * Math.log(n_n[i]);
            double n_b_merge_new = n_b_merge * n_n[i] * Math.log(n_n[i]);
            System.out.println("QuickSort. For n = " +  n_n[i] + " prediction time equal to " + n_b_quick_new);
            n_b_quick_new_array[i] = n_b_quick_new;
            System.out.println("MergeSort. For n = " +  n_n[i] + " prediction time equal to " + n_b_merge_new);
            n_b_merge_new_array[i] = n_b_merge_new;
            System.out.println("\n");
        }

        long[] time_quicksort1 = new long[2];
        long[] time_mergesort1 = new long[2];
        int[] n_i1 = {1000000, 10000000};


        for (int i_n = 0; i_n < n_i1.length; i_n++ ){
            long count_time_guick1 = 0;
            long count_time_merge1 = 0;
            for (int pos = 0; pos < 100; pos++) {
                int n = n_i1[i_n];
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = i + 1;
                }

                Random rnd = new Random();
                for (int i = 0; i < arr.length; i++) {
                    int index = rnd.nextInt(i + 1);
                    int a = arr[index];
                    arr[index] = arr[i];
                    arr[i] = a;
                }
                int[] arr1 = new int[n];
                for (int i = 0; i < n; i++){
                    arr1[i] = arr[i];
                }

                long start1 = System.nanoTime();
                int low = 0;
                int high = arr.length - 1;
                quickSort(arr, low, high);
                long end1 = System.nanoTime();
                long time1 = end1 - start1;
                count_time_guick1 += time1;


                if(pos == 99){
                    time_quicksort1[i_n] = count_time_guick1;
                }




                long start2 = System.nanoTime();
                MergeSort ob = new MergeSort();
                ob.sort(arr1, 0, arr1.length - 1);
                long end2 = System.nanoTime();
                long time2 = end2 - start2;
                count_time_merge1 += time2;
                if(pos == 99){
                    time_mergesort1[i_n] = count_time_merge1;
                }


            }
        }
        for (int i = 0; i < n_n.length; i++){
            System.out.println("QuickSort. For n = " +  n_i1[i] + " real time equal to " + time_quicksort1[i]);
            System.out.println("MergeSort. For n = " +  n_i1[i] + " real time equal to " + time_mergesort1[i]);
            System.out.println("\n");
            System.out.println("QuickSort. Real - predicted equals to " + (time_quicksort1[i] - n_b_quick_new_array[i]));
            System.out.println("MergeSort. Real - predicted equals to " + (time_mergesort1[i] - n_b_merge_new_array[i]));
            System.out.println("\n");
        }
    }
}


