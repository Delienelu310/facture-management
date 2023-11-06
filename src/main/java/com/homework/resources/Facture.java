package com.homework.resources;

import java.util.ArrayList;
import java.util.List;

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
    private List<Element> elements = new ArrayList<>();

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Facture id: " + this.id + ";" + (opened ? " Opened" : " Closed") + "\n");

        int sum = 0;
        for(Element el : elements){
            Product product = el.getProduct();
            sum += product.getPrice() * el.getQuantity();
            result.append(product.getPrice() * el.getQuantity() + " | " + el.getQuantity() + " X " + product.getPrice() + " || " + product.getTitle() + "\n");
        }

        result.append("Total: " + sum);
        return result.toString();
    }
}