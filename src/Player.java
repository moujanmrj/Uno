import java.util.ArrayList;

public class Player
{
    private String playerName;
    private ArrayList<UnoCard> playerCards;
    private CardDeck theCards;

    public ArrayList<UnoCard> getPlayerCards() { return playerCards; }
    public String getPlayerName() { return playerName; }

    public void setPlayerCards(ArrayList<UnoCard> playerCards) { this.playerCards = playerCards; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public Player(String playerName)
    {
        this.playerName = playerName;
        playerCards = new ArrayList<>();
        theCards.shuffledCards(playerCards);
    }


}
