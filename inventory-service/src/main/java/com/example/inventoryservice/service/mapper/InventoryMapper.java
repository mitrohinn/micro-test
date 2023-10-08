package com.example.inventoryservice.service.mapper;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.model.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {
    public InventoryResponse mapToDto(Inventory inventory) {
        return new InventoryResponse(inventory.getScuCode(), inventory.getQuantity() > 0);
    }
}
