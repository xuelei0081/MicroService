package com.example.eurekaserver;

public class DeadLock {
    // 全局锁对象
    public static Object obj1 = new Object();
    public static Object obj2 = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());

        thread1.start();
        thread2.start();
    }

}
class Thread1 implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while(true){
            synchronized (DeadLock.obj1){
                System.err.println(Thread.currentThread().getName()+"获取的锁为:"+ DeadLock.obj1.toString()+"-"+i);

                synchronized (DeadLock.obj2){
                    System.err.println(Thread.currentThread().getName()+"获取的锁为:"+ DeadLock.obj2.toString()+"-"+i);
                }
                i ++;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DeadLock.obj1.notifyAll();
            }
        }
    }
}
class Thread2 implements Runnable{

    @Override
    public void run() {
        int i = 0;
        while(true){
            synchronized (DeadLock.obj2){
                System.err.println(Thread.currentThread().getName()+"获取的锁为:"+ DeadLock.obj2.toString()+"-"+i);

                synchronized (DeadLock.obj1){
                    System.err.println(Thread.currentThread().getName()+"获取的锁为:"+ DeadLock.obj1.toString()+"-"+i);
                }
                i ++;
            }
        }
    }
}
