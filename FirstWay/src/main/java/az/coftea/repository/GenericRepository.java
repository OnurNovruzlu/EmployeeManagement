package az.coftea.repository;

import az.coftea.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

// Burada T type olaraq Employee classini şerti yazmisam (burada Product classi olmalidi)
public interface GenericRepository extends JpaRepository<Employee,Integer>{
        @Query(value = "select p.ID as idProduct,p.CODE as productCode,p.NAME as productName,w.ID as idWarehouse,w.NAME as warehouseName,wa.AMOUNT as currentAmount,pt.ID as idProductType from product p left join warehouse w on w.ID = p.IDWAREHOUSE left join producttype pt on pt.ID = p.IDPRODUCTTYPE" +
                " left join warehouse_amount wa on wa.IDWAREHOUSE = w.ID WHERE (:idWarehouse is null or p.IDWAREHOUSE = :idWarehouse)" +
                " AND (:idProduct is null or p.ID = :idProduct) AND (:idProductGroup1 is null or p.IDPRODUCTGROUP1 = :idProductGroup1)" +
                " AND (:idProductGroup2 is null or p.IDPRODUCTGROUP2 = :idProductGroup2) AND (:idProductGroup3 is null or p.IDPRODUCTGROUP3 = :idProductGroup3)" +
                " AND (:idProductType is null or p.IDPRODUCTTYPE = :idProductType)",nativeQuery = true)
        List<Object[]> currentWarehouseAmountReportByWarehouses(
                @Param(value = "idWarehouse") Integer idWarehouse,
                @Param(value = "idProduct") Integer idProduct,
                @Param(value = "idProductGroup1") Integer idProductGroup1,
                @Param(value = "idProductGroup2") Integer idProductGroup2,
                @Param(value = "idProductGroup3") Integer idProductGroup3,
                @Param(value = "idProductType") Integer idProductType);
}