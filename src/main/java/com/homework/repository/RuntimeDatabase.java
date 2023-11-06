package com.homework.repository;

import java.util.ArrayList;

import com.homework.resources.Client;
import com.homework.resources.Facture;
import com.homework.resources.Product;

public class RuntimeDatabase implements DatabaseInterface{

    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Facture> factures = new ArrayList<>();


    public Client retrieveClientById(Long id){

        for(Client client : clients){
            if(client.getId() == id) return client;
        }

        throw new RuntimeException();

    }

    public ArrayList<Client> retrieveClients(){
        return clients;
    }

    public void createClient(Client clientData){
        
    }

    public void deleteClient(Long id){
        for(Client client : clients){
            if(client.getId() == id){
                clients.remove(client);
                return;
            }
        }
        throw new RuntimeException();
    }

    public ArrayList<Product> retreiveProducts(){
        return products;
    }
    public Product retrieveProductById(Long id){
        for(Product product : products){
            if(product.getId() == id){
                return product;
            }
        }
        throw new RuntimeException();
    }
    public void deleteProductById(Long id){
        for(Product product : products){
            if(product.getId() == id){
                products.remove(product);
                return;
            }
        }
        throw new RuntimeException();
    }
    public void createProduct(Product productData){

    }

    public Facture retrieveFactureById(Long id){
        for(Facture facture : factures){
            if(facture.getId() == id){
                return facture;
            }
        }
        throw new RuntimeException();
    }
    public ArrayList<Facture> retrieveFactures(){
        return factures;
    }
    public void deleteFacturebyId(Long id){
        for(Facture facture : factures){
            if(facture.getId() == id){
                factures.remove(facture);
                return;
            }
        }
        throw new RuntimeException();
    }
    public void openFactureForClient(Long clientId){

    }

    public void closeFacture(Long id){

    }

    public void addElement(Long factureId, Long productId, int quantity){

    }

    public void removeElement(Long factureId, Long productId){

    }
    
}
