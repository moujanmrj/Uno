import java.util.ArrayList;

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
                cards.add(new NumberCard("blue", i));
                cards.add(new NumberCard("red", i));
                cards.add(new NumberCard("green", i));
                cards.add(new NumberCard("yellow", i));

            }
        }

        cards.add(new NumberCard("blue", 0));
        cards.add(new NumberCard("red", 0));
        cards.add(new NumberCard("green", 0));
        cards.add(new NumberCard("yellow", 0));

        for (int i=0; i<2; i++)
        {
            cards.add(new Reverse("blue"));
            cards.add(new Reverse("red"));
            cards.add(new Reverse("green"));
            cards.add(new Reverse("yellow"));

            cards.add(new Skip("blue"));
            cards.add(new Skip("red"));
            cards.add(new Skip("green"));
            cards.add(new Skip("yellow"));

            cards.add(new Draw("blue"));
            cards.add(new Draw("red"));
            cards.add(new Draw("green"));
            cards.add(new Draw("yellow"));
        }

        for (int i=0; i<2; i++)
        {
            cards.add(new WildCard("wildDraw"));
            cards.add(new WildCard("wildColor"));
        }
    }
}
