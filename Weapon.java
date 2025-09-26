public class Weapon {
    private int value;
    private char suit;
    private int durability;

    public Weapon() {
        this.value = -1;
        this.suit = 'N';
        this.durability = -1;
    }

    public Weapon(int value, char suit) {
        this.value = value;
        this.suit = suit;
        this.durability = Integer.MAX_VALUE;
    }

    public void useWeapon(int damage) {
        durability = damage;

        if (durability <= 2) {
            value = -1;
        }
    }

    public void showWeapon() {
        if (durability != Integer.MAX_VALUE) {
            String v;
            switch (durability) {
                case 11 -> v = "J";
                case 12 -> v = "Q";
                case 13 -> v = "K";
                case 14 -> v = "A";
                default -> v = String.valueOf(durability);
            }

            Utils.colorPrint(ColorType.YELLOW, "WEAPON: "+ value + suit);
            Utils.colorPrint(ColorType.YELLOW, " -> "+ v +"\r\n");
        } else {
            Utils.colorPrint(ColorType.YELLOW, "WEAPON: "+ value + suit +"\r\n");
        }
    }

    public int getValue() {
        return value;
    }

    public int getDurability() {
        return durability;
    }
}
