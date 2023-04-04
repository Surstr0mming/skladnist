// Java implementation of QuickSort

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Lab_1_2_c extends JPanel {




    // Допоміжна функція для обміну місцями двох елементів
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* Ця функція бере останній елемент як опору, розміщує
      поворотний елемент у правильному положенні відсортовано
      масив і розміщує всі менші розміри (менше опорної точки)
      ліворуч від опори, а всі більші елементи – праворуч
      опори */
    static int[] partition(int[] arr, int low, int high, int[] massive) {

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
                massive[1] += 1;
                swap(arr, i, j);
            }
            else {
                massive[1] += 1;
            }
        }
        swap(arr, i + 1, high);
        massive[0] = i + 1;
        return massive;
    }

    /* Основна функція, яка реалізує QuickSort
              arr[] --> Масив для сортування,
              low --> Початковий індекс,
              high --> Кінцевий індекс
      */
    static void quickSort(int[] arr, int low, int high, int[] massive) {
        if (low < high) {

            // pi - індекс поділу, arr[p]
            // зараз у потрібному місці
            int pi[] = partition(arr, low, high, massive);

            // Окремо сортувати елементи раніше
            // розділ і після розділу
            quickSort(arr, low, pi[0] - 1, massive);
            quickSort(arr, pi[0] + 1, high, massive);
        }
    }


/*
    public void drawDiagram(Graphics g, double[] x, double y[], double scaling, int height, Color color) {
        int lastX = 0, lastY = 0;

        g.setColor(color);

        for(int i = 0; i < x.length; i++) {
            g.drawLine((int)(lastX * scaling), height - (int)(lastY * scaling),
                    height - (int)(x[i] * scaling), (int)(y[i] * scaling));

            lastX = (int)x[i];
            lastY = (int)y[i];
        }
    }

 */

    public static void main(String[] args) throws IOException {

        int N_graf = 100;
        int[] graf_x = new int[100];
        int[] graf_avg_mas = new int[100];

        for (int graf = 1; graf <= N_graf; graf++){
            graf_x[graf - 1] = graf * 1000;
        }


        for (int graf = 0; graf < graf_x.length; graf++){
            int avg_mas = 0;
            int[] massive = new int[2];
            for (int pos = 0; pos < 100; pos++) {
                int n = graf_x[graf];

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

                int low = 0;
                int high = arr.length - 1;
                quickSort(arr, low, high, massive);
                avg_mas += massive[1];
                massive[0] = 0;
                massive[1] = 0;
            }
            graf_avg_mas[graf] = avg_mas/100;
        }
        for (int i = 0; i < graf_avg_mas.length; i++){

            double cn = 2 * (graf_x[i] + 1) * (Math.log(graf_x[i]) + 0.57721 - 1);

            System.out.println("predicted number of comparisons cn equals to " + cn + " and average comparison is " + graf_avg_mas[i] + " for n = " + graf_x[i]);
        }


        FileWriter myWriter_cn_real = new FileWriter("graf_cn_real.txt");


        for (int i = 0; i < graf_avg_mas.length; i++){

            myWriter_cn_real.write(graf_avg_mas[i] + "\n");
        }

        myWriter_cn_real.close();

        FileWriter myWriter_n = new FileWriter("graf_n.txt");


        for (int i = 0; i < graf_avg_mas.length; i++){

            myWriter_n.write(graf_x[i] + "\n");
        }

        myWriter_n.close();


        FileWriter myWriter_cn_predicted = new FileWriter("graf_cn_predicted.txt");
        for (int i = 0; i < graf_avg_mas.length; i++){
            double cn = 2 * (graf_x[i] + 1) * (Math.log(graf_x[i]) + 0.57721 - 1);
            myWriter_cn_predicted.write( cn + "\n");
        }

        myWriter_cn_predicted.close();

    }
}

