package com.homework.repository;

import java.util.ArrayList;

import com.homework.resources.Client;
import com.homework.resources.Element;
import com.homework.resources.Facture;
import com.homework.resources.Product;

public class RuntimeDatabase implements DatabaseInterface{

    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Facture> factures = new ArrayList<>();

    private Long clientsCounter = 0l, productsCounter = 0l, facturesCounter = 0l;


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
        clientData.setId(++clientsCounter);
        clients.add(clientData);
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
        productData.setId(++productsCounter);
        products.add(productData);
    }

    public Facture retrieveFactureById(Long id){
        for(Facture facture : factures){
            if(facture.getId() == id){
                return facture;
            }
        }
        throw new RuntimeException();
    }

    public ArrayList<Facture> retrieveFacturesForClient(Long clientId){
        ArrayList<Facture> result = new ArrayList<>();
        for(Facture facture : factures){
            if(facture.getClient().getId() == clientId) result.add(facture);
        }   
        return result;
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
        Client client = null;
        for(Client cl : clients){
            if(cl.getId() == clientId){
                client = cl;
                break;
            }
        }
        if(client == null) throw new RuntimeException();

        Facture facture = Facture.builder()
            .client(client)
            .id(++facturesCounter)
            .build();
        factures.add(facture);
    }

    public void closeFacture(Long id){
        Facture facture = null;

        for(Facture fc : factures){
            if(fc.getId() == id){
                facture = fc;
                break;
            }
        }
        if(facture == null) throw new RuntimeException();

        facture.setOpened(false);
    }

    public void addElement(Long factureId, Long productId, int quantity){
        Facture facture = null;

        for(Facture fc : factures){
            if(fc.getId() == factureId){
                facture = fc;
                break;
            }
        }
        if(facture == null) throw new RuntimeException();

        if(!facture.getOpened()) throw new RuntimeException();

        Product product = null;

        for(Product pc : products){
            if(pc.getId() == productId){
                product = pc;
                break;
            }
        }
        if(product == null) throw new RuntimeException();

        if(quantity < 1) throw new RuntimeException();

        Element element = Element.builder()
            .product(product)
            .quantity(quantity)
            .build();
        
        for(Element el : facture.getElements()){
            if(el.getProduct().getId() == element.getProduct().getId()){
                facture.getElements().remove(el);
                break;
            }
        }
        facture.getElements().add(element);
    }

    public void removeElement(Long factureId, Long productId){
        Facture facture = null;

        for(Facture fc : factures){
            if(fc.getId() == factureId){
                facture = fc;
                break;
            }
        }
        if(facture == null) throw new RuntimeException();

        if(!facture.getOpened()) throw new RuntimeException();

        Product product = null;

        for(Product pc : products){
            if(pc.getId() == productId){
                product = pc;
                break;
            }
        }
        if(product == null) throw new RuntimeException();

        for(Element el : facture.getElements()){
            if(el.getProduct().getId() == productId){
                facture.getElements().remove(el);
                return;
            }
        }
        throw new RuntimeException();
    }
    
}
