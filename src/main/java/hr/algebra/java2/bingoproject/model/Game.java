package hr.algebra.java2.bingoproject.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();;

    private List<List<Integer>> listOfExtractedNumbers = new ArrayList<>();
    private Integer round=0;

    public Game() {
    }

    public Game(List<Player> players, Integer round) {
        this.players = players;
        this.round = round;
    }

    public void setListOfExtractedNumbers(List<Integer> listOfExtractedNumbers) {
        this.listOfExtractedNumbers.add(listOfExtractedNumbers);
    }

    public List<Integer> getListOfExtractedNumbers() {
        return listOfExtractedNumbers.get(round-1);
    }

    public void setRound() {
        this.round += 1;
    }

    public Integer getRound() {
        return round;
    }


}
