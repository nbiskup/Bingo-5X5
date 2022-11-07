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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;

public class GameController {

    private int HIGHEST_BINGO_NUMBER = 25;
    private final String BUTTON_STYLE = "-fx-background-color: green";

    @FXML
    private Button btnFirstColumnRow1_PlayerOne;
    @FXML
    private Button btnFirstColumnRow2_PlayerOne;
    @FXML
    private Button btnFirstColumnRow3_PlayerOne;
    @FXML
    private Button btnFirstColumnRow4_PlayerOne;
    @FXML
    private Button btnFirstColumnRow5_PlayerOne;
    @FXML
    private Button btnSecondColumnRow1_PlayerOne;
    @FXML
    private Button btnSecondColumnRow2_PlayerOne;
    @FXML
    private Button btnSecondColumnRow3_PlayerOne;
    @FXML
    private Button btnSecondColumnRow4_PlayerOne;
    @FXML
    private Button btnSecondColumnRow5_PlayerOne;
    @FXML
    private Button btnThirdColumnRow1_PlayerOne;
    @FXML
    private Button btnThirdColumnRow2_PlayerOne;
    @FXML
    private Button btnThirdColumnRow3_PlayerOne;
    @FXML
    private Button btnThirdColumnRow4_PlayerOne;
    @FXML
    private Button btnThirdColumnRow5_PlayerOne;
    @FXML
    private Button btnFourthColumnRow1_PlayerOne;
    @FXML
    private Button btnFourthColumnRow2_PlayerOne;
    @FXML
    private Button btnFourthColumnRow3_PlayerOne;
    @FXML
    private Button btnFourthColumnRow4_PlayerOne;
    @FXML
    private Button btnFourthColumnRow5_PlayerOne;
    @FXML
    private Button btnFifthColumnRow1_PlayerOne;
    @FXML
    private Button btnFifthColumnRow2_PlayerOne;
    @FXML
    private Button btnFifthColumnRow3_PlayerOne;
    @FXML
    private Button btnFifthColumnRow4_PlayerOne;
    @FXML
    private Button btnFifthColumnRow5_PlayerOne;



    @FXML
    private Button btnFirstColumnRow1_PlayerTwo;
    @FXML
    private Button btnFirstColumnRow2_PlayerTwo;
    @FXML
    private Button btnFirstColumnRow3_PlayerTwo;
    @FXML
    private Button btnFirstColumnRow4_PlayerTwo;
    @FXML
    private Button btnFirstColumnRow5_PlayerTwo;
    @FXML
    private Button btnSecondColumnRow1_PlayerTwo;
    @FXML
    private Button btnSecondColumnRow2_PlayerTwo;
    @FXML
    private Button btnSecondColumnRow3_PlayerTwo;
    @FXML
    private Button btnSecondColumnRow4_PlayerTwo;
    @FXML
    private Button btnSecondColumnRow5_PlayerTwo;
    @FXML
    private Button btnThirdColumnRow1_PlayerTwo;
    @FXML
    private Button btnThirdColumnRow2_PlayerTwo;
    @FXML
    private Button btnThirdColumnRow3_PlayerTwo;
    @FXML
    private Button btnThirdColumnRow4_PlayerTwo;
    @FXML
    private Button btnThirdColumnRow5_PlayerTwo;
    @FXML
    private Button btnFourthColumnRow1_PlayerTwo;
    @FXML
    private Button btnFourthColumnRow2_PlayerTwo;
    @FXML
    private Button btnFourthColumnRow3_PlayerTwo;
    @FXML
    private Button btnFourthColumnRow4_PlayerTwo;
    @FXML
    private Button btnFourthColumnRow5_PlayerTwo;
    @FXML
    private Button btnFifthColumnRow1_PlayerTwo;
    @FXML
    private Button btnFifthColumnRow2_PlayerTwo;
    @FXML
    private Button btnFifthColumnRow3_PlayerTwo;
    @FXML
    private Button btnFifthColumnRow4_PlayerTwo;
    @FXML
    private Button btnFifthColumnRow5_PlayerTwo;


    @FXML
    private Button btnBingo;
    @FXML
    private Button btnNextTicket;
    @FXML
    private Button btnStartGame;
    @FXML
    private Label lblExtractedNumber;
    @FXML
    private Label lblExtractedNumbers;

    private Ticket playerTicket;
    private Ticket computerTicket;
    public Player player;
    public Player computer;
    public void setPlayer(Player player) {
        this.player=player;
    }
    private List<Player> listOfPlayers = new ArrayList<>();
    private List<Integer> listOfExtractedNumbers = new ArrayList<>();
    private List<Integer> listOfRandomNumbers_ticket;
    private List<Integer> listOfRandomNumbers_extractedNumber;

    Timeline timer = new Timeline();
    Game game = new Game();

