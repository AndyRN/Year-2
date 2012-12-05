package oldfrenchayinn;

/**
 * @author Andy
 */
public class Bookings {

  int room;
  String type;
  int startDate;
  int nights;

  public Bookings(String type, int room, int startDate, int nights) {
    this.type = type;
    this.room = room;
    this.startDate = startDate;
    this.nights = nights;
  }

  public void setRoom(int room) {
    this.room = room;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setStartDate(int startDate) {
    this.startDate = startDate;
  }

  public void setNights(int nights) {
    this.nights = nights;
  }

  public int getRoom() {
    return room;
  }

  public boolean isAvailable(int startDate, int nights) {
    if (startDate > (this.startDate + this.nights)) {
      return true;
    } else if ((startDate + nights) < this.startDate) {
      return true;
    } else {
      return false;
    }
  }//isAvailable()
}//Bookings.java
