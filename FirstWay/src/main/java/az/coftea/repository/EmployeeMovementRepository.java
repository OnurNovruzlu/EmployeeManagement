package az.coftea.repository;

import az.coftea.entity.EmployeeMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMovementRepository extends JpaRepository<EmployeeMovement,Integer> {
}
