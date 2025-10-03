public class Weapon {
    public static final int NEW_WEAPON = Integer.MAX_VALUE;

    private int value;
    private char suit;
    private int strength;

    public Weapon() {
        this.value = -1;
        this.suit = 'N';
        this.strength = -1;
    }

    public Weapon(int value, char suit) {
        this.value = value;
        this.suit = suit;
        this.strength = NEW_WEAPON;
    }

    public void useWeapon(int damage) {
        if (damage <= 2) {
            Utils.colorPrintln(ColorType.RED, "Your weapon broke...");
            value = -1;
            return;
        }

        Utils.colorPrintln(ColorType.YELLOW, "Your weapon took some damage...");
        strength = damage;
    }

    public void showWeapon() {
        Utils.colorPrint(ColorType.WHITE, " | ");
        if (strength != NEW_WEAPON) {
            String v;
            switch (strength) {
                case 11 -> v = "J";
                case 12 -> v = "Q";
                case 13 -> v = "K";
                case 14 -> v = "A";
                default -> v = String.valueOf(strength);
            }

            Utils.colorPrint(ColorType.YELLOW, "WEAPON: "+ value + suit);
            Utils.colorPrint(ColorType.YELLOW, " -> "+ v);
        } else {
            Utils.colorPrint(ColorType.YELLOW, "WEAPON: "+ value + suit);
        }
    }

    public int getValue() {
        return value;
    }

    public int getStrength() {
        return strength;
    }
}
