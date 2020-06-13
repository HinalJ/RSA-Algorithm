package RSA;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Class implementing KeyGeneration, Encryption and Decryption of the message.
 */
public class RSA {
    /**
     * Method asking user what action to perform.
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        int number;
        Scanner scan = new Scanner(System.in);
         do{
            System.out.println("What do you want to do ?");
            System.out.println("1. Generate the keys (PK, SK)");
            System.out.println("2. Encryption of the message ");
            System.out.println("3. Decryption of the message");

            number = scan.nextInt();

            if(number > 4 || number < 1)
                System.err.println("Please choose from the option!");
        }while(number > 4 || number < 1);

        switch (number) {

            case 1:
                generateKey();
                break;

            case 2:
                encryption();
                break;

            case 3:
                decryption();
                break;
        }
    }

    /**
     * Method generate Public and Private Keys.
     * @throws FileNotFoundException
     */
    public static void generateKey() throws FileNotFoundException {
        KeyGeneration keyGeneration = new KeyGeneration();
        BigInteger n = keyGeneration.getN();
        BigInteger e = keyGeneration.getE();
        BigInteger d = keyGeneration.getD();
        Scanner scan = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("1. Save the cipher text in a file.");
        System.out.println("2. Print out on the console");
        System.out.println("3. Do Both");
        int number = scan.nextInt();

        while (true) {
            if (number > 3 || number < 1) {
                System.err.println("Please choose from the option!");
                continue;
            }

            if (number == 1) {
                PrintStream out1 = new PrintStream("PublicKey.txt");
                out1.println("(n,e) -> " + n + "," + e);
                PrintStream out2 = new PrintStream("PrivateKey.txt");
                out2.println("d -> " + d);
                System.out.println("[+] Files created for both the keys.");
                break;
            }
            else if(number == 2){
                System.out.println("PK(n,e): (" + n + "," + e + ")");
                System.out.println("SK(d): = " + d);
                System.out.println("[-] Files are not created.");
                break;
            }
            else{
                PrintStream out1 = new PrintStream("PublicKey.txt");
                out1.println("(n,e) -> " + n + "," + e);
                PrintStream out2 = new PrintStream("PrivateKey.txt");
                out2.println("d -> " + d);

                System.out.println("PK(n,e): (" + n + "," + e + ")");
                System.out.println("SK(d): = " + d);
                System.out.println("[+] Files created for both the keys.");
                break;
            }
        }
    }

    /**
     * Method encrypt the message provided.
     * @throws FileNotFoundException
     */
    public static void encryption() throws FileNotFoundException{
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter your message: ");
        BigInteger m = scan.nextBigInteger();
        BigInteger cipher, e, n;


        System.out.println("Enter Public Key: ");
        System.out.print("Enter e: ");
        e = scan.nextBigInteger();
        System.out.print("Enter n: ");
        n = scan.nextBigInteger();

        cipher = FastModExpo.FME(m, e, n);

        System.out.println("What would you like to do?");
        System.out.println("1. Save the cipher text in a file.");
        System.out.println("2. Print out on the console");
        System.out.println("3. Do Both");
        int number = scan.nextInt();

        while (true) {
            if (number > 3 || number < 1) {
                System.err.println("Please choose from the option!");
                continue;
            }

            if (number == 1) {
                PrintStream out3 = new PrintStream("CipherText.txt");
                out3.println("CipherText: " + cipher);

                System.out.println("[+] File created for CipherText.");
                break;
            }
            else if(number == 2){
                System.out.println("Encrypted Message: " + cipher);
                System.out.println("[-] Files are not created.");
                break;
            }
            else{
                PrintStream out3 = new PrintStream("CipherText.txt");
                out3.println("CipherText: " + cipher);

                System.out.println("Encrypted Message: " + cipher);
                System.out.println("[+] File created for CipherText.");
                break;
            }
        }
    }

    /**
     * Method decrypt the following Cipher text provided.
     * @throws FileNotFoundException
     */
    public static void decryption() throws FileNotFoundException{
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter Cipher message: ");
        BigInteger c = scan.nextBigInteger();
        BigInteger msg, d, n;

        System.out.println("Enter Private Key: ");
        System.out.print("Enter d: ");
        d = scan.nextBigInteger();
        System.out.print("Enter n: ");
        n = scan.nextBigInteger();

        msg = FastModExpo.FME(c, d, n);

        System.out.println("What would you like to do?");
        System.out.println("1. Save the cipher text in a file.");
        System.out.println("2. Print out on the console");
        System.out.println("3. Do Both");
        int number = scan.nextInt();

        while (true) {
            if (number > 3 || number < 1) {
                System.err.println("Please choose from the option!");
                continue;
            }

            if (number == 1) {
                PrintStream out4 = new PrintStream("DecryptedMsg.txt");
                out4.println("Decrypted Message: " + msg);

                System.out.println("[+] File created for CipherText.");
                break;
            }
            else if(number == 2){
                System.out.println("Decrypted Message: " + msg);
                System.out.println("[-] Files are not created.");
                break;
            }
            else{
                PrintStream out4 = new PrintStream("DecryptedMsg.txt");
                out4.println("Decrypted Message: " + msg);

                System.out.println("Decrypted Message: " + msg);
                System.out.println("[+] File created for CipherText.");
                break;
            }
        }
    }
}