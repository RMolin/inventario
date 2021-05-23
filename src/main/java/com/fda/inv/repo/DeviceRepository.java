package com.fda.inv.repo;

import com.fda.inv.domain.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository  extends JpaRepository<Device, Integer> {

    //List<Device> findByDeviceId(Integer deviceId);

    //Page<Device> findByDeviceId(Integer deviceId, Pageable pageable);

    //Optional<Device> findByTradeMarkIdAndTypeDeviceId(Integer tradeMarkId, Integer typeDeviceId);


}
