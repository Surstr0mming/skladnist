import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;

class graphic_1_2_d extends JFrame  {

    public static void main(String[] args) {
        graphic_1_2_d jf = new graphic_1_2_d();
        jf.setSize(1500, 1000);
        jf.setTitle("lab_1_2_d");
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public graphic_1_2_d() {add(new lab_1_2_d_graf());}

}


class lab_1_2_d_graf extends JPanel {
    public void paint(Graphics g) {
        String separator = File.separator;
        String path1 = separator + "D:" + separator + "sklasdnist"
                + separator + "lab1" + separator + "number_hist_quick_9.txt";

        String path2 = separator + "D:" + separator + "sklasdnist"
                + separator + "lab1" + separator + "number_hist_quick_10.txt";

        String path3 = separator + "D:" + separator + "sklasdnist"
                + separator + "lab1" + separator + "number_hist_merge_9.txt";

        String path4 = separator + "D:" + separator + "sklasdnist"
                + separator + "lab1" + separator + "number_hist_merge_10.txt";


        //перша чверть
        g.drawLine(730, 380, 730, 20);
        g.drawLine(730, 380, 1450, 380);


        //друга чверть
        g.drawLine(10, 380, 10, 20);
        g.drawLine(10, 380, 720, 380);



        //третя чверть
        g.drawLine(10, 760, 10, 400);
        g.drawLine(10, 760, 720, 760);

        //четверта чверть
        g.drawLine(730, 760, 730, 400);
        g.drawLine(730, 760, 1450, 760);


        //1
        BufferedReader reader1 = null;
        try {
            reader1 = new BufferedReader(new FileReader(path1));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String str1;



        int count1 = 0;
        while(true){
            try {
                if (!((str1 = reader1.readLine()) != null)){
                    break;
                }

                count1++;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            reader1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        double[] quick_9 = new double[count1];

        count1 = 0;

        try {
            reader1 = new BufferedReader(new FileReader(path1));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while(true){
            try {
                if (!((str1 = reader1.readLine()) != null)){

                    break;
                }

                quick_9[count1] = Integer.parseInt(str1);
                count1++;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            reader1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //2
        BufferedReader reader2 = null;
        try {
            reader2 = new BufferedReader(new FileReader(path2));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String str2;



        int count2 = 0;
        while(true){
            try {
                if (!((str2 = reader2.readLine()) != null)){
                    break;
                }
                count2++;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            reader2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        double[] quick_10 = new double[count2];

        count2 = 0;

        try {
            reader2 = new BufferedReader(new FileReader(path2));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while(true){
            try {
                if (!((str2 = reader2.readLine()) != null)){

                    break;
                }

                quick_10[count2] = Integer.parseInt(str2);
                count2++;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            reader2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //3
        BufferedReader reader3 = null;
        try {
            reader3 = new BufferedReader(new FileReader(path3));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String str3;



        int count3 = 0;
        while(true){
            try {
                if (!((str3 = reader3.readLine()) != null)){
                    break;
                }

                count3++;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            reader3.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        double[] merge_9 = new double[count3];

        count3 = 0;

        try {
            reader3 = new BufferedReader(new FileReader(path3));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while(true){
            try {
                if (!((str3 = reader3.readLine()) != null)){

                    break;
                }

                merge_9[count3] = Integer.parseInt(str3);
                count3++;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            reader3.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //4
        BufferedReader reader4 = null;
        try {
            reader4 = new BufferedReader(new FileReader(path4));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String str4;



        int count4 = 0;
        while(true){
            try {
                if (!((str4 = reader4.readLine()) != null)){
                    break;
                }

                count4++;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            reader4.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        double[] merge_10 = new double[count4];

        count4 = 0;

        try {
            reader4 = new BufferedReader(new FileReader(path4));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while(true){
            try {
                if (!((str4 = reader4.readLine()) != null)){

                    break;
                }

                merge_10[count4] = Integer.parseInt(str4);
                count4++;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            reader4.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Arrays.toString(quick_9));
        System.out.println(Arrays.toString(quick_10));
        System.out.println(Arrays.toString(merge_9));
        System.out.println(Arrays.toString(merge_10));

        double quick_9_max = quick_9[0];
        double quick_10_max = quick_10[0];
        double merge_9_max = merge_9[0];
        double merge_10_max = merge_10[0];


        //1
        for (int i = 0; i < quick_9.length; i++){
            if(quick_9_max < quick_9[i]){
                quick_9_max = quick_9[i];
            }
        }
        for (int i = 0; i < quick_9.length; i++){
            quick_9[i] = quick_9[i]/quick_9_max * 300;
        }


        //2
        for (int i = 0; i < quick_10.length; i++){
            if(quick_10_max < quick_10[i]){
                quick_10_max = quick_10[i];
            }
        }
        for (int i = 0; i < quick_10.length; i++){
            quick_10[i] = quick_10[i]/quick_10_max * 300;
        }


        //3
        for (int i = 0; i < merge_9.length; i++){
            if(merge_9_max < merge_9[i]){
                merge_9_max = merge_9[i];
            }
        }
        for (int i = 0; i < merge_9.length; i++){
            merge_9[i] = merge_9[i]/merge_9_max * 300;
        }


        //4
        for (int i = 0; i < merge_10.length; i++){
            if(merge_10_max < merge_10[i]){
                merge_10_max = merge_10[i];
            }
        }
        for (int i = 0; i < merge_10.length; i++){
            merge_10[i] = merge_10[i]/merge_10_max * 300;
        }

        System.out.println("\n");
        System.out.println(Arrays.toString(quick_9));
        System.out.println(Arrays.toString(quick_10));
        System.out.println(Arrays.toString(merge_9));
        System.out.println(Arrays.toString(merge_10));




        //g.drawLine(10 + vid/quick_9.length * i, 380, 10 + vid/quick_9.length * i, 380 - (int) quick_9[i]);
        //g.drawLine(10 + vid/quick_9.length * i, 380 - (int) quick_9[i], 10 + vid/quick_9.length * i + 10, 380 - (int) quick_9[i]);
        //g.drawLine(10 + vid/quick_9.length * i + 10, 380 - (int) quick_9[i], 10 + vid/quick_9.length * i + 10, 380);


        int vid = 1450 - 730;
        for (int i = 0; i < quick_9.length; i++){
            g.drawRect(10 + vid/quick_9.length * i, 380 - (int) quick_9[i], vid/quick_9.length / 2 , (int) quick_9[i]);
            g.setColor(Color.BLUE);
            g.fillRect(10 + vid/quick_9.length * i, 380 - (int) quick_9[i], vid/quick_9.length / 2 , (int) quick_9[i]);
            g.setColor(Color.black);
            g.drawString(String.valueOf(i + 1), 10 + vid/quick_9.length * i, 395);
            if (i != 0) {
                g.setColor(Color.red);
                g.drawLine(10 + vid/quick_9.length * (i - 1) + vid/quick_9.length / 4, 380 - (int) quick_9[i - 1], 10 + vid/quick_9.length * i + vid/quick_9.length / 4, 380 - (int) quick_9[i]);
            }

        }

        for (int i = 0; i < quick_10.length; i++){
            g.drawRect(10 + vid/quick_10.length * i, 760 - (int) quick_10[i], vid/quick_10.length / 2 , (int) quick_10[i]);
            g.setColor(Color.BLUE);
            g.fillRect(10 + vid/quick_10.length * i, 760 - (int) quick_10[i], vid/quick_10.length / 2 , (int) quick_10[i]);
            g.setColor(Color.black);
            g.drawString(String.valueOf(i + 1), 10 + vid/quick_10.length * i, 775);
            if (i != 0) {
                g.setColor(Color.red);
                g.drawLine(10 + vid/quick_10.length * (i - 1) + vid/quick_10.length / 4, 760 - (int) quick_10[i - 1], 10 + vid/quick_10.length * i + vid/quick_10.length / 4, 760 - (int) quick_10[i]);
            }
        }

        for (int i = 0; i < merge_9.length; i++){
            g.drawRect(730 + vid/merge_9.length * i, 380 - (int) merge_9[i], vid/merge_9.length / 2 , (int) merge_9[i]);
            g.setColor(Color.BLUE);
            g.fillRect(730 + vid/merge_9.length * i, 380 - (int) merge_9[i], vid/merge_9.length / 2 , (int) merge_9[i]);
            g.setColor(Color.black);
            g.drawString(String.valueOf(i + 1), 730 + vid/merge_9.length * i, 395);
            if (i != 0) {
                g.setColor(Color.red);
                g.drawLine(730 + vid/merge_9.length * (i - 1) + vid/merge_9.length / 4, 380 - (int) merge_9[i - 1], 730 + vid/merge_9.length * i + vid/merge_9.length / 4, 380 - (int) merge_9[i]);
            }
        }

        for (int i = 0; i < merge_10.length; i++){
            g.drawRect(730 + vid/merge_10.length * i, 760 - (int) merge_10[i], vid/merge_10.length / 2 , (int) merge_10[i]);
            g.setColor(Color.BLUE);
            g.fillRect(730 + vid/merge_10.length * i, 760 - (int) merge_10[i], vid/merge_10.length / 2 , (int) merge_10[i]);
            g.setColor(Color.black);
            g.drawString(String.valueOf(i + 1), 730 + vid/merge_10.length * i, 775);
            if (i != 0) {
                g.setColor(Color.red);
                g.drawLine(730 + vid/merge_10.length * (i - 1) + vid/merge_10.length / 4, 760 - (int) merge_10[i - 1], 730 + vid/merge_10.length * i + vid/merge_10.length / 4, 760 - (int) merge_10[i]);
            }
        }

        g.setColor(Color.black);
        g.drawString("Quick sort, n = 9", 275, 40 );
        g.drawString("Quick sort, n = 10", 275, 420);
        g.drawString("Merge sort, n = 9", 1075, 40);
        g.drawString("Merge sort, n = 10", 1075, 420);



    }
}