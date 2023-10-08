import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    public static Scanner keyboard;

    public Generator(Scanner scanner){
        keyboard = scanner;
    }
    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
    }

    public void mainloop() {
        System.out.println("Hi you want use our servises:)");
        printMenu();

        String userOption = "-1";

        while (!userOption.equals("4") ){
            userOption = keyboard.next();

            switch (userOption){
                case "1" -> {
                    requestPassword();
                    printMenu();
                }
                case "2" -> {
                    checkPassword();
                    printMenu();
                    
                }
                case "3" -> {
                    QuitMessege();
                }
            }
        }

    }



    private void checkPassword() {
        String input;

        System.out.print("\nEnter your password:");
        input = keyboard.next();

        final Password password = new Password(input);
        System.out.println(password.calculateScore());
    }

    private void requestPassword() {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNum = false;
        boolean IncludeSym = false;
        boolean correctParams;
        int found;

        System.out.println();
        System.out.println("Hello, welcome to the Password Generator. Answer"
                + " the following questions by Yes(Y) or No(N) \n");

        do {
            String input;
            correctParams = false;

//          get Lower case letters
            do {
                System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
                input = keyboard.next();
                found = PasswordRequestError(input);
            } while (found == 0);
            if (found > 0) IncludeLower = true;

//          get Upper case letters
            do {
                System.out.println("Do you want Upper letters \"ABCD...\" to be used? ");
                input = keyboard.next();
                found = PasswordRequestError(input);
            } while (found == 0);
            if (found > 0) IncludeUpper= true;

//          get Numbers
            do {
                System.out.println("Do you want Upper letters \"1234...\" to be used? ");
                input = keyboard.next();
                found = PasswordRequestError(input);
            } while (found == 0);
            if (found > 0) IncludeNum= true;

//          get Special characters
            do {
                System.out.println("Do you want Upper letters \"!@#$...\" to be used? ");
                input = keyboard.next();
                found = PasswordRequestError(input);
            } while (found == 0);
            if (found > 0) IncludeSym= true;
//          nothing selected
            if (!IncludeLower && !IncludeUpper && !IncludeNum && !IncludeSym){
                System.out.println("You havn't selected any characters to generate your " +
                        "password, at least one of your answers should be Yes\n");
                correctParams = true;
            }
        } while (correctParams);

        System.out.println("Great! Now enter the length of the password");
        int length = keyboard.nextInt();

        final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
            final Password password = generator.GeneratePassword(length);

            System.err.println("Your generated password -> " + password);

        System.err.println("Your generated password -> " + password);

    }

    private Password GeneratePassword(int length) {
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }

    private int PasswordRequestError(String input) {
        String correct[] = {"Yes", "YES","yes", "y", "Y",  };
        String incorrect[] = {"No", "no", "NO", "n", "N", };
        int found = 0;

        for (int i = 0; i < correct.length; i++){
            if (correct[i].equals(input)){
                found = 1;
                break;
            } else if (incorrect[i].equals(input)) {
                found = -1;
                break;
            }
        }
        if (found == 0) {
            return found;
        }else {
            System.out.println("You entered incorect value, try again. \n");
            return found;
        }
    }

    private void QuitMessege() {
        System.out.println("The program is closing!");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Quit");
        System.out.print("Choice:");
    }
}
