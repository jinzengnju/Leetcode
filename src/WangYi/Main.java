package WangYi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private double[] init_dataweights(int N){
        double[] data_weights=new double[N];
        for (int i=0;i<N;i++){
            data_weights[i]=1.0/N;
        }
        return data_weights;
    }
    private double get_em(int[] G,int[] y,double[] data_weights){
        double count=0.0;
        int N=G.length;
        for (int i=0;i<N;i++){
            int isEquals=G[i]==y[i]?0:1;
            count+=isEquals*data_weights[i];
        }
        return count;

    }
    private double get_am(double em){
        if (em==0.0)
            return 1.0;
        if (em==1.0){
            return 0.0;
        }else {
            return 0.5*Math.log((1-em)/em);
        }

    }
    private double[] get_dateweiths(int[] G,int[] y,double a,double[] old_weights){
        //计算m+1轮的样本权重，G是上一轮的模型预测值
        //a为上一轮的模型权重
        //old_weights第m轮是的训练样本权重
        int N=G.length;
        double[] data_weights=new double[N];
        double count=0;
        for (int i=0;i<N;i++){
            double temp=old_weights[i]*Math.exp(-1.0*y[i]*G[i]*a);
            data_weights[i]=temp;
            count+=temp;
        }
        for (int i=0;i<N;i++){
            data_weights[i]=data_weights[i]/count;
        }
        return data_weights;

    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Main model=new Main();
        while(scan.hasNext()){
            int M=scan.nextInt();
            double[] classifierweights=new double[M];
            int N=scan.nextInt();
            int K=scan.nextInt();
            int[] y=new int[N];
            for (int i=0;i<N;i++){
                y[i]=scan.nextInt();
            }
            //System.out.println("y:"+ Arrays.toString(y));
            double[] data_weights=model.init_dataweights(N);
            for (int i=0;i<M;i++){
                int[] predict=new int[N];
                for (int j=0;j<N;j++){
                    predict[j]=scan.nextInt();
                }
                //System.out.println("第"+i+"轮:"+Arrays.toString(predict));
                double em=model.get_em(predict,y,data_weights);
                double am=model.get_am(em);
                classifierweights[i]=am;
                //System.out.println(am);
                data_weights=model.get_dateweiths(predict,y,am,data_weights);
            }
            for (int i=0;i<K;i++){
                int[] predict_label=new int[M];
                for (int j=0;j<M;j++){
                    predict_label[j]=scan.nextInt();
                }
                System.out.println(model.predict(predict_label,M,classifierweights));
            }
        }
    }
    private int predict(int[] label,int M,double[] classifier_weights){
        double count=0.0;
        for (int i=0;i<M;i++){
            count+=label[i]*classifier_weights[i];
        }
        if (count>=0)
            return 1;
        else
            return -1;
    }

}
