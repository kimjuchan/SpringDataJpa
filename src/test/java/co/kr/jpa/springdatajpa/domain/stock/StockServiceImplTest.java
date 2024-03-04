package co.kr.jpa.springdatajpa.domain.stock;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class StockServiceImplTest {


    @Test
    public void 동시성_재고이슈테스트_100개요청() throws InterruptedException{
        int threadCnt = 100;

        //
        ExecutorService executorService = Executors.newFixedThreadPool(32);

        CountDownLatch latch


    }


}