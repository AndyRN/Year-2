/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareDesignPracticals;

import java.util.Scanner;

/**
 *
 * @author ar2-nutt
 */
public class Welcome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean bye = false;

        while (bye == false) {

            System.out.print("What is your name?: ");
            String name = scan.nextLine();

            if ("bye".equals(name)) {
                bye = true;
            } else {
                for (int i = 0; i <= 9; i++) {
                    System.out.println((i + 1) + ") Hello " + name + ", welcome to Software Design world!");
                    System.out.println("\n");
                }
            }
        }

    }
}
