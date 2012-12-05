/*****************************************************
 * Author = ar2-nutt 
 * Student ID = 11004967 
 * File = Student.java
 ****************************************************/
package degreeCeremony;

import listImplementations.SList;

/**
 * Edited version of:
 * @author Jane
 */
public class Student {

  private int studentNum;
  private String name = null;
  private SList guestList;

  public Student(int number, String name) {
    this.studentNum = number;
    this.name = name;
    guestList = new SList(4);
  }

  public int getStudentNum() {
    return studentNum;
  }

  public void setStudentNum(int StudentNum) {
    this.studentNum = StudentNum;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SList getGuestList() {
    return guestList;
  }

  public void setGuestList(SList guestList) {
    this.guestList = guestList;
  }

  /**
   * This method displays the guest list on the console
   */
  public void displayGuestList() {
    guestList.display();
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 67 * hash + this.studentNum;
    return hash;
  }

  @Override
  public boolean equals(Object anItem) {
    boolean equal = false;
    if (anItem instanceof Student) {
      Student aStudent = (Student) anItem;
      if (this.studentNum == aStudent.getStudentNum()) {
        equal = true;
      }
    }
    return equal;
  }

  /**
   * Adds a new guest to a guest list. Duplicate guests are not allowed
   * @param newGuest
   * @return true if guest is added
   *         false if the list is full or the guest is already on the list
   */
  public boolean addGuest(Guest newGuest) {
    boolean added = false;
    if (this.getGuestList().contains(newGuest) < 0) {
      // guest not yet added
      added = this.getGuestList().add(newGuest);
    }
    return added;
  }

  /**
   * this method displays the student details, together with the guest list
   */
  public void display() {
    System.out.println(this.toString());
    this.displayGuestList();
  }

  @Override
  public String toString() {
    return "=( Student number is '" + this.getStudentNum()
            + "' | Student name is '" + this.getName() + "' )=";
  }
}//Student.java