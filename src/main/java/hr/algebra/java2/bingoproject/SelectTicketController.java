package hr.algebra.java2.bingoproject;

import hr.algebra.java2.bingoproject.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SelectTicketController{

    @FXML
    private TextField tfPlayerName;
    @FXML
    private Label lblPlayersNameIsEmpty;
    private Player player;

    public void startGame() throws IOException {

        player = new Player(tfPlayerName.getText());
        if (player.getNickName() == ""){
            lblPlayersNameIsEmpty.setVisible(true);
            return;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("game.fxml"));
        Parent root = fxmlLoader.load();

        GameController gameController = fxmlLoader.getController();
        gameController.setPlayer(player);

        loadNewScreen(root);
    }

    public void loadNewScreen(Parent root) throws IOException{

        Scene scene = new Scene(root);
        Application.getMainStage().setTitle("Game board");
        Application.getMainStage().setScene(scene);
        Application.getMainStage().show();
    }
}
