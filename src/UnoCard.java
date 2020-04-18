/**
 * this class has the uno cards characteristics
 *
 * @author Moujan Mirjalili
 * @version 2020
 */
public class UnoCard {
    //this field has the cards score
    private int point;
    //this field has the type of the card
    private String value;
    //this field has the color of the card
    private String color;
    //this field shows if the player is blocked during the game or not (players turn)
    private boolean blocked;

    /**
     * this method shows if the player is blocked from playing
     * in his turn
     *
     * @return a boolean which shows if blocked or not
     */
    public boolean isBlocked() {
        return blocked;
    }

    /**
     * this method blocks the player from playing
     *
     * @param blocked is the block boolean which shows the turn
     */
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    /**
     * this method gets the card score
     *
     * @return card score
     */
    public int getPoint() {
        return point;
    }

    /**
     * this method gets card color
     *
     * @return card's color
     */
    public String getColor() {
        return color;
    }

    /**
     * this method gets the type of the card
     *
     * @return type of the card
     */
    public String getValue() {
        return value;
    }

    /**
     * this is the constructor it makes a new uno card
     *
     * @param color color of the card
     * @param point score of the card
     * @param value type of the card
     */
    public UnoCard(String color, int point, String value) {
        this.blocked = false;
        this.color = color;
        this.point = point;
        this.value = value;
    }
}