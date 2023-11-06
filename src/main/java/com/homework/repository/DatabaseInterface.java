package com.homework.repository;

import java.util.ArrayList;

import com.homework.resources.Client;
import com.homework.resources.Facture;
import com.homework.resources.Product;

public interface DatabaseInterface {
    

    public Client retrieveClientById(Long id);
    public ArrayList<Client> retrieveClients();
    public void createClient(Client clientData);
    public void deleteClient(Long id);

    public ArrayList<Product> retreiveProducts();
    public Product retrieveProductById(Long id);
    public void deleteProductById(Long id);
    public void createProduct(Product productData);

    public Facture retrieveFactureById(Long id);
    public ArrayList<Facture> retrieveFacturesForClient(Long clientId);
    public ArrayList<Facture> retrieveFactures();
    public void deleteFacturebyId(Long id);
    public void openFactureForClient(Long clientId);
    public void closeFacture(Long id);

    public void addElement(Long factureId, Long productId, int quantity);
    public void removeElement(Long factureId, Long productId);
}
