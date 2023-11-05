package com.homework.resources;

import java.util.ArrayList;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Facture{

    private Long id;

    @Builder.Default
    private Boolean opened = true;

    private Client client;
    
    @Builder.Default
    private ArrayList<Element> elements = new ArrayList<>();
}