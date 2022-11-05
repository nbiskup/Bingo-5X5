package hr.algebra.java2.bingoproject;

import hr.algebra.java2.bingoproject.model.Game;
import hr.algebra.java2.bingoproject.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class ScoreboardController {

    private Player player;
    @FXML
    private Pane panePlayerOne;
    @FXML
    private Pane panePlayerTwo;

    @FXML
    private Label lblPlayerOneName;
    @FXML
    private Label lblPlayerTwoName;
    @FXML
    private Label lblRound;
    @FXML
    private Label lblPlayerOnePoints;
    @FXML
    private Label lblPlayerTwoPoints;
    @FXML
    private Label lblPlayerOneWon;
    @FXML
    private Label lblPlayerTwoWon;
    @FXML
    private Label lblPlayerOneLost;
    @FXML
    private Label lblPlayerTwoLost;

    private Game game = new Game();


    public void setScene(Player player, Game game) {
        this.game = game;
        this.player=player;
        lblPlayerOneName.setText(player.getNickName());
        lblPlayerOneLost.setText(player.getLostGames().toString());
        lblPlayerOneWon.setText(player.getWins().toString());
        lblPlayerOnePoints.setText(player.getPoints().toString());
        lblRound.setText(game.getRound().toString());
    }

    public void returnToGame() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("game.fxml"));
        Parent root = fxmlLoader.load();
        GameController gameController = fxmlLoader.getController();
        gameController.player=player;
        gameController.game = game;
        loadNewScreen(root,"Game");
    }

    public void loadNewScreen(Parent root, String title){
        Scene scene = new Scene(root);
        Application.getMainStage().setTitle(title);
        Application.getMainStage().setScene(scene);
        Application.getMainStage().show();
    }
}