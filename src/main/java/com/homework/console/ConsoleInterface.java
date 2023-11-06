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

    }

    private void printHelpMessage(){

    }

    private void printException(Exception exception){

    }

    private void printExitMessage(){

    }
    
    public void launch(){

        printWelcomeMessage();
        
        Scanner scanner = new Scanner(System.in);
        String commandLine = null;
        do{
            commandLine = scanner.nextLine();
            try{
                switch(commandLine){
                    case "/help":
                        printHelpMessage();
                        break;
                    case "/exit":
                        scanner.close();
                        printExitMessage();
                        return;
                    default:
                        if(commandLine.startsWith("get")){
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
