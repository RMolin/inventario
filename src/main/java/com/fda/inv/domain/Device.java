package com.fda.inv.domain;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "serial")
    private String serial;

    @Column(name = "plaque")
    private String plaque;

    @Column(name = "observation")
    private String observation;

    @Column(name = "state")
    private String state;

    @Column(name = "idtrademark")
    private Integer tradeMark;

    @Column(name = "idtypedevice")
    private Integer typeDevice;

    /**
     * Creacion de un dispositivo
     *
     * @param serial del dispositivo.
     * @param plaque asignada por la empresa al dispositivo.
     * @param observation comentario del dispositivo.
     * @param state estado actual del dispostivo.
     * @param tradeMark marca del dispositivo.
     * @param typeDevice tipo del dispositivo.
     */
    public Device(String serial, String plaque
            , String observation, String state
            , Integer tradeMark, Integer typeDevice) {
        this.serial = serial;
        this.plaque = plaque;
        this.observation = observation;
        this.state = state;
        this.tradeMark = tradeMark;
        this.typeDevice = typeDevice;
    }

    protected Device(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getIdTradeMark() {
        return tradeMark;
    }

    public void setIdTradeMark(Integer idTradeMark) {
        this.tradeMark = idTradeMark;
    }

    public Integer getIdTypeDevice() {
        return typeDevice;
    }

    public void setIdTypeDevice(Integer idTypeDevice) {
        this.typeDevice = idTypeDevice;
    }
}
