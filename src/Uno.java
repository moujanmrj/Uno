import java.util.Scanner;

public class Uno
{
    public static void main(String[] args)
    {
        CardDeck cardDeck = new CardDeck();
        Table table = new Table();
        Player player1 = new Player(cardDeck);
        player1.showHand();

        System.out.println("please enter the number(3, 4 or 5) of players you want to play with :");
        Scanner scanMove = new Scanner(System.in);
        int numberOfPlayers = scanMove.nextInt();

    }
}
