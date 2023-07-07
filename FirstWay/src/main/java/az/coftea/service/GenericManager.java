package az.coftea.service;

import az.coftea.report.CWarehouseAmountReport;
import az.coftea.repository.GenericRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenericManager implements GenericService{

    private final GenericRepository genericRepository;
    @Override
    public List<CWarehouseAmountReport> currentWarehouseAmountReportByWarehouses(Integer idWarehouse, Integer idProduct, Integer idProductGroup1, Integer idProductGroup2, Integer idProductGroup3, Integer idProductType) {
        List<Object[]> objects = genericRepository.currentWarehouseAmountReportByWarehouses(idWarehouse, idProduct, idProductGroup1, idProductGroup2, idProductGroup3, idProductType);
        List<CWarehouseAmountReport> list = new ArrayList<>(objects.size());
        for (Object[] object : objects) {
            CWarehouseAmountReport report = new CWarehouseAmountReport();
            report.setIdProduct((Integer) object[0]);
            report.setProductCode((String) object[1]);
            report.setProductName((String) object[2]);
            report.setIdWarehouse((Integer) object[3]);
            report.setWarehouseName((String) object[4]);
            report.setCurrentAmount((BigDecimal) object[5]);
            report.setIdProductType((Integer) object[6]);
            list.add(report);
        }
        return list;
    }
}