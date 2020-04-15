public class Uno
{
    public static void main(String[] args)
    {
        CardDeck cardDeck = new CardDeck();
        Player player = new Player(cardDeck);
        player.showHand();
    }
}
