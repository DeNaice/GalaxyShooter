package View;

import Controller.GalaxyShooterController;
import Controller.IGalaxyShooterController;
import Controller.IGalaxyShooterView;
import processing.core.PApplet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server{

    public Socket socket = null;
    public ServerSocket server = null;
    public BufferedReader reader = null;

    public PrintWriter writer = null;

    IGalaxyShooterController controller;


    public static void main(String args[]) {

        new Server().setup();
        System.out.println("Server is running");







    }

    public Server() {





    }

    public void setup() {


        try {
            startServer();

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }




    public void startServer() throws IOException{

        int port = 8080;
        server = new ServerSocket(port);
        socket = server.accept();
        String line = "";
        System.out.println("Server gestartet");
        while (!line.equals("CONNECTED")){
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            line = reader.readLine();
            System.out.println("RECEIVED" + line);


        }


    }






}
