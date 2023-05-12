import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
    
    public class random_password_generator {
        private static final String UPPER_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String LOWER_CHARS = "abcdefghijklmnopqrstuvwxyz";
        private static final String NUMBERS = "0123456789";
        private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}\\|;:'\",.<>/?";
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean generateAnotherPassword = true;
    
            do {
                System.out.print("Enter the length of the password: ");
                int passwordLength = scanner.nextInt();
                String password = generatePassword(passwordLength);
                System.out.println("Password: " + password);
    
                System.out.print("Generate another password? (Y/N): ");
                String input = scanner.next().toUpperCase();
                generateAnotherPassword = input.equals("Y");
            } while (generateAnotherPassword);
    
            scanner.close();
        }
    
        public static String generatePassword(int length) {
            Random random = new SecureRandom();
            StringBuilder passwordBuilder = new StringBuilder();
    
            // Add at least one character from each character set
            passwordBuilder.append(getRandomChar(UPPER_CHARS, random));
            passwordBuilder.append(getRandomChar(LOWER_CHARS, random));
            passwordBuilder.append(getRandomChar(NUMBERS, random));
            passwordBuilder.append(getRandomChar(SYMBOLS, random));
    
            // Add remaining characters
            for (int i = 4; i < length; i++) {
                String charSet = getRandomCharSet(random);
                passwordBuilder.append(getRandomChar(charSet, random));
            }
    
            return passwordBuilder.toString();
        }
    
        private static char getRandomChar(String charSet, Random random) {
            int index = random.nextInt(charSet.length());
            return charSet.charAt(index);
        }
    
        private static String getRandomCharSet(Random random) {
            int index = random.nextInt(4);
            switch (index) {
                case 0:
                    return UPPER_CHARS;
                case 1:
                    return LOWER_CHARS;
                case 2:
                    return NUMBERS;
                case 3:
                    return SYMBOLS;
                default:
                    return "";
            }
        }
    }