package com.company;
import java.util.ArrayList;
import java.util.List;

public abstract class Document implements java.io.Serializable {
        protected String name, path;
        protected List<String> authors;
        protected Integer year;

        Document(String name, String path, Integer year, String... authors){
            this.name = name;
            this.path = path;
            this.year = year;
            this.authors = new ArrayList<>();
            for (String author : authors) {
                this.authors.add(author);
            }
        }
        @Override
    public String toString(){
            return "Document " + "name = " + name  + " path = '" + path  + " authors = " + authors + " year = " + year;
        }
    }

