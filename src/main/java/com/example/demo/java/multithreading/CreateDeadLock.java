package com.example.demo.java.multithreading;

public class CreateDeadLock {
    public static void main(String[] args) {
        final String res1 = "PNM";
        final String res2 = "ABC";

        Thread t1 = new Thread() {
            public void run() {
                synchronized (res1) {
                    System.out.println("Thread 1 : Locked Res1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (res2) {
                        System.out.println("Thread 1 : Locked Res2");
                    }
                }
            }
        };
        //This code below creates deadlock

        /*Thread t2 = new Thread() {
            public void run() {
                synchronized (res2) {
                    System.out.println("Thread 2 : Locked Res2");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (res1) {
                        System.out.println("Thread 2 : Locked Res1");
                    }
                }
            }
        };*/


        //This code below resolves deadlock

        //By Changing the lock to first    aquire resource1 and resource2, we can avoid the dead lock

        Thread t2 = new Thread() {
            public void run() {
                synchronized (res1) {
                    System.out.println("Thread 2 : Locked Res1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (res2) {
                        System.out.println("Thread 2 : Locked Res2");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
