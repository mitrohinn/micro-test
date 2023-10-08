package com.example.inventoryservice;

import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepo inventoryRepo) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setScuCode("poco");
            inventory.setQuantity(100);

            Inventory inventory1 = new Inventory();
            inventory1.setScuCode("iphone");
            inventory1.setQuantity(0);

            inventoryRepo.save(inventory);
            inventoryRepo.save(inventory1);
        };
    }

}
