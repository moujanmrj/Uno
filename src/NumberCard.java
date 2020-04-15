public class NumberCard extends ColorCard
{
    private int number;

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    @Override
    public void setValue(int value)
    {
        value = getNumber();
    }

    public NumberCard(String color, int number,String name)
    {
        super(color, number,name);
        this.number = number;
    }
}
