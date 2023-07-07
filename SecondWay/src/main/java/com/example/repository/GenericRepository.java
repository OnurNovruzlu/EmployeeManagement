package com.example.repository;

import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenericRepository extends AbstractRepository{
    public  List<Object[]> currentWarehouseAmountReportByWarehouses
            (Integer idWarehouse, Integer idProduct, Integer idProductGroup1,
             Integer idProductGroup2, Integer idProductGroup3, Integer idProductType){
     String queryStr = "select p.ID as idProduct,p.CODE as productCode,p.NAME as productName,w.ID as idWarehouse,w.NAME as warehouseName,wa.AMOUNT as currentAmount,pt.ID as idProductType from product p left join warehouse w on w.ID = p.IDWAREHOUSE left join producttype pt on pt.ID = p.IDPRODUCTTYPE" +
             " left join warehouse_amount wa on wa.IDWAREHOUSE = w.ID WHERE (:idWarehouse is null or p.IDWAREHOUSE = :idWarehouse)" +
             " AND (:idProduct is null or p.ID = :idProduct) AND (:idProductGroup1 is null or p.IDPRODUCTGROUP1 = :idProductGroup1)" +
             " AND (:idProductGroup2 is null or p.IDPRODUCTGROUP2 = :idProductGroup2) AND (:idProductGroup3 is null or p.IDPRODUCTGROUP3 = :idProductGroup3)" +
             " AND (:idProductType is null or p.IDPRODUCTTYPE = :idProductType)";
        Query query = this.em.createNativeQuery(queryStr);
        query.setParameter("idWarehouse",idWarehouse);
        query.setParameter("idProduct",idProduct);
        query.setParameter("idProductGroup1",idProductGroup1);
        query.setParameter("idProductGroup2",idProductGroup2);
        query.setParameter("idProductGroup3",idProductGroup3);
        query.setParameter("idProductType",idProductType);
        return (List<Object[]>) query.getResultList();
    }

}
