import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lab2_3 {


    public static int[] cycShift(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // якщо k > n, здійснюємо зсув на k % n позицій

        // Перевертаємо весь масив
        for (int i = 0; i < n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;
        }

        // Перевертаємо підмасив [0, k-1]
        for (int i = 0; i < k/2; i++) {
            int temp = arr[i];
            arr[i] = arr[k-1-i];
            arr[k-1-i] = temp;
        }

        // Перевертаємо підмасив [k, n-1]
        for (int i = k; i < (k+n)/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-1-i+k];
            arr[n-1-i+k] = temp;
        }
        return arr;
    }


    public static int Search(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[left] <= x && x < arr[mid]) {
                right = mid - 1;
            }
            else if (arr[mid] < x && x <= arr[right]) {
                left = mid + 1;
            }
            else if (arr[left] > arr[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return -1;
    }



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("n = ");
        int n = in.nextInt();
        int[] arr = new int[n];

        // заповнюємо масив випадковими числами
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1; // заповнюємо початковими значеннями
        }

        Random rand = new Random(); // створюємо об'єкт Random

        // перемішуємо елементи масиву у випадковому порядку

        System.out.println(Arrays.toString(arr));


        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

     /*   System.out.print("k = ");
        int k = in.nextInt();

      */


        int k = rand.nextInt(1, 100);
        System.out.println("Shift k = " + k);

        arr = cycShift(arr, k);
        System.out.println(Arrays.toString(arr));


        System.out.print("Which one do u want to find: ");
        int x = in.nextInt();
        if ((Search(arr, x)) == -1){
            System.out.println("There are no element equals to" + x);
        }
        else {
            System.out.println(Search(arr, x) + 1);
        }

    }
}
