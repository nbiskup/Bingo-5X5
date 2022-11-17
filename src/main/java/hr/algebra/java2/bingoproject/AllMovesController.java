package hr.algebra.java2.bingoproject;
import hr.algebra.java2.bingoproject.model.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class AllMovesController {

    @FXML
    private TableView tblMoves;

    private Game game = new Game();
    private ObservableList<Move> allMoves;

    public void fillTable(Game game){
        this.game = game;
        if (game.computer==null || game.playerOne==null) return;

        List<Integer> extractedNumbers = game.getListOfExtractedNumbers();
        allMoves = FXCollections.observableArrayList();
        game.setGuessedNumbers();
        for (int i = 0; i<extractedNumbers.size();i++) {
            allMoves.add(new Move(extractedNumbers.get(i),game.playerGuessed_String.get(i),game.computerGuessed_String.get(i)));
        }

        init();
        tblMoves.setItems(allMoves);
    }

    private void init(){
        TableColumn ColumnExtractedNumbers = new TableColumn<>("Extracted numbers");
        ColumnExtractedNumbers.setPrefWidth(150);
        ColumnExtractedNumbers.setCellValueFactory(
                new PropertyValueFactory<Move,Integer>("extractedNumber")
        );

        TableColumn ColumnPlayerGuessed = new TableColumn<>("Player contains");
        ColumnPlayerGuessed.setPrefWidth(150);
        ColumnPlayerGuessed.setCellValueFactory(
                new PropertyValueFactory<Move,String>("playerOneContainsString")
        );

        TableColumn ColumnComputerGuessed = new TableColumn<>("Computer contains");
        ColumnComputerGuessed.setPrefWidth(150);
        ColumnComputerGuessed.setCellValueFactory(
                new PropertyValueFactory<Move,String>("playerTwoContainsString")
        );

        tblMoves.getColumns().addAll(ColumnExtractedNumbers, ColumnPlayerGuessed, ColumnComputerGuessed);
    }

    public void returnToGame() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("game.fxml"));
        Parent root = fxmlLoader.load();
        GameController gameController = fxmlLoader.getController();
        gameController.game = game;
        gameController.player = game.playerOne;
        gameController.computer = game.computer;
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
