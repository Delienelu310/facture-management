package com.homework.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.homework.resources.Client;
import com.homework.resources.Product;

public class RuntimeDatabaseTest {
    
    //test to chekc whether clients ids in the database are unique
    @Test
    public void checkIfClientIdsAreUnique(){

        RuntimeDatabase database = new RuntimeDatabase();

        Client client1 = Client.builder().username("user1").build();
        Client client2 = Client.builder().username("user2").build();
        Client client3 = Client.builder().username("user3").build();

        database.createClient(client1);
        database.createClient(client2);
        database.createClient(client3);

        List<Client> clients = database.retrieveClients();

        Map<Long, Boolean> map = new HashMap<>();
        for(Client cl : clients){
            if(map.containsKey(cl.getId())) {
                assert false;
            }
            map.put(cl.getId(), true);
        }
        assert true;
    } 

    @Test
    public void checkIfInvalidIdThrows(){

        RuntimeDatabase database = new RuntimeDatabase();

        Client client1 = Client.builder().username("user1").build();

        database.createClient(client1);
        try{
            database.retrieveClientById(555l);
            assert false;
        }catch(Exception exception){
            assert true;
        }
 
    }

    @Test
    public void checkIfClosedFactureCanBeModified(){
        RuntimeDatabase database = new RuntimeDatabase();

        Client client1 = Client.builder().username("user1").build();
        database.createClient(client1);

        Product product1 = Product.builder().price(15).title("Bananas").build();
        database.createProduct(product1);

        database.openFactureForClient(1l);

        database.closeFacture(1l);

        try{
            database.addElement(1l, 1l, 2);
            assert false;
        }catch(Exception exception){
            assert true;
        }
    }



}
