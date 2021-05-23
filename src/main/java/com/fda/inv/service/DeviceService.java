package com.fda.inv.service;

import com.fda.inv.domain.Device;
import com.fda.inv.repo.DeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DeviceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceService.class);

    private DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository repository) {
        this.deviceRepository = repository;

    }

    public List<Device> getAll() {
        return deviceRepository.findAll();
    }

    public Optional<Device> getOne(Integer id){
        return deviceRepository.findById(id);
    }

    public Device createNew(Device d){
        LOGGER.info("creando nuevo device {}", d);
        return deviceRepository.save(d);
    }

    public Device update(Integer idDevice, Device device){
        Device d = deviceRepository.findById(idDevice).orElseThrow(
                () -> new NoSuchElementException("El dispositivo no existe" + idDevice)
        );
        d.setIdTypeDevice(device.getIdTypeDevice());
        d.setObservation(device.getObservation());
        d.setSerial(device.getSerial());
        d.setPlaque(device.getPlaque());
        d.setState(device.getState());
        d.setIdTradeMark(device.getIdTradeMark());

        return deviceRepository.save(d);
    }

}
