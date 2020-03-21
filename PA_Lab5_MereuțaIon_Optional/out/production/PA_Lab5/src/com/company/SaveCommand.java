package com.company;

public class SaveCommand {
    public void run(Catalog catalog, String[] arr) {
        catalog.save(arr[1]);
    }
}
