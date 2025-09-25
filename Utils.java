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
}
