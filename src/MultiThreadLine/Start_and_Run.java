package MultiThreadLine;

import java.util.concurrent.TimeUnit;


//系统调用线程类中的start方法时，会启动一个线程，启动该线程后线程处于就绪状态
//而不是运行状态，那么该线程可以被JVM调用执行
//在调度过程中，JVM通过调用Thread类的run方法来完成实际的操作。run结束，此线程终止

//如果未经过启动线程的start方法直接调用run方法，那么不会去开启一个线程，而会被当做普通的程序调用，此时，程序中仍然只有main这样一个主线程


//start()方法能够异步的调用run()方法，但是直接调用run()方法却是同步的，无法达到多线程的目的。
class Test implements Runnable{
    public void run(){
        System.out.println("run中开始");
        try{
            TimeUnit.SECONDS.sleep(1);

        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("run中结束");
    }
}
public class Start_and_Run {
    static void testStart(){
        System.out.println("teststart开始");
        Thread thread=new Thread(new Test());
        thread.start();
        //另外启动了一个线程，是真正意义上的多线程
        System.out.println("teststart结束");
    }
    static void testRun(){
        System.out.println("testRun开始");
        Runnable thread=new Test();
        thread.run();
        System.out.println("testRun结束");
    }
    public static void main(String[] args){
        testRun();
        System.out.println();
        testStart();
    }
}