    public GameController() {
        playerTicket = new Ticket();
        computerTicket = new Ticket();
        computer = new Player("Computer");
        listOfRandomNumbers_ticket = new ArrayList<>();
        listOfRandomNumbers_extractedNumber = new ArrayList<>();
        fillListWithRandomNumbers(listOfRandomNumbers_extractedNumber);
        if (HIGHEST_BINGO_NUMBER<25) displayVictoryDialog("DANGER");
    }

    public Ticket nextTicket(){
        btnStartGame.setVisible(true);
        Ticket ticketDemo = new Ticket();
        listOfRandomNumbers_ticket.clear();
        fillListWithRandomNumbers(listOfRandomNumbers_ticket);

        addButtonToMainList(btnFirstColumnRow1_PlayerOne, ticketDemo);
        addButtonToMainList(btnFirstColumnRow2_PlayerOne,ticketDemo);
        addButtonToMainList(btnFirstColumnRow3_PlayerOne,ticketDemo);
        addButtonToMainList(btnFirstColumnRow4_PlayerOne,ticketDemo);
        addButtonToMainList(btnFirstColumnRow5_PlayerOne,ticketDemo);

        addButtonToMainList(btnSecondColumnRow1_PlayerOne,ticketDemo);
        addButtonToMainList(btnSecondColumnRow2_PlayerOne,ticketDemo);
        addButtonToMainList(btnSecondColumnRow3_PlayerOne,ticketDemo);
        addButtonToMainList(btnSecondColumnRow4_PlayerOne,ticketDemo);
        addButtonToMainList(btnSecondColumnRow5_PlayerOne,ticketDemo);

        addButtonToMainList(btnThirdColumnRow1_PlayerOne,ticketDemo);
        addButtonToMainList(btnThirdColumnRow2_PlayerOne,ticketDemo);
        addButtonToMainList(btnThirdColumnRow3_PlayerOne,ticketDemo);
        addButtonToMainList(btnThirdColumnRow4_PlayerOne,ticketDemo);
        addButtonToMainList(btnThirdColumnRow5_PlayerOne,ticketDemo);

        addButtonToMainList(btnFourthColumnRow1_PlayerOne,ticketDemo);
        addButtonToMainList(btnFourthColumnRow2_PlayerOne,ticketDemo);
        addButtonToMainList(btnFourthColumnRow3_PlayerOne,ticketDemo);
        addButtonToMainList(btnFourthColumnRow4_PlayerOne,ticketDemo);
        addButtonToMainList(btnFourthColumnRow5_PlayerOne,ticketDemo);

        addButtonToMainList(btnFifthColumnRow1_PlayerOne,ticketDemo);
        addButtonToMainList(btnFifthColumnRow2_PlayerOne,ticketDemo);
        addButtonToMainList(btnFifthColumnRow3_PlayerOne,ticketDemo);
        addButtonToMainList(btnFifthColumnRow4_PlayerOne,ticketDemo);
        addButtonToMainList(btnFifthColumnRow5_PlayerOne,ticketDemo);

        return playerTicket =ticketDemo;
    }

    public Ticket getComputerTicket(){
        Ticket ticketDemo = new Ticket();
        listOfRandomNumbers_ticket.clear();
        fillListWithRandomNumbers(listOfRandomNumbers_ticket);

        addButtonToMainList(btnFirstColumnRow1_PlayerTwo, ticketDemo);
        addButtonToMainList(btnFirstColumnRow2_PlayerTwo,ticketDemo);
        addButtonToMainList(btnFirstColumnRow3_PlayerTwo,ticketDemo);
        addButtonToMainList(btnFirstColumnRow4_PlayerTwo,ticketDemo);
        addButtonToMainList(btnFirstColumnRow5_PlayerTwo,ticketDemo);

        addButtonToMainList(btnSecondColumnRow1_PlayerTwo,ticketDemo);
        addButtonToMainList(btnSecondColumnRow2_PlayerTwo,ticketDemo);
        addButtonToMainList(btnSecondColumnRow3_PlayerTwo,ticketDemo);
        addButtonToMainList(btnSecondColumnRow4_PlayerTwo,ticketDemo);
        addButtonToMainList(btnSecondColumnRow5_PlayerTwo,ticketDemo);

        addButtonToMainList(btnThirdColumnRow1_PlayerTwo,ticketDemo);
        addButtonToMainList(btnThirdColumnRow2_PlayerTwo,ticketDemo);
        addButtonToMainList(btnThirdColumnRow3_PlayerTwo,ticketDemo);
        addButtonToMainList(btnThirdColumnRow4_PlayerTwo,ticketDemo);
        addButtonToMainList(btnThirdColumnRow5_PlayerTwo,ticketDemo);

        addButtonToMainList(btnFourthColumnRow1_PlayerTwo,ticketDemo);
        addButtonToMainList(btnFourthColumnRow2_PlayerTwo,ticketDemo);
        addButtonToMainList(btnFourthColumnRow3_PlayerTwo,ticketDemo);
        addButtonToMainList(btnFourthColumnRow4_PlayerTwo,ticketDemo);
        addButtonToMainList(btnFourthColumnRow5_PlayerTwo,ticketDemo);

        addButtonToMainList(btnFifthColumnRow1_PlayerTwo,ticketDemo);
        addButtonToMainList(btnFifthColumnRow2_PlayerTwo,ticketDemo);
        addButtonToMainList(btnFifthColumnRow3_PlayerTwo,ticketDemo);
        addButtonToMainList(btnFifthColumnRow4_PlayerTwo,ticketDemo);
        addButtonToMainList(btnFifthColumnRow5_PlayerTwo,ticketDemo);

        return ticketDemo;
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
        startExtractingNumbers();
        player.setTicket(playerTicket);
        computer.setTicket(getComputerTicket());
        computerTicket=computer.getTicket();
        computerBingo();
    }

