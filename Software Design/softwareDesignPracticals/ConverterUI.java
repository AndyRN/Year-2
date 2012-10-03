/***************************************************************************************
Author: Andy Nutt
Student ID: 11004967
File: ConverterUI.java
Version: 1.0
 ****************************************************************************************/
package softwareDesignPracticals;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConverterUI {

  private double er;
  private int menu;
  private double value;

  public void RunUI() {
    Scanner erScan = new Scanner(System.in);
    Scanner menuScan = new Scanner(System.in);
    Scanner valueScan = new Scanner(System.in);

    Conversion c = new Conversion();
    DecimalFormat fmt = new DecimalFormat("0.00");

    System.out.print("What is the exchange rate from Pounds to Euros?: ");
    er = erScan.nextDouble();

    System.out.println("\nWhat would you like to do?");
    System.out.println("1) Pounds to Euros conversion");
    System.out.println("2) Euros to Pounds conversion");
    System.out.print(": ");
    menu = menuScan.nextInt();

    if (menu == 1) {
      System.out.print("\nWhat is the value to be converted?: ");
      value = valueScan.nextDouble();
      System.out.println(fmt.format(value) + " pounds = " + fmt.format(c.convertPtoE(er, value)) + " euros");
    } else if (menu == 2) {
      System.out.print("\nWhat is the value to be converted?: ");
      value = valueScan.nextDouble();
      System.out.println(fmt.format(value) + " euros = " + fmt.format(c.convertEtoP(er, value)) + " pounds");
    }
  }//RunUI()
}//ConverterUI

