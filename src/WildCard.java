public abstract class WildCard extends UnoCard
{
    String cardName;

    public String getCardName() { return cardName; }

    public void setCardName(String cardName) { this.cardName = cardName; }

    @Override
    public void setValue(int value)
    {
        value = 50;
    }

    public WildCard(String color, int value,String cardName)
    {
        super(color,value);
        this.cardName = cardName;
    }
}
