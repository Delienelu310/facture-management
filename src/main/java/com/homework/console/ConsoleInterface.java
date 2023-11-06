package com.homework.console;

import java.util.Scanner;

import com.homework.controllers.ReadingController;
import com.homework.controllers.ServiceProviderController;
import com.homework.repository.DatabaseInterface;

public class ConsoleInterface {

    private ServiceProviderController serviceProviderController;
    private ReadingController readingController;

    public ConsoleInterface(DatabaseInterface database){
        this.serviceProviderController = new ServiceProviderController(database);
        this.readingController = new ReadingController(database);
    }


    private void printWelcomeMessage(){
        System.out.println("Welcome to the facture management application. It allows you create factures and manage them. Use /help for more info");
    }

    private void printHelpMessage(){
        System.out.println("Helping message to be implemented");
    }

    private void printException(Exception exception){
        System.out.println(exception);
        for(StackTraceElement st : exception.getStackTrace()){
            System.out.println(st.toString());
        }
       
    }

    private void printExitMessage(){
        System.out.println("The app finished working");
    }
    
    public void launch(){

        printWelcomeMessage();
        try(Scanner scanner = new Scanner(System.in);){
            String commandLine = null;
            do{
                commandLine = scanner.nextLine();
                try{
                    switch(commandLine){
                        case "/help":
                            printHelpMessage();
                            break;
                        case "/exit":
                            printExitMessage();
                            return;
                        default:
                            if(commandLine.startsWith("/get")){
                                String response = readingController.execute(commandLine);
                                System.out.println(response);
                            }else{
                                serviceProviderController.execute(commandLine);
                                System.out.println("The operation was successfull");
                            }
                        break;
                    }
                }catch(Exception e){
                    printException(e);
                }
                
            }while(true);
        }
        
        

        
    }
}
