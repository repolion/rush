/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g42442.view;

public class Color {

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
                car = toBlack("7");
                break;
            case "8":
                car = toWhite("7");
                break;
        }

        return car;
    }

    /**
     * Méthode de couleur default du BASH.
     *
     * @return La couleur default.
     */
    private static String toDefault() {
        return "\033[0m";
    }

    /**
     * Colorie une chaine en noir.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public static String toBlack(String a) {
        return "\033[30m" + a + toDefault();
    }

    /**
     * Colorie une chaine en rouge.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public static String toRed(String a) {
        return "\033[31m" + a + toDefault();
    }

    /**
     * Colorie une chaine en vert.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public static String toGreen(String a) {
        return "\033[32m" + a + toDefault();
    }

    /**
     * Colorie une chaine en jaune.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public static String toYellow(String a) {
        return "\033[33m" + a + toDefault();
    }

    /**
     * Colorie une chaine en bleu.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public static String toBlue(String a) {
        return "\033[34m" + a + toDefault();
    }

    /**
     * Colorie une chaine en mauve.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public static String toPurple(String a) {
        return "\033[35m" + a + toDefault();
    }

    /**
     * Colorie une chaine en cyan.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public static String toCyan(String a) {
        return "\033[36m" + a + toDefault();
    }

    /**
     * Colorie une chaine en blanc.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public static String toWhite(String a) {
        return "\033[37m" + a + toDefault();
    }

}
