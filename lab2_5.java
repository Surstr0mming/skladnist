import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lab2_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("n = ");
        int n = in.nextInt();
        int[] arr = new int[n];
        Random rand = new Random();
        int index;

        System.out.print("start = ");
        int start = in.nextInt();

        System.out.print("finish = ");
        int finish = in.nextInt();

        // заповнюємо масив випадковими числами
        for (int i = 0; i < n; i++) {

            index = rand.nextInt(start, finish);
            arr[i] = index;
        }



        System.out.println(Arrays.toString(arr));

        int[][] arr_mas = new int[n*n][2];
        int count = 0;
        for(int i1 = 0; i1 < arr.length; i1++){
            for(int i2 = 0; i2 < arr.length; i2++){
                arr_mas[count][0] = i1;
                arr_mas[count][1] = i2;
                count++;
            }
        }

        System.out.println("arrrr" + arr_mas.length);

        System.out.println(Arrays.deepToString(arr_mas));
        System.out.println(arr[arr_mas[0][1]]);
        System.out.println(arr[arr_mas[24][1]]);
        count = 0;
        for (int i = 0; i < arr.length; i++){
            for (int t = 0; t < arr_mas.length ; t++){

                if (arr[arr_mas[t][1]] + arr[arr_mas[t][0]] + arr[i] == 2023){
                    System.out.println("number " + count + ": ");
                    System.out.println("i = " + arr_mas[t][0] + " equals to " + arr[arr_mas[t][0]]);
                    System.out.println("j = " + arr_mas[t][1] + " equals to " + arr[arr_mas[t][1]]);
                    System.out.println("k = " + i + " equals to " + arr[i] + "\n");
                    count++;


                }
            }
        }

        System.out.println("Number of (i, j, k) = 2023 equals to " + count);


    }
}
