package com.homework.controllers;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class CommandParser{
    
    private String route;
    private Map<String, String> parameters = new HashMap<>();

    //the typical command looks smth like this: /put/element/add?factureId=5;productId=3;quantity=10
    public void parse(String command){
        String[] routeAndParams = command.split("?");
        route = routeAndParams[0];

        parameters = new HashMap<>();
        if(routeAndParams.length == 1) return;

        String[] paramsPairs = routeAndParams[1].split(";");
        for(String pair : paramsPairs){
            String[] keyAndValue = pair.split("=");
            parameters.put(keyAndValue[0], keyAndValue[1]);
        }


    }
}