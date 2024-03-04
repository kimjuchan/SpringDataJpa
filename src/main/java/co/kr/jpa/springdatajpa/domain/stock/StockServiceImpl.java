package co.kr.jpa.springdatajpa.domain.stock;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StockServiceImpl {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    public synchronized void decrease(final Long id, final Long quantity){
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new NullPointerException("해당 ID 정보를 가지고 있지 않아요."));
        stock.decrease(quantity);
        //
        stockRepository.saveAndFlush(stock);


    }







}
