import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lab2_4 {

    public static int findMissingNumber(int[] nums) {
        int n = nums.length + 1;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
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

        System.out.println(Arrays.toString(arr));

        Random rand = new Random();
        int index = rand.nextInt(0, arr.length - 1);


        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);



        System.out.println(Arrays.toString(newArr));
        System.out.println(findMissingNumber(newArr));
    }
}
