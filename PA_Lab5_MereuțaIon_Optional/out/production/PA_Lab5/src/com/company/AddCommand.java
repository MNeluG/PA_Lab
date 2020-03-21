package com.company;
import java.util.ArrayList;
import java.util.List;

public class AddCommand {
    AddCommand(){

    }
    public void run(Catalog catalog, String type, String[] all){
        if (type.compareTo("book") == 0) {
            String[] authors = new String[all.length - 4];
            for (int i = 4; i < all.length; i++)
                authors[i - 4] = all[i];
            Document doc = new Book(all[1], all[2], Integer.parseInt(all[3]), authors);
            catalog.add(doc);
        }
        if (type.compareTo("article") == 0){
            String[] authors = new String[all.length - 4];
            for (int i = 4; i < all.length; i++)
                authors[i - 4] = all[i];
            Document doc = new Article(all[1], all[2], Integer.parseInt(all[3]), authors);
            catalog.add(doc);
        }
        if(type.compareTo("manual") == 0){
            Document doc = new Manual(all[1], all[2]);
            catalog.add(doc);
        }
    }
}
