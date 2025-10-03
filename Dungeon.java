import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private List<Card> room;

    public Dungeon() {
        room = new ArrayList<>();
    }

    public void addCard(Card card) {
        room.add(card);
    }

    public Card getCard(int index) {
        return room.get(index - 1);
    }

    public void removeCard(int index) {
        room.remove(index - 1);
    }

    public Card selectCard(int index) {
        return room.get(index);
    }

    public void clearRoom() {
        room.clear();
    }

    public int roomSize() {
        return room.size();
    }

    public int enemiesLeft() {
        int total = 0;
        for (Card card : room) {
            if (card.getType() == CardType.ENEMY) {
                total++;
            }
        }

        return total;
    }

    public void showRoom() {
        Utils.colorPrint(ColorType.WHITE, "ROOM: ");
        for (int i = 0; i < room.size(); i++) {
            room.get(i).showCard(i + 1);
            System.out.print(" | ");
        }
    }
}
