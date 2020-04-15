public abstract class UnoCard
{
    private int value;
    private String color;

    public int getValue() { return value; }
    public String getColor() { return color; }

    public void setValue(int value) { this.value = value; }
    public void setColor(String color) { this.color = color; }

    public UnoCard(String color, int value)
    {
        this.color = color;
        this.value = value;
    }
}