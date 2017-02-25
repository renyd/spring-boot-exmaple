package com.example.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * Created by Domg on 2017/2/25.
 */
@Component
public class AsyncTask {

    Random random = new Random();

    @Async
    public Future<String> doTask() throws InterruptedException {
        System.out.println("Execute task.");
        Thread.sleep(random.nextInt(10000));
        return new AsyncResult<>("Task done.");
    }

}
