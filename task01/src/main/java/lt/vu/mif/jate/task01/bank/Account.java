package lt.vu.mif.jate.task01.bank;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Public class Account.
 * @author Martynas
 *
 */
public class Account extends Bank {
    /**
     * Account number.
     */
    private String accnumber;
    /**
     * Credit sum.
     */
    private String credits = "0";
    /**
     * Debit sum.
     */
    private String debits = "0";
    /**
     * Temporary debit variable for counting.
     */
    private BigDecimal debitss = new BigDecimal("0");
    /**
     * Temporary credit variable for counting.
     */
    private BigDecimal creditss = new BigDecimal("0");
    /**
     * Regular expression to find adequate format.
     */
    private String reguliariEkspresija = "^[0-9]{1,20}([.][0-9]{2})?$";
    /**
     * Account number length.
     */
    public static final int ACCNLENGTH = 20;
    /**
     * Constant to avoid magic numbers.
     */
    private static final int CONST1 = 3;
    /**
     * Constant to avoid magic numbers.
     */
    private static final int CONST2 = 2;
    /**
     * Account constructor.
     * @param pAccnumber represents account
     */
    public Account(final String pAccnumber) {
        this.accnumber = pAccnumber;
        if (accnumber.length() != ACCNLENGTH) {
            throw new NumberFormatException();
        } else if (getBank() == null) {
            throw new NumberFormatException();
        }
    }
    /**
     * Method to find if bank is in list.
     * @return bank that is in list
     */
    public final Bank getBank() {
        for (Bank temp: BANKS) {
            if (accnumber.contains(String.valueOf(temp.getCode()))) {
                return temp;
            }
        }
        return null;
    }
    /**
     * Method to find balance of an account.
     * @return the balance
     */
    public final String balance() {
        String balansas;
        BigDecimal lokalusc = new BigDecimal(credits);
        BigDecimal lokalusd = new BigDecimal(debits);
        debitss = debitss.add(lokalusd);
        creditss = creditss.add(lokalusc);
        BigDecimal balansass = creditss.subtract(debitss);
        balansas = balansass.toString();
        credits = "0";
        debits = "0";
        return balansas;
    }
    /**
     * Check the format of input credit/debit.
     * @param kaReikiaRasti the right format
     * @param strInput input
     */
    public static void formatoTikrinimas(final String kaReikiaRasti,
            final String strInput) {
        Pattern checkRegex = Pattern.compile(kaReikiaRasti);
        Matcher regexMatcher = checkRegex.matcher(strInput);
        if (regexMatcher.find()) {
            int i = strInput.length();
            int j = i - CONST1;
            int g = i - CONST2;
            String substringg = strInput.substring(j, g);
            if (substringg.equals(".")) {
                i = 0;
            } else {
                throw new NumberFormatException();
            }
        } else {
            throw new NumberFormatException();
        }
    }
    /**
     * Debit format checking.
     * @param input input
     * @param acc account to credit
     */
    public final void debit(final String input, final Account acc) {
        formatoTikrinimas(reguliariEkspresija, input);
        if (acc != null) {
            acc.credit(input);
        }
        debits = input;
    }
    /**
     * Credit format checking.
     * @param input input
     */
    public final void credit(final String input) {
        formatoTikrinimas(reguliariEkspresija, input);
        credits = input;
    }
    /**
     * Debit format checking.
     * @param inputs input
     */
    public final void debit(final String inputs) {
        formatoTikrinimas(reguliariEkspresija, inputs);
        debits = inputs;
    }
}
