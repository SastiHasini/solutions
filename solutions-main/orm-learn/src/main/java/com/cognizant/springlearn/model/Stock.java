package com.cognizant.springlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "open")
    private Double open;

    @Column(name = "close")
    private Double close;

    @Column(name = "volume")
    private Integer volume;

    public Stock() {
    }

    public Stock(Integer id, String code, LocalDate date, Double open, Double close, Integer volume) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.open = open;
        this.close = close;
        this.volume = volume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Stock{id=" + id + ", code='" + code + '\'' + ", date=" + date + ", open=" + open + ", close=" + close + ", volume=" + volume + '}';
    }
}