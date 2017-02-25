package com.example.async;

import com.example.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Domg on 2017/2/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AsyncTaskTest {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void testDoTask() throws InterruptedException, ExecutionException, TimeoutException {
        Future<String> future = asyncTask.doTask(); // 异步方法
        System.out.println("Task already execute.");
        while (true) {
            if (future.isDone()) {
                System.out.println(future.get()); // 获取异步调用结果
                break;
            }
        }
    }

}
