package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BusHistoryModel;
import com.example.demo.service.BusHistoryService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/busHistory")
public class BusHistoryController {
    public BusHistoryService busHistoryService;

    public BusHistoryController(BusHistoryService busHistoryService) {
        this.busHistoryService = busHistoryService;
    }

    //New passenger - post passenger details
    @PostMapping("/post")
    public BusHistoryModel postBusHistory(@RequestBody BusHistoryModel busHistoryModel) {
        return busHistoryService.postbusHistory(busHistoryModel);
    }

    //Update passenger details - put method
    @PutMapping("/update")
    public ResponseEntity<BusHistoryModel> updateBusHistory(@RequestBody BusHistoryModel busHistoryModel) {
        BusHistoryModel updatedModel = busHistoryService.updateBusHistory(busHistoryModel);
        if (updatedModel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updatedModel, HttpStatus.OK); 
        }
    }

    //Cancle ticket - delete passenger details
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBusHistory(@PathVariable Integer id) {
        try {
            busHistoryService.deleteBusHistory(id);
            return new ResponseEntity<>("Bus history with ID " + id + " deleted successfully", HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } 
    }

    //Showing Upcoming journeys - get passenger details
    @GetMapping("/get/{userid}")
    public List<BusHistoryModel> getMethodName(@PathVariable Integer userid) {
        return busHistoryService.getBusHistory(userid);
    }

    //Showing Past journeys - get passenger details 
    @GetMapping("/get/past/{userid}")
    public List<BusHistoryModel> getPastJournery(@PathVariable Integer userid) {
        return busHistoryService.getPastJourney(userid);
    }
    
}
