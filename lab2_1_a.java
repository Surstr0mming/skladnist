import java.util.Scanner;

public class lab2_1_a {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("n = ");
        int n = in.nextInt();
        double an = 1;

        System.out.println("a0 = " + an );
        for (int i = 1; i < n; i++){
            an = 1/(1 + an);
            if (i < 11){
                System.out.println("a"+ i + " = " + an);
            }
        }

        System.out.println("\nan = " + an + " for n = " + n);


        n = 10000;
        an = 1;
        double[] mas = new double[n];
        mas[0] = an;
        for (int i = 1; i < n; i++){
            an = 1/(1 + an);
            mas[i] = an;
        }

        System.out.println("\na = " + an + " for n = " + n);


        System.out.print("(max length equals to 15)\nk = ");
        int k = in.nextInt();
        while (k > 15 | k < 1) {
            System.out.print("Enter k one more time, max length equals to 15 and min must be more than 0 \n");
            k = in.nextInt();
        }

        String str1;
        String str2 = Double.toString(mas[n - 1]).substring(2, 2 + k);

        for (int i = 5; i < mas.length; i++){

            str1 = Double.toString(mas[i]).substring(2, 2 + k);
            if (str1.equals(str2)){

                System.out.println("From i = " + i +  " they have same sign after dot");
                System.out.println(mas[mas.length - 1]);
                System.out.println(mas[i]);
                break;
            }

        }



    }
}