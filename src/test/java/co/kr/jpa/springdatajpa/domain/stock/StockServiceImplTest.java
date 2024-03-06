package co.kr.jpa.springdatajpa.domain.stock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("prod") //profile.active  설정.
class StockServiceImplTest {

    @Autowired
    private StockServiceImpl stockService;
    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    public void before() {
        Stock stock = new Stock(1L, 100L);
        stockRepository.saveAndFlush(stock);
    }

    @Test
    public void stock_decrease() {
        stockService.decrease(1L, 1L);
        Stock stock = stockRepository.findById(1L).orElseThrow();
        assertThat(stock.getQuantity()).isEqualTo(99L);
    }


    @Test
    @DisplayName("동시에_100개의_요청")
    public void requests_100_AtTheSameTime() throws InterruptedException{
        int threadCnt = 100;

        //멀티스레드 이용 ExecutorService : 비동기를 단순하게 처리할 수 있또록 해주는 java api
        ExecutorService executorService = Executors.newFixedThreadPool(32);

        //다른 스레드에서 수행이 완료될 때 까지 대기할 수 있도록 도와주는 API - 요청이 끝날때 까지 기다림
        CountDownLatch latch = new CountDownLatch(threadCnt);
        for(int i=0; i<threadCnt; i++){
            executorService.submit(()->{
               try {
                   stockService.decrease(1L,1L);
               }finally {
                   latch.countDown();
               }
            });
        }
        latch.await();
        Stock stock = stockRepository.findById(1L).orElseThrow();
        //assertThat(stock.getQuantity()).isEqualTo(0L);
        System.out.println("##");

    }


}