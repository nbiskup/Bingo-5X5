package hr.algebra.java2.bingoproject;

import hr.algebra.java2.bingoproject.model.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;


public class ScoreboardController {

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


    public void setScene(Game game) {
        this.game = game;
        lblPlayerOneName.setText(game.playerOne.getNickName());
        lblPlayerOneLost.setText(game.playerOne.getLostGames().toString());
        lblPlayerOneWon.setText(game.playerOne.getWins().toString());
        lblPlayerOnePoints.setText(game.playerOne.getPoints().toString());

        lblPlayerTwoName.setText(game.computer.getNickName());
        lblPlayerTwoLost.setText(game.computer.getLostGames().toString());
        lblPlayerTwoWon.setText(game.computer.getWins().toString());
        lblPlayerTwoPoints.setText(game.computer.getPoints().toString());

        lblRound.setText(game.getRound().toString());
    }

    public void returnToGame() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("game.fxml"));
        Parent root = fxmlLoader.load();
        GameController gameController = fxmlLoader.getController();
        gameController.player = game.playerOne;
        gameController.computer = game.computer;
        gameController.game = game;
        gameController.setGameOver(true);
        loadNewScreen(root,"Game");
    }

    public void loadNewScreen(Parent root, String title){
        Scene scene = new Scene(root);
        Application.getMainStage().setTitle(title);
        Application.getMainStage().setScene(scene);
        Application.getMainStage().show();
    }
}