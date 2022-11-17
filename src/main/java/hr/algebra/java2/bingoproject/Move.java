package hr.algebra.java2.bingoproject;

public class Move{
    private final int extractedNumber;
    private final String playerOneContainsString;
    private final String playerTwoContainsString;

    public Move(final int extractedNumber, final String playerOneContainsString, final String playerTwoContainsString){
        this.extractedNumber = extractedNumber;
        this.playerOneContainsString = playerOneContainsString;
        this.playerTwoContainsString = playerTwoContainsString;
    }

    public int getExtractedNumber() {
        return extractedNumber;
    }

    public String getPlayerOneContainsString() {
        return playerOneContainsString;
    }

    public String getPlayerTwoContainsString() {
        return playerTwoContainsString;
    }

}
