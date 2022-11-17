package hr.algebra.java2.bingoproject;

import hr.algebra.java2.bingoproject.model.Game;
import hr.algebra.java2.bingoproject.model.Player;
import hr.algebra.java2.bingoproject.model.SerializableGame;
import hr.algebra.java2.bingoproject.model.Ticket;
import hr.algebra.java2.bingoproject.utils.DocumentationUtils;
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
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.*;
import java.util.*;

public class GameController {

    private int HIGHEST_BINGO_NUMBER = 25;
    private final String BUTTON_STYLE = "-fx-background-color: green";
    private static final String CLASS_EXTENSION = ".class";

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
    @FXML
    private Pane pnPlayerOneTicket;
    @FXML
    private Pane pnComputerTicket;



    private Ticket playerTicket;
    private Ticket computerTicket;
    public Player player;
    public Player computer;
    public void setPlayer(Player player) {
        this.player=player;
    }
    private List<Integer> listOfExtractedNumbers = new ArrayList<>();
    private List<Integer> listOfRandomNumbers_ticket;
    private List<Integer> listOfRandomNumbers_extractedNumber;
    private Boolean isSaved = false;
    private Integer buttonIndex=0;
    private Boolean isGameOver=false;
    private List<Integer> loadedListOfExtractedNumbers;
    private String contentDialog = " won!";
    private String titleDialog="Game over";
    Timeline timer = new Timeline();
    Game game = new Game();
    SerializableGame serializableGame;


    public GameController() {
        playerTicket = new Ticket();
        computerTicket = new Ticket();
        computer = new Player("Computer");
        game.computer=computer;
        listOfRandomNumbers_ticket = new ArrayList<>();
        listOfRandomNumbers_extractedNumber = new ArrayList<>();
        fillListWithRandomNumbers(listOfRandomNumbers_extractedNumber);

        if (HIGHEST_BINGO_NUMBER<25){
            titleDialog="ERROR";
            contentDialog="Highest Bingo number must be HIGHER than 24!";
            displayDialog(titleDialog,contentDialog);
        }
    }

    public void setGameOver(Boolean gameOver) {
        isGameOver = gameOver;
    }

    public Ticket nextTicket(){
        btnStartGame.setVisible(true);
        Ticket ticketDemo = new Ticket();
        listOfRandomNumbers_ticket.clear();
        fillListWithRandomNumbers(listOfRandomNumbers_ticket);

        if (isSaved) ticketDemo=game.playerOne.getTicket();

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

        buttonIndex=0;
        return playerTicket=ticketDemo;
    }

    public Ticket getComputerTicket(){
        Ticket ticketDemo = new Ticket();
        listOfRandomNumbers_ticket.clear();
        fillListWithRandomNumbers(listOfRandomNumbers_ticket);

        if (isSaved) ticketDemo=game.computer.getTicket();

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

        buttonIndex=0;
        return computerTicket=ticketDemo;
    }

    private void addButtonToMainList(Button button, Ticket ticket) {
        if (isSaved){
            button.setText(ticket.mainList.get(buttonIndex).getText());
            button.setStyle(ticket.mainList.get(buttonIndex).getStyle());
            buttonIndex++;
            return;
        }
        button.setText(listOfRandomNumbers_ticket.get(ticket.getMainListSize()).toString());
        ticket.fillMainList(button);
    }

    private void fillListWithRandomNumbers(List<Integer> list) {
        for (int i=1; i<=HIGHEST_BINGO_NUMBER; i++) list.add(i);
        Collections.shuffle(list);
    }

    public void startGame(){
        player.setTicket(playerTicket);
        computer.setTicket(getComputerTicket());
        btnBingo.setVisible(true);
        btnNextTicket.setVisible(false);
        btnStartGame.setVisible(false);
        isGameOver=false;
        pnPlayerOneTicket.setDisable(false);
        pnComputerTicket.setDisable(false);
        startExtractingNumbers();
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
                    contentDialog=game.computer.getNickName()+contentDialog;
                    displayDialog(titleDialog,contentDialog);
                    endOfRound();
                }
                if ((listOfExtractedNumbers.size())%divider==0) lblExtractedNumbers.setText(lblExtractedNumbers.getText() + "\t" + number + "\n");
                else lblExtractedNumbers.setText(lblExtractedNumbers.getText().isEmpty() ? "\t" + number : lblExtractedNumbers.getText() + "\t" + number);

