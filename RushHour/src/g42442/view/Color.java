package g42442.view;

/**
 * to use colors
 *
 * @author Cordier Olivier
 */
public class Color {

    /**
     * to color a char converting it in String
     *
     * @param a the char to be converted in String
     * @return the char converted
     */
    public static String color(char a) {
        String car = Character.toString(a);

        switch (car) {
            case "1":
                car = toRed("1");

                break;
            case "2":
                car = toGreen("2");
                break;
            case "3":
                car = toBlue("3");
                break;
            case "4":
                car = toPurple("4");
                break;
            case "5":
                car = toCyan("5");
                break;
            case "6":
                car = toYellow("6");
                break;
            case "7":
                car = toPurple("7");
                break;
            case "8":
                car = toRed("8");
                break;
            case "9":
                car = toGreen("9");
                break;

        }

        return car;
    }

    /**
     * method default color from the BASH.
     *
     * @return color default.
     */
    private static String toDefault() {
        return "\033[0m";
    }

    /**
     * to color a String in black.
     *
     * @param a the String to be colored.
     * @return the String colored.
     */
    public static String toBlack(String a) {
        return "\033[30m" + a + toDefault();
    }

    /**
     * to color a String in red.
     *
     * @param a the String to be colored.
     * @return the String colored.
     */
    public static String toRed(String a) {
        return "\033[31m" + a + toDefault();
    }

    /**
     * to color a String in green.
     *
     * @param a the String to be colored.
     * @return the String colored.
     */
    public static String toGreen(String a) {
        return "\033[32m" + a + toDefault();
    }

    /**
     * to color a String in yellow.
     *
     * @param a the String to be colored.
     * @return the String colored.
     */
    public static String toYellow(String a) {
        return "\033[33m" + a + toDefault();
    }

    /**
     * to color a String in blue.
     *
     * @param a the String to be colored.
     * @return the String colored.
     */
    public static String toBlue(String a) {
        return "\033[34m" + a + toDefault();
    }

    /**
     * to color a String in purple.
     *
     * @param a the String to be colored.
     * @return the String colored.
     */
    public static String toPurple(String a) {
        return "\033[35m" + a + toDefault();
    }

    /**
     * to color a String in cyan.
     *
     * @param a the String to be colored.
     * @return the String colored.
     */
    public static String toCyan(String a) {
        return "\033[36m" + a + toDefault();
    }

    /**
     * to color a String in white.
     *
     * @param a the String to be colored.
     * @return the String colored.
     */
    public static String toWhite(String a) {
        return "\033[37m" + a + toDefault();
    }

}
