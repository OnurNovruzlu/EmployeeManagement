package az.coftea.repository;

import az.coftea.entity.SalaryBonusPercent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryBonusPercentRepository extends JpaRepository<SalaryBonusPercent,Integer> {
}
