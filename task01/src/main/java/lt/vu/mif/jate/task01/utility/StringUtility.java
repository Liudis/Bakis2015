package lt.vu.mif.jate.task01.utility;

/**
 * @author Martynas
 *
 */
public final class StringUtility {
    /**
     * private constructor.
     */
    private StringUtility() { }

    /**
     * Reverse a string.
     * @param a input
     * @return reversed string
     */
    public static String reverse(final String a) {
        if (a == null) {
            return a;
        }
        return new StringBuilder(a).reverse().toString();
    }
    /**
     * compress a word.
     * @param b input
     * @return compressed word
     */
    public static String compress(final String b) {
        if (b == null || b.length() == 0) {
            return b;
        }
        StringBuilder output = new StringBuilder();
        int pasikartojimas = 1;
        int apatineReiksme = 0;
        for (int i = 1; i < b.length(); i++) {
            if (b.charAt(apatineReiksme) == b.charAt(i)) {
                pasikartojimas++;
            } else if (pasikartojimas <= 2) {
                output.append(b.substring(apatineReiksme, i));
                pasikartojimas = 1;
                apatineReiksme = i;
            } else {
                output.append(b.charAt(apatineReiksme));
                output.append(String.valueOf(pasikartojimas));
                apatineReiksme = i;
                pasikartojimas = 1;
            }
        }
        if (apatineReiksme != b.length()) {
            output.append(b.substring(apatineReiksme, b.length()));
        }
        return output.toString();
    }
    /**
     * Decompress a word.
     * @param b input
     * @return compressed word
     */
    public static String decompress(final String b) {
        if (b == null || b.length() == 0) {
            return b;
        }
        StringBuilder output = new StringBuilder();
        int okk = 0;
        int chk = 0;
        StringBuilder apat = new StringBuilder();
        if (b.matches(".*\\d.*")) {
            for (int i = 0; i < b.length(); i++) {
                if (Character.isDigit(b.charAt(i))) {
                    apat.append(b.charAt(i));
                    //okk = i;
                    chk++;
                } else if (apat.length() != 0) {
                    okk = Integer.parseInt(apat.toString());
                    for (int j = 0; j < okk - 1; j++) {
                        output.append(b.charAt(i - chk - 1));
                    }
                    chk = 0;
                    apat.setLength(0);
                    i--;
                } else {
                    output.append(b.charAt(i));
                }
            }
            return output.toString();
        } else {
            return b;
        }
    }
}
