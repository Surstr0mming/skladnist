import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;


public class Lab1_2_d {
    private static int count = 0;

    private static int count_quick_merge = 0;

    private static int[] peres_quick_9 = new int[362880];
    private static int[] peres_quick_10 = new int[3628800];
    private static int[] peres_merge_9 = new int[362880];
    private static int[] peres_merge_10 = new int[3628800];



    /* Ця функція бере останній елемент як опору, розміщує
      поворотний елемент у правильному положенні відсортовано
      масив і розміщує всі менші розміри (менше опорної точки)
      ліворуч від опори, а всі більші елементи – праворуч
      опори */
    static int partition(int[] arr, int low, int high) {

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
                count_quick_merge++;
                swap(arr, i, j);
            }
            else {
                count_quick_merge++;
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
    static void quickSort(int[] arr, int low, int high) {
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

    void merge(int array[], int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        // fill the left and right array
        for (int i = 0; i < n1; i++)
            L[i] = array[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = array[q + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        // for sorting in descending
        // use if(L[i] >= <[j])
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                array[k] = L[i];
                i++;
                count_quick_merge++;
            } else {
                array[k] = M[j];
                j++;
                count_quick_merge++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = M[j];
            j++;
            k++;
        }
    }

    void mergeSort(int array[], int left, int right) {
        if (left < right) {

            // m is the point where the array is divided into two sub arrays
            int mid = (left + right) / 2;

            // recursive call to each sub arrays
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted sub arrays
            merge(array, left, mid, right);
        }
    }



    public static void main(String[] args) throws IOException {
        int[] arr_9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr_10 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        permutation_quick_9(arr_9, 0, arr_9.length - 1);
        count = 0;
        permutation_quick_10(arr_10, 0, arr_10.length - 1);
        count = 0;
        permutation_merge_9(arr_9, 0, arr_9.length - 1);
        count = 0;
        permutation_merge_10(arr_10, 0, arr_10.length - 1);
        Arrays.sort(peres_quick_9);
        Arrays.sort(peres_quick_10);
        Arrays.sort(peres_merge_9);
        Arrays.sort(peres_merge_10);

        System.out.println(peres_quick_9[peres_quick_9.length - 1]);
        System.out.println(peres_quick_10[peres_quick_10.length - 1]);
        System.out.println(peres_merge_9[peres_merge_9.length - 1]);
        System.out.println(peres_merge_10[peres_merge_10.length - 1]);


        int[] number_hist_quick_9 = new int[peres_quick_9[peres_quick_9.length - 1]];
        for (int i = 0; i < peres_quick_9.length; i++){
            number_hist_quick_9[peres_quick_9[i] - 1]++;
        }

        FileWriter myWriter_number_hist_quick_9 = new FileWriter("number_hist_quick_9.txt");
        for (int i = 0; i < number_hist_quick_9.length; i++){
            myWriter_number_hist_quick_9.write( number_hist_quick_9[i] + "\n");
        }

        myWriter_number_hist_quick_9.close();

        System.out.println(Arrays.toString(number_hist_quick_9));




        int[] number_hist_quick_10 = new int[peres_quick_10[peres_quick_10.length - 1]];
        for (int i = 0; i < peres_quick_10.length; i++){
            number_hist_quick_10[peres_quick_10[i] - 1]++;
        }


        FileWriter myWriter_number_hist_quick_10 = new FileWriter("number_hist_quick_10.txt");
        for (int i = 0; i < number_hist_quick_10.length; i++){
            myWriter_number_hist_quick_10.write( number_hist_quick_10[i] + "\n");
        }

        myWriter_number_hist_quick_10.close();

        System.out.println(Arrays.toString(number_hist_quick_10));





        int[] number_hist_merge_9 = new int[peres_merge_9[peres_merge_9.length - 1]];
        for (int i = 0; i < peres_merge_9.length; i++){
            number_hist_merge_9[peres_merge_9[i] - 1]++;
        }

        FileWriter myWriter_number_hist_merge_9 = new FileWriter("number_hist_merge_9.txt");
        for (int i = 0; i < number_hist_merge_9.length; i++){
            myWriter_number_hist_merge_9.write( number_hist_merge_9[i] + "\n");
        }

        myWriter_number_hist_merge_9.close();



        System.out.println(Arrays.toString(number_hist_merge_9));



        int[] number_hist_merge_10 = new int[peres_merge_10[peres_merge_10.length - 1]];
        for (int i = 0; i < peres_merge_10.length; i++){
            number_hist_merge_10[peres_merge_10[i] - 1]++;
        }

        FileWriter myWriter_number_hist_merge_10 = new FileWriter("number_hist_merge_10.txt");
        for (int i = 0; i < number_hist_merge_10.length; i++){
            myWriter_number_hist_merge_10.write( number_hist_merge_10[i] + "\n");
        }

        myWriter_number_hist_merge_10.close();




        System.out.println(Arrays.toString(number_hist_merge_10));





        //System.out.println(Arrays.toString(peres_quick_9));
        //System.out.println(Arrays.toString(peres_quick_10));
        //System.out.println(Arrays.toString(peres_merge_9));
        //System.out.println(Arrays.toString(peres_merge_10));




    }





    public static void permutation_quick_9(int[] arr, int left, int right) {
        count_quick_merge = 0;
        if (left == right) {
            //System.out.println(Arrays.toString(arr));
            count++;
            int low = 0;
            int high = arr.length - 1;
            quickSort(arr, low, high);
            peres_quick_9[count - 1] = count_quick_merge;

        }
        else
        {
            for (int i = left; i <= right; i++) {
                swap(arr, left, i);
                permutation_quick_9(arr, left + 1, right);
                swap(arr, left, i);
            }
        }
    }

    public static void permutation_quick_10(int[] arr, int left, int right) {
        count_quick_merge = 0;
        if (left == right) {

            //System.out.println(Arrays.toString(arr));
            count++;
            int low = 0;
            int high = arr.length - 1;
            quickSort(arr, low, high);

            peres_quick_10[count - 1] = count_quick_merge;

        }
        else
        {
            for (int i = left; i <= right; i++) {
                swap(arr, left, i);
                permutation_quick_10(arr, left + 1, right);
                swap(arr, left, i);
            }
        }
    }


    public static void permutation_merge_9(int[] arr, int left, int right) {
        count_quick_merge = 0;
        if (left == right) {
            //System.out.println(Arrays.toString(arr));
            count++;
            Lab1_2_d ob = new Lab1_2_d();
            ob.mergeSort(arr, 0, arr.length - 1);
            peres_merge_9[count - 1] = count_quick_merge;

        }
        else {


            for (int i = left; i <= right; i++) {
                swap(arr, left, i);
                permutation_merge_9(arr, left + 1, right);
                swap(arr, left, i);
            }
        }
    }

    public static void permutation_merge_10(int[] arr, int left, int right) {
        count_quick_merge = 0;
        if (left == right) {
            //System.out.println(Arrays.toString(arr));
            count++;

            Lab1_2_d ob = new Lab1_2_d();
            ob.mergeSort(arr, 0, arr.length - 1);

            peres_merge_10[count - 1] = count_quick_merge;

        }
        else
        {
            for (int i = left; i <= right; i++) {
                swap(arr, left, i);
                permutation_merge_10(arr, left + 1, right);
                swap(arr, left, i);
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}