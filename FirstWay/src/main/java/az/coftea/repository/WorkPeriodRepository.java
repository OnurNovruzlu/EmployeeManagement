package az.coftea.repository;

import az.coftea.entity.WorkPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkPeriodRepository extends JpaRepository<WorkPeriod,Integer> {
}
