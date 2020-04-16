import java.util.ArrayList;

public class Player
{

    private ArrayList<UnoCard> playerCards;
    private CardDeck cardDeck;

    public ArrayList<UnoCard> getPlayerCards() { return playerCards; }
    public CardDeck getCardDeck() { return cardDeck; }

    public void setPlayerCards(ArrayList<UnoCard> playerCards) { this.playerCards = playerCards; }
    public void setCardDeck(CardDeck cardDeck) { this.cardDeck = cardDeck; }

    public Player(CardDeck cardDeck)
    {
        this.cardDeck = cardDeck;
        playerCards = new ArrayList<>();
        cardDeck.shuffledCards(playerCards);
    }

    public void showHand()
    {
        for (UnoCard print : playerCards)
        {
           cardDeck.printCard(print);
        }
        System.out.println("______________________________________________________________________");
        System.out.println();
    }

    public int TotalScore()
    {
        int total = 0;
        for (UnoCard score : playerCards)
        {
            total += score.getValue();
        }
        return total;
    }
}
