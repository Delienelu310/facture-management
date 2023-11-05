package com.homework.resources;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Element {
    private Product product;

    @Builder.Default
    private Integer quantity = 0;
}
