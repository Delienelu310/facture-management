package com.homework;

import com.homework.console.ConsoleInterface;
import com.homework.repository.DatabaseInterface;
import com.homework.repository.RuntimeDatabase;

public class App 
{
    public static void main( String[] args )
    {
        DatabaseInterface database = new RuntimeDatabase();

        ConsoleInterface consoleInterface = new ConsoleInterface(database);

        consoleInterface.launch();
    }
}
