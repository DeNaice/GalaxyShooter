package View;

import Controller.IGalaxyShooterController;
import Model.GalaxyShooter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

    public Socket socket = null;
    public ServerSocket server = null;
    public BufferedReader reader = null;

    public PrintWriter writer = null;

    private GalaxyShooter galaxyShooter;


    public static void main(String args[]) {


        System.out.println("Server is running");


    }

    public Server(GalaxyShooter galaxyShooter) {
        this.galaxyShooter = galaxyShooter;

        new Server(galaxyShooter).setup();




    }

    public void setup() {


        try {
            startServer();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void startServer() throws IOException {

        int port = 8080;
        server = new ServerSocket(port);
        socket = server.accept();
        String line = "";
        System.out.println("Server gestartet");
        while (!line.equals("CONNECTED")) {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            line = reader.readLine();
            System.out.println("RECEIVED" + line);


        }


    }


}
