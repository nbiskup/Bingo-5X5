package hr.algebra.java2.bingoproject;

import hr.algebra.java2.bingoproject.model.Game;
import hr.algebra.java2.bingoproject.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AllMovesController {

    @FXML
    private Label lblExtractedNumbers;
    @FXML
    private Label lblPlayerNumbers;

    private List<Integer> extractedNumbers = new ArrayList<>();
    private Player player;
    private Game game = new Game();
    private String YES = "YES";
    private String NO = "NO";



    public void fillTable(Player player, Game game){
        this.player = player;
        this.game = game;
        extractedNumbers = game.getListOfExtractedNumbers();

        for (int i=0;i<extractedNumbers.size();i++){
            lblExtractedNumbers.setText(lblExtractedNumbers.getText() + extractedNumbers.get(i).toString()+"\n");
            if (player.guessedNumbers.contains(extractedNumbers.get(i))) lblPlayerNumbers.setText(lblPlayerNumbers.getText()+YES+"\n");
            else lblPlayerNumbers.setText(lblPlayerNumbers.getText()+NO+"\n");
        }
    }

    public void returnToGame() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("game.fxml"));
        Parent root = fxmlLoader.load();
        GameController gameController = fxmlLoader.getController();
        gameController.game = game;
        gameController.player = player;
        loadNewScreen(root,"Game");
    }

    public void loadNewScreen(Parent root, String title){
        Scene scene = new Scene(root);
        Application.getMainStage().setTitle(title);
        Application.getMainStage().setScene(scene);
        Application.getMainStage().show();
    }
}
