import java.util.Scanner;

public class Uno
{
    public static void main(String[] args)
    {
        CardDeck cardDeck = new CardDeck();
        Table table = new Table(cardDeck);
        Player player1 = new Player(cardDeck);
        player1.showHand();

        System.out.println("please enter the number(3, 4 or 5) of players you want to play with :");
        Scanner scanMove = new Scanner(System.in);
        int numberOfPlayers = scanMove.nextInt();
        System.out.println("______________________________________________________________________");
        System.out.println();
        table.firstCard(cardDeck.getCards());
        System.out.println("______________________________________________________________________");
        System.out.println();
        System.out.println("please choose the card you want to play considering the cards you have by saying: ");
        System.out.println("1) it's color(e.g. red, blue, green or yellow) + pressing enter + it's action(e.g. draw, skip or reverse) + pressing enter");
        System.out.println("2) it's color(e.g. , blue, green or yellow) + pressing enter + it's number(0 to 9) + pressing enter");
        System.out.println("3) wild(if it is a wild card) + pressing enter + it's action(e.g. color or draw) + pressing enter");
        String colorMode = scanMove.nextLine();
        colorMode = scanMove.nextLine();
        String actionNum = scanMove.nextLine();
        System.out.println("______________________________________________________________________");
        System.out.println();
        table.readCard(colorMode, actionNum, player1);
    }
}
