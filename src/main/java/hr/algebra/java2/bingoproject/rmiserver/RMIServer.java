package hr.algebra.java2.bingoproject.rmiserver;

import hr.algebra.java2.bingoproject.jndi.JNDIConfigurationKey;
import hr.algebra.java2.bingoproject.jndi.JNDIManager;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {

    public static void main(String[] args){
        try {
            String rmiPortString = JNDIManager.getConfigurationParameter(JNDIConfigurationKey.RMI_SERVER_PORT);
            int rmiPort = Integer.parseInt(rmiPortString);

            String rndPortString = JNDIManager.getConfigurationParameter(JNDIConfigurationKey.RANDOM_PORT);
            int rndPort = Integer.parseInt(rndPortString);

            Registry registry = LocateRegistry.createRegistry(rmiPort);
            ChatService chatService = new ChatServiceImpl();
            ChatService skeleton = (ChatService) UnicastRemoteObject.exportObject(chatService, rndPort);
            registry.rebind(ChatService.REMOTE_OBJECT_NAME,skeleton);
            System.err.println("Object registered in RMI registry");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
