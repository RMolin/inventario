package com.fda.inv.service;

import com.fda.inv.domain.TradeMark;
import com.fda.inv.domain.TypeDevice;
import com.fda.inv.repo.TypeDeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TypeDeviceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceService.class);

    private TypeDeviceRepository typeDeviceRepository;

    @Autowired
    public TypeDeviceService(TypeDeviceRepository typeDeviceRepository) {
        this.typeDeviceRepository = typeDeviceRepository;

    }

    public List<TypeDevice> getAll() {
        return typeDeviceRepository.findAll();
    }

    public Optional<TypeDevice> getOne(Integer id){
        return typeDeviceRepository.findById(id);
    }

    public TypeDevice createNew(TypeDevice t){
        LOGGER.info("creando un nuevo tipo de dispositivo: {}", t);
        return typeDeviceRepository.save(t);
    }

    public TypeDevice update(Integer idType, TypeDevice typeDevice){
        TypeDevice t = typeDeviceRepository.findById(idType).orElseThrow(
                () -> new NoSuchElementException("El tipo de dispositivo no existe: -->" + idType)
        );
        t.setName(typeDevice.getName());

        return typeDeviceRepository.save(t);
    }

}
