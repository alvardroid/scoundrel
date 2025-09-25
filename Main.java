public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.showDeck();

        System.out.println("");

        Dungeon dungeon = new Dungeon();
        dungeon.addCard(deck.getCard());
        dungeon.addCard(deck.getCard());
        dungeon.addCard(deck.getCard());
        dungeon.addCard(deck.getCard());

        dungeon.showRoom();
    }
}
