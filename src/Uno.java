import java.util.Scanner;

public class Uno
{
    public static void main(String[] args)
    {
        CardDeck cardDeck = new CardDeck();

        Table table = new Table(cardDeck);


        System.out.println("please enter the number(3, 4 or 5) of players you want to play with :");
        Scanner scanMove = new Scanner(System.in);
        int numberOfPlayers = scanMove.nextInt();

        Player player1 = new Player(cardDeck, "player1");
        Player player2 = new Player(cardDeck, "player2");
        Player player3 = new Player(cardDeck, "player3");
        Player player4;
        Player player5;
        player1.showHand();
        table.addPlayer(player1);
        table.addPlayer(player2);
        table.addPlayer(player3);
        if (numberOfPlayers == 4)
        {
            player4 = new Player(cardDeck, "player4");
            table.addPlayer(player4);
        }
        else if (numberOfPlayers == 5)
        {
            player4 = new Player(cardDeck, "player4");
            table.addPlayer(player4);
            player5 = new Player(cardDeck, "player5");
            table.addPlayer(player5);
        }
        table.firstCard(); //inja avalin karte table moshakhas mishe
        System.out.println("please enter the number of the card you want to play.");
        while(table.checkWinner(numberOfPlayers))
        {

            table.getPlayers().get(table.getTurn()).setValidMove(table.getPlayers().get(table.getTurn()).valid(table));
            table.getPlayers().get(table.getTurn()).play(table);
            table.setDirection(numberOfPlayers);

        }
        table.showResult();
    }
}
