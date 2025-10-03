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
        showHealth();
        weapon.showWeapon();
    }

    public void showHealth() {
        Utils.colorPrint(ColorType.LIME, "PLAYER HEALTH: "+ health);
    }

    public void attackWeapon(Card card) {
        showWeaponAttackDetails(card);

        int diff = weapon.getValue() - card.getValue();
        if (diff < 0) {
            applyDamage(Math.abs(diff));
        } else {
            Utils.separator();
            Utils.colorPrintln(ColorType.PINK, "You took down the enemy flawlessly!");
        }
        
        if (isAlive()) {
            weapon.useWeapon(card.getValue());
        }
    }

    public void attackBarehanded(Card card) {
        Utils.colorPrintln(ColorType.RED, "You tried to beat the enemy with your own hands...");

        applyDamage(card.getValue());
    }


    public void heal(int healAmount, boolean canHeal) {
        if (!canHeal) {
            showHealError("You can only heal once per room...");
            return;
        }
        if (isAtFullHealth()) {
            showHealError("You tried to heal, but you're already at full health...");
            return;
        }

        applyHealing(healAmount);
    }

    public void equipWeapon(Card card) {
        if (weapon.getValue() <= 0)
            Utils.colorPrintln(ColorType.LIME, "You equipped a new weapon!");
        else 
            Utils.colorPrintln(ColorType.YELLOW, "You switched weapons!");
        
        Utils.colorPrintln(ColorType.YELLOW, "Now you're wielding a "+ card.getValue() + card.getSuit());

        weapon = new Weapon(card.getValue(), card.getSuit());
    }

    private void applyHealing(int healAmount) {
        Utils.colorPrintln(ColorType.LIME, "You healed some wounds!");

        int newHealth = Math.min(this.health + healAmount, baseHealth);
        healthChange(health, newHealth);
    }

    private void applyDamage(int damage) {
        int newHealth = Math.max(health - damage, 0);
        healthChange(health, newHealth);

        showFightResult();
    }

    private void showWeaponAttackDetails(Card card) {
        Utils.colorPrintln(ColorType.YELLOW, "You draw your weapon to fight the enemy");
        Utils.colorPrint(ColorType.LIME, "WEAPON STRENGTH: " + weapon.getValue());
        Utils.colorPrint(ColorType.YELLOW, " - ");
        Utils.colorPrintln(ColorType.RED, "ENEMY STRENGTH: " + card.getValue());
    }

    public void healthChange(int oldHealth, int newHealth) {
        Utils.colorPrintln(ColorType.PINK, "PLAYER HEALTH: " + oldHealth + " -> " + newHealth);
        this.health = newHealth;
    }

    public void showFightResult() {
        System.out.println();
        if (health > 0)
            Utils.colorPrintln(ColorType.LIME, "You took down the enemy!");
        else
            Utils.colorPrintln(ColorType.RED, "You have been defeated...");
    }

    private void showHealError(String message) {
        Utils.colorPrintln(ColorType.RED, message);
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

    private boolean isAtFullHealth() {
        return this.health >= baseHealth;
    }
}
