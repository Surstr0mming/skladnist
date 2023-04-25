import java.nio.channels.Pipe;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;

public class lab2_6 {

    public static int[][] multiply(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("number of columns of A not equals to B rows");
        }

        int[][] C = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    public static double frobeniusNormSq(int[][] C) {
        double normSq = 0;

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                normSq += Math.pow(C[i][j], 2);
            }
        }

        return normSq;
    }


    public static void main(String[] args) {
        //a
        Scanner in = new Scanner(System.in);
        System.out.print("n = ");
        int n = in.nextInt();

        int[][] A = new int[n][n];

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                A[i][i-1] = i*i;
            }
            if (i < n-1) {
                A[i][i+1] = i;
            }
        }
        System.out.println("A:");
        for (int i = 0; i < A.length; i++) {
            System.out.println(Arrays.toString(A[i]));
        }



        int[][] B = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = A[j][i];
            }
        }
        System.out.println("\nTrans matrix A: ");
        for (int i = 0; i < B.length; i++) {
            System.out.println(Arrays.toString(B[i]));
        }

        int[][] C;

        C = multiply(A, B);
        System.out.println("\nTheir multiply: ");
        for (int i = 0; i < C.length; i++) {
            System.out.println(Arrays.toString(C[i]));
        }



        double frob = frobeniusNormSq(C);
        System.out.println("Frobenius norm equals to " + frob + " for n = " + n);

        //b
        System.out.println("For n = 10: ");
        n = 10;
        A = new int[n][n];

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                A[i][i-1] = i*i;
            }
            if (i < n-1) {
                A[i][i+1] = i;
            }
        }
        System.out.println("A:");
        for (int i = 0; i < A.length; i++) {
            System.out.println(Arrays.toString(A[i]));
        }



        B = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = A[j][i];
            }
        }
        System.out.println("\nTrans matrix A: ");
        for (int i = 0; i < B.length; i++) {
            System.out.println(Arrays.toString(B[i]));
        }



        C = multiply(A, B);
        System.out.println("\nTheir multiply: ");
        for (int i = 0; i < C.length; i++) {
            System.out.println(Arrays.toString(C[i]));
        }



        frob = frobeniusNormSq(C);
        System.out.println("Frobenius norm equals to " + frob + " for n = " + n);

        //c
        double sum = 0;
        for (int c = 10; c <= 1000; c++){
            n = c;
            A = new int[n][n];

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    A[i][i-1] = i*i;
                }
                if (i < n-1) {
                    A[i][i+1] = i;
                }
            }



            B = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    B[i][j] = A[j][i];
                }
            }

            C = multiply(A, B);
            sum += frobeniusNormSq(C);

        }
        System.out.println("sum = " + sum + " for n from 10 to 1000");

      /*
        //d
        System.out.println("For n = 1ddmm: ");
        n = 11206;
        A = new int[n][n];

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                A[i][i-1] = i*i;
            }
            if (i < n-1) {
                A[i][i+1] = i;
            }
        }
        System.out.println("A:");
        for (int i = 0; i < A.length; i++) {
            System.out.println(Arrays.toString(A[i]));
        }



        B = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = A[j][i];
            }
        }
        System.out.println("\nTrans matrix A: ");
        for (int i = 0; i < B.length; i++) {
            System.out.println(Arrays.toString(B[i]));
        }



        C = multiply(A, B);
        System.out.println("\nTheir multiply: ");
        for (int i = 0; i < C.length; i++) {
            System.out.println(Arrays.toString(C[i]));
        }



        frob = frobeniusNormSq(C);
        System.out.println("Frobenius norm equals to " + frob + " for n = " + n);
       */

    }
}
