package com.example.makersharks.service;

import com.example.makersharks.model.Supplier;
import com.example.makersharks.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> getSuppliers(String location, String natureOfBusiness, String manufacturingProcesses, Pageable pageable) {
        return supplierRepository.findByCriteria(location, natureOfBusiness, manufacturingProcesses, pageable);
    }
}
