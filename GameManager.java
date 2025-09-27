public class GameManager {
    private static final int ROOM_SIZE = 4;
    private boolean roomAvoided = false;
    private boolean canEscape = true;
    private boolean canHeal = true;

    private Player player;
    private Deck deck;
    private Dungeon dungeon;

    public GameManager() {
        player = new Player(20);
        deck = new Deck();
        dungeon = new Dungeon();
    }

    public void fillRoom() {
        int totalCards = dungeon.roomSize();
        for (int i = totalCards; i < ROOM_SIZE; i++) {
            if (deck.getTotalCards() >= 1)
                dungeon.addCard(deck.getCard());
        }

        if (roomAvoided) {
            canEscape = false;
            roomAvoided = false;
        } else {
            canEscape = true;
        }
        canHeal = true;
    }

    public boolean gameLoop() {
        do {
            Utils.clearScreen();
            fillRoom();
            challengeRoom();

            if (player.isAlive() && deck.getTotalCards() <= 0 && dungeon.enemiesLeft() <= 0)
                return true;
                
        } while (player.isAlive());

        return false;
    }

    public void challengeRoom() {
        do {
            Utils.clearScreen();

            int userInput = userSelect();
            if (userInput == 0 && canEscape) {
                Utils.colorPrint(ColorType.YELLOW, "You left the room...");
                for (int i = 0; i < dungeon.roomSize(); i++)
                    deck.addCard(dungeon.getCard(i + 1));
                
                dungeon.clearRoom();
                roomAvoided = true;
                Utils.waitEnter();
                return;

            } else if (userInput == 0 && dungeon.roomSize() <= 1) {
                Utils.colorPrint(ColorType.YELLOW, "You step into the next room...");
                Utils.waitEnter();
                return;
            }

            challengeCard(userInput);

            if (player.isAlive() && dungeon.roomSize() <= 0) {
                Utils.colorPrint(ColorType.YELLOW, "\nThe room is cleared. You move forward");
            }

            Utils.waitEnter();

        } while (player.isAlive() && dungeon.roomSize() > 0);

    }

    public void challengeCard(int userInput) {
        Card selectedCard = dungeon.getCard(userInput);
        switch (selectedCard.getType()) {
            case CardType.ENEMY:
                fightEnemy(selectedCard);
                break;
            case CardType.HEAL:
                player.getHealth(selectedCard.getValue(), canHeal);
                canHeal = false;
                break;
            case CardType.WEAPON:
                player.equipWeapon(selectedCard);
                break;
        }

        dungeon.removeCard(userInput);
        canEscape = false;
    }

    public int userSelect() {
        showRoomInfo();

        int number = Utils.userNumberInput();
        if (number < 0 || number > dungeon.roomSize()) {
            Utils.colorPrint(ColorType.RED, "Please enter a number in range [0-"+ dungeon.roomSize() +"]\n\n\r");
            return userSelect();

        } else if (number == 0 && (!canEscape && dungeon.roomSize() > 1 && deck.getTotalCards() <= 0)) {
            Utils.colorPrint(ColorType.RED, "Please enter a number in range [1-"+ dungeon.roomSize() +"]\n\n\r");
            return userSelect();

        }

        return number;
    }

    public void showRoomInfo() {
        if (player.withWeapon())
            player.showAllStats();
        else
            player.showHealth();

        if (deck.getTotalCards() > 1) {
            if (canEscape)
                Utils.colorPrint(ColorType.PINK, "[0] Escape room");
            else if (dungeon.roomSize() <= 1)
                Utils.colorPrint(ColorType.LIME,"[0] Enter next room");
            System.out.print(" \\\\ ");
        }
        
        dungeon.showRoom();
    }

    public void fightEnemy(Card enemy) {
        if (!player.withWeapon() || enemy.getValue() >= player.getWeaponDurability()) {
            player.attackBarehanded(enemy);
            return;
        }

        Utils.colorPrint(ColorType.YELLOW, "\nHow you wanna fight the enemy?\r\n");
        Utils.colorPrint(ColorType.LIME, "[1] Use Weapon");
        Utils.colorPrint(ColorType.YELLOW, " | ");
        Utils.colorPrint(ColorType.RED, "[0] Barehanded\r\n");

        int userInput = Utils.userNumberInput();
        if (userInput > 1 || userInput < 0) {
            Utils.colorPrint(ColorType.RED, "Please enter a number in range [0-1]");
            fightEnemy(enemy);
        }

        switch (userInput) {
            case 1:
                player.attackWeapon(enemy);
                break;
        
            default:
                player.attackBarehanded(enemy);
                break;
        }

    }
}
