package lt.vu.mif.jate.task01.bank;
/**
 * Bank class.
 * @author Martynas
 *
 */
public class Bank {
    /**
     * Variable names.
     */
    private String name;
    /**
     * Variable codes.
     */
    private int code;
    /**
     * List of parameters.
     */
    public static final Bank[] BANKS = {
        new Bank("Swedbank", 7300),
        new Bank("SEB", 7400),
        new Bank("Snoras", 5953),
        new Bank("Sekunde", 5555),
        new Bank("Ukio", 5444)
    };

    /**
     * Bank constructor.
     * @param pName Bank name
     * @param pCode Bank code
     */
    public Bank(final String pName, final int pCode) {
        this.name = pName;
        this.code = pCode;
    }
    /**
     * Constructors.
     */
    public Bank() {
    }

    /**
     * Bank get the bank from code.
     * @param i local variable to iterate
     * @return bank
     */
    public static Bank get(final int i) {
        for (Bank bank: BANKS) {
            if (i == bank.getCode()) {
                return bank;
            }
        }
        return null;
    }
    /**
     * Get bank name.
     * @return name of bank
     */
    public final String getName() {
        return name;
    }
    /**
     * Get bank code.
     * @return code of bank
     */
    public final int getCode() {
        return code;
    }
    /**
     * Get all banks.
     * @return banks list
     */
    public static Bank[] all() {
        return BANKS;
    }
}
