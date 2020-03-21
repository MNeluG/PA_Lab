package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Optional
        Catalog catalog = new Catalog();
        while(1 > 0) {
            String str = new String();
            Scanner scanner = new Scanner(System.in);
            String command = new String();
            String type = new String();
            command = scanner.next();
            if(command.compareTo("add") == 0)
                type = scanner.next();
            if(command.compareTo("quit") == 0)
                break;
            str = scanner.nextLine();
            str = str.replace(" ", "");
            String[] arr = str.split("\"*\"");
            System.out.println("Comanda : " + command + "\nTipul : " + type);

            if (command.compareTo("add") == 0) {
                //book
                //article
                //manual
                AddCommand addCommand = new AddCommand();
                addCommand.run(catalog, type, arr);
            }
            if (command.compareTo("load") == 0) {
                //catalog
                //System.out.print("Ajuns");
                LoadCommand loadCommand = new LoadCommand();
                loadCommand.run(catalog, arr);
            }
            if (command.compareTo("list") == 0) {
                //catalog
                ListCommand listCommand = new ListCommand();
                listCommand.run(catalog, arr);
            }
            if (command.compareTo("save") == 0) {
                //toCatalog
                SaveCommand saveCommand = new SaveCommand();
                saveCommand.run(catalog, arr);
            }
            if (command.compareTo("play") == 0) {
                //file
                PlayCommand playCommand = new PlayCommand();
                playCommand.run(arr);
            }
        }
    }

}

