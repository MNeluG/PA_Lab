package com.company;

public class LoadCommand {
    public void run(Catalog catalog, String[] arr) {
        catalog = Catalog.load(arr[1]);
    }
}
