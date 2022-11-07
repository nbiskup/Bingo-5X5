package hr.algebra.java2.bingoproject;

import hr.algebra.java2.bingoproject.model.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AllMovesController {

    @FXML
    private Label lblExtractedNumbers;
    @FXML
    private Label lblPlayerOneNumbers;
    @FXML
    private Label lblPlayerTwoNumbers;

    private List<Integer> extractedNumbers = new ArrayList<>();
    private Game game = new Game();
    private String YES = "YES";
    private String NO = "NO";



    public void fillTable(Game game){
        this.game = game;
        extractedNumbers = game.getListOfExtractedNumbers();
        if (game.computer==null || game.playerOne==null) return;

        for (int i=0;i<extractedNumbers.size();i++){
            lblExtractedNumbers.setText(lblExtractedNumbers.getText() + extractedNumbers.get(i).toString()+"\n");
            if (game.playerOne.guessedNumbers.contains(extractedNumbers.get(i))) lblPlayerOneNumbers.setText(lblPlayerOneNumbers.getText()+YES+"\n");
            else lblPlayerOneNumbers.setText(lblPlayerOneNumbers.getText()+NO+"\n");
            if (game.computer.guessedNumbers.contains(extractedNumbers.get(i))) lblPlayerTwoNumbers.setText(lblPlayerTwoNumbers.getText()+YES+"\n");
            else lblPlayerTwoNumbers.setText(lblPlayerTwoNumbers.getText()+NO+"\n");
        }
    }

    public void returnToGame() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("game.fxml"));
        Parent root = fxmlLoader.load();
        GameController gameController = fxmlLoader.getController();
        gameController.game = game;
        gameController.player = game.playerOne;
        gameController.computer = game.computer;
        loadNewScreen(root,"Game");
    }

    public void loadNewScreen(Parent root, String title){
        Scene scene = new Scene(root);
        Application.getMainStage().setTitle(title);
        Application.getMainStage().setScene(scene);
        Application.getMainStage().show();
    }
}
