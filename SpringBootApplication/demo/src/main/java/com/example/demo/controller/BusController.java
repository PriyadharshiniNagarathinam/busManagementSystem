package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BusModel;
import com.example.demo.service.BusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class BusController {
    @Autowired
    private BusService busService;

    //sorted by field
    @GetMapping("/bus/getall/{field}")
    public List<BusModel> getMethodName(@PathVariable String field) {
        return busService.getAllBuses(field);
    }
    
    @PostMapping("/bus/post")
    public BusModel postMethodName(@RequestBody BusModel bus) {
        return busService.addNewBus(bus);
    }
    
    //pagination example
    @GetMapping("/bus/getall/{page}/{size}")
    public List<BusModel> getMethod(@PathVariable int page,@PathVariable int size) {
        return busService.getAllBusesPaginated(page, size).getContent();
    }
}
