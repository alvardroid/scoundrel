public class Main {

    public static void main(String[] args) {
        GameManager game = new GameManager();
        boolean gameWon = game.gameLoop();
        
        System.out.println();
        if (gameWon) {
            Utils.colorPrint(ColorType.LIME, "YOU MADE IT OUT!! :D");
        } else {
            Utils.colorPrint(ColorType.RED, "GAME OVER");
        }
    }
}
