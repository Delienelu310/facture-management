package com.homework.controllers;

import java.util.Map;

import com.homework.repository.DatabaseInterface;
import com.homework.resources.Client;
import com.homework.resources.Facture;
import com.homework.resources.Product;

public class ServiceProviderController {
    private DatabaseInterface database;
    private CommandParser commandParser = new CommandParser();

    public ServiceProviderController(DatabaseInterface database){
        this.database = database;
    }

    public String execute(String command){
        commandParser.parse(command);
        String route = commandParser.getRoute();
        Map<String, String> parameters = commandParser.getParameters();

        switch(route){
            case "/delete/client":
                if(!parameters.containsKey("id")) throw new RuntimeException();
                deleteClientById(Long.parseLong(parameters.get("id")));
                return null;
            case "/delete/product":
                if(!parameters.containsKey("id")) throw new RuntimeException();
                deleteProductById(Long.parseLong(parameters.get("id")));
                return null;
            case "/delete/facture":
                if(!parameters.containsKey("id")) throw new RuntimeException();
                deleteFactureById(Long.parseLong(parameters.get("id")));
                return null;
            case "/put/client":
                if(!parameters.containsKey("username")) throw new RuntimeException();
                Client client = Client.builder().username(parameters.get("username")).build();
                addClient(client);
                return null;
            case "/put/product":
                if(!parameters.containsKey("title")) throw new RuntimeException();
                if(!parameters.containsKey("price")) throw new RuntimeException();
                Product product = Product.builder()
                    .title(parameters.get("title"))
                    .price(Integer.parseInt(parameters.get("price")))
                    .build();
                addProduct(product);
                return null;
            case "put/facture/open":
                if(!parameters.containsKey("clientId")) throw new RuntimeException();
                openFactureForClient(Long.parseLong(parameters.get("clientId")));
                return null;
            case "put/facture/close":
                if(!parameters.containsKey("factureId")) throw new RuntimeException();
                closeFacture(Long.parseLong(parameters.get("factureId")));
                return null;
            case "put/element/add":
                if(!parameters.containsKey("factureId")) throw new RuntimeException();
                if(!parameters.containsKey("productId")) throw new RuntimeException();
                if(!parameters.containsKey("quantity")) throw new RuntimeException();
                addElement(
                    Long.parseLong(parameters.get("factureId")), 
                    Long.parseLong(parameters.get("productId")), 
                    Integer.parseInt(parameters.get("quantity")));
                return null;
            case "put/element/remove":
                if(!parameters.containsKey("factureId")) throw new RuntimeException();
                if(!parameters.containsKey("productId")) throw new RuntimeException();
                removeElement(
                    Long.parseLong(parameters.get("factureId")), 
                    Long.parseLong(parameters.get("productId"))
                );
                return null;
            default:
                throw new RuntimeException();
        }
    }

    public void deleteClientById(Long id){
        database.deleteClient(id);
    }

    public void deleteFactureById(Long id){
        database.deleteFacturebyId(id);
    }

    public void deleteProductById(Long id){
        database.deleteProductById(id);
    }

    public void addClient(Client clientData){
        database.createClient(clientData);
    }

    public void addProduct(Product product){
        database.createProduct(product);
    }

    public void openFactureForClient(Long clientId){
        database.openFactureForClient(clientId);
    }

    public void closeFacture(Long factureId){
        database.closeFacture(factureId);
    }

    public void addElement(Long factureId, Long productId, int quantity){
        if(quantity < 1) throw new RuntimeException();

        Facture facture = database.retrieveFactureById(factureId);
        if(!facture.getOpened()) throw new RuntimeException();

        database.addElement(factureId, productId, quantity);
    }

    public void removeElement(Long factureId, Long productId){
        Facture facture = database.retrieveFactureById(factureId);
        if(!facture.getOpened()) throw new RuntimeException();

        database.removeElement(factureId, productId);
    }
}
