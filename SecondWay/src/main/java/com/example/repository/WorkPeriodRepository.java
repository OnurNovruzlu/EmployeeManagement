package com.example.repository;

import com.example.entity.WorkPeriod;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class WorkPeriodRepository extends AbstractRepository{
    public Optional<WorkPeriod> findById(int id){
        return Optional.of(this.em.find(WorkPeriod.class,id));
    }
}
