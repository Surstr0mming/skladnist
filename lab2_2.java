import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lab2_2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("n = ");
        int n = in.nextInt();
        int[] arr = new int[n];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(2);
        }
        System.out.println(Arrays.toString(arr));


        int[] counts = new int[2];
        for (int num : arr) {
            counts[num]++;
        }

        int[] sortedArr = new int[arr.length];
        int i = 0;
        for (int j = 0; j < counts[0]; j++) {
            sortedArr[i++] = 0;
        }
        for (int j = 0; j < counts[1]; j++) {
            sortedArr[i++] = 1;
        }


        System.out.println(Arrays.toString(sortedArr));
        System.out.println(counts[0]);
        System.out.println(counts[1]);

    }
}
