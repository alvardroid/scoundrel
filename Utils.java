import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);

    public static int userNumberInput() {
        while (true) {
            try {
                System.out.println();
                colorPrintln(ColorType.YELLOW, "----------------------------------------------");
                colorPrint(ColorType.YELLOW, "Enter a number: ");

                int userInput = scanner.nextInt();
                scanner.nextLine();
                Utils.separator();
                return userInput;
                
            } catch (Exception e) {
                scanner.nextLine();
                Utils.colorPrintln(ColorType.RED, "Please enter a number");
                Utils.waitEnter();
            }
        }
    }

    public static void colorPrint(ColorType color, String text) {
        String printColor = getColor(color);

        System.out.print(printColor + text + "\033[0m");
    }

    public static void colorPrintln(ColorType color, String text) {
        String printColor = getColor(color);

        System.out.println(printColor + text + "\033[0m");
    }

    public static String getColor(ColorType color) {
        switch (color) {
            case RED: return "\033[31m";
            case YELLOW: return "\033[33m";
            case LIME: return "\033[32m";
            case WHITE: return "\033[0m";
            case PINK: return "\033[95m";
        }

        return "\033[0m";
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void waitEnter() {
        Utils.separator();
        colorPrint(ColorType.YELLOW, "Press ENTER to continue...");
        scanner.nextLine();
    }

    public static void separator() {
        System.out.println("\n\r");
    }

}
