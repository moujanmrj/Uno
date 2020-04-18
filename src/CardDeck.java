import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CardDeck
{
    private ArrayList<UnoCard> cards;

    public ArrayList<UnoCard> getCards() { return cards; }

    public void setCards(ArrayList<UnoCard> cards) { this.cards = cards; }

    public CardDeck()
    {
        cards = new ArrayList<>();
        for (int j=0; j<2; j++)
        {
            for (int i=1; i<10; i++)
            {
                cards.add(new UnoCard("blue", i, "number" + i) {
                });
                cards.add(new UnoCard("red", i, "number" + i) {
                });
                cards.add(new UnoCard("green", i, "number" + i) {
                });
                cards.add(new UnoCard("yellow", i,"number" + i));

            }
        }

        cards.add(new UnoCard("blue", 0,"number" + 0));
        cards.add(new UnoCard("red", 0,"number" + 0));
        cards.add(new UnoCard("green", 0,"number"+ 0));
        cards.add(new UnoCard("yellow", 0,"number"+ 0));

        for (int i=0; i<2; i++)
        {
            cards.add(new UnoCard("blue",20,"reverse"));
            cards.add(new UnoCard("red",20,"reverse"));
            cards.add(new UnoCard("green",20,"reverse"));
            cards.add(new UnoCard("yellow",20,"reverse"));

            cards.add(new UnoCard("blue",20,"skip"));
            cards.add(new UnoCard("red",20,"skip"));
            cards.add(new UnoCard("green",20,"skip"));
            cards.add(new UnoCard("yellow",20,"skip"));

            cards.add(new UnoCard("blue",20,"draw+2"));
            cards.add(new UnoCard("red",20,"draw+2"));
            cards.add(new UnoCard("green",20,"draw+2"));
            cards.add(new UnoCard("yellow",20,"draw+2"));
        }

        for (int i=0; i<4; i++)
        {
            cards.add(new UnoCard("black",50,"wildDraw+4"));
            cards.add(new UnoCard("black",50,"wildColor"));
        }
    }

    public void shuffledCards(ArrayList<UnoCard> playerCards)
    {
        Iterator<UnoCard> iterator = cards.iterator();
        Collections.shuffle(cards);
        int i=0;
        while(iterator.hasNext() && i<7)
        {
            playerCards.add(cards.get(i));
            cards.remove(i);
            i++;
        }
    }

    public void printCard(UnoCard print)
    {
        switch (print.getColor()) {
            case "blue":
                System.out.println("\u001B[34m" + "****************" + "\u001B[0m");
                System.out.println("\u001B[34m" + "*              *" + "\u001B[0m");
                if (print.getClass().getName().equals("NumberCard"))
                    System.out.println("\u001B[34m" + "*      " + print.getValue() + "       *" + "\u001B[0m");
                else
                    System.out.println("\u001B[34m" + "*    " + print.getValue() + "\u001B[0m");
                System.out.println("\u001B[34m" + "*              *" + "\u001B[0m");
                System.out.println("\u001B[34m" + "****************" + "\u001B[0m");
                break;
            case "red":
                System.out.println("\u001B[31m" + "****************" + "\u001B[0m");
                System.out.println("\u001B[31m" + "*              *" + "\u001B[0m");
                if (print.getClass().getName().equals("NumberCard"))
                    System.out.println("\u001B[31m" + "*      " + print.getValue() + "       *" + "\u001B[0m");
                else
                    System.out.println("\u001B[31m" + "*    " + print.getValue() + "\u001B[0m");
                System.out.println("\u001B[31m" + "*              *" + "\u001B[0m");
                System.out.println("\u001B[31m" + "****************" + "\u001B[0m");

                break;
            case "green":
                System.out.println("\u001B[32m" + "****************" + "\u001B[0m");
                System.out.println("\u001B[32m" + "*              *" + "\u001B[0m");
                if (print.getClass().getName().equals("NumberCard"))
                    System.out.println("\u001B[32m" + "*      " + print.getValue() + "       *" + "\u001B[0m");
                else
                    System.out.println("\u001B[32m" + "*    " + print.getValue() + "\u001B[0m");
                System.out.println("\u001B[32m" + "*              *" + "\u001B[0m");
                System.out.println("\u001B[32m" + "****************" + "\u001B[0m");
                break;
            case "yellow":
                System.out.println("\u001B[33m" + "****************" + "\u001B[0m");
                System.out.println("\u001B[33m" + "*              *" + "\u001B[0m");
                if (print.getClass().getName().equals("NumberCard"))
                    System.out.println("\u001B[33m" + "*      " + print.getValue() + "       *" + "\u001B[0m");
                else
                    System.out.println("\u001B[33m" + "*    " + print.getValue() + "\u001B[0m");
                System.out.println("\u001B[33m" + "*              *" + "\u001B[0m");
                System.out.println("\u001B[33m" + "****************" + "\u001B[0m");
                break;
            case "black":
                System.out.println("****************");
                System.out.println("*              *");
                System.out.println("*   " + print.getValue());
                System.out.println("*              *");
                System.out.println("****************");
                break;
        }
    }
}
