package com.dedalus;

class Counter {
    private volatile int count;//volatile keyword and synchronization to ensure thread safety in a multithreaded environment.

    public int getCount() {
        return count;
    }

    public void increment() {
      //  count++;  // Non-atomic operation
    	 synchronized (this) {//By synchronizing on the Counter instance (this), only one thread can execute the synchronized block at a time, preventing race conditions and ensuring atomicity.
             count++; // Atomic operation within the synchronized block
         }
    }
}

public class MainVolatile {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                counter.increment();
                System.out.println("t1 -- i "+i +" - " +counter.getCount());
            }
          
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                counter.increment();
                System.out.println("t2 -- i "+i +" - " +counter.getCount());
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();//The join() method is used to wait for both threads to complete before printing the final value of count.
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Count: " + counter.getCount());
    }
}