    private void startExtractingNumbers() {
        timer.setCycleCount(Timeline.INDEFINITE);
        KeyFrame perTwoSecondsKeyframe = new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Integer number = extractNumber();
                Integer divider=5;
                lblExtractedNumber.setText(number.toString());
                if (listOfExtractedNumbers.size()==HIGHEST_BINGO_NUMBER){
                    timer.stop();
                    displayVictoryDialog(computer.getNickName());
                    endOfRound();
                }
                lblExtractedNumbers.setText(lblExtractedNumbers.getText().isEmpty() ? "\t" + number : lblExtractedNumbers.getText() + "\t" + number);
                if (HIGHEST_BINGO_NUMBER>25) divider=15;
                if ((listOfExtractedNumbers.size())%divider==0) lblExtractedNumbers.setText(lblExtractedNumbers.getText() + "\n");
                findExtractedNumberInComputerTicket(number);
            }
        });
        timer.getKeyFrames().add(perTwoSecondsKeyframe);
        timer.play();
    }


    private Integer extractNumber(){
        int extractedNumber = listOfRandomNumbers_extractedNumber.get(listOfRandomNumbers_extractedNumber.size()-1);
        listOfRandomNumbers_extractedNumber.remove(listOfRandomNumbers_extractedNumber.size()-1);
        listOfExtractedNumbers.add(extractedNumber);

        return extractedNumber;
    }

    public void button_OnClick(ActionEvent event){
        Button button = (Button) event.getSource();
        if (listOfExtractedNumbers.contains(Integer.parseInt(button.getText()))) {
            button.setStyle(BUTTON_STYLE);
            player.guessedNumbers.add(Integer.valueOf(button.getText()));
        }
    }

    private void findExtractedNumberInComputerTicket(Integer number ) {
        for (int i=0;i<computerTicket.mainList.size();i++){
            if (Integer.parseInt(computerTicket.mainList.get(i).getText())==number){
                computerTicket.mainList.get(i).setStyle(BUTTON_STYLE);
                computer.guessedNumbers.add(Integer.valueOf(computerTicket.mainList.get(i).getText()));
                computerBingo();
            }
        }
    }

    private void computerBingo() {
        if (computer.isBingo()){
            timer.stop();
            player.setLostGames();
            computer.setWins();
            displayVictoryDialog(computer.getNickName());
            endOfRound();
        }
    }

    public void bingo(){
        timer.stop();

        if (player.isBingo()){
            displayVictoryDialog(player.getNickName());
            player.setWins();
            computer.setLostGames();
        }
        else{
            displayVictoryDialog(computer.getNickName());
            player.setLostGames();
            computer.setWins();
        }
        endOfRound();
    }

    private static void displayVictoryDialog(String playerName) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("GAME OVER!");
        alert.setContentText("Player " + playerName.toUpperCase() + " won!");
        alert.showAndWait();
    }

    private void endOfRound() {
        btnBingo.setVisible(false);
        player.setPoints();
        computer.setPoints();
        game.setRound();
        game.setListOfExtractedNumbers(listOfExtractedNumbers);
        game.playerOne=player;
        game.computer=computer;
    }

    public void selectNewTicket() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("game.fxml"));
        Parent root = fxmlLoader.load();
        GameController gameController = fxmlLoader.getController();
        gameController.game = game;
        gameController.player = game.playerOne;
        gameController.computer = game.computer;
        loadNewScreen(root, "New ticket");
    }

    public void showScoreboard() throws IOException {

        if (game.getRound()==0) return;

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("scoreboard.fxml"));
        Parent root = fxmlLoader.load();

        ScoreboardController scoreboardController = fxmlLoader.getController();
        scoreboardController.setScene(game);
        loadNewScreen(root, "Scoreboard");
    }

    public void showAllMoves() throws IOException {

        if (game.getRound()==0) return;

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("allMoves.fxml"));
        Parent root = fxmlLoader.load();

        AllMovesController allMovesController = fxmlLoader.getController();
        allMovesController.fillTable(game);
        loadNewScreen(root,"All moves");
    }

    public void loadNewScreen(Parent root, String title) throws IOException {
        Scene scene = new Scene(root);
        Application.getMainStage().setTitle(title);
        Application.getMainStage().setScene(scene);
        Application.getMainStage().show();
    }

}
