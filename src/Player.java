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
        System.out.println("Your Cards");
        System.out.println("______________________________________________________________________");
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
        if (table.getTableCards().get(table.getTableCards().size()-1).getValue().equals("skip") && !(table.getTableCards().get(table.getTableCards().size()-1).isBlocked()))
        {
            block = true;
            table.getTableCards().get(table.getTableCards().size()-1).setBlocked(true);
        }
        if (table.getTableCards().get(table.getTableCards().size()-1).getValue().equals("draw+2")&& !(table.getTableCards().get(table.getTableCards().size()-1).isBlocked()))
        {
            boolean draw2 = false;
            table.setDraw1();
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
                table.getTableCards().get(table.getTableCards().size()-1).setBlocked(true);
                block = true;
                table.setDraw(0);
            }


        }
        if (table.getTableCards().get(table.getTableCards().size()-1).getValue().equals("wildDraw+4")&& !(table.getTableCards().get(table.getTableCards().size()-1).isBlocked()))
        {
            boolean wildDraw = false;
            table.setWildDraw1();
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
                table.getTableCards().get(table.getTableCards().size()-1).setBlocked(true);
                table.setWildDraw(0);
                block = true;
            }
        }

        if (name.equals("player1") && !block)
        {
            System.out.println(name);
            validMove = valid(table);
            if (validMove.size() == 0)
            {
                playerCards.add(cardDeck.getCards().get(0));
                cardDeck.getCards().remove(0);
            }
            validMove = valid(table);
            if (validMove.size() != 0)
            {
                this.showHand();
                Scanner scanner = new Scanner(System.in);
                System.out.println("choose your card\n");
                int move = scanner.nextInt();
                if (validMove.contains(playerCards.get(move-1)))
                {
                    table.getTableCards().add(playerCards.get(move-1));
                    if (table.getTableCards().get(table.getTableCards().size()-1).getValue().equals("reverse"))
                    {
                        table.setClockWise(!table.getClockWise());
                    }
                    playerCards.remove(move-1);
                    if (table.getTableCards().get(table.getTableCards().size()-1).getValue().equals("wildColor"))
                    {
                        String color = scanner.nextLine();
                        table.setLastColor(color);
                    }
                    else
                    {
                        table.setLastColor(table.getTableCards().get(table.getTableCards().size()-1).getColor());
                    }
                }
                else
                {
                    System.out.println("wrong move!");
                }
            }

        }
        else if (!name.equals("player1") && !block)
        {
            System.out.println(name);
            validMove = valid(table);
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
                if (table.getTableCards().get(table.getTableCards().size()-1).getValue().equals("reverse"))
                {
                    table.setClockWise(!table.getClockWise());
                }
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
                        System.out.println("BLUE");
                    }
                    else if ( max == r)
                    {
                        table.setLastColor("red");
                        System.out.println("RED");
                    }
                    else if ( max == g)
                    {
                        table.setLastColor("green");
                        System.out.println("GREEN");
                    }
                    else
                    {
                        table.setLastColor("yellow");
                        System.out.println("YELLOW");
                    }
                }
                else
                {
                    table.setLastColor(table.getTableCards().get(table.getTableCards().size()-1).getColor());
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
