package com.example.makersharks.controller;

import com.example.makersharks.model.Supplier;
import com.example.makersharks.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(
            @RequestParam String location,
            @RequestParam String natureOfBusiness,
            @RequestParam String manufacturingProcesses,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Supplier> suppliers = supplierService.getSuppliers(location, natureOfBusiness, manufacturingProcesses, pageable);

        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello working";
    }
}
