package com.company;

public class Article extends Document {
    Article(String name, String path, Integer year, String... authors) {
        super(name, path, year, authors);
    }
}
