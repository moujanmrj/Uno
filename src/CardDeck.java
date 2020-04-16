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
                cards.add(new NumberCard("blue", i,"number"));
                cards.add(new NumberCard("red", i,"number"));
                cards.add(new NumberCard("green", i,"number"));
                cards.add(new NumberCard("yellow", i,"number"));

            }
        }

        cards.add(new NumberCard("blue", 0,"number"));
        cards.add(new NumberCard("red", 0,"number"));
        cards.add(new NumberCard("green", 0,"number"));
        cards.add(new NumberCard("yellow", 0,"number"));

        for (int i=0; i<2; i++)
        {
            cards.add(new Reverse("blue","reverse"));
            cards.add(new Reverse("red","reverse"));
            cards.add(new Reverse("green","reverse"));
            cards.add(new Reverse("yellow","reverse"));

            cards.add(new Skip("blue","skip"));
            cards.add(new Skip("red","skip"));
            cards.add(new Skip("green","skip"));
            cards.add(new Skip("yellow","skip"));

            cards.add(new Draw("blue","draw +2"));
            cards.add(new Draw("red","draw +2"));
            cards.add(new Draw("green","draw +2"));
            cards.add(new Draw("yellow","draw +2"));
        }

        for (int i=0; i<4; i++)
        {
            cards.add(new WildDraw("black","wild draw +4"));
            cards.add(new WildColor("black","wild color"));
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
}
