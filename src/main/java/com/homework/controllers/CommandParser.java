package com.homework.controllers;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class CommandParser{
    
    private String route;
    private Map<String, String> parameters = new HashMap<>();

    public void parse(String command){

    }
}