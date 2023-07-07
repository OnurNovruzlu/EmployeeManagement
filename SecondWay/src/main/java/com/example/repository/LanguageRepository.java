package com.example.repository;

import com.example.entity.Language;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LanguageRepository extends AbstractRepository{
    public Optional<Language> findById(int id){
        return Optional.of(this.em.find(Language.class,id));
    }
}
