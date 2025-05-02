package com.demo1.demo1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bus_stops")
public class BusStops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @ManyToOne
    @JoinColumn(name = "stops_id")
    private Stops stops;

    public Stops getStops() {
        return stops;
    }

    public void setStops(Stops stops) {
        this.stops = stops;
    }

    @Column(name = "stop_order")
    private String stopOrder;

    public String getStopOrder() {
        return stopOrder;
    }

    public void setStopOrder(String stopOrder) {
        this.stopOrder = stopOrder;
    }

}