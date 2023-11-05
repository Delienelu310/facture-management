package com.homework.resources;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private Long id;
    private String title;

    @Builder.Default
    private Integer price = 0;
}
