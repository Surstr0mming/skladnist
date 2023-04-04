
import javax.swing.*;
import java.awt.*;
import java.io.*;

class graphic extends JFrame  {

    public static void main(String[] args) {
        graphic jf = new graphic();
        jf.setSize(1500, 1000);
        jf.setTitle("lab_1_2_c");
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public graphic(){
        add(new lab_1_2_c());
    }
}


class lab_1_2_c extends JPanel {
    public void paint(Graphics g){
        String separator = File.separator;
        String path1 = separator + "D:" + separator + "sklasdnist"
                + separator + "lab1"  + separator + "graf_cn_predicted.txt";

        String path2 = separator + "D:" + separator + "sklasdnist"
                + separator + "lab1"  + separator + "graf_cn_real.txt";

        String path3 = separator + "D:" + separator + "sklasdnist"
                + separator + "lab1"  + separator + "graf_n.txt";


        int[] graf_cn_predicted = new int[100];
        int[] graf_cn_real= new int[100];
        int[] graf_n = new int[100];
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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
                graf_cn_predicted[count1] = (int) Double.parseDouble(str1);
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


        for (int i = 0; i < graf_cn_predicted.length; i++){
            System.out.println(graf_cn_predicted[i]);
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
                graf_cn_real[count2] = (int) Double.parseDouble(str2);
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


        for (int i = 0; i < graf_cn_predicted.length; i++){
            System.out.println(graf_cn_real[i]);
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
                graf_n[count3] = (int) Double.parseDouble(str3);
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


        for (int i = 0; i < graf_cn_predicted.length; i++){
            System.out.println(graf_n[i]);
        }


        g.drawLine(10, 760, 10, 20);
        g.drawLine(10, 760, 1450, 760);

        for (int i = 0; i < graf_n.length; i ++){
            graf_n[i] = graf_n[i] * 1450 / graf_n[graf_n.length - 1];
            graf_cn_real[i] = graf_cn_real[i] * 750  / graf_cn_real[graf_cn_real.length - 1] + 750 - 15 * i;
            graf_cn_predicted[i] = graf_cn_predicted[i] * 750  / graf_cn_predicted[graf_cn_predicted.length - 1] + 750 - 15 * i;
        }




        for (int i = 0; i < graf_cn_predicted.length - 1; i++){
            g.drawLine(graf_n[i], graf_cn_predicted[i], graf_n[i + 1], graf_cn_predicted[i + 1]);
        }

        for (int i = 0; i < graf_cn_predicted.length - 1; i++){
            g.setColor(Color.RED);
            g.drawLine(graf_n[i], graf_cn_real[i], graf_n[i + 1], graf_cn_real[i + 1]);
        }





    }
}