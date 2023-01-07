package hr.algebra.java2.bingoproject.model;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Game{

    private final String YES = "YES";
    private final String NO = "NO";

    public Game(){
    }
    private Integer round=0;
    public Player playerOne;
    public Player computer;

    private List<Integer> listOfExtractedNumbers = new ArrayList<>();
    public List<String> playerGuessed_String = new ArrayList<>();
    public List<String> computerGuessed_String = new ArrayList<>();

    public void setListOfExtractedNumbers(List<Integer> listOfExtractedNumbers) {
        this.listOfExtractedNumbers = listOfExtractedNumbers;
    }
    public List<Integer> getListOfExtractedNumbers() {
        return listOfExtractedNumbers;
    }
    public void setRound() {
        this.round ++;
    }
    public Integer getRound() {
        return round;
    }
    public void loadRound(Integer round){ this.round = round;}
    public void setGuessedNumbers(){
        for (Integer number : listOfExtractedNumbers) {
            if (playerOne.guessedNumbers.contains(number))
                playerGuessed_String.add(YES);
            else
                playerGuessed_String.add(NO);

            if (computer.guessedNumbers.contains(number))
                computerGuessed_String.add(YES);
            else
                computerGuessed_String.add(NO);
        }
    }

}
