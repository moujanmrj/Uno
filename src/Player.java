import java.util.*;

/**
 * this class is the player class and playing methods
 *
 * @author Moujan Mirjalili
 * @version 2020
 */
public class Player implements Comparable<Player> {
    //this field has the list of the valid cards that players can play
    private ArrayList<UnoCard> validMove;
    //this field has the player cards list
    private ArrayList<UnoCard> playerCards;
    //this field has the cards deck
    private CardDeck cardDeck;
    //this field has the name of the players
    private String name;
    //this field has players score
    private Integer score;

    /**
     * this method gets player cards
     *
     * @return player cards
     */
    public ArrayList<UnoCard> getPlayerCards() {
        return playerCards;
    }

    /**
     * this method gets the player name
     *
     * @return player name
     */
    public String getName() {
        return name;
    }

    /**
     * this method gets the player score
     *
     * @return player score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * this method sets the list of the valid cards to play
     *
     * @param validMove list of the valid cards to play
     */
    public void setValidMove(ArrayList<UnoCard> validMove) {
        this.validMove = validMove;
    }

    /**
     * this method sets player score
     *
     * @param score player score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * this is the constructor and makes a new player
     *
     * @param cardDeck the deck of cards
     * @param name     name of the player
     */
    public Player(CardDeck cardDeck, String name) {
        score = 0;
        validMove = new ArrayList<>();
        this.name = name;
        this.cardDeck = cardDeck;
        playerCards = new ArrayList<>();
        cardDeck.shuffledCards(playerCards);
    }

    /**
     * this method prints the cards we have
     */
    public void showHand() {
        System.out.println("Your Cards");
        System.out.println("______________________________________________________________________");
        for (UnoCard print : playerCards) {
            cardDeck.printCard(print);
        }
        System.out.println("______________________________________________________________________");
        System.out.println();
    }

    /**
     * this method calculates players total score
     */
    public void TotalScore() {
        int total = 0;
        for (UnoCard score : playerCards) {
            total += score.getPoint();
        }
        setScore(total);
        this.score = total;
    }

    /**
     * this method gives us the valid cards to play (that we can play)
     *
     * @param table the table we're playing on
     * @return the list of cards we can play
     */
    public ArrayList<UnoCard> valid(Table table) {
        ArrayList<UnoCard> validMove = new ArrayList<>();
        if (table.getTableCards().get(table.getTableCards().size()-1).getValue().equals("draw+2") &&!table.getTableCards().get(table.getTableCards().size()-1).isBlocked())
        {
            for (UnoCard card : playerCards)
            {
                if (card.getValue().equals("draw+2"))
                    validMove.add(card);
            }
            return validMove;
        }
        for (UnoCard card : playerCards) {
            if (!card.getColor().equals("black") && table.getLastColor().equals(card.getColor()) || table.getTableCards().get(table.getTableCards().size() - 1).getValue().equals(card.getValue())) {
                validMove.add(card);
            }
        }

        boolean noValid = validMove.size() == 0;
        for (UnoCard playerCard : playerCards) {
            if (playerCard.getColor().equals("black")) {
                if (noValid) {
                    validMove.add(playerCard);
                }
            }
        }
        return validMove;
    }

