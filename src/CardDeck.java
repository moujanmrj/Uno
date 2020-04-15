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

        for (int i=0; i<2; i++)
        {
            cards.add(new WildCard("black","wild draw +4"));
            cards.add(new WildCard("black","wild color"));
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
}
