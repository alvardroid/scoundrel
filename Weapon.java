public class Weapon {
    private int value;
    private char suit;
    private int durability;

    public Weapon(int value, char suit) {
        this.value = value;
        this.suit = suit;
        this.durability = value;
    }

    public int useWeapon(int value) {
        durability -= value;
        return durability;
    }

    public void showWeapon() {
        Utils.colorPrint(ColorType.RED, value + suit + " - " + durability);
    }
}
