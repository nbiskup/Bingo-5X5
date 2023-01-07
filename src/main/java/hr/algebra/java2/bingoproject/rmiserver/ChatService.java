package hr.algebra.java2.bingoproject.rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatService extends Remote {
    String REMOTE_OBJECT_NAME = "hr.algebra.rmi.service";

    void sendMessage(String newMessage, String username) throws RemoteException;
    List<String> receiveAllMessages() throws RemoteException;
}
