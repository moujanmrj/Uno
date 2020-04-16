import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Table
{
    private ArrayList<UnoCard> tableCards;
    private CardDeck cardDeck;

    public ArrayList<UnoCard> getTableCards() { return tableCards; }
    public CardDeck getCardDeck() { return cardDeck; }

    public void setTableCards(ArrayList<UnoCard> tableCards) { this.tableCards = tableCards; }
    public void setCardDeck(CardDeck cardDeck) { this.cardDeck = cardDeck; }

    public Table(CardDeck cardDeck)
    {
        this.cardDeck = cardDeck;
    }

    public void firstCard(ArrayList<UnoCard> playCards)
    {
        tableCards = new ArrayList<>();
        Collections.shuffle(playCards);
        tableCards.add(playCards.get(0));
        playCards.remove(0);
        cardDeck.printCard(tableCards.get(0));
    }

    public void readCard(String colorMode, String actionNum, Player player)
    {
        int i = 0;
        boolean put = false;
        Iterator<UnoCard> iterator = player.getPlayerCards().iterator();
        while(iterator.hasNext())
        {
            if (tableCards.get(tableCards.size()-1)instanceof WildDraw && colorMode.equals("wild") && actionNum.equals("draw"))
            {
                put = true;
                iterator.remove();
                tableCards.add(player.getPlayerCards().get(i));
                applyEffectWildDraw();
                break;
            }
            else if (tableCards.get(tableCards.size()-1)instanceof WildColor && colorMode.equals("wild") && actionNum.equals("color"))
            {
                put = true;
                iterator.remove();
                tableCards.add(player.getPlayerCards().get(i));
                applyEffectWildColor();
                break;
            }
            else if (tableCards.get(tableCards.size()-1)instanceof Draw  && actionNum.equals("draw") && (tableCards.get(tableCards.size()-1).getColor().equals(colorMode)))
            {
                put = true;
                iterator.remove();
                tableCards.add(player.getPlayerCards().get(i));
                applyEffectDraw();
                break;
            }
            else if (tableCards.get(tableCards.size()-1)instanceof Skip && actionNum.equals("skip") && (tableCards.get(tableCards.size()-1).getColor().equals(colorMode)))
            {
                put = true;
                iterator.remove();
                tableCards.add(player.getPlayerCards().get(i));
                applyEffectSkip();
                break;
            }
            else if (tableCards.get(tableCards.size()-1)instanceof Reverse && actionNum.equals("reverse") && (tableCards.get(tableCards.size()-1).getColor().equals(colorMode)))
            {
                put = true;
                iterator.remove();
                tableCards.add(player.getPlayerCards().get(i));
                applyEffectReverse();
                break;
            }
            else if (tableCards.get(tableCards.size()-1)instanceof NumberCard && (tableCards.get(tableCards.size()-1).getColor().equals(colorMode)))
            {
                put = true;
                iterator.remove();
                tableCards.add(player.getPlayerCards().get(i));
                applyEffect();
                break;
            }
            i++;
        }
        if (!put)
        {
            System.out.println("wrong card to play!!!");
        }
    }

    private void applyEffectWildDraw() {
    }
    private void applyEffectWildColor() {
    }
    private void applyEffectDraw() {
    }
    private void applyEffect() {
    }
    private void applyEffectSkip() {
    }
    private void applyEffectReverse() {
    }
}
