public abstract class ColorCard extends UnoCard
{
    private String color;

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public ColorCard(String color) {
        this.color = color;
    }
}
