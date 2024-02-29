package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.BusModel;
import com.example.demo.repository.BusRepository;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public BusModel addNewBus(BusModel bus) {
        return busRepository.save(bus);
    }
    
    //sorted by field
    public List<BusModel> getAllBuses(String field) {
        return busRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    //pagination
    public Page<BusModel> getAllBusesPaginated(int page,int size){
        return busRepository.findAll(PageRequest.of(page,size));
    }
}
