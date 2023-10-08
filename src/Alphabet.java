


public class Alphabet {
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "1234567890";
    public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";

    private final StringBuilder pool;

    public Alphabet( boolean upperIncluded, boolean lowIncluded, boolean numIncluded, boolean specIncluded){

        pool = new StringBuilder();

        if (upperIncluded) pool.append(UPPERCASE_LETTERS);
        if (lowIncluded) pool.append(LOWERCASE_LETTERS);
        if (numIncluded) pool.append(NUMBERS);
        if (specIncluded) pool.append(SYMBOLS);
    }

    public String getAlphabet() {
        return pool.toString();
    }
}
