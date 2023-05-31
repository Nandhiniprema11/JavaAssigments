package com.dedalus;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ExecutorExample implements Callable<Integer> {

    private static Random random = new Random(System.currentTimeMillis());//(method with class)

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return random.nextInt(100);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(5);//is created using Executors.newFixedThreadPool(5), which creates a thread pool with a fixed size of 5 threads.
        Future<Integer>[] futures = new Future[5];//Future<Integer> objects, you are creating a container to store the Future objects for each task that will be submitted to the ExecutorService for execution.
        for (int i = 0; i < futures.length; i++) {
            futures[i] = service.submit(new ExecutorExample());
        }
        
        for (int i = 0; i < futures.length; i++) {
            Integer retVal = futures[i].get();
            System.out.println("retVal " + retVal);
        }
        service.shutdown();
    }
}