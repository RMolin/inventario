package com.fda.inv.repo;

import com.fda.inv.domain.TradeMark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TradeRepository extends JpaRepository<TradeMark, Integer> {

}
