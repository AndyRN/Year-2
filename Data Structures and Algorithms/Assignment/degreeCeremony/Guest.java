/*****************************************************
 * Author = ar2-nutt 
 * Student ID = 11004967 
 * File = Guest.java
 ****************************************************/
package degreeCeremony;

/**
 * Edited version of:
 * @author Jonathan
 */
public class Guest {

  String name;
  String emailAddress = null;

  /**
   * @param name Guest name
   * @param emailAddress Guest email address
   */
  public Guest(String name, String emailAddress) {
    this.name = name;
    this.emailAddress = emailAddress;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object anItem) {
    boolean equal = false;
    if (anItem instanceof Guest) {
      Guest aGuest = (Guest) anItem;
      if (this.name.equalsIgnoreCase(aGuest.getName())
              && this.emailAddress.equalsIgnoreCase(aGuest.getEmailAddress())) {
        equal = true;
      }
    }
    return equal;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + (this.name != null ? this.name.hashCode() : 0);
    hash = 67 * hash + (this.emailAddress != null ? this.emailAddress.hashCode() : 0);
    return hash;
  }

  @Override
  public String toString() {
    return "- Guest name is '" + this.getName()
            + "' | Guest email address is '" + this.getEmailAddress() + "' -";
  }

  /**
   * Displays guest details
   */
  public void display() {
    System.out.println(this.toString());
  }
}//Guest.java