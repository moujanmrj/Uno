import java.util.*;

public class Player implements Comparable<Player>
{
    private ArrayList<UnoCard> validMove;
    private ArrayList<UnoCard> playerCards;
    private CardDeck cardDeck;
    private String name;
    private Integer score;


    public ArrayList<UnoCard> getPlayerCards() { return playerCards; }
    public CardDeck getCardDeck() { return cardDeck; }
    public String getName() { return name; }
    public Integer getScore() { return score; }
    public ArrayList<UnoCard> getValidMove() { return validMove; }

    public void setValidMove(ArrayList<UnoCard> validMove) { this.validMove = validMove; }
    public void setPlayerCards(ArrayList<UnoCard> playerCards) { this.playerCards = playerCards; }
    public void setCardDeck(CardDeck cardDeck) { this.cardDeck = cardDeck; }
    public void setName(String name) { this.name = name; }
    public void setScore(Integer score) { this.score = score; }

    public Player(CardDeck cardDeck, String name)
    {
        score = 0;
        validMove = new ArrayList<>();
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

    public void TotalScore()
    {
        int total = 0;
        for (UnoCard score : playerCards)
        {
            total += score.getPoint();
        }
        setScore(total);
        this.score = total;
    }

    public ArrayList<UnoCard> valid (Table table)
    {
        ArrayList<UnoCard> validMove = new ArrayList<>();
        for (UnoCard card : playerCards) {
            if (table.getLastColor().equals(card.getColor()) || table.getTableCards().get(table.getTableCards().size() - 1).getValue().equals(card.getValue())) {
                validMove.add(card);
            }
        }
        int validSize = validMove.size();
        for (UnoCard playerCard : playerCards) {
            if (playerCard.getColor().equals("black")) {
                if (validSize == 0) {
                    validMove.add(playerCard);
                }
            }
        }
        return validMove;
    }




    public void play(Table table)
    {
        boolean block = false;
        if (table.getTableCards().get(table.getTableCards().size()-1).getValue().equals("skip"))
        {
            block = true;
        }
        if (table.getTableCards().get(table.getTableCards().size()-1).getValue().equals("reverse"))
        {
            table.setClockWise(!table.getClockWise());
            block = true;
        }
        if (table.getTableCards().get(table.getTableCards().size()-1).getValue().equals("draw+2"))
        {
            boolean draw2 = false;
            table.setDraw();
            for(UnoCard search : validMove)
            {
                if (search.getValue().equals("draw+2"))
                {
                    draw2 = true;
                    break;
                }
            }
            if (!draw2)
            {
                for (int i=0; i<table.getDraw()*2; i++)
                {
                    playerCards.add(cardDeck.getCards().get(0));
                    cardDeck.getCards().remove(0);
                }
            }
            block = true;
        }
        if (table.getTableCards().get(table.getTableCards().size()-1).getValue().equals("wildDraw+4"))
        {
            boolean wildDraw = false;
            table.setDraw();
            for(UnoCard search : validMove)
            {
                if (search.getValue().equals("wildDraw+4"))
                {
                    wildDraw = true;
                    break;
                }
            }
            if (!wildDraw)
            {
                for (int i=0; i<table.getDraw()*4; i++)
                {
                    playerCards.add(cardDeck.getCards().get(0));
                    cardDeck.getCards().remove(0);
                }
            }
            block = true;
        }

        if (table.getTurn() == 0 && !block)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("choose your card\n");
            int move = scanner.nextInt();
            if (validMove.size() == 0)
            {
                playerCards.add(cardDeck.getCards().get(0));
                cardDeck.getCards().remove(0);
            }
            validMove = valid(table);
            if (validMove.contains(playerCards.get(move-1)))
            {
                table.getTableCards().add(playerCards.get(move-1));
                playerCards.remove(move-1);
                if (table.getTableCards().get(table.getTableCards().size()-1).getValue().equals("wildColor"))
                {
                    String color = scanner.nextLine();
                    table.setLastColor(color);
                }
            }
            else
            {
                System.out.println("wrong move!");
            }
        }
        else if (table.getTurn() != 0 && !block)
        {
            if (validMove.size() == 0)
            {
                playerCards.add(cardDeck.getCards().get(0));
                cardDeck.getCards().remove(0);
            }
            validMove = valid(table);
            if (validMove.size() != 0)
            {
                Collections.shuffle(validMove);
                table.getTableCards().add(validMove.get(0));
                if (table.getTableCards().get(table.getTableCards().size()-1).getValue().equals("wildColor"))
                {
                    int b=0, r=0, g=0, y=0;
                    for (UnoCard set : playerCards)
                    {
                        switch (set.getColor())
                        {
                            case "blue":
                                b++;
                                break;
                            case "red":
                                r++;
                                break;
                            case "green":
                                g++;
                                break;
                            case "yellow":
                                y++;
                                break;
                        }
                    }
                    int max = Math.max(Math.max(r, b), Math.max(g, y));

                    if ( max == b)
                    {
                        table.setLastColor("blue");
                    }
                    else if ( max == r)
                    {
                        table.setLastColor("red");
                    }
                    else if ( max == g)
                    {
                        table.setLastColor("green");
                    }
                    else
                    {
                        table.setLastColor("yellow");
                    }
                }
                playerCards.remove(validMove.get(0));
                validMove.remove(0);
            }
        }
    }

    @Override
    public int compareTo(Player o) {
        return this.getScore().compareTo(o.getScore());
    }
}
