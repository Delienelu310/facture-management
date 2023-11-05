package com.homework.controllers;

import com.homework.repository.DatabaseInterface;
import com.homework.resources.Client;
import com.homework.resources.Product;

public class ServiceProviderController {
    private DatabaseInterface database;
    private CommandParser commandParser = new CommandParser();

    public ServiceProviderController(DatabaseInterface database){
        this.database = database;
    }

    public String execute(String command){
        return null;
    }

    public void deleteClientById(Long id){

    }

    public void deleteFactureById(Long id){

    }

    public void deleteProductById(Long id){

    }

    public void addClient(Client clientData){

    }

    public void addProduct(Product product){

    }

    public void openFactureForClient(Long clientId){

    }

    public void closeFacture(Long factureId){

    }

    public void addElement(Long factureId, Long productId, int quantity){

    }

    public void removeElement(Long factureId, Long productId){

    }
}
