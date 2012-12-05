package oldfrenchayinn;

/**
 * @author Andy
 */
public class Room {

  String type;
  boolean enSuite;
  boolean miniBar;
  boolean internet;
  boolean tv;
  int bookings;

  public Room(String type, boolean enSuite, boolean miniBar, boolean internet, boolean tv) {
    this.type = type;
    this.enSuite = enSuite;
    this.miniBar = miniBar;
    this.internet = internet;
    this.tv = tv;
  }

  public String getType() {
    return type;
  }

  public void addBooking() {
    bookings++;
  }

  public int getBookings() {
    return bookings;
  }

  @Override
  public String toString() {
    return ("Room type = " + type + "\nEnsuite = " + enSuite + "\nMinibar = " + miniBar + "\nInternet = " + internet + "\nTv = " + tv);
  }
}//Room.java