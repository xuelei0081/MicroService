package com.example.eurekaserver;


public class TestYield {
    static Object obj = new Object();
    public static void main(String[] args) {
        Thread t1 = new MyThread("线程ONE");
        Thread t2 = new MyThread("线程TWO");
        t1.start();
        t2.start();
    }

    static class MyThread extends Thread{
        public MyThread(String name){
            this.setName(name);
        }

        public void  run(){
            synchronized (obj){
                int i = 1;
                while ((i <= 10)){
                    System.err.println(this.getName()+":"+i);
                    if(i%3 == 0){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    i ++;
                    if(i == 2){
                        obj.notifyAll();
                    }
                }
            }
        }
    }
}
