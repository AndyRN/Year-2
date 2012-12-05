package oldfrenchayinn;

/**
 * @author Andy
 */
public class Pay {

  public static void toString(Room[] rooms, int startDate, int nights, String name, 
          String email, String cardNumber, String issueDate, String expiryDate) {
          System.out.println("\n--- Reservation Details ---\n" + rooms[UI.room].toString() + "\n"
                           + "Arriving " + startDate + "/4/12 then staying for " + nights + " night(s).\n"
                           + "\nName = " + name + ",  Email = " + email + "\n"
                           + "The card with these details will be charged £" + UI.cost + "\n"
                           + " - Card Number = " + cardNumber + "\n"
                           + " - Issue Date = " + issueDate + "\n"
                           + " - Expiry Date = " + expiryDate + "\n\n");
  }
}//Pay.java
