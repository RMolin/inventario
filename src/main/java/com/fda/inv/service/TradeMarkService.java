package com.fda.inv.service;

import com.fda.inv.domain.TradeMark;
import com.fda.inv.repo.TradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TradeMarkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceService.class);

    private TradeRepository tradeRepository;

    @Autowired
    public TradeMarkService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;

    }

    public List<TradeMark> getAll() {
        return tradeRepository.findAll();
    }

    public Optional<TradeMark> getOne(Integer id){
        return tradeRepository.findById(id);
    }

    public TradeMark createNew(TradeMark t){
        LOGGER.info("creando una nueva marca de dispositivo: {}", t);
        return tradeRepository.save(t);
    }

    public TradeMark update(Integer idTrade, TradeMark trade){
        TradeMark t = tradeRepository.findById(idTrade).orElseThrow(
                () -> new NoSuchElementException("La marca de dispositivo no existe: -->" + idTrade)
        );
        t.setName(trade.getName());

        return tradeRepository.save(t);
    }

}
