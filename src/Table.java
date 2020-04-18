import java.util.ArrayList;
import java.util.Collections;


public class Table {

    private ArrayList<UnoCard> tableCards;
    private CardDeck cardDeck;
    private boolean clockWise;
    private ArrayList<UnoCard> validCards;
    private ArrayList<Player> players;
    private int turn;
    private String lastColor;
    private int wildDraw = 0;
    private int draw = 0;

    public ArrayList<UnoCard> getTableCards() {
        return tableCards;
    }
    public CardDeck getCardDeck() { return cardDeck; }
    public boolean getClockWise() { return clockWise; }
    public ArrayList<UnoCard> getValidCards() { return validCards; }
    public int getTurn() { return turn; }
    public String getLastColor() { return lastColor; }

    public int getWildDraw() {
        return wildDraw;
    }

    public void setWildDraw1() {
        this.wildDraw++;
    }
    public void setWildDraw(int i)
    {
        this.wildDraw = i;
    }


    public int getDraw() {
        return draw;
    }
    public void setDraw(int i) {
        this.draw = i;
    }

    public void setDraw1() {
        this.draw++;
    }

    public void setTableCards(ArrayList<UnoCard> tableCards) { this.tableCards = tableCards; }
    public void setCardDeck(CardDeck cardDeck) { this.cardDeck = cardDeck; }
    public void setClockWise(boolean clockWise) { this.clockWise = clockWise; }
    public void setValidCards(ArrayList<UnoCard> validCards) { this.validCards = validCards; }
    public ArrayList<Player> getPlayers() { return players; }
    public void setTurn(int turn) { this.turn += turn; }
    public void setLastColor(String lastColor) { this.lastColor = lastColor; }

    public Table(CardDeck cardDeck) {
        players = new ArrayList<>();
        tableCards = new ArrayList<>();
        this.cardDeck = cardDeck;
        clockWise = true;
        turn = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void firstCard()
    {
        System.out.println("First Card");
        Collections.shuffle(cardDeck.getCards());
        while (cardDeck.getCards().get(cardDeck.getCards().size()-1).getColor().equals("black"))
        {
            Collections.shuffle(cardDeck.getCards());
        }
        tableCards.add(cardDeck.getCards().get(cardDeck.getCards().size()-1));
        cardDeck.printCard(tableCards.get(0));
        this.setLastColor(this.getTableCards().get(this.getTableCards().size()-1).getColor());
    }
    public boolean checkWinner( int num) {
        boolean winner = true;
        for (int i = 0; i < num-1; i++) {
            if (players.get(i).getPlayerCards().size() == 0) {
                winner = false;
                break;
            }
        }
        return winner;
    }

    public void showResult()
    {
        for(Player player:players)
            player.TotalScore();
        Collections.sort(players);
        for(int i =  0; i < players.size() ; i++)
        {
            System.out.println((i+1) + "-" + players.get(i).getName() + " score:" + players.get(i).getScore());
        }
    }

    public void setDirection(int numOfPlayers)
    {
        if (clockWise)

        {
            if(turn == numOfPlayers-1)
                turn = 0;
            else
                turn++;
        }
        else
        {
            if(turn == 0)
                turn = numOfPlayers-1;
            else
                turn--;
        }
    }
    public void showLastCard()
    {
        System.out.println("last Card");
        cardDeck.printCard(tableCards.get(tableCards.size()-1));
    }
}
