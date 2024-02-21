package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bus_history")
public class BusHistoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name = "userid")
    public Integer userid;
    public String username;
    public String departure_point;
    public String destination_point;
    public Integer seat_no;
    public String bus_name;
    public Integer bus_id;
    public Date date;

    public BusHistoryModel() {

    }

    public BusHistoryModel(Integer id, Integer user_id, String username, String departure_point,
            String destination_point, Integer seat_no, String bus_name, Integer bus_id, Date date) {
        this.id = id;
        this.userid = user_id;
        this.username = username;
        this.departure_point = departure_point;
        this.destination_point = destination_point;
        this.seat_no = seat_no;
        this.bus_name = bus_name;
        this.bus_id = bus_id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeparture_point() {
        return departure_point;
    }

    public void setDeparture_point(String departure_point) {
        this.departure_point = departure_point;
    }

    public String getDestination_point() {
        return destination_point;
    }

    public void setDestination_point(String destination_point) {
        this.destination_point = destination_point;
    }

    public Integer getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(Integer seat_no) {
        this.seat_no = seat_no;
    }

    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public Integer getBus_id() {
        return bus_id;
    }

    public void setBus_id(Integer bus_id) {
        this.bus_id = bus_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
