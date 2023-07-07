package com.example.repository;

import com.example.entity.Section;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SectionRepository extends AbstractRepository {
    public Optional<Section> findById(int id){
        return Optional.of(this.em.find(Section.class,id));
    }
}
