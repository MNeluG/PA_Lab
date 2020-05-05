package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread(GameServer gameServer, Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String request = in.readLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            if(request.equals("stop"))
            {
                String rs = new String("Server stopped");
                out.println(rs);
            }
            else
            {
                String rs = new String("Server received the request: " + request + "!");
                out.println(rs);
            }

            out.flush();
        } catch (IOException e) {
            System.err.println("---ERROR--- " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) { System.err.println (e); }
        }
    }
}