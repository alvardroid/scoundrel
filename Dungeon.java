import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private List<Card> room;

    public Dungeon() {
        room = new ArrayList<>();
    }

    public void showRoom() {
        Utils.colorPrint(ColorType.WHITE, "| ROOM: ");
        for (int i = 0; i < room.size(); i++) {
            System.out.print("["+ (i + 1) +"] ");
            room.get(i).showCard();
            System.out.print(" | ");
        }
    }

    public void addCard(Card card) {
        room.add(card);
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
}
