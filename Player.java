public class Player {
    private int baseHealth;
    private int health;
    private Weapon weapon;

    public Player(int health) {
        this.baseHealth = health;
        this.health = health;
        this.weapon = new Weapon();
    }

    public void showAllStats() {
        Utils.colorPrint(ColorType.LIME, "PLAYER HP: "+health);
        Utils.colorPrint(ColorType.WHITE, " | ");
        weapon.showWeapon();
    }

    public void showHealth() {
        Utils.colorPrint(ColorType.LIME, "PLAYER HP: "+ health +"\n\r");
    }

    public void attackWeapon(Card card) {
        int diff = weapon.getValue() - card.getValue();
        if (diff < 0)
            health -= Math.abs(diff);
        
        weapon.useWeapon(card.getValue());
    }

    public void attackBarehanded(Card card) {
        health -= card.getValue();
    }

    public void getHealth(int health) {
        this.health = Math.min(this.health + health, baseHealth);
    }

    public void equipWeapon(Card card) {
        weapon = new Weapon(card.getValue(), card.getSuit());
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean withWeapon() {
        return weapon.getValue() >= 2;
    }

    public int getWeaponDurability() {
        return weapon.getDurability();
    }

}
