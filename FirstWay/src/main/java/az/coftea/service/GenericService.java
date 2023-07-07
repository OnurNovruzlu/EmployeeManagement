package az.coftea.service;

import az.coftea.report.CWarehouseAmountReport;
import java.util.List;

public interface GenericService {
    List<CWarehouseAmountReport> currentWarehouseAmountReportByWarehouses(Integer idWarehouse,
                                                                          Integer idProduct,
                                                                          Integer idProductGroup1,
                                                                          Integer idProductGroup2,
                                                                          Integer idProductGroup3,
                                                                          Integer idProductType);
}
