import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);

    public static void colorPrint(ColorType color, String text) {
        String pColor = "\033[0m";

        switch (color) {
            case RED -> pColor = "\033[31m";
            case YELLOW -> pColor = "\033[33m";
            case LIME -> pColor = "\033[32m";
            case WHITE -> pColor = "\033[0m";
            case PINK -> pColor = "\033[95m";
        }

        System.out.print(pColor + text + "\033[0m");
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static int userNumberInput() {
        try {
            System.out.print(
                "--------------------------\r\n" + //
                "Enter a number: "
            );
            int userInput = scanner.nextInt();
            scanner.nextLine();
            return userInput;
            
        } catch (Exception e) {
            scanner.nextLine();
            Utils.colorPrint(ColorType.RED, "\r\n Please enter a number \r\n");
            return userNumberInput();
        }
    }

    public static void waitEnter() {
        colorPrint(ColorType.YELLOW, "\n\nPress ENTER to continue...");
        scanner.nextLine();
    }
}
