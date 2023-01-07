package hr.algebra.java2.bingoproject.rmiserver;

import java.util.ArrayList;
import java.util.List;

public class ChatServiceImpl implements ChatService {

    private List<String> allMessages;
    private String lastMessage;

    public ChatServiceImpl(){
        allMessages = new ArrayList<>();
    }

    @Override
    public void sendMessage(String newMessage, String username) {

        String userMessage = username + "-> " + newMessage + "\n";
        allMessages.add(userMessage);
    }

    @Override
    public List<String> receiveAllMessages() { return allMessages; }
}
