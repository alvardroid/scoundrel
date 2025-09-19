public class Utils {
    public static void colorPrint(ColorType color, String text) {
        String pColor = "\033[0m";

        switch (color) {
            case RED:
                pColor = "\033[31m";
                break;
            case YELLOW:
                pColor = "\033[33m";
                break;
            case LIME:
                pColor = "\033[32m";
                break;
        }

        System.out.print(pColor + text + "\033[0m");
    }
}
