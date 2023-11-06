package com.homework.controllers;

import java.util.ArrayList;
import java.util.Map;

import com.homework.repository.DatabaseInterface;
import com.homework.resources.Client;
import com.homework.resources.Facture;
import com.homework.resources.Product;

public class ReadingController {
    

    private DatabaseInterface database;
    private CommandParser commandParser = new CommandParser();

    public ReadingController(DatabaseInterface database){
        this.database = database;
    }

    public String execute(String command){

        commandParser.parse(command);
        String route = commandParser.getRoute();
        Map<String, String> parameters = commandParser.getParameters();

        switch(route){
            case "/get/clients":
                if(parameters.containsKey("id")) return getClientById(Long.parseLong(parameters.get("id"))).toString();
                else return getClients().toString();
            case "/get/products":
                if(parameters.containsKey("id")) return getProductById(Long.parseLong(parameters.get("id"))).toString();
                else return getProducts().toString();
            case "/get/factures":
                if(parameters.containsKey("id")) return getFactureById(Long.parseLong(parameters.get("id"))).toString();
                else return getFactures().toString();
            default:
                throw new RuntimeException();
        }
    }

    public Client getClientById(Long id){
        return database.retrieveClientById(id);
    }

    public ArrayList<Client> getClients(){
        return database.retrieveClients();
    }

    public Product getProductById(Long id){
        return database.retrieveProductById(id);
    }

    public ArrayList<Product> getProducts(){
        return database.retreiveProducts();
    }

    public Facture getFactureById(Long id){
        return database.retrieveFactureById(id);     
    }

    public ArrayList<Facture> getFactures(){
        return database.retrieveFactures();
    }

    public ArrayList<Facture> getFacturesForClient(Long clientId){
        return database.retrieveFacturesForClient(clientId);
    }
    

}
