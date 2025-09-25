public class Weapon {
    private int value;
    private char suit;
    private int durability;

    public Weapon(int value, char suit) {
        this.value = value;
        this.suit = suit;
        this.durability = Integer.MAX_VALUE;
    }

    public void useWeapon(int damage) {
        durability = damage;
    }

    public void showWeapon() {
        Utils.colorPrint(ColorType.RED, value + suit + " - " + durability);
    }

    public int getValue() {
        return value;
    }

    public int getDurability() {
        return durability;
    }
}
