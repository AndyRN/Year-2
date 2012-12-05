/*****************************************************
 * Author = ar2-nutt 
 * Student ID = 11004967 
 * File = CeremonyList.java
 ****************************************************/
package degreeCeremony;

import listImplementations.DList;
import listImplementations.SList;

/**
 * Edited version of:
 * @author Jonathan
 */
public class CeremonyList {

  private DList<Student> myList = new DList<Student>();

  /**
   * Add the student with the given name
   */
  public boolean addStudent(Student aStudent) {
    boolean success = false;
    boolean same = studentCheckNum(aStudent.getStudentNum());
    if (!myList.contains(aStudent) && !same) {
      myList.add(aStudent);
      success = true;
    } else {
      System.out.println("[Student '" + aStudent.getStudentNum() + "' already exists]");
    }
    return success;
  }

  /**
   * Adds a guest to a student. Returns: -1 if the student's name was not in
   * the list 0 if guest list is full 1 if guest successfully added
   */
  public int addGuest(int number, String guestName, String email) {
    int result = -1;
    Guest newGuest = new Guest(guestName, email);
    Student aStudent = getStudent(number);
    int index = myList.indexOf(aStudent);
    if (index >= 0) {
      if (!guestCheckEmail(email)) {
        Student tmpStudent = (Student) myList.get(index);
        if (tmpStudent.addGuest(newGuest)) {
          result = 1;
        } else {
          result = 0;
          System.out.println("[Student '" + number + "' not found]");
        }//if(newGuest)
      } else {
        System.out.println("[The address '" + email + "' is already in use]");
      }//if(email)
    } else {
      System.out.println("[Student '" + number + "' doesn't exist]");
    }//if(aStudent)
    return result;
  }

  /**
   * Displays all Guests for a specific Student.
   * @param number 
   */
  public void displayGuestList(int number) {
    Student aStudent = getStudent(number);
    int index = myList.indexOf(aStudent);
    if (index < 0) {
      System.out.println("[Student '" + number + "' doesn't exist]");
    } else {
      aStudent = myList.get(index);
      aStudent.displayGuestList();
    }
  }

  /**
   * Displays all students and their guests
   */
  public void displayStudents() {
    for (int i = 0; i < myList.size(); i++) {
      myList.get(i).display();
      System.out.println("");
    }
  }

  /**
   * Displays all guests.
   */
  public void listAllGuests() {
    for (int i = 0; i < myList.size(); i++) {
      myList.get(i).displayGuestList();
    }
  }

  /**
   * This searches through the current Student list for a student that has the
   * number requested.
   * @param number
   * @return student - Null if the Student was not found. 
   */
  private Student getStudent(int number) {
    Student student = null;

    if (!myList.isEmpty()) {
      for (int i = 0; i < myList.getCurrentLength(); i++) {
        if (number == myList.get(i).getStudentNum()) {
          student = myList.get(i);
        }
      }//for(currentLength)
    }//if(isEmpty())
    return student;
  }

  /**
   * This searches through all the Student list to see if a Student is already 
   * using the number.
   * @param number
   * @return True if a matching number is found. 
   */
  private boolean studentCheckNum(int number) {
    for (int i = 0; i < myList.getCurrentLength(); i++) {
      if (number == myList.get(i).getStudentNum()) {
        return true;
      }
    }//for(currentLength)
    return false;
  }

  /**
   * This searches through the current Guest list for a Student to see if a Guest
   * is already using the email address.
   * @param email
   * @return True if a matching email is found.
   */
  private boolean guestCheckEmail(String email) {
    for (int i = 0; i < myList.getCurrentLength(); i++) {
      SList guestList = myList.get(i).getGuestList();
      for (int x = 0; x < 4; x++) {
        Guest guestItem = (Guest) guestList.getItem(x);
        try {
          if (email.equals(guestItem.getEmailAddress())) {
            return true;
          }
        } catch (NullPointerException e) {
          x = 4;
        }
      }//for(guests)
    }//for(currentLength)
    return false;
  }//guestCheckEmail()
}//CeremonyList.java