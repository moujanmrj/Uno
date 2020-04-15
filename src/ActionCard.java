public abstract class ActionCard extends ColorCard
{
    public ActionCard(String color, int value,String name)
    {
        super(color,20,name);
    }

    @Override
    public void setValue(int value)
    {
        value = 20;
    }
}