                if (HIGHEST_BINGO_NUMBER>25) divider=15;
                findExtractedNumberInComputerTicket(number);
            }
        });
        timer.getKeyFrames().add(perTwoSecondsKeyframe);
        timer.play();
    }


    private Integer extractNumber(){
        if (loadedListOfExtractedNumbers!=null)listOfRandomNumbers_extractedNumber.removeAll(loadedListOfExtractedNumbers);
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
            endOfRound();
            contentDialog = game.computer.getNickName()+contentDialog;
            displayDialog(titleDialog,contentDialog);
        }
    }

    public void bingo(){

        timer.stop();
        if (player.isBingo()){
            contentDialog = player.getNickName()+contentDialog;
            displayDialog(titleDialog,contentDialog);
            player.setWins();
            computer.setLostGames();
        }
        else{
            contentDialog = computer.getNickName()+contentDialog;
            displayDialog(titleDialog,contentDialog);
            player.setLostGames();
            computer.setWins();
        }
        endOfRound();
    }

    private void endOfRound() {
        btnBingo.setVisible(false);
        game.setRound();
        game.setListOfExtractedNumbers(listOfExtractedNumbers);
        game.playerOne=player;
        game.computer=computer;
        isGameOver=true;
        pnPlayerOneTicket.setDisable(true);
        pnComputerTicket.setDisable(true);
    }

    private static void displayDialog(String title,String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.show();
    }

    public void saveGame() throws IOException {
        if (listOfExtractedNumbers==null) return;
        timer.stop();
        game.setListOfExtractedNumbers(listOfExtractedNumbers);
        game.playerOne = player;
        game.computer = computer;
        btnBingo.setVisible(false);
        pnPlayerOneTicket.setDisable(true);
        pnComputerTicket.setDisable(true);
        prepareTicketForSave();

        try (ObjectOutputStream serializable = new ObjectOutputStream(new FileOutputStream("savedGame.ser"))) {
            serializable.writeObject(serializableGame);
            btnBingo.setVisible(false);
            titleDialog="Game is saved";
            contentDialog="You can close application and continue to play game next time.";
            displayDialog(titleDialog,contentDialog);
        }
    }

    private void prepareTicketForSave(){
        List<String> listOfButtonText_player = new ArrayList<>();
        List<String> listOfButtonStyle_player = new ArrayList<>();
        List<String> listOfButtonText_computer = new ArrayList<>();
        List<String> listOfButtonStyle_computer = new ArrayList<>();

        for (Button button:game.playerOne.getTicket().mainList) {
            listOfButtonText_player.add(button.getText());
            listOfButtonStyle_player.add(button.getStyle());
        }
        for(Button button:game.computer.getTicket().mainList){
            listOfButtonText_computer.add(button.getText());
            listOfButtonStyle_computer.add(button.getStyle());
        }

        serializableGame = new SerializableGame(listOfButtonText_player,listOfButtonStyle_player,game.playerOne.getNickName());
        serializableGame.setComputerButtons(game.computer.getNickName(),listOfButtonText_computer,listOfButtonStyle_computer);
        serializableGame.setPlayersInformation(game.playerOne.getWins(),game.computer.getWins(),game.playerOne.getLostGames(),game.computer.getLostGames(),game.playerOne.guessedNumbers,game.computer.guessedNumbers);
        serializableGame.setGameInformation(game.getRound(),isGameOver,lblExtractedNumbers.getText(),game.getListOfExtractedNumbers());
    }

    public void loadGame() throws IOException, ClassNotFoundException {
        try (ObjectInputStream deserializer = new ObjectInputStream((new FileInputStream("savedGame.ser")))) {
            serializableGame = (SerializableGame) deserializer.readObject();
            game.loadRound(serializableGame.round);
            isSaved = true;
            setLoadedInformation();
            extractingButtonText();
            nextTicket();
            getComputerTicket();
            if (isGameOver) btnStartGame.setVisible(false);
            isSaved = false;
        }
    }

    private void setLoadedInformation() {
        isGameOver=serializableGame.isGameOver;
        if (isGameOver){
            btnBingo.setVisible(false);
            btnNextTicket.setVisible(true);
            btnNextTicket.setOnAction(event -> {
                try {
                    selectNewTicket();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        else{
            btnBingo.setVisible(false);
            btnNextTicket.setVisible(false);
            btnStartGame.setVisible(true);
        }
        pnPlayerOneTicket.setDisable(true);
        pnComputerTicket.setDisable(true);
        lblExtractedNumbers.setText(serializableGame.lblExtractedNumbers);
        player = new Player(serializableGame.playerOne_Name);
        game.playerOne = player;
        game.playerOne.loadWins(serializableGame.playerOne_Wins);
        game.playerOne.loadLostGames(serializableGame.playerOne_LostGames);
        game.playerOne.loadGuessedNumbers(serializableGame.playerOne_guessedNumbers);
        player=game.playerOne;


        computer = new Player(serializableGame.computer_Name);
        game.computer = computer;
        game.computer.loadWins(serializableGame.computer_Wins);
        game.computer.loadLostGames(serializableGame.computer_LostGames);
        game.computer.loadGuessedNumbers(serializableGame.computer_guessedNumbers);
        computer=game.computer;
        loadedListOfExtractedNumbers=serializableGame.listOfExtractedNumbers;
        listOfExtractedNumbers=serializableGame.listOfExtractedNumbers;
        game.setListOfExtractedNumbers(serializableGame.listOfExtractedNumbers);
    }

    private void extractingButtonText(){

        List<Button> newMainButtonList_playerOne = new ArrayList<>();
        List<Button> newMainButtonList_computer = new ArrayList<>();
        for (int i = 0; i< serializableGame.listOfButtonText_playerOne.size(); i++){
            Button player_button = new Button();
            player_button.setText(serializableGame.listOfButtonText_playerOne.get(i));
            player_button.setStyle(serializableGame.listOfButtonStyle_playerOne.get(i));
            newMainButtonList_playerOne.add(player_button);

            Button computer_button = new Button();
            computer_button.setText(serializableGame.listOfButtonText_computer.get(i));
            computer_button.setStyle(serializableGame.listOfButtonStyle_computer.get(i));
            newMainButtonList_computer.add(computer_button);
        }
        game.playerOne.setLoadedMainList(newMainButtonList_playerOne);
        playerTicket=game.playerOne.ticket;

        game.computer.setLoadedMainList(newMainButtonList_computer);
        computerTicket = game.computer.ticket;
    }

    public void generateDocumentation() {
        DocumentationUtils.generateDocumentation();
    }

    public void selectNewTicket() throws IOException {
        if (!isGameOver) return;
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("game.fxml"));
        Parent root = fxmlLoader.load();
        GameController gameController = fxmlLoader.getController();
        gameController.game = game;
        gameController.player = game.playerOne;
        gameController.computer = game.computer;
        loadNewScreen(root, "New ticket");
    }

    public void showScoreboard() throws IOException {

        if (!isGameOver) return;

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("scoreboard.fxml"));
        Parent root = fxmlLoader.load();

        ScoreboardController scoreboardController = fxmlLoader.getController();
        scoreboardController.setScene(game);
        loadNewScreen(root, "Scoreboard");
    }

    public void showAllMoves() throws IOException {

        if (!isGameOver) return;

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("allMoves.fxml"));
        Parent root = fxmlLoader.load();

        AllMovesController allMovesController = fxmlLoader.getController();
        allMovesController.fillTable(game);
        loadNewScreen(root,"All moves");
    }

    public void loadNewScreen(Parent root, String title){
        Scene scene = new Scene(root);
        Application.getMainStage().setTitle(title);
        Application.getMainStage().setScene(scene);
        Application.getMainStage().show();
    }

}
