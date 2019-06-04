import java.util.Scanner; 
public class Cipher { 
    static int key = 0; 
    public static void main(String[] args) { 
        Scanner keyboard = new Scanner(System.in); 
        System.out.println("Welcome to the L.E.A.P Encrytor/Decryptor, Enter Message: "); 
        String message = keyboard.nextLine(); 
        //System.out.println("\nDECRYPTED ATBASH: " + AtBashCipher(message).toUpperCase()); 
        System.out.println("Enter a key: "); key = keyboard.nextInt(); 
        //System.out.println("\nENCRYPTED CAESAR: " + CaesarEncrypt(message).toUpperCase()); 
        System.out.println("\nDECRYPTED CAESAR: " + CaesarDecrypt(message).toUpperCase()); } 

    public static String CaesarEncrypt(String message) { 
        String encrypt = ""; 
        for (int i = 0; i < message.length(); i++) { 
            char c = message.charAt(i); 
            if (Character.isLetter(c)) { 
                int newChar = (char)(((int)message.charAt(i) + key - 65) % 26 + 65); 
                encrypt = encrypt + (char) newChar; } 
            else { encrypt = encrypt + " "; } 
        } 
        return encrypt; }