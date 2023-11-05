package com.homework.controllers;

import java.util.ArrayList;

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

    public String execute(String string){
        return null;
    }

    public Client getClientById(Long id){
        return null;
    }

    public ArrayList<Client> getClients(){
        return null;
    }

    public Product getProductById(Long id){
        return null;
    }

    public ArrayList<Product> getProducts(){
        return null;
    }

    public Facture getFactureById(Long id){
        return null;     
    }

    public ArrayList<Facture> getFactures(){
        return null;
    }

    public ArrayList<Facture> getFacturesForClient(Long clientId){
        return null;
    }
    

}
