package com.fda.inv.web;

import com.fda.inv.domain.*;
import com.fda.inv.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/devices/")
public class DeviceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceController.class);

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private TradeMarkService markService;

    @Autowired
    private TypeDeviceService typeService;

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar dispositivo por id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Dispositivo no encontrado")})
    public Device getOneById(@PathVariable(value = "id") Integer id) {
        LOGGER.info("Dispositivo GET /{}", id);
        return deviceService.getOne(id).orElseThrow(
                () -> new NoSuchElementException(String.format("Dispositivo con id %s no encontrado", id))
        );
    }

    @PutMapping("/{id}")
    public Device updateWithPut(@PathVariable(value = "id") Integer deviceId
            , @RequestBody @Validated Device device){
        LOGGER.info("PUT /devices/{}", deviceId);
        return deviceService.update(deviceId, device);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Device createDevice(@RequestBody Device d){
        return deviceService.createNew(d);
    }

    @GetMapping("/trademark")
    public List<TradeMark> getAllTradeMark() {
        return markService.getAll();
    }

    @GetMapping("/trademark/{id}")
    @ApiOperation(value = "Buscar dispositivo por id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Dispositivo no encontrado")})
    public TradeMark getOneTradeById(@PathVariable(value = "id") Integer id) {
        LOGGER.info("Obteniendo marca de Dispositivo GET /{}", id);
        return markService.getOne(id).orElseThrow(
                () -> new NoSuchElementException(String.format("Marca de Dispositivo con id %s no encontrado", id))
        );
    }

    @PutMapping("/trademark/{id}")
    public TradeMark updateTradeMark(@PathVariable(value = "id") Integer id
            , @RequestBody @Validated TradeMark trade){
        LOGGER.info("Actualizando marca de dispositivo PUT /trademark/{}", id);
        return markService.update(id, trade);
    }

    @PostMapping("/trademark")
    @ResponseStatus(HttpStatus.CREATED)
    public TradeMark createTradeMark(@RequestBody TradeMark t){
        return markService.createNew(t);
    }

    @GetMapping("/typedevice")
    public List<TypeDevice> getAllTradeTypes() {
        return typeService.getAll();
    }

    @GetMapping("/typedevice/{id}")
    @ApiOperation(value = "Buscar dispositivo por id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Dispositivo no encontrado")})
    public TypeDevice getOneTypeById(@PathVariable(value = "id") Integer id) {
        LOGGER.info("Obteniendo marca de Dispositivo GET /{}", id);
        return typeService.getOne(id).orElseThrow(
                () -> new NoSuchElementException(String.format("Marca de Dispositivo con id %s no encontrado", id))
        );
    }

    @PutMapping("/typedevice/{id}")
    public TypeDevice updateTypeMark(@PathVariable(value = "id") Integer id
            , @RequestBody @Validated TypeDevice trade){
        LOGGER.info("Actualizando marca de dispositivo PUT /trademark/{}", id);
        return typeService.update(id, trade);
    }

    @PostMapping("/typedevice")
    @ResponseStatus(HttpStatus.CREATED)
    public TypeDevice createTypeMark(@RequestBody TypeDevice t){
        return typeService.createNew(t);
    }

    /**
     * Operacion del api cuando lanza la exception
     *
     * @param ex exception
     * @return mensaje de error.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        LOGGER.error("No se puede completar la transacción", ex);
        return ex.getMessage();
    }
}
