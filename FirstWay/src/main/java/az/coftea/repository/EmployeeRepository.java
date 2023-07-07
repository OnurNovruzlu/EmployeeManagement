package az.coftea.repository;

import az.coftea.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "SELECT e.* FROM EMPLOYEE e WHERE (:username is null or e.USERNAME = :username) AND e.PASSWORD = :password",nativeQuery = true)
    Optional<Employee> login(@Param("username")String username, @Param("password")String password);
}
