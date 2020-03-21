package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements java.io.Serializable{
    List<Document> documents;

    Catalog() {
        documents = new ArrayList<>();
    }

    public void add(Document document) {
        documents.add(document);
    }

    public void save(String path) {
        //Serializare
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Wrote catalog in " + path);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Catalog load(String path) {
        //Deserializare
        Catalog rez;

        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            rez = (Catalog) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Document class not found");
            c.printStackTrace();
            return null;
        }

        return rez;
    }

    public void list() {
        for (Document document : documents)
            System.out.println(document);
    }
}


