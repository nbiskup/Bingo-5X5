package hr.algebra.java2.bingoproject.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public Player(Ticket ticket) {
        this.ticket = ticket;
    }
    public Player(String nickName) {
        this.nickName = nickName;
        guessedNumbers = new ArrayList<>();
    }
    private String nickName;
    private Integer points=0;
    private Ticket ticket;
    public List<Integer> guessedNumbers;
    private Integer wins = 0;
    private Integer lostGames = 0;

    public Integer getWins() {
        return wins;
    }

    public void setWins() {
        this.wins += 1;
    }

    public void setLostGames() {
        this.lostGames += 1;
    }

    public Integer getLostGames() {
        return lostGames;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String guessedNumbersToString() {
        String stringGuessedNumbers="";
        for (int i=0; i<guessedNumbers.size();i++){
            if (i<guessedNumbers.size()-1){
                stringGuessedNumbers+=guessedNumbers.get(i)+", ";
            }
        }
        return stringGuessedNumbers;
    }

    public String getNickName() {return nickName;}

    public Integer getPoints() {return points;}

    public Integer setPoints() {return points=wins*10-lostGames*10;}

    @Override
    public String toString() {return nickName;}
}
