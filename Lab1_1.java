public class Lab1_1 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //System.out.print(" Enter n ");
        //int n = in.nextInt();
        int n = 1000;
        System.out.println("n = " + n);

        long start1 = System.nanoTime();

        float[] C_N = new float[n];
        C_N[0] = 0;

        float sum = 0;
        for (int i_1 = 1; i_1 < n; i_1++){
            sum = 0;
            for (int i_new = 0; i_new < i_1; i_new++){
                sum += C_N[i_new] + C_N[i_1 - i_new];

            }

            C_N[i_1] = i_1 + 1 + 1/(float)i_1 * sum;


        }
        long end1 = System.nanoTime();



        System.out.println("First method equal to " + C_N[n - 1]);



        long start2 = System.nanoTime();


        float i2 = 1;
        float cn2 = 0;


        while (i2 < n){
            cn2 = (i2 + 1) / i2 * cn2 + 2;
            i2++;
        }
        long end2 = System.nanoTime();
        System.out.println("Second method equal to " + cn2);



        long elapsedTime1 = end1 - start1;

        System.out.printf("time in nanoseconds for first method equal to %.5f %n", (double) (elapsedTime1));

        long elapsedTime2 = end2 - start2;

        System.out.printf("time in nanoseconds for second method equal to %.5f %n", (double) (elapsedTime2));


        if (elapsedTime1 > elapsedTime2){
            System.out.println("Second method faster for n = " + n);
            long dif = elapsedTime1 - elapsedTime2;
            System.out.println("difference equal to " + dif);
        }
        else if (elapsedTime2 > elapsedTime1) {
            System.out.println("First method faster for n = " + n);
            long dif = elapsedTime2 - elapsedTime1;
            System.out.println("difference equal to " + dif);
        }
        else {
            System.out.println("They have equal time");
            long dif = elapsedTime2 - elapsedTime1;
            System.out.println("difference equal to " + dif);
        }

        long startb_1 = System.nanoTime();
        double log1 = Math.log(n - 1 + 1);
        double cn_1 =  (2 * (n - 1 + 1) * (log1 + 0.57721 - 1));
        long endb_1 = System.nanoTime();

        System.out.println("first case equal to " + cn_1);


        long startb_2 = System.nanoTime();
        double log2 = Math.log(n - 1 + 1);
        double cn_2 =  (2 * (n - 1 + 1) * (log2 + 0.57721 - 1 + (double) 1/(2 * (n - 1 + 1))));
        long endb_2 = System.nanoTime();
        System.out.println("second case equal to " + cn_2);

        long elapsedTimeb_1 = endb_1 - startb_1;
        System.out.printf("time in nanoseconds for first case equal to %.5f %n", (double) (elapsedTimeb_1));


        long elapsedTimeb_2 = endb_2 - startb_2;
        System.out.printf("time in nanoseconds for second case equal to %.5f %n", (double) (elapsedTimeb_2));


        double dif_2_1 = Math.abs(cn2 - cn_1);
        double dif_2_2 = Math.abs(cn2 - cn_2);
        System.out.println("Difference for first case "  + dif_2_1);
        System.out.println("Difference for second case " + dif_2_2);



    }
}
