/**
 * ***************************************************
 * Author = ar2-nutt Student ID = 11004967 File = Spy.java
 * ***************************************************
 */
package softwareDesignPracticals;

import java.util.Scanner;

public class Spy {

    /**
     *
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("1) Encode a message");
        System.out.println("2) Decode a message");
        System.out.print(":> ");

        int answer = scan.nextInt();

        if (answer == 1) {
            System.out.println("\nInput your message to be encoded.");
            System.out.print(": ");
            String message = scan.nextLine();
            String newMessage = "";
            for (int i = 0; i < message.length(); i++) {
                Character c = message.charAt(i);
                switch (c) {
                    case 'a':
                        newMessage = newMessage + "p";
                        break;
                    case 'b':
                        newMessage = newMessage + "r";
                        break;
                    case 'c':
                        newMessage = newMessage + "j";
                        break;
                    case 'd':
                        newMessage = newMessage + "i";
                        break;
                    case 'e':
                        newMessage = newMessage + "t";
                        break;
                    case 'f':
                        newMessage = newMessage + "g";
                        break;
                    case 'g':
                        newMessage = newMessage + "c";
                        break;
                    case 'h':
                        newMessage = newMessage + "o";
                        break;
                    case 'i':
                        newMessage = newMessage + "x";
                        break;
                    case 'j':
                        newMessage = newMessage + "b";
                        break;
                    case 'k':
                        newMessage = newMessage + "s";
                        break;
                    case 'l':
                        newMessage = newMessage + "y";
                        break;
                    case 'm':
                        newMessage = newMessage + "n";
                        break;
                    case 'n':
                        newMessage = newMessage + "w";
                        break;
                    case 'o':
                        newMessage = newMessage + "d";
                        break;
                    case 'p':
                        newMessage = newMessage + "e";
                        break;
                    case 'q':
                        newMessage = newMessage + "m";
                        break;
                    case 'r':
                        newMessage = newMessage + "h";
                        break;
                    case 's':
                        newMessage = newMessage + "u";
                        break;
                    case 't':
                        newMessage = newMessage + "v";
                        break;
                    case 'u':
                        newMessage = newMessage + "l";
                        break;
                    case 'v':
                        newMessage = newMessage + "z";
                        break;
                    case 'w':
                        newMessage = newMessage + "f";
                        break;
                    case 'x':
                        newMessage = newMessage + "q";
                        break;
                    case 'y':
                        newMessage = newMessage + "k";
                        break;
                    case 'z':
                        newMessage = newMessage + "a";
                        break;
                    case ' ':
                        newMessage = newMessage + " ";
                        break;
                    default:
                        break;
                }
            }
            System.out.println("Your encoded message = " + newMessage);
        } else if (answer == 2) {
            System.out.println("\nInput your message to be decoded.");
            System.out.print(": ");
            String message = scan.nextLine();
            String newMessage = "";
            for (int i = 0; i < message.length(); i++) {
                Character c = message.charAt(i);
                switch (c) {
                    case 'a':
                        newMessage = newMessage + "z";
                        break;
                    case 'b':
                        newMessage = newMessage + "j";
                        break;
                    case 'c':
                        newMessage = newMessage + "g";
                        break;
                    case 'd':
                        newMessage = newMessage + "o";
                        break;
                    case 'e':
                        newMessage = newMessage + "p";
                        break;
                    case 'f':
                        newMessage = newMessage + "g";
                        break;
                    case 'g':
                        newMessage = newMessage + "f";
                        break;
                    case 'h':
                        newMessage = newMessage + "r";
                        break;
                    case 'i':
                        newMessage = newMessage + "d";
                        break;
                    case 'j':
                        newMessage = newMessage + "c";
                        break;
                    case 'k':
                        newMessage = newMessage + "y";
                        break;
                    case 'l':
                        newMessage = newMessage + "u";
                        break;
                    case 'm':
                        newMessage = newMessage + "q";
                        break;
                    case 'n':
                        newMessage = newMessage + "m";
                        break;
                    case 'o':
                        newMessage = newMessage + "h";
                        break;
                    case 'p':
                        newMessage = newMessage + "e";
                        break;
                    case 'q':
                        newMessage = newMessage + "x";
                        break;
                    case 'r':
                        newMessage = newMessage + "b";
                        break;
                    case 's':
                        newMessage = newMessage + "k";
                        break;
                    case 't':
                        newMessage = newMessage + "e";
                        break;
                    case 'u':
                        newMessage = newMessage + "s";
                        break;
                    case 'v':
                        newMessage = newMessage + "t";
                        break;
                    case 'w':
                        newMessage = newMessage + "n";
                        break;
                    case 'x':
                        newMessage = newMessage + "i";
                        break;
                    case 'y':
                        newMessage = newMessage + "l";
                        break;
                    case 'z':
                        newMessage = newMessage + "v";
                        break;
                    case ' ':
                        newMessage = newMessage + " ";
                        break;
                    default:
                        break;
                }
            }
            System.out.println("Your decoded message = " + newMessage);
        }
    }
}
