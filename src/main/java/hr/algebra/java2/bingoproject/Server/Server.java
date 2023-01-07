package hr.algebra.java2.bingoproject.Server;

import hr.algebra.java2.bingoproject.client.model.ClientModel;
import hr.algebra.java2.bingoproject.jndi.JNDIConfigurationKey;
import hr.algebra.java2.bingoproject.jndi.JNDIManager;

import javax.naming.NamingException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {

    public static int PORT;
    public static String HOST;

    private static Map<Integer,ClientModel> clientsMap = new HashMap<>();
    public static void main(String[] args){
        setServerProperties();
        acceptRequest();
    }

    private static void setServerProperties() {
        try {
            HOST = JNDIManager.getConfigurationParameter(JNDIConfigurationKey.GAME_SERVER_IP);
            PORT = Integer.parseInt(JNDIManager.getConfigurationParameter(JNDIConfigurationKey.GAME_SERVER_PORT));
        } catch (NamingException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void acceptRequest() {

        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server listening on port: " + serverSocket.getLocalPort() + "\n");

            while (true){

                if (clientsMap.size()<2){
                    Socket clientSocket  = serverSocket.accept();
                    System.out.println("Client connected from port: " + clientSocket.getPort());

                    clientsMap.put(clientSocket.getPort(), new ClientModel(clientSocket.getPort(), HOST));
                    new Thread(() -> processSerializableClient(clientSocket)).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processSerializableClient(Socket clientSocket) {
        try (ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());){

            System.out.println("The message has been sent!" + "\n");
            oos.writeObject(clientsMap.get(clientSocket.getPort()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
