package com.example.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CWarehouseAmountReport {
    private Integer idProduct;
    private String productCode;
    private String productName;
    private Integer idWarehouse;
    private String warehouseName;
    private BigDecimal currentAmount;
    private Integer idProductType;
}
