package com.company;
import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {
        try {
            ArtistController artists = new ArtistController();
            AlbumController albums = new AlbumController();

            artists.create("Radiohead", "United Kingdom");
            artists.create("Phoenix", "Romania");
            Database.commit();

            Integer phoenixId = artists.findByName("Phoenix");
            Integer radioHead = artists.findByName("Radiohead");
            
            albums.create(phoenixId, "Mugur de fluier", 1974);
            albums.create(radioHead, "Ok Computer", 1997);
            albums.create(radioHead, "Kid A", 2000);
            albums.create(radioHead, "In Rainbows", 2007);

            albums.list(radioHead); //displays all the albums from the specified artist
            Database.commit();
            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}