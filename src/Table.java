import java.util.*;

/**
 * this class is the table that we put the cards on
 *
 * @author Moujan Mirjalili
 * @version 2020
 */
public class Table {
    //this field has the cards on the table we're playing on
    private ArrayList<UnoCard> tableCards;
    //this field has the cards deck
    private CardDeck cardDeck;
    //this field shows in which direction we're playing
    private boolean clockWise;
    //this field has a list of valid cards that each player can play in each turn
    private ArrayList<UnoCard> validCards;
    //this field has the list of players
    private ArrayList<Player> players;
    //this field shows the turn
    private int turn;
    //this field holds the last color of card on the table
    private String lastColor;
    //this field is for the times that wild draw cards are played continuously
    private int wildDraw = 0;
    //this field is for the times that draw cards are played continuously
    private int draw = 0;

    /**
     * this method returns table cards
     *
     * @return table cards
     */
    public ArrayList<UnoCard> getTableCards() {
        return tableCards;
    }



    /**
     * this method returns the direction we're playing
     *
     * @return direction we're playing
     */
    public boolean isClockWise() {
        return clockWise;
    }
/////////////////////////////////////////////////////////////////
    /**
     * this method returns turn
     *
     * @return turn
     */
    public int getTurn() {
        return turn;
    }

    /**
     * this method returns the last color of the card on the table
     *
     * @return last color of the card on the table
     */
    public String getLastColor() {
        return lastColor;
    }

    /**
     * this method gets the number of continuous draws
     *
     * @return number of continuous draws
     */
    public int getDraw() {
        return draw;
    }

    /**
     * this method gets the list of players
     *
     * @return list of players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     *this method sets continuous wild draws
     */
    public void setWildDraw1() {
        this.wildDraw++;
    }

    /**
     *this method sets continuous wild draws (in another way)
     */
    public void setWildDraw(int i) {
        this.wildDraw = i;
    }

    /**
     *this method sets continuous draws
     */
    public void setDraw(int i) {
        this.draw = i;
    }

    /**
     *this method sets continuous draws (in another way)
     */
    public void setDraw1() {
        this.draw++;
    }

    /**
     * this method sets the direction we're playing in
     *
     * @param clockWise direction we're playing in
     */
    public void setClockWise(boolean clockWise) {
        this.clockWise = clockWise;
    }

    /**
     * this method sets the color of the last card on the table
     *
     * @param lastColor last card on the table
     */
    public void setLastColor(String lastColor) {
        this.lastColor = lastColor;
    }

    /**
     * this method is the constructor of the table we're playing on
     *
     * @param cardDeck is the deck of cards of the game
     */
    public Table(CardDeck cardDeck) {
        players = new ArrayList<>();
        tableCards = new ArrayList<>();
        this.cardDeck = cardDeck;
        clockWise = true;
        turn = 0;
    }

    /**
     * this method add player
     *
     * @param player the player
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * this method puts the first card on the table
     */
    public void firstCard() {
        System.out.println("First Card");
        Collections.shuffle(cardDeck.getCards());
        while (cardDeck.getCards().get(cardDeck.getCards().size() - 1).getColor().equals("black")) {
            Collections.shuffle(cardDeck.getCards());
        }
        tableCards.add(cardDeck.getCards().get(cardDeck.getCards().size() - 1));
        cardDeck.printCard(tableCards.get(0));
        this.setLastColor(this.getTableCards().get(this.getTableCards().size() - 1).getColor());
    }

    /**
     * this method checks if we have a winner or not
     *
     * @param num is the number of players
     * @return returns a boolean which shows if we have a winner or not
     */
    public boolean checkWinner(int num) {
        boolean winner = true;
        for (int i = 0; i < num - 1; i++) {
            if (players.get(i).getPlayerCards().size() == 0) {
                winner = false;
                break;
            }
        }
        return winner;
    }

    /**
     * this method shows the result of players
     */
    public void showResult() {
        for (Player player : players)
            player.TotalScore();
        Collections.sort(players);
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + "-" + players.get(i).getName() + " score:" + players.get(i).getScore());
        }
    }

    /**
     * this method directs the game
     *
     * @param numOfPlayers number of players
     */
    public void setDirection(int numOfPlayers) {
        if (clockWise) {
            if (turn == numOfPlayers - 1)
                turn = 0;
            else
                turn++;
        } else {
            if (turn == 0)
                turn = numOfPlayers - 1;
            else
                turn--;
        }
    }

    /**
     * this method shows the last card
     */
    public void showLastCard() {
        System.out.println("last Card");
        cardDeck.printCard(tableCards.get(tableCards.size() - 1));
    }
}
