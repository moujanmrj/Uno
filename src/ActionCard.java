public abstract class ActionCard extends ColorCard
{
    public ActionCard(String color)
    {
        super(color);
    }

    @Override
    public void setValue(int value)
    {
        value = 20;
    }
}
