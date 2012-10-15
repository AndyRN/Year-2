/***************************************************************************************
 * Author: Andy Nut
 * Student ID: 11004967
 * File: SortingAlgorithm.java
 * Version: 1.0
 ****************************************************************************************/
package dstralgPracticals;

import java.util.Scanner;

public class InsertionSort {

  public static void main(String[] args) {
    Scanner lScan = new Scanner(System.in);
    Scanner nScan = new Scanner(System.in);

    System.out.println("How many numbers in the list?");
    System.out.print("> ");
    int l = lScan.nextInt();

    System.out.println("");

    int[] unSortedList = new int[l];
    int[] sortedList = new int[unSortedList.length];

    System.out.println("Input numbers to be sorted.");
    System.out.print("> ");
    for (int z = 0; z < l; z++) {
      unSortedList[z] = nScan.nextInt();
    }

    //--------------------------<Insertion Algorithm>---------------------------

    int sortedCount = 0;
    int i = 0;

    //Checks through the entire unSortedList[]
    for (int x = 0; x < unSortedList.length; x++) {
      sortedList[x] = unSortedList[x];
      i = 0;

      //Checks through the current values in sortedList[]
      while (i < sortedCount) {

        //If the value we want to sort is lower than a value in the sorted list...
        if (unSortedList[x] < sortedList[i]) {

          //...Move everything above and including the sorted list's value up one.
          for (int y = sortedCount - 1; y >= i; y--) {
            sortedList[y + 1] = sortedList[y];
          }//for(Shifting)

          //Place the value we want to sort into the now empty space below the
          //larger values in the sorted list.
          sortedList[i] = unSortedList[x];
          i = sortedCount;
        }//if(Insertion)

        i++;
      }//while(sortedList[])

      sortedCount++;
    }//for(unSortedList[])

    //--------------------------------------------------------------------------

    //Displays both lists.
    System.out.println("");
    for (int z = 0; z < unSortedList.length; z++) {
      System.out.print(unSortedList[z] + " ");
    }
    System.out.println("");
    for (int z = 0; z < unSortedList.length; z++) {
      System.out.print(sortedList[z] + " ");
    }
    System.out.println("");
  }//main()
}//InsertionSort

