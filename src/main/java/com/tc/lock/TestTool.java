package com.tc.lock;

import java.nio.file.FileSystemLoopException;
import java.util.Date;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;


public class TestTool {
    public static ExclusiveLock lock= new ExclusiveLock();
    public static void main(String[]args) throws Exception{
        Thread thread1=new Thread(new Runnable1(),"-------test1--------");
        Thread thread2=new Thread(new Runnable1(),"--------test2--------");
        thread1.start();
        thread2.start();

        Hashtable<String,String> table = new Hashtable<>();

        Thread.sleep(10*60*1000);


    }
    public static class Runnable1 implements Runnable{
        public void run(){
            lock.lock();
            try{
                System.out.print(Thread.currentThread().getName() + "  ");
                System.out.println(new Date(System.currentTimeMillis()));
                Integer[]  array= new Integer[100000];
                for(int i=0;i<100000;i++){
                    array[i]=i;
                }
                Thread.sleep(10*90*1000);
            }
            catch (Exception e){
                System.out.println(e);
            }
            finally {
                lock.unlock();
            }
            System.out.println("------------退出线程------------------");
        }
    }


}
