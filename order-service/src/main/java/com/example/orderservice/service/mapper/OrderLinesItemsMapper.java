package com.example.orderservice.service.mapper;

import com.example.orderservice.dto.OrderLineItemsDto;
import com.example.orderservice.model.OrderLineItems;
import org.springframework.stereotype.Component;

@Component
public class OrderLinesItemsMapper {

    public OrderLineItems mapToOrderLineItems(OrderLineItemsDto itemsDto) {
        return OrderLineItems.builder()
                .skuCode(itemsDto.skuCode())
                .price(itemsDto.price())
                .quantity(itemsDto.quantity())
                .build();
    }
}
