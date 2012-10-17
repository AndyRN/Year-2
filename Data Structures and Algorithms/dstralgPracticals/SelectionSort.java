/***************************************************************************************
Author: Andy Nutt
Student ID: 11004967
File: SelectionSort.java
Version: 1.0
 ****************************************************************************************/
package dstralgPracticals;

import java.util.Scanner;

public class SelectionSort {

  public static void main(String[] args) {
    Scanner lScan = new Scanner(System.in);
    Scanner nScan = new Scanner(System.in);

    System.out.println("How many numbers in the list?");
    System.out.print("> ");
    int l = lScan.nextInt();

    System.out.println("");

    int[] unSortedList = new int[l];

    System.out.println("Input numbers to be sorted.");
    System.out.print("> ");
    for (int z = 0; z < l; z++) {
      unSortedList[z] = nScan.nextInt();
    }

    //--------------------------<Selection Algorithm>---------------------------

    int minVal = 0;
    int minPos = 0;
    int swap = 0;

    //Checks through the entire unSortedList[]
    for (int i = 0; i < unSortedList.length; i++) {
      minVal = unSortedList[i];
      minPos = i;

      //Continues through the rest of the list, searching for the minimum value.
      for (int x = i; x < unSortedList.length; x++) {
        if (unSortedList[x] < minVal) {
          minVal = unSortedList[x];
          minPos = x;
        }//if(minVal)
      }//for(unSortedList[])

      //Swaps the minimum value that was found with the 1st value checked.
      swap = unSortedList[minPos];
      unSortedList[minPos] = unSortedList[i];
      unSortedList[i] = swap;

    }//for(unSortedList[])

    //--------------------------------------------------------------------------

    //Displays both lists.
    System.out.println("");
    for (int z = 0; z < unSortedList.length; z++) {
      System.out.print(unSortedList[z] + " ");
    }

  }//main
}//SelectionSort

