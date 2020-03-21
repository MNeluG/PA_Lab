package com.company;

public class Book extends Document {

    Book(String name, String path, Integer year, String... authors) {
        super(name, path, year, authors);
    }
}

