package hr.algebra.java2.bingoproject;

import hr.algebra.java2.bingoproject.model.Game;
import hr.algebra.java2.bingoproject.model.Player;
import hr.algebra.java2.bingoproject.model.Ticket;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;

public class GameController {

    private final int HIGHEST_BINGO_NUMBER = 25;
    private final String BUTTON_STYLE = "-fx-background-color: green";
    @FXML
    private Button btnBingo;
    private List<Button> buttonList = new ArrayList<>();

    @FXML
    private Button btnFirstColumnRow1;

    @FXML
    private Button btnFirstColumnRow2;
    @FXML
    private Button btnFirstColumnRow3;
    @FXML
    private Button btnFirstColumnRow4;
    @FXML
    private Button btnFirstColumnRow5;
    @FXML
    private Button btnSecondColumnRow1;
    @FXML
    private Button btnSecondColumnRow2;
    @FXML
    private Button btnSecondColumnRow3;
    @FXML
    private Button btnSecondColumnRow4;
    @FXML
    private Button btnSecondColumnRow5;
    @FXML
    private Button btnThirdColumnRow1;
    @FXML
    private Button btnThirdColumnRow2;
    @FXML
    private Button btnThirdColumnRow3;
    @FXML
    private Button btnThirdColumnRow4;
    @FXML
    private Button btnThirdColumnRow5;
    @FXML
    private Button btnFourthColumnRow1;
    @FXML
    private Button btnFourthColumnRow2;
    @FXML
    private Button btnFourthColumnRow3;
    @FXML
    private Button btnFourthColumnRow4;
    @FXML
    private Button btnFourthColumnRow5;
    @FXML
    private Button btnFifthColumnRow1;
    @FXML
    private Button btnFifthColumnRow2;
    @FXML
    private Button btnFifthColumnRow3;
    @FXML
    private Button btnFifthColumnRow4;
    @FXML
    private Button btnFifthColumnRow5;

    public Ticket ticket;

    public Player player;

    private List<Integer> listOfExtractedNumbers = new ArrayList<>();

    public void setPlayer(Player player) {
        this.player=player;
    }

    private List<Integer> listOfRandomNumbers_ticket;

    private List<Integer> listOfRandomNumbers_extractedNumber;

    @FXML
    private Pane pnTicket;
    @FXML
    private Button btnNextTicket;
    @FXML
    private Button btnStartGame;
    @FXML
    private Label lblExtractedNumber;
    @FXML
    private Label lblExtractedNumbers;

    @FXML
    private Label lblYouWon;
    @FXML
    private Label lblLost;

    private Integer round;

    private List<Player> listOfPlayers = new ArrayList<>();

    Timeline timer = new Timeline();

    Game game = new Game();

    public GameController() {
        ticket = new Ticket();
        listOfRandomNumbers_ticket = new ArrayList<>();
        listOfRandomNumbers_extractedNumber = new ArrayList<>();
        listOfPlayers.add(player);
        fillListWithRandomNumbers(listOfRandomNumbers_extractedNumber);
    }

    public Ticket nextTicket(){
        btnStartGame.setVisible(true);
        Ticket ticketDemo = new Ticket();
        listOfRandomNumbers_ticket.clear();
        fillListWithRandomNumbers(listOfRandomNumbers_ticket);

        addButtonToMainList(btnFirstColumnRow1, ticketDemo);
        addButtonToMainList(btnFirstColumnRow2,ticketDemo);
        addButtonToMainList(btnFirstColumnRow3,ticketDemo);
        addButtonToMainList(btnFirstColumnRow4,ticketDemo);
        addButtonToMainList(btnFirstColumnRow5,ticketDemo);

        addButtonToMainList(btnSecondColumnRow1,ticketDemo);
        addButtonToMainList(btnSecondColumnRow2,ticketDemo);
        addButtonToMainList(btnSecondColumnRow3,ticketDemo);
        addButtonToMainList(btnSecondColumnRow4,ticketDemo);
        addButtonToMainList(btnSecondColumnRow5,ticketDemo);

        addButtonToMainList(btnThirdColumnRow1,ticketDemo);
        addButtonToMainList(btnThirdColumnRow2,ticketDemo);
        addButtonToMainList(btnThirdColumnRow3,ticketDemo);
        addButtonToMainList(btnThirdColumnRow4,ticketDemo);
        addButtonToMainList(btnThirdColumnRow5,ticketDemo);

        addButtonToMainList(btnFourthColumnRow1,ticketDemo);
        addButtonToMainList(btnFourthColumnRow2,ticketDemo);
        addButtonToMainList(btnFourthColumnRow3,ticketDemo);
        addButtonToMainList(btnFourthColumnRow4,ticketDemo);
        addButtonToMainList(btnFourthColumnRow5,ticketDemo);

        addButtonToMainList(btnFifthColumnRow1,ticketDemo);
        addButtonToMainList(btnFifthColumnRow2,ticketDemo);
        addButtonToMainList(btnFifthColumnRow3,ticketDemo);
        addButtonToMainList(btnFifthColumnRow4,ticketDemo);
        addButtonToMainList(btnFifthColumnRow5,ticketDemo);

        return ticket=ticketDemo;
    }

    private void addButtonToMainList(Button button, Ticket ticket) {
        button.setText(listOfRandomNumbers_ticket.get(ticket.getMainListSize()).toString());
        ticket.fillMainList(button);
    }

    private void fillListWithRandomNumbers(List<Integer> list) {
        for (int i=1; i<=HIGHEST_BINGO_NUMBER; i++) list.add(i);
        Collections.shuffle(list);
    }