    /**
     * this method is for playing and the moves
     * and implements game rules 
     * and is basically one of the main methods in this code
     *
     * @param table the table we're playing on
     */
    public void play(Table table) {
        boolean block = false;
        if (table.getTableCards().get(table.getTableCards().size() - 1).getValue().equals("skip") && !(table.getTableCards().get(table.getTableCards().size() - 1).isBlocked())) {
            block = true;
            System.out.println(name + ": Your turn is SKIPPED");
            table.getTableCards().get(table.getTableCards().size() - 1).setBlocked(true);
        }
        else if (table.getTableCards().get(table.getTableCards().size() - 1).getValue().equals("draw+2") && !(table.getTableCards().get(table.getTableCards().size() - 1).isBlocked())) {
            boolean draw2 = false;
            table.setDraw1();
            validMove = valid(table);
            for (UnoCard search : validMove) {
                if (search.getValue().equals("draw+2")) {
                    draw2 = true;
                    break;
                }
            }
            if (!draw2) {
                table.getTableCards().get(table.getTableCards().size() - 1).setBlocked(true);
                for (int i = 0; i < table.getDraw() * 2; i++) {
                    playerCards.add(cardDeck.getCards().get(0));
                    cardDeck.getCards().remove(0);
                }
                block = true;
                System.out.println(name + ": Your turn is SKIPPED");
                table.setDraw(0);
            }
        }
        else if (table.getTableCards().get(table.getTableCards().size() - 1).getValue().equals("wildDraw+4") && !(table.getTableCards().get(table.getTableCards().size() - 1).isBlocked())) {
            boolean wildDraw = false;
            table.setWildDraw1();
            validMove = valid(table);
            for (UnoCard search : validMove) {
                if (search.getValue().equals("wildDraw+4")) {
                    wildDraw = true;
                    break;
                }
            }
            if (!wildDraw) {
                table.getTableCards().get(table.getTableCards().size() - 1).setBlocked(true);
                for (int i = 0; i < table.getDraw() * 4; i++) {
                    playerCards.add(cardDeck.getCards().get(0));
                    cardDeck.getCards().remove(0);
                }
                block = true;
                System.out.println(name + ": Your turn is SKIPPED");
                table.setWildDraw(0);
            }
        }

        if (name.equals("player1") && !block) {
            System.out.println(name);
            validMove = valid(table);
            if (validMove.size() == 0) {
                System.out.println("card was added!");
                playerCards.add(cardDeck.getCards().get(0));
                cardDeck.getCards().remove(0);
            }
            validMove = valid(table);
            if (validMove.size() != 0) {
                this.showHand();
                Scanner scanner = new Scanner(System.in);
                System.out.println("choose your card\n");
                int move = scanner.nextInt();
                if (validMove.contains(playerCards.get(move - 1))) {
                    table.getTableCards().add(playerCards.get(move - 1));
                    if (table.getTableCards().get(table.getTableCards().size() - 1).getValue().equals("reverse")) {
                        table.setClockWise(!table.isClockWise());
                    }
                    if (table.getTableCards().get(table.getTableCards().size() - 1).getValue().equals("wildDraw+4"))
                    {
                        System.out.println("Choose your Color:");
                        table.setLastColor(scanner.nextLine());
                    }
                    playerCards.remove(move - 1);
                    if (table.getTableCards().get(table.getTableCards().size() - 1).getValue().equals("wildColor")) {
                        System.out.println("Choose Your Color :");
                        String color = scanner.nextLine();
                        color = scanner.nextLine();
                        table.setLastColor(color);
                    } else {
                        table.setLastColor(table.getTableCards().get(table.getTableCards().size() - 1).getColor());
                    }
                } else {
                    System.out.println("wrong move!");
                }
            }

        }
        else if (!name.equals("player1") && !block) {
            System.out.println(name);
            validMove = valid(table);
            if (validMove.size() == 0) {
                System.out.println("card was added.");
                playerCards.add(cardDeck.getCards().get(0));
                cardDeck.getCards().remove(0);
            }
            validMove = valid(table);
            if (validMove.size() != 0) {
                Collections.shuffle(validMove);
                table.getTableCards().add(validMove.get(0));
                if (table.getTableCards().get(table.getTableCards().size() - 1).getValue().equals("reverse")) {
                    table.setClockWise(!table.isClockWise());
                }
                if (table.getTableCards().get(table.getTableCards().size() - 1).getValue().equals("wildDraw+4"))
                {
                    int b = 0, r = 0, g = 0, y = 0;
                    for (UnoCard set : playerCards) {
                        switch (set.getColor()) {
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

                    if (max == b) {
                        table.setLastColor("blue");
                        System.out.println("BLUE");
                    } else if (max == r) {
                        table.setLastColor("red");
                        System.out.println("RED");
                    } else if (max == g) {
                        table.setLastColor("green");
                        System.out.println("GREEN");
                    } else {
                        table.setLastColor("yellow");
                        System.out.println("YELLOW");
                    }
                }
                if (table.getTableCards().get(table.getTableCards().size() - 1).getValue().equals("wildColor")) {
                    int b = 0, r = 0, g = 0, y = 0;
                    for (UnoCard set : playerCards) {
                        switch (set.getColor()) {
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

                    if (max == b) {
                        table.setLastColor("blue");
                        System.out.println("BLUE");
                    } else if (max == r) {
                        table.setLastColor("red");
                        System.out.println("RED");
                    } else if (max == g) {
                        table.setLastColor("green");
                        System.out.println("GREEN");
                    } else {
                        table.setLastColor("yellow");
                        System.out.println("YELLOW");
                    }
                } else {
                    table.setLastColor(table.getTableCards().get(table.getTableCards().size() - 1).getColor());
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
