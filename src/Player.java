import java.util.ArrayList;

public class Player
{

    private ArrayList<UnoCard> playerCards;
    private CardDeck cardDeck;
    private String name;
    private int score;


    public ArrayList<UnoCard> getPlayerCards() { return playerCards; }
    public CardDeck getCardDeck() { return cardDeck; }
    public String getName() { return name; }
    public int getScore() { return score; }

    public void setPlayerCards(ArrayList<UnoCard> playerCards) { this.playerCards = playerCards; }
    public void setCardDeck(CardDeck cardDeck) { this.cardDeck = cardDeck; }
    public void setName(String name) { this.name = name; }
    public void setScore(int score) { this.score = score; }

    public Player(CardDeck cardDeck, String name)
    {
        this.name = name;
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
        setScore(total);
        return total;
    }
}
