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
        Utils.colorPrint(ColorType.LIME, "PLAYER HEALTH: "+health);
        Utils.colorPrint(ColorType.WHITE, " | ");
        weapon.showWeapon();
    }

    public void showHealth() {
        Utils.colorPrint(ColorType.LIME, "PLAYER HEALTH: "+ health +"\n\n\r");
    }

    public void attackWeapon(Card card) {
        Utils.colorPrint(ColorType.YELLOW, "You draw your weapon to fight the enemy\n");
        Utils.colorPrint(ColorType.LIME, "WEAPON STRENGTH: "+ weapon.getValue());
        Utils.colorPrint(ColorType.YELLOW, " - ");
        Utils.colorPrint(ColorType.RED, "ENEMY STRENGTH: "+ card.getValue());

        int diff = weapon.getValue() - card.getValue();
        if (diff < 0) {
            Utils.colorPrint(ColorType.PINK, "\nPLAYER HEALTH: "+ health +" -");
            health = Math.max(health - Math.abs(diff), 0);
            Utils.colorPrint(ColorType.PINK, "> "+ health +"\n");
            playerState();

        } else {
            Utils.colorPrint(ColorType.PINK, "\nYou took down the enemy flawlessly!\n");
        }
        
        if (isAlive())
            weapon.useWeapon(card.getValue());
        
    }

    public void attackBarehanded(Card card) {
        Utils.colorPrint(ColorType.RED, "You tried to beat the enemy with your own hands...\n");
        Utils.colorPrint(ColorType.PINK, "PLAYER HEALTH: "+ health +" -");
        health = Math.max(health - card.getValue(), 0);
        Utils.colorPrint(ColorType.PINK, "> "+ health);

        playerState();
    }

    public void getHealth(int health, boolean canHeal) {
        if (!canHeal) {
            Utils.colorPrint(ColorType.RED, "You can only heal once per room...");
            return;
        } else if (this.health >= baseHealth) {
            Utils.colorPrint(ColorType.WHITE, "You tried to heal, but you're already at full health...");
            return;
        }

        Utils.colorPrint(ColorType.LIME, "You healed some wounds!\n");
        Utils.colorPrint(ColorType.PINK, this.health+" -");
        this.health = Math.min(this.health + health, baseHealth);
        Utils.colorPrint(ColorType.PINK, "> "+ this.health +" HP");
    }

    public void equipWeapon(Card card) {
        if (weapon.getValue() <= 0)
            Utils.colorPrint(ColorType.LIME, "You equipped a new weapon!\n");
        else 
            Utils.colorPrint(ColorType.YELLOW, "You switched weapons!\n");
        
        Utils.colorPrint(ColorType.YELLOW, "Now you're wielding a "+ card.getValue() + card.getSuit() +"\n");

        weapon = new Weapon(card.getValue(), card.getSuit());
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean withWeapon() {
        return weapon.getValue() >= 2;
    }

    public int getWeaponDurability() {
        return weapon.getStrength();
    }

    public void playerState() {
        if (health > 0)
            Utils.colorPrint(ColorType.LIME, "\nYou took down the enemy!\n");
        else
            Utils.colorPrint(ColorType.RED, "\nYou have been defeated...\n");
    }

}
