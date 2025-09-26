import java.util.Scanner;

public class Utils {
    public static void colorPrint(ColorType color, String text) {
        String pColor = "\033[0m";

        switch (color) {
            case RED -> pColor = "\033[31m";
            case YELLOW -> pColor = "\033[33m";
            case LIME -> pColor = "\033[32m";
            case WHITE -> pColor = "\033[0m";
        }

        System.out.print(pColor + text + "\033[0m");
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static int userNumberInput() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print(
                "--------------------------\r\n" + //
                "Enter a number: "
            );
            int userInput = scanner.nextInt();

            return userInput;
            
        } catch (Exception e) {
            Utils.colorPrint(ColorType.RED, "\r\n Please enter a number \r\n");
            return userNumberInput();
        }
    }
}
