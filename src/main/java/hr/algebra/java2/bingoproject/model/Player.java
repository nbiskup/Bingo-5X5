package hr.algebra.java2.bingoproject.model;

import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {

    public Player(Ticket ticket) {
        this.ticket = ticket;
    }
    public Player(String nickName) {
        this.nickName = nickName;
        guessedNumbers = new ArrayList<>();
    }
    private final String BUTTON_STYLE = "-fx-background-color: green";
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
        ticket.divisionIntoColumns();
    }
    public Ticket getTicket() { return ticket; }

    public String getNickName() {return nickName;}

    public Integer getPoints() {return points;}

    public Integer setPoints() {return points=wins*10-lostGames*10;}

    public boolean isBingo(){
        boolean firstColumnBingo=true, secondColumnBingo=true, thirdColumnBingo=true, fourthColumnBingo=true, fifthColumnBingo=true;

        // ROW
        for (int i=0; i<5;i++){
            if (firstColumnInList(i) && secondColumnInList(i) && thirdColumnInList(i) && fourthColumnInList(i) && fifthColumnInList(i)) return true;
        }

        // COLUMN
        for (int i=0; i<5;i++){
            if (!firstColumnInList(i))  firstColumnBingo  = false;
            if (!secondColumnInList(i)) secondColumnBingo = false;
            if (!thirdColumnInList(i))  thirdColumnBingo  = false;
            if (!fourthColumnInList(i)) fourthColumnBingo = false;
            if (!fifthColumnInList(i))  fifthColumnBingo  = false;
        }

        if (firstColumnBingo || secondColumnBingo || thirdColumnBingo || fourthColumnBingo || fifthColumnBingo) return true;

        // DIAGONAL
        if (firstColumnInList(0) && secondColumnInList(1) && thirdColumnInList(2) && fourthColumnInList(3) && fifthColumnInList(4)) return true;

        return false;
    }

    private boolean firstColumnInList(int index) {
        if (Objects.equals(ticket.firstColumn.get(index).getStyle(), BUTTON_STYLE)) return true;
        return false;
    }
    private boolean secondColumnInList(int index) {
        if (Objects.equals(ticket.secondColumn.get(index).getStyle(), BUTTON_STYLE)) return true;
        return false;
    }
    private boolean thirdColumnInList(int index) {
        if (Objects.equals(ticket.thirdColumn.get(index).getStyle(), BUTTON_STYLE)) return true;
        return false;
    }
    private boolean fourthColumnInList(int index) {
        if (Objects.equals(ticket.fourthColumn.get(index).getStyle(), BUTTON_STYLE)) return true;
        return false;
    }
    private boolean fifthColumnInList(int index) {
        if (Objects.equals(ticket.fifthColumn.get(index).getStyle(), BUTTON_STYLE)) return true;
        return false;
    }


    @Override
    public String toString() {return nickName;}
}
