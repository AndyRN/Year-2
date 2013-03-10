/*****************************************************
 * Author = ar2-nutt 
 * Student ID = 11004967 
 * File = MyDegreeCeremonyFrontEnd.java
 ****************************************************/
package degreeCeremony;

/**
 * Edited version of:
 * @author Jonathan
 */
import java.io.*;

public class DegreeCeremonyFrontEnd {

  CeremonyList thisCeremony = new CeremonyList();
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public DegreeCeremonyFrontEnd() throws IOException {

    /**
     * Displays the main menu and responds to the input.
     * Processing loops, ignoring invalid input and responding to valid
     * choices. It exits on the input of the exit value. 
     */
    int choice = 0;
    while (choice != -1) {
      choice = displayMenu(); // Display the menu
      switch (choice) {
        case 1: {
          addStudent();
          break;
        }
        case 2: {
          addGuest();
          break;
        }
        case 3: {
          displayGuestList();
          break;
        }
        case 4: {
          thisCeremony.displayStudents();
          break;
        }
        case 5: {
          thisCeremony.listAllGuests();
          break;
        }
        default:
          if (choice != -1) {
            System.out.println("[Invalid choice]");
          }
      }//switch(choice)
    }
  }

  /**
   * @return The value input as an integer
   * @throws IOException
   */
  private int displayMenu() throws IOException {
    int menuInput = 0;
    System.out.print("\n1. Add a Student\n"
            + "2. Add a Student's Guest\n"
            + "3. Display a Student's Guest list\n"
            + "4. Display all Students\n"
            + "5. List all Student's Guests\n"
            + "-1. Quit\n");

    //  open up standard input
    menuInput = getNumber("Enter choice: ");
    System.out.println("");
    return menuInput;
  }

  /**
   * @param message Prompt to be displayed
   * @return The string that has been input.
   * @throws IOException
   */
  private String getDetail(String message) throws IOException {
    System.out.print(message);
    String input = in.readLine();
    return input;
  }

  /**
   * This method prompts for a student number. It returns when a number has
   * been input.
   * @param message Prompt to be displayed
   * @return The integer that has been input
   * @throws IOException
   */
  private int getNumber(String message) throws IOException {
    int number = 0;
    boolean success = false;
    while (!success) {
      success = true;
      System.out.print(message);
      String input = in.readLine();
      try {
        number = Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("[Please enter digits]\n");
        success = false;
      }
    }
    return number;
  }

  /**
   * Creates a new student object and passes it to the "engine" to be added
   * to the list. Duplicates are not allowed.
   * @throws IOException
   */
  private void addStudent() throws IOException {
    int studentNumber = getNumber("Enter Student number: ");
    String name = getDetail("Enter Student's name: ");
    Student aStudent = new Student(studentNumber, name);
    if (thisCeremony.addStudent(aStudent) == true) {
      System.out.println("--- Student '" + name + "' successfully added ---");
    } else {
      System.out.println("|-- Student '" + name + "' not added --|");
    }
  }

  /**
   * This method gets the name of the student to whom the guest should be 
   * added and the guest detail. It then attempts to add the guest to that 
   * student.
   */
  private void addGuest() throws IOException {
    int result;
    // Get input details
    int num = getNumber("Enter Student's number: ");
    String guestName = getDetail("Enter Guest's name: ");
    String guestEmail = getDetail("Enter Guest's email address: ");

    // Now try to add the guest to the student
    result = thisCeremony.addGuest(num, guestName, guestEmail);

    if (result > 0) {
      System.out.println("--- Guest added to Student '" + num + "' ---");
    } else {
      System.out.println("|-- Guest not added to Student '" + num + "' --|");
      if (result == 0) {
        System.out.println("[The Guest list for '" + num + "' is full]");
      }
    }
  }

  private void displayGuestList() throws IOException {
    // Get input details
    int num = getNumber("Enter Student's number: ");
    thisCeremony.displayGuestList(num);
  }

  /**
   * Runs the degree ceremony front end.
   * @param args
   * @throws IOException
   */
  public static void main(String args[]) throws IOException {
    DegreeCeremonyFrontEnd myDegreeCeremony = new DegreeCeremonyFrontEnd();
  }
}//DegreeCeremonyFrontEnd.java