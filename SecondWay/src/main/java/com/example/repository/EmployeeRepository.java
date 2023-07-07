package com.example.repository;

import com.example.entity.Employee;
import com.example.exception.InvalidInputException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository extends AbstractRepository{
    public List<Employee> findAll(){
            String query = "select e from Employee e";
        TypedQuery<Employee> typedQuery = this.em.createQuery(query,Employee.class);
        return typedQuery.getResultList();
    }
    public Optional<Employee> findById(int id){
        return Optional.ofNullable(this.em.find(Employee.class,id));
    }
    @Transactional
    public void insert(Employee employee){
        this.em.persist(employee);
    }
    @Transactional
    public void update(Employee employee){
        this.em.merge(employee);
    }
    public Optional<Employee> login(String username, String password){
        String queryStr = "SELECT e FROM Employee e WHERE (:username is null or e.username = :username) AND e.password = :password";
        Query query = this.em.createQuery(queryStr);
        query.setParameter("username",username);
        query.setParameter("password",password);
        if(query.getResultList().isEmpty())throw new InvalidInputException("Invalid username or password");
        else return Optional.of((Employee) query.getResultList().get(0));
    }
}