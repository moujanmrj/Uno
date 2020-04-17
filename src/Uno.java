import java.util.ArrayList;
import java.util.Scanner;

public class Uno
{
    public static void main(String[] args)
    {
        CardDeck cardDeck = new CardDeck();

        Table table = new Table(cardDeck);

        Player player1 = new Player(cardDeck, "player1");

        Player player2 = new Player(cardDeck, "player2");
        Player player3 = new Player(cardDeck, "player3");
        Player player4;
        Player player5;

        player1.showHand();

        ArrayList<Player> players = new ArrayList<>();

        players.add(player1);
        players.add(player2);
        players.add(player3);

        System.out.println("please enter the number(3, 4 or 5) of players you want to play with :");
        Scanner scanMove = new Scanner(System.in);
        int numberOfPlayers = scanMove.nextInt();

        System.out.println("INSTRUCTIONS: please choose the card you want to play considering the cards you have by saying: ");
        System.out.println("1) it's color(e.g. red, blue, green or yellow) + pressing enter + it's action(e.g. draw, skip or reverse) + pressing enter");
        System.out.println("2) it's color(e.g. , blue, green or yellow) + pressing enter + it's number(0 to 9) + pressing enter");
        System.out.println("3) wild(if it is a wild card) + pressing enter + it's action(e.g. color or draw) + pressing enter");

        if (numberOfPlayers == 4)
        {
            player4 = new Player(cardDeck, "player4");
            players.add(player4);
        }
        else if (numberOfPlayers == 5)
        {
            player4 = new Player(cardDeck, "player4");
            players.add(player4);
            player5 = new Player(cardDeck, "player5");
            players.add(player5);
        }
        int i = 0;
        switch (table.firstCard(cardDeck.getCards()))
        {
            case 6:
                i++;
                break;
            case 5://////////////////////////////////////////////////////////

            case 2:
                if (numberOfPlayers == 3)
                {
                    i=2;
                    break;
                }
                if (numberOfPlayers == 4)
                {
                    i=3;
                    break;
                }
                if (numberOfPlayers == 5)
                    i=4;
                break;
            case 3:////////////////////////////////////////////////////

            case 4:////////////////////////////////////////////////////////

        }


        while(table.checkWinner(players, numberOfPlayers))
        {
            if (players.get(i).equals(player1) && i == 0)
            {
                table.showDirection();

                String colorMode = scanMove.nextLine();
                colorMode = scanMove.nextLine();
                String actionNum = scanMove.nextLine();

                switch (table.readCard(colorMode, actionNum, players.get(0)))
                {
                    case 0:
                        System.out.println("wrong move!!!");
                       if (table.getDirection())
                       {
                           i++;
                           break;
                       }
                       else
                       {
                           if (numberOfPlayers == 3)
                           {
                               i = 2;
                               break;
                           }
                           else if (numberOfPlayers == 4)
                           {
                               i = 3;
                               break;
                           }
                           else if (numberOfPlayers == 5)
                           {
                               i = 4;
                               break;
                           }
                       }

                    case 1:
                        i++;
                        break;
                    case 2:
                        if (numberOfPlayers == 3)
                        {
                            i = 2;
                            break;
                        }
                        else if (numberOfPlayers == 4)
                        {
                            i = 3;
                            break;
                        }
                        else if (numberOfPlayers == 5)
                        {
                            i = 4;
                            break;
                        }
                    case 3:////////////////////////////////////////

                    case 4://////////////////////////////
//                        if (table.getDirection())
//                        {
//                            players.get(i)
//                        }
                        if (table.getDirection())
                        {
                            i+=2;
                            break;
                        }
                        else
                        {
                            if (numberOfPlayers == 3)
                            {
                                i = 1;
                                break;
                            }
                            else if (numberOfPlayers == 4)
                            {
                                i = 2;
                                break;
                            }
                            else if (numberOfPlayers == 5)
                            {
                                i = 3;
                                break;
                            }
                        }
                    case 5://///////////////////////////////////////////

                    if (table.getDirection())
                    {
                        i+=2;
                        break;
                    }
                    else
                    {
                        if (numberOfPlayers == 3)
                        {
                            i = 1;
                            break;
                        }
                        else if (numberOfPlayers == 4)
                        {
                            i = 2;
                            break;
                        }
                        else if (numberOfPlayers == 5)
                        {
                            i = 3;
                            break;
                        }
                    }
                    case 6:
                        if (table.getDirection())
                        {
                            i+=2;
                            break;
                        }
                        else
                        {
                            if (numberOfPlayers == 3)
                            {
                                i = 1;
                                break;
                            }
                            else if (numberOfPlayers == 4)
                            {
                                i = 2;
                                break;
                            }
                            else if (numberOfPlayers == 5)
                            {
                                i = 3;
                                break;
                            }
                        }
                    case 7:
                        if (table.getDirection())
                        {
                            i++;
                            break;
                        }
                        else
                        {
                            if (numberOfPlayers == 3)
                            {
                                i = 2;
                                break;
                            }
                            else if (numberOfPlayers == 4)
                            {
                                i = 3;
                                break;
                            }
                            else if (numberOfPlayers == 5)
                            {
                                i = 4;
                                break;
                            }
                        }
                }
            }
            else if (i != 0)
            {
                cardDeck.AIPlayers(players.get(i))
                switch (table.readCard(colorMode, actionNum, player1)) {
                    case 0:
                        System.out.println("wrong move!!!");
                        if (table.getDirection())
                        {
                            if (numberOfPlayers == 3 && i == 2)
                            {
                                i = 0;
                                break;
                            }
                            else if (numberOfPlayers == 4 && i == 3)
                            {
                                i = 0;
                                break;
                            }
                            else if (numberOfPlayers == 5 && i == 4)
                            {
                                i = 0;
                                break;
                            }
                            else
                                i++;
                            break;
                        }
                        else
                        {
                            i--;
                            break;
                        }
                    case 1:
                        if (numberOfPlayers == 3 && i == 2)
                        {
                            i = 0;
                            break;
                        }
                        else if (numberOfPlayers == 4 && i == 3)
                        {
                            i = 0;
                            break;
                        }
                        else if (numberOfPlayers == 5 && i == 4)
                        {
                            i = 0;
                            break;
                        }
                        else
                            i++;
                        break;
                    case 2:
                        i--;
                        break;
                    case 3:////////////////////////////////////////

                    case 4://////////////////////////////
//                        if (table.getDirection()) {
//                            players.get(i)
//                        }
                        if (table.getDirection())
                        {
                            if (numberOfPlayers == 3 && i == 2)
                            {
                                i = 1;
                                break;
                            }
                            else if (numberOfPlayers == 4 && i == 3)
                            {
                                i = 1;
                                break;
                            }
                            else if (numberOfPlayers == 5 && i == 4)
                            {
                                i = 1;
                                break;
                            }
                            else if (numberOfPlayers == 3 && i == 1)
                            {
                                i = 0;
                                break;
                            }
                            else if (numberOfPlayers == 4 && i == 2)
                            {
                                i = 0;
                                break;
                            }
                            else if (numberOfPlayers == 5 && i == 3)
                            {
                                i = 0;
                                break;
                            }
                            else
                                i += 2;
                            break;
                        }
                        else
                        {
                            if (numberOfPlayers == 3 && i == 1)
                            {
                                i = 2;
                                break;
                            }
                            else if (numberOfPlayers == 4 && i == 1)
                            {
                                i = 3;
                                break;
                            }
                            else if (numberOfPlayers == 5 && i == 1)
                            {
                                i = 4;
                                break;
                            }
                            else
                                i -= 2;
                            break;
                        }
                    case 5://///////////////////////////////////////////

                        if (table.getDirection())
                        {
                            if (numberOfPlayers == 3 && i == 2)
                            {
                                i = 1;
                                break;
                            }
                            else if (numberOfPlayers == 4 && i == 3)
                            {
                                i = 1;
                                break;
                            }
                            else if (numberOfPlayers == 5 && i == 4)
                            {
                                i = 1;
                                break;
                            }
                            else if (numberOfPlayers == 3 && i == 1)
                            {
                                i = 0;
                                break;
                            }
                            else if (numberOfPlayers == 4 && i == 2)
                            {
                                i = 0;
                                break;
                            }
                            else if (numberOfPlayers == 5 && i == 3)
                            {
                                i = 0;
                                break;
                            }
                            else
                                i += 2;
                            break;
                        }
                        else
                        {
                            if (numberOfPlayers == 3 && i == 1)
                            {
                                i = 2;
                                break;
                            }
                            else if (numberOfPlayers == 4 && i == 1)
                            {
                                i = 3;
                                break;
                            }
                            else if (numberOfPlayers == 5 && i == 1) {
                                i = 4;
                                break;
                            }
                            else
                                i -= 2;
                            break;
                        }
                    case 6:
                        if (table.getDirection())
                        {
                            if (numberOfPlayers == 3 && i == 2)
                            {
                                i = 1;
                                break;
                            }
                            else if (numberOfPlayers == 4 && i == 3)
                            {
                                i = 1;
                                break;
                            }
                            else if (numberOfPlayers == 5 && i == 4)
                            {
                                i = 1;
                                break;
                            }
                            else if (numberOfPlayers == 3 && i == 1)
                            {
                                i = 0;
                                break;
                            }
                            else if (numberOfPlayers == 4 && i == 2)
                            {
                                i = 0;
                                break;
                            }
                            else if (numberOfPlayers == 5 && i == 3)
                            {
                                i = 0;
                                break;
                            }
                            else
                                i += 2;
                            break;
                        }
                        else
                        {
                            if (numberOfPlayers == 3 && i == 1)
                            {
                                i = 2;
                                break;
                            }
                            else if (numberOfPlayers == 4 && i == 1)
                            {
                                i = 3;
                                break;
                            }
                            else if (numberOfPlayers == 5 && i == 1)
                            {
                                i = 4;
                                break;
                            }
                            else
                                i -= 2;
                            break;
                        }
                    case 7:
                        if (table.getDirection())
                        {
                            if (numberOfPlayers == 3 && i == 2)
                            {
                                i = 0;
                                break;
                            }
                            else if (numberOfPlayers == 4 && i == 3)
                            {
                                i = 0;
                                break;
                            }
                            else if (numberOfPlayers == 5 && i == 4)
                            {
                                i = 0;
                                break;
                            }
                            else
                                i++;
                            break;
                        }
                        else
                        {
                            i--;
                            break;
                        }

                }
            }
        }
    }
}
