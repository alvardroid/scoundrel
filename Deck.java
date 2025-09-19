import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    
    public Deck() {
        cards = new ArrayList<>();
        addCardsInRange(14, CardType.ENEMY);
        addCardsInRange(14, CardType.ENEMY);
        addCardsInRange(10, CardType.WEAPON);
        addCardsInRange(10, CardType.HEAL);

        shuffleDeck();
    }

    public void showDeck() {
        for (Card card : cards) {
            card.showCard();
            System.out.print(" ");
        }
    }

    public void addCardsInRange(int maxValues, CardType type) {
        for (int i = 2; i <= maxValues; i++) {
            Card card = new Card(i, type);
            cards.add(card);
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
}