    public void startGame(){
        btnBingo.setVisible(true);
        btnNextTicket.setVisible(false);
        btnStartGame.setVisible(false);
        ticket.divisionIntoColumns();
        startExtractingNumbers();
        player.setTicket(ticket);
    }

    private void startExtractingNumbers() {
        timer.setCycleCount(Timeline.INDEFINITE);
        KeyFrame perTwoSecondsKeyframe = new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String number = extractNumber();
                lblExtractedNumber.setText(number);
                if (listOfExtractedNumbers.size()==HIGHEST_BINGO_NUMBER){
                    timer.stop();
                    lblLost.setVisible(true);
                    endOfRound();
                }
                lblExtractedNumbers.setText(lblExtractedNumbers.getText().isEmpty() ? "\t" + number + "," : lblExtractedNumbers.getText() + "\t" + number + ",");
                if ((listOfExtractedNumbers.size())%5==0) lblExtractedNumbers.setText(lblExtractedNumbers.getText() + "\n");

            }
        });
        timer.getKeyFrames().add(perTwoSecondsKeyframe);
        timer.play();
    }

    private String extractNumber(){
        int extractedNumber = listOfRandomNumbers_extractedNumber.get(listOfRandomNumbers_extractedNumber.size()-1);
        listOfRandomNumbers_extractedNumber.remove(listOfRandomNumbers_extractedNumber.size()-1);
        listOfExtractedNumbers.add(extractedNumber);

        return Integer.toString(extractedNumber);
    }

    public void button_OnClick(ActionEvent event){
        Button button = (Button) event.getSource();
        if (listOfExtractedNumbers.contains(Integer.parseInt(button.getText()))) {
            button.setStyle(BUTTON_STYLE);
            player.guessedNumbers.add(Integer.valueOf(button.getText()));
        }
    }

    /*private Boolean isInList(Button button){
        int buttonNumber = Integer.parseInt(button.getText());
        for (Integer listOfExtractedNumber : listOfExtractedNumbers) {
            if (buttonNumber == listOfExtractedNumber) return true;
        }

        return false;
    }*/

    public void bingo(){

        timer.stop();
        boolean firstColumnBingo=true, secondColumnBingo=true, thirdColumnBingo=true, fourthColumnBingo=true, fifthColumnBingo=true;

        // ROW
        for (int i=0; i<5;i++){
            if (Objects.equals(ticket.firstColumn.get(i).getStyle(), BUTTON_STYLE)
             && Objects.equals(ticket.secondColumn.get(i).getStyle(), BUTTON_STYLE)
             && Objects.equals(ticket.thirdColumn.get(i).getStyle(), BUTTON_STYLE)
             && Objects.equals(ticket.fourthColumn.get(i).getStyle(), BUTTON_STYLE)
             && Objects.equals(ticket.fifthColumn.get(i).getStyle(), BUTTON_STYLE)) lblYouWon.setVisible(true);
        }

        // COLUMN
        for (int i=0; i<5;i++){
            if (!Objects.equals(ticket.firstColumn.get(i).getStyle(), BUTTON_STYLE)) firstColumnBingo = false;
            if (!Objects.equals(ticket.secondColumn.get(i).getStyle(), BUTTON_STYLE)) secondColumnBingo = false;
            if (!Objects.equals(ticket.thirdColumn.get(i).getStyle(), BUTTON_STYLE)) thirdColumnBingo = false;
            if (!Objects.equals(ticket.fourthColumn.get(i).getStyle(), BUTTON_STYLE)) fourthColumnBingo = false;
            if (!Objects.equals(ticket.fifthColumn.get(i).getStyle(), BUTTON_STYLE)) fifthColumnBingo = false;
        }

        if (firstColumnBingo || secondColumnBingo || thirdColumnBingo || fourthColumnBingo || fifthColumnBingo) lblYouWon.setVisible(true);

        // DIAGONAL
        if (Objects.equals(ticket.firstColumn.get(0).getStyle(), BUTTON_STYLE)
         && Objects.equals(ticket.secondColumn.get(1).getStyle(), BUTTON_STYLE)
         && Objects.equals(ticket.thirdColumn.get(2).getStyle(), BUTTON_STYLE)
         && Objects.equals(ticket.fourthColumn.get(3).getStyle(), BUTTON_STYLE)
         && Objects.equals(ticket.fifthColumn.get(4).getStyle(), BUTTON_STYLE)) lblYouWon.setVisible(true);

        if (!lblYouWon.isVisible()){
            lblLost.setVisible(true);
            player.setLostGames();
        }
        else player.setWins();

        endOfRound();
    }

    private void endOfRound() {
        btnBingo.setVisible(false);
        player.setPoints();
        game.setRound();
        game.setListOfExtractedNumbers(listOfExtractedNumbers);
    }

    public void selectNewTicket() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("game.fxml"));
        Parent root = fxmlLoader.load();
        loadNewScreen(root, "New ticket");
    }

    public void showScoreboard() throws IOException {

        if (game.getRound()==0) return;

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("scoreboard.fxml"));
        Parent root = fxmlLoader.load();

        ScoreboardController scoreboardController = fxmlLoader.getController();
        scoreboardController.setScene(player, game);
        loadNewScreen(root, "Scoreboard");
    }

    public void showAllMoves() throws IOException {

        if (game.getRound()==0) return;

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("allMoves.fxml"));
        Parent root = fxmlLoader.load();

        AllMovesController allMovesController = fxmlLoader.getController();
        allMovesController.fillTable(player, game);
        loadNewScreen(root,"All moves");
    }

    public void loadNewScreen(Parent root, String title) throws IOException {
        Scene scene = new Scene(root);
        Application.getMainStage().setTitle(title);
        Application.getMainStage().setScene(scene);
        Application.getMainStage().show();
    }

}
