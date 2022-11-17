package hr.algebra.java2.bingoproject.model;

import java.io.Serializable;
import java.util.List;

public class SerializableGame implements Serializable {


    //Game information
    public String lblExtractedNumbers;
    public List<Integer> listOfExtractedNumbers;
    public int round = 0;
    public Boolean isGameOver;


    //Player 1 information
    public String playerOne_Name;
    public List<String> listOfButtonText_playerOne;
    public List<String> listOfButtonStyle_playerOne;
    public Integer playerOne_Wins;
    public Integer playerOne_LostGames;
    public List<Integer> playerOne_guessedNumbers;


    /* Player 2 information
    public String playerTwo_Name;
    public List<String> listOfButtonText_playerTwo;
    public List<String> listOfButtonStyle_playerTwo;
    public Integer playerTwo_Wins;
    public Integer playerTwo_LostGames;*/


    //Computer information
    public String computer_Name;
    public List<String> listOfButtonText_computer;
    public List<String> listOfButtonStyle_computer;
    public Integer computer_Wins;
    public Integer computer_LostGames;
    public List<Integer> computer_guessedNumbers;


    public SerializableGame(List<String> listOfButtonText_playerOne, List<String> listOfButtonStyle_playerOne, String playerOne_Name) {
        this.listOfButtonText_playerOne = listOfButtonText_playerOne;
        this.listOfButtonStyle_playerOne = listOfButtonStyle_playerOne;
        this.playerOne_Name = playerOne_Name;
    }

    public void setComputerButtons(String computer_Name, List<String> listOfButtonText_computer, List<String> listOfButtonStyle_computer){
        this.computer_Name=computer_Name;
        this.listOfButtonText_computer = listOfButtonText_computer;
        this.listOfButtonStyle_computer = listOfButtonStyle_computer;
    }

    public void setPlayersInformation(Integer playerOne_Wins, Integer computer_Wins, Integer playerOne_LostGames, Integer computer_LostGames,List<Integer> playerOne_guessedNumbers,List<Integer> computer_guessedNumbers){
       this.playerOne_Wins = playerOne_Wins;
        this.playerOne_LostGames = playerOne_LostGames;
        this.computer_Wins = computer_Wins;
        this.computer_LostGames = computer_LostGames;
        this.playerOne_guessedNumbers = playerOne_guessedNumbers;
        this.computer_guessedNumbers = computer_guessedNumbers;
    }

    public void setGameInformation(Integer round,Boolean isGameOver,String lblExtractedNumbers, List<Integer> listOfExtractedNumbers){
        this.round = round;
        this.isGameOver = isGameOver;
        this.lblExtractedNumbers = lblExtractedNumbers;
        this.listOfExtractedNumbers = listOfExtractedNumbers;
    }

}
