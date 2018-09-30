package MultiThreadLine;

//将5个线程执行5个任务，修改为5个线程执行同一任务。
//将synchronized(MyRunnable.class)修改为synchronized(this)

//代码一是创建了5个MyRunnable对象，代码二只创建了1个MyRunnable对象。考虑并发时用到的锁就是不一样的，代码一我们需要锁住整个类，
// 因为对象是不同的，而针对代码二我们只需要锁住一个对象即可。
//synchronized(this)代表锁住同一对象。
//synchronized(MyRunnable.class)代表锁住整个MyRunnable类的对象。


public class MultiLineCounter2 {
    //公共变量
    int count=0;
    public static void main(String[] args){
        //new一个实现Runnable的类
        MultiLineCounter2 test=new MultiLineCounter2();
        //创建1个任务
        MyRunnable myRunnable1=test.new MyRunnable();
//		MyRunnable myRunnable2=test.new MyRunnable();
//		MyRunnable myRunnable3=test.new MyRunnable();
//		MyRunnable myRunnable4=test.new MyRunnable();
//		MyRunnable myRunnable5=test.new MyRunnable();
        //创建5个线程
        for(int i=0;i<4;i++){
            new Thread(myRunnable1).start();
        }
//		new Thread(myRunnable2).start();
//		new Thread(myRunnable3).start();
//		new Thread(myRunnable4).start();
//		new Thread(myRunnable5).start();
    }
    //创建一个实现Runnable的类
    class MyRunnable implements Runnable{
        public void run() {
            while(true){
                //锁住的是同一对象
                synchronized(this){
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

}
