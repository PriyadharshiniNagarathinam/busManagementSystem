package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.BusHistoryModel;
import com.example.demo.repository.BusHIstoryRepository;

@Service
public class BusHistoryService {
    private BusHIstoryRepository busHistoryRepository;

    public BusHistoryService(BusHIstoryRepository busHistoryRepository) {
        this.busHistoryRepository = busHistoryRepository;
    }

    public BusHistoryModel postbusHistory(BusHistoryModel busHistoryModel) {
        return busHistoryRepository.save(busHistoryModel);
    }

    public List<BusHistoryModel> getBusHistory(Integer userid) {
        return busHistoryRepository.findByUserid(userid);
    }

    public List<BusHistoryModel> getPastJourney(Integer userid) {
        return busHistoryRepository.findPastJourney(userid);
    }
    
    public BusHistoryModel updateBusHistory(BusHistoryModel updatedModel) {
        Optional<BusHistoryModel> optionalBusHistoryModel = busHistoryRepository.findById(updatedModel.id);
        if (optionalBusHistoryModel.isPresent()) {
            return busHistoryRepository.save(updatedModel);
        } else {
            return null;
        }
    }

    public void deleteBusHistory(Integer id) {
        Optional<BusHistoryModel> optionalBusHistoryModel = busHistoryRepository.findById(id);
        if (optionalBusHistoryModel.isPresent()) {
            busHistoryRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Bus history with id " + id + " does not exist.");
        }
    }
}
