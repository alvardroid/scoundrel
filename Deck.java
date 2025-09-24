import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    
    public Deck() {
        cards = new ArrayList<>();
        addCardsInRange(14, 'C');
        addCardsInRange(14, 'S');
        addCardsInRange(10, 'D');
        addCardsInRange(10, 'H');

        shuffleDeck();
    }

    public void showDeck() {
        for (Card card : cards) {
            card.showCard();
            System.out.print(" ");
        }
    }

    public void addCardsInRange(int maxValues, char suit) {
        for (int i = 2; i <= maxValues; i++) {
            Card card = new Card(i, suit);

            switch (suit) {
                case 'C' -> card.setType(CardType.ENEMY);
                case 'S' -> card.setType(CardType.ENEMY);
                case 'D' -> card.setType(CardType.WEAPON);
                case 'H' -> card.setType(CardType.HEAL);
            }

            cards.add(card);
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
}
