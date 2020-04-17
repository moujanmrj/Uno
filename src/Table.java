import jdk.nashorn.api.tree.LiteralTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Table
{
    private ArrayList<UnoCard> tableCards;
    private CardDeck cardDeck;
    private boolean direction;
    private ArrayList<UnoCard> validCards;

    public ArrayList<UnoCard> getTableCards() { return tableCards; }
    public CardDeck getCardDeck() { return cardDeck; }
    public boolean getDirection() { return direction; }
    public ArrayList<UnoCard> getValidCards() { return validCards; }

    public void setTableCards(ArrayList<UnoCard> tableCards) { this.tableCards = tableCards; }
    public void setCardDeck(CardDeck cardDeck) { this.cardDeck = cardDeck; }
    public void setDirection(boolean direction) { this.direction = direction; }
    public void setValidCards(ArrayList<UnoCard> validCards) { this.validCards = validCards; }

    public Table(CardDeck cardDeck)
    {
        this.cardDeck = cardDeck;
        direction = true;
    }

    public void firstCard(ArrayList<UnoCard> playCards)
    {
        tableCards = new ArrayList<>();
        Collections.shuffle(playCards);
        tableCards.add(playCards.get(0));
        playCards.remove(0);
        cardDeck.printCard(tableCards.get(0));
    }
    public ArrayList<UnoCard> validCart()
    {
        
    }
    public int readCard(String colorMode, String actionNum, Player player)
    {
        int mode = 0;
        int i = 0;
        boolean put = false;
        Iterator<UnoCard> iterator = player.getPlayerCards().iterator();
        for (UnoCard find:player.getPlayerCards())
        {
            if
            if (tableCards.get(tableCards.size()-1)instanceof WildDraw && colorMode.equals("wild") && actionNum.equals("draw"))
            {
                put = true;
                iterator.remove();
                tableCards.add(player.getPlayerCards().get(i));
                mode = applyEffectWildDraw();
                break;
            }
            else if (tableCards.get(tableCards.size()-1)instanceof WildColor && colorMode.equals("wild") && actionNum.equals("color"))
            {
                put = true;
                iterator.remove();
                tableCards.add(player.getPlayerCards().get(i));
                mode = applyEffectWildColor();
                break;
            }
            boolean checkHand = false;
            for ()
            else if (colorMode.equals("wild"))
            {

            }
            else if (tableCards.get(tableCards.size()-1)instanceof Draw  && actionNum.equals("draw") && (tableCards.get(tableCards.size()-1).getColor().equals(colorMode)))
            {
                put = true;
                iterator.remove();
                tableCards.add(player.getPlayerCards().get(i));
                mode = applyEffectDraw();
                break;
            }
            else if (tableCards.get(tableCards.size()-1)instanceof Skip && actionNum.equals("skip") && (tableCards.get(tableCards.size()-1).getColor().equals(colorMode)))
            {
                put = true;
                iterator.remove();
                tableCards.add(player.getPlayerCards().get(i));
                mode = applyEffectSkip();
                break;
            }
            else if (tableCards.get(tableCards.size()-1)instanceof Reverse && actionNum.equals("reverse") && (tableCards.get(tableCards.size()-1).getColor().equals(colorMode)))
            {
                put = true;
                iterator.remove();
                tableCards.add(player.getPlayerCards().get(i));
                mode = applyEffectReverse();
                break;
            }
            else if (tableCards.get(tableCards.size()-1)instanceof NumberCard && (tableCards.get(tableCards.size()-1).getColor().equals(colorMode)))
            {
                put = true;
                iterator.remove();
                tableCards.add(player.getPlayerCards().get(i));
                mode = 7;
                break;
            }
            i++;
        }
        if (put)

            cardDeck.printCard(tableCards.get(tableCards.size()-1));
        return mode;
    }

    public int applyEffectWildDraw()
    {
        return 4;
    }

    public int applyEffectWildColor()
    {
        return 3;
    }

    public int applyEffectDraw()
    {
        return 5;
    }

    public int applyEffectSkip()
    {
        return 6;
    }

    public int applyEffectReverse()
    {
        setDirection(!direction);
        if (getDirection())
            return 1;
        else
            return 2;
    }

    public void showDirection()
    {
        if (direction)
            System.out.println("clock wise 1 2 3 4 5");
        else
            System.out.println("non-clock wise 5 4 3 2 1");
    }

//    public void AIPlayers(Player player)
//    {
//        Iterator<UnoCard> iterator = player.getPlayerCards().iterator();
//        int i = 0;
//        while(iterator.hasNext())
//        {
//
//            if (tableCards.get(tableCards.size()-1).getColor().equals(iterator.))
//        i++;
//        }
//    }

    public boolean checkWinner(ArrayList<Player> players, int num)
    {
        boolean winner = true;
        for (int i=0; i<num; i++)
        {
            if (players.get(i).TotalScore() == 0)
            {
                winner = false;
                break;
            }
        }
        if (!winner)
        {
//            displayWinner(players, num);
        }
        return winner;
    }

//    public void displayWinner(ArrayList<Player> players, int num)
//    {
//        ArrayList<Player> result = new ArrayList<>();
//        for (int i=0; i<num; i++)
//        {
//            result = players;
//        }
//        Collections.sort(result.get(i).TotalScore());
//        for (int i=0; i<num; i++)
//        {
//
//        }
//    }
}
