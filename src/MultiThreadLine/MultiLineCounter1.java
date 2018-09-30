package MultiThreadLine;
//给定count=0；让5个线程并发累加到1000；
//创建一个类MyRunnable，实现Runnable（继承Thread类也可）
//定义一个公共变量count(初始值为0)，5个线程都可以访问到；
//创建5个线程并发递增count到1000；

//法一
//将count公共变量放到测试类Test的类成员变量里，将MyRunnable类作为Test类的内部类，在Test类的main方法里创建5个线程，实现累加。

public class MultiLineCounter1 {
    //公共变量
    int count=0;

    class MyRunnable implements Runnable{
        public void run() {
            while(true){
                //锁住的是整个MyRunnable类
                synchronized(MyRunnable.class){
                    if(count>=1000){
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+":count:"+(++count));
                    //测试时，线程更容易切换
                    Thread.yield();
                }

            }
        }
    }

    public static void main(String[] args){
        //new一个实现Runnable的类
        MultiLineCounter1 test=new MultiLineCounter1();
        //创建5个任务
        MyRunnable myRunnable1=test.new MyRunnable();
        MyRunnable myRunnable2=test.new MyRunnable();
        MyRunnable myRunnable3=test.new MyRunnable();
        MyRunnable myRunnable4=test.new MyRunnable();
        MyRunnable myRunnable5=test.new MyRunnable();
        //创建5个线程
        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();
        new Thread(myRunnable3).start();
        new Thread(myRunnable4).start();
        new Thread(myRunnable5).start();
    }

}

