package com.example.controller;

import com.example.report.CWarehouseAmountReport;
import com.example.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("generic")
@RequiredArgsConstructor
public class GenericController {
    private final GenericService genericService;

    @GetMapping("/currentWarehouseAmountReportByWarehouses")
    public List<CWarehouseAmountReport> currentWarehouseAmountReportByWarehouses(
            @RequestParam(required = false) Integer idWarehouse,
            @RequestParam(required = false) Integer idProduct,
            @RequestParam(required = false) Integer idProductGroup1,
            @RequestParam(required = false) Integer idProductGroup2,
            @RequestParam(required = false) Integer idProductGroup3,
            @RequestParam(required = false) Integer idProductType) {
        return genericService.currentWarehouseAmountReportByWarehouses(
                idWarehouse, idProduct, idProductGroup1, idProductGroup2, idProductGroup3, idProductType);
    }
}
