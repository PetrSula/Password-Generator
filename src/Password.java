import com.sun.jdi.CharType;

public class Password {

    String Value;
    int Lenght;

    public Password(String s){
        Value = s;
        Lenght = s.length();
    }

    public String calculateScore() {
        int score = this.PasswordStrength();

        if (score == 6){
            return " Verry Strong passwprd";
        } else if ( score >= 4) {
            return " This is strong password";
        } else if (score >= 3) {
            return " This is good password";
        } else {
            return "This is a weak password, recomend to find better one";
        }
    }

    private int PasswordStrength() {
        String s = this.Value;
        boolean UsedUpper = false;
        boolean UsedLower = false;
        boolean UsedNum = false;
        boolean UsedSym = false;
        int type;
        int Score = 0;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (Character.isUpperCase(c)){
                UsedUpper = true;
            } else if (Character.isLowerCase(c)) {
                UsedLower = true;
            } else if (Character.isDigit(c)) {
                UsedNum = true;
            } else {
                UsedSym = true;
            }
        }
        if (UsedUpper) Score += 1;
        if (UsedLower) Score += 1;
        if (UsedNum) Score += 1;
        if (UsedSym) Score += 1;

        if (s.length() >= 8) Score += 1;
        if (s.length() >= 16) Score += 1;

        return Score;
    }
}
