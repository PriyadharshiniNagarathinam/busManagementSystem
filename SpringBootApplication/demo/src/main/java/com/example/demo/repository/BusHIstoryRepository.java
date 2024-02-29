package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.BusHistoryModel;
import java.util.List;


public interface BusHIstoryRepository extends JpaRepository<BusHistoryModel, Integer> {
    List<BusHistoryModel> findByUserid(Integer userid);

    @Query("Select b from BusHistoryModel b where b.date < CURRENT_DATE and b.userid=userid")
    List<BusHistoryModel> findPastJourney(Integer userid);
}
