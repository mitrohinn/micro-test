package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.repository.InventoryRepo;
import com.example.inventoryservice.service.mapper.InventoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    public final InventoryRepo inventoryRepo;
    public final InventoryMapper inventoryMapper;

    public InventoryService(InventoryRepo inventoryRepo, InventoryMapper inventoryMapper) {
        this.inventoryRepo = inventoryRepo;
        this.inventoryMapper = inventoryMapper;
    }

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {

        return inventoryRepo.findByScuCodeIn(skuCode).stream()
                .map(inventoryMapper::mapToDto)
                .toList();
    }
}
