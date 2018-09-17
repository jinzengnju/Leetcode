package WangYi;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[][] t1 = new int[n][4];
        for(int i=0;i<n;i++) {
            t1[i][0] = in.nextInt();
            t1[i][1] = in.nextInt();
            t1[i][2] = in.nextInt();
            t1[i][3] = in.nextInt();
            in.nextLine();
        }
        getResult(t1);
    }

    public static void getResult(int[][] t1) {
        int n = t1.length;
        int[][] joint = new int[n*(n-1)][8];
        double[] vals = new double[joint.length];
        int index = 0;
        for(int i =0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(j==i) {
                    continue;
                }
                joint[index][0] = t1[i][0];
                joint[index][1] = t1[i][1];
                joint[index][2] = t1[i][2];
                joint[index][3] = t1[i][3];
                joint[index][4] = t1[j][0];
                joint[index][5] = t1[j][1];
                joint[index][6] = t1[j][2];
                joint[index][7] = t1[j][3];
                index++;
            }
        }


        for(int i=0;i<joint.length;i++) {
            int a = (int) Math.pow(joint[i][1]-joint[i][5], 2);
            int b = (int) Math.pow(joint[i][2]-joint[i][6], 2);
            int c = (int) Math.pow(joint[i][3]-joint[i][7], 2);
            int sum = a+b+c;
            double temp = Math.sqrt(sum);
            DecimalFormat dFormat=new DecimalFormat("#.00");
            String str=dFormat.format(temp);
            vals[i] = Double.valueOf(str);
        }

/*		System.out.println();
		for(int i=0;i<joint.length;i++) {
			System.out.println(joint[i][0]+" "+joint[i][4]+" "+vals[i]);
		}
		System.out.println();*/

        for(int i=0;i<n;i++) {
            int index2 = -1;
            double min = 20.00;
            for(int j=i*(n-1);j<(i+1)*(n-1) && j<joint.length;j++){
                if(vals[j]<min) {
                    index2 = j;
                    min = vals[index2];
                }
            }
            if(index2!=-1) {
                System.out.println(joint[index2][0]+" "+joint[index2][4]+" "+vals[index2]);
            }
        }
    }

}