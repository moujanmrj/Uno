public  class UnoCard
{
    private int point;
    private String value;
    private String color;
    private boolean blocked;


    public boolean isBlocked() {
        return blocked;
    }
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    public int getPoint() { return point; }
    public String getColor() { return color; }
    public String getValue() {
        return value;
    }

    public void setPoint(int point) { this.point = point; }
    public void setColor(String color) { this.color = color; }

    public UnoCard(String color, int point, String value)
    {
        this.blocked = false;
        this.color = color;
        this.point = point;
        this.value = value;
    }
}