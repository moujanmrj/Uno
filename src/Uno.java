import java.util.*;

/**
 * this class is Uno and has the main and implements the whole game
 *
 * @author Moujan Mirjalili
 * @version 2020
 */
public class Uno {
    public static void main(String[] args) {
        //making a new deck of card
        CardDeck cardDeck = new CardDeck();
        //making a new table to put the cards in
        Table table = new Table(cardDeck);
        //scanning the number of players
        System.out.println("please enter the number(3, 4 or 5) of players you want to play with :");
        Scanner scanMove = new Scanner(System.in);
        int numberOfPlayers = scanMove.nextInt();
        //making players according to the number of players scanned
        Player player1 = new Player(cardDeck, "player1");
        Player player2 = new Player(cardDeck, "player2");
        Player player3 = new Player(cardDeck, "player3");
        Player player4;
        Player player5;
        table.addPlayer(player1);
        table.addPlayer(player2);
        table.addPlayer(player3);
        if (numberOfPlayers == 4) {
            player4 = new Player(cardDeck, "player4");
            table.addPlayer(player4);
        } else if (numberOfPlayers == 5) {
            player4 = new Player(cardDeck, "player4");
            table.addPlayer(player4);
            player5 = new Player(cardDeck, "player5");
            table.addPlayer(player5);
        }
        //the first card is specified and is on the table
        table.firstCard();
        //the game starts
        while (table.checkWinner(numberOfPlayers)) {
            table.getPlayers().get(table.getTurn()).setValidMove(table.getPlayers().get(table.getTurn()).valid(table));
            table.getPlayers().get(table.getTurn()).play(table);
            table.setDirection(numberOfPlayers);
            table.showLastCard();
        }
        //showing the result of the players who didn't won
        table.showResult();
    }
}
