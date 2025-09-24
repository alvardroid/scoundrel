public class Player {
    private int health;
    private Weapon weapon;

    public Player(int health) {
        this.health = health;
    }

    public void showAllStats() {
        Utils.colorPrint(ColorType.LIME, ""+health);
        Utils.colorPrint(ColorType.YELLOW, " | ");
        weapon.showWeapon();
    }

    public void showHealth() {
        Utils.colorPrint(ColorType.LIME, ""+health);
    }

    public void attackWeapon(Card card) {
        int diff = weapon.useWeapon(card.getValue());
        if (diff < 0)
            health -= Math.abs(diff);
    }

    public void attackBarehand(Card card) {
        health -= card.getValue();
    }

    public void getHealth(int health) {
        this.health += health;
    }

    public void equipWeapon(Card card) {
        weapon = new Weapon(card.getValue(), card.getSuit());
    }

    public boolean isAlive() {
        return health > 0;
    }

}
