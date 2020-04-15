public abstract class ColorCard extends UnoCard
{
    String cardName;

    public String getCardName() { return cardName; }

    public void setCardName(String cardName) { this.cardName = cardName; }

    public ColorCard(String color, int value,String cardName)
    {
        super(color,value);
        this.cardName = cardName;

    }
}
