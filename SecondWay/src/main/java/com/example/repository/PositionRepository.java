package com.example.repository;

import com.example.entity.Position;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PositionRepository extends AbstractRepository{
    public Optional<Position> findById(int id){
        return Optional.of(this.em.find(Position.class,id));
    }
}
