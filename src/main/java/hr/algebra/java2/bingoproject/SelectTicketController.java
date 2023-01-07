package hr.algebra.java2.bingoproject;

import hr.algebra.java2.bingoproject.client.model.ClientModel;
import hr.algebra.java2.bingoproject.jndi.JNDIConfigurationKey;
import hr.algebra.java2.bingoproject.jndi.JNDIManager;
import hr.algebra.java2.bingoproject.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.naming.NamingException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SelectTicketController implements Initializable {


    @FXML
    private TextField tfPlayerName;
    @FXML
    private Label lblPlayersNameIsEmpty;
    @FXML
    private Label lblPlayerName;

    private Player player;
    private boolean isSinglePlayer = true;

    public static int PORT;
    public static String HOST;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (!Objects.equals(Application.getPlayerName(),""))
            lblPlayerName.setText(Application.getPlayerName());

        try {
            HOST = JNDIManager.getConfigurationParameter(JNDIConfigurationKey.GAME_SERVER_IP);
            PORT = Integer.parseInt(JNDIManager.getConfigurationParameter(JNDIConfigurationKey.GAME_SERVER_PORT));
        } catch (NamingException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void multiplayer() throws IOException {

        //connecting to server
        player = new Player(tfPlayerName.getText());
        if (Objects.equals(player.getNickName(), "")){
            lblPlayersNameIsEmpty.setVisible(true);
            return;
        }
        try (Socket clientSocket = new Socket(HOST, PORT)){
            System.out.println("Welcome " + player.getNickName() + "! Client is connecting to " + clientSocket.getInetAddress() + " - Port: " + clientSocket.getPort());

            sendSerializableRequest(clientSocket);

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        isSinglePlayer=false;
        startGame();
    }

    public void startGame() throws IOException {

        if (player==null){
            player = new Player(tfPlayerName.getText());
            if (Objects.equals(player.getNickName(), "")){
                lblPlayersNameIsEmpty.setVisible(true);
                return;
            }
        }


        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("game.fxml"));
        Parent root = fxmlLoader.load();

        GameController gameController = fxmlLoader.getController();
        gameController.setGame(player, isSinglePlayer);

        loadNewScreen(root);
    }

    private void sendSerializableRequest(Socket client) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

        ClientModel clientModelFromServer = (ClientModel) ois.readObject();
        System.out.println("Message received: Client connected from port " + clientModelFromServer.getPort());
    }

    public void loadNewScreen(Parent root) throws IOException{

        Scene scene = new Scene(root);
        Application.getMainStage().setTitle("Game board");
        Application.getMainStage().setScene(scene);
        Application.getMainStage().show();
    }

}
