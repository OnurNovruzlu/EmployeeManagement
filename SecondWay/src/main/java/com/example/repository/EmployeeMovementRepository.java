package com.example.repository;

import com.example.entity.EmployeeMovement;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeMovementRepository extends AbstractRepository{
    public List<EmployeeMovement> findAll(){
        String query = "select em from EmployeeMovement em";
        TypedQuery<EmployeeMovement> typedQuery = this.em.createQuery(query,EmployeeMovement.class);
        return typedQuery.getResultList();
    }
    public Optional<EmployeeMovement> findById(int id){
        return Optional.ofNullable(this.em.find(EmployeeMovement.class,id));
    }
    @Transactional
    public void insert(EmployeeMovement employeeMovement){
        this.em.persist(employeeMovement);
    }
    @Transactional
    public void update(EmployeeMovement employeeMovement){
        this.em.merge(employeeMovement);
    }
}
