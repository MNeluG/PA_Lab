package com.Laborator5.se.task;

import com.Laborator5.se.task1.Catalog;
import com.Laborator5.se.task1.Document;
import com.Laborator5.se.task1.InvalidCatalogException;
import com.Laborator5.se.task1.Serializator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();

    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("Java Resources" , "catalog.ser");
        Document doc = new Document( "Java1" , "Java Course 1 " , "\"https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf\"");
        doc.addTag("type" , "Slides");
        catalog.addDoc(doc);
        try {
            Serializator.save(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private  void testLoadView () {
        Catalog catalog = null;
        try {
             catalog = Serializator.load("catalog.ser");
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Document doc = catalog.findById("Java1");
        Serializator.view(doc);
    }
}
