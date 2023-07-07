package com.example.repository;

import com.example.entity.SalaryBonusPercent;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SalaryBonusPercentRepository extends AbstractRepository{
    public Optional<SalaryBonusPercent> findById(int id){
        return Optional.of(this.em.find(SalaryBonusPercent.class,id));
    }
}
