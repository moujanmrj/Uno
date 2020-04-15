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
            switch (print.getColor()) {
                case "blue":
                    System.out.println("\u001B[34m" + "****************" + "\u001B[0m");
                    System.out.println("\u001B[34m" + "*              *" + "\u001B[0m");
                    if (print.getClass().getName().equals("NumberCard"))
                        System.out.println("\u001B[34m" + "*      " + print.getValue() + "       *" + "\u001B[0m");
                    else
                        System.out.println("\u001B[34m" + "*    " + print.getClass().getName() + "\u001B[0m");
                    System.out.println("\u001B[34m" + "*              *" + "\u001B[0m");
                    System.out.println("\u001B[34m" + "****************" + "\u001B[0m");
                    break;
                case "red":
                    System.out.println("\u001B[31m" + "****************" + "\u001B[0m");
                    System.out.println("\u001B[31m" + "*              *" + "\u001B[0m");
                    if (print.getClass().getName().equals("NumberCard"))
                        System.out.println("\u001B[31m" + "*      " + print.getValue() + "       *" + "\u001B[0m");
                    else
                        System.out.println("\u001B[31m" + "*    " + print.getClass().getName() + "\u001B[0m");
                    System.out.println("\u001B[31m" + "*              *" + "\u001B[0m");
                    System.out.println("\u001B[31m" + "****************" + "\u001B[0m");

                    break;
                case "green":
                    System.out.println("\u001B[32m" + "****************" + "\u001B[0m");
                    System.out.println("\u001B[32m" + "*              *" + "\u001B[0m");
                    if (print.getClass().getName().equals("NumberCard"))
                        System.out.println("\u001B[32m" + "*      " + print.getValue() + "       *" + "\u001B[0m");
                    else
                        System.out.println("\u001B[32m" + "*    " + print.getClass().getName() + "\u001B[0m");
                    System.out.println("\u001B[32m" + "*              *" + "\u001B[0m");
                    System.out.println("\u001B[32m" + "****************" + "\u001B[0m");
                    break;
                case "yellow":
                    System.out.println("\u001B[33m" + "****************" + "\u001B[0m");
                    System.out.println("\u001B[33m" + "*              *" + "\u001B[0m");
                    if (print.getClass().getName().equals("NumberCard"))
                        System.out.println("\u001B[33m" + "*      " + print.getValue() + "       *" + "\u001B[0m");
                    else
                        System.out.println("\u001B[33m" + "*    " + print.getClass().getName() + "\u001B[0m");
                    System.out.println("\u001B[33m" + "*              *" + "\u001B[0m");
                    System.out.println("\u001B[33m" + "****************" + "\u001B[0m");
                    break;
                case "black":
                    System.out.println("****************");
                    System.out.println("*              *");
                    System.out.println("*   " + print.getClass().getName());
                    System.out.println("*              *");
                    System.out.println("****************");
                    break;
            }
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
