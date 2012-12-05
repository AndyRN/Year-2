package oldfrenchayinn;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Andy
 */
public class UI {

  public static int cost, room;
  public static ArrayList<Integer> reservations = new ArrayList<>();

  /**
   * @param args the command line arguments
   */
  @SuppressWarnings("empty-statement")
  public static void main(String[] args) {
    Scanner stringScan = new Scanner(System.in);
    Scanner intScan = new Scanner(System.in);
    int type = 0, startDate = 0, nights = 0, i = 0;
    String response = null, happy = "";
    boolean stop = false, stop2, proceed = false, available, unavailable;

    //Room objects
    Room one = new Room("Single", false, true, true, false);
    Room two = new Room("Single", false, true, true, false);
    Room three = new Room("Single", false, true, true, false);
    Room four = new Room("Single", false, true, true, false);
    Room five = new Room("Double", false, true, false, true);
    Room six = new Room("Double", false, true, false, true);
    Room seven = new Room("Family", false, false, true, true);
    Room eight = new Room("Family", false, false, true, true);

    //Instantiating the array and inputting the room objects
    Room[] rooms = new Room[]{one, two, three, four, five, six, seven, eight};

    //Instantiating the ArrayList so any amount of bookings/customers can be made
    ArrayList<Bookings> bookings = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();

    //----------------------------- Start of Program ---------------------------
    //Loops until user doesn't want to book a room.
    while (stop != true) {
      System.out.println("------- Welcome to the Old Frenchay Inn booking system -------");
      available = true;
      unavailable = false;
      while (proceed != true) {
        System.out.print("\nWould you like to book a room?\n(y/n): ");
        response = stringScan.nextLine();
        if ("y".equals(response) || "n".equals(response)) {
          proceed = true;
        } else {
          System.out.println("[Invalid Input]");
        }
      }//while(proceed)
      proceed = false;
      stop2 = false;

      switch (response) {
        case "y":
          //Loops until user is happy with the available room and price
          while (stop2 == false) {
            while (proceed != true) {
              type = 0;
              System.out.println("\nPlease choose a room type;");
              System.out.println("1) Single");
              System.out.println("2) Double");
              System.out.println("3) Family");
              System.out.print("(Enter number): ");
              try {
                type = intScan.nextInt();
              } catch (InputMismatchException e) {
                intScan.next();
              }

              //Viewing the details of the room type chosen
              if (type == 1) {
                System.out.println("\n" + rooms[0].toString());
                proceed = true;
              } else if (type == 2) {
                System.out.println("\n" + rooms[4].toString());
                proceed = true;
              } else if (type == 3) {
                System.out.println("\n" + rooms[6].toString());
                proceed = true;
              } else {
                System.out.println("[Invalid Input]");
              }//if(type)
            }//while(proceed)
            proceed = false;

            while (proceed != true) {
              while (proceed != true) {
                startDate = 0;
                System.out.print("\nPlease enter your arrival date\n(April 1-30): ");
                try {
                  startDate = intScan.nextInt();
                } catch (InputMismatchException e) {
                  System.out.println("[Invalid Input]");
                  intScan.next();
                }
                if (startDate > 0 && startDate < 31) {
                  proceed = true;
                } else {
                  System.out.println("[Not a day in April]");
                }
              }//while(proceed)
              proceed = false;
              while (proceed != true) {
                nights = 0;
                System.out.print("Please enter the amount of nights you'd wish to stay\n: ");
                try {
                  nights = intScan.nextInt();
                } catch (InputMismatchException e) {
                  System.out.println("[Invalid Input]\n");
                  intScan.next();
                }
                if (nights > 0) {
                  proceed = true;
                } else {
                  System.out.println("[Invalid input]\n");
                }
              }//while(proceed)
              proceed = false;
              if ((startDate + nights) < 30) {
                proceed = true;
              } else {
                System.out.println("[Stay exceeds the end of April]");
              }
            }//while(proceed)
            proceed = false;

            //Continuing with the user's room type choice, displays the cost of the nights requested
            if (type == 1) {
              if (i != 0) {
                if (isRoomAvailable(rooms, bookings, "Double", startDate, nights)) {
                  available = true;
                } else {
                  available = false;
                }
              }//if(i != 0)
              if (available) {
                System.out.println("\nThe cost will be £" + calculateCost("Single", nights));
                if (i == 0) {
                  room = 0;
                }
                while (proceed != true) {
                  System.out.println("Are you happy with this?");
                  System.out.print("(y/n): ");
                  happy = stringScan.nextLine();
                  if ("y".equals(happy) || "n".equals(happy)) {
                    proceed = true;
                  } else {
                    System.out.println("[Invalid Input]\n");
                  }
                }//while(proceed)
                proceed = false;
                stop2 = true;
              } else {
                System.out.println("\nNo single rooms available, sorry.\n");
                unavailable = true;
                stop2 = true;
              }
            } else if (type == 2) {
              if (i != 0) {
                if (isRoomAvailable(rooms, bookings, "Double", startDate, nights)) {
                  available = true;
                } else {
                  available = false;
                }
              }//if(i != 0)
              if (available) {
                System.out.println("\nThe cost will be £" + calculateCost("Double", nights));
                if (i == 0) {
                  room = 4;
                }
                while (proceed != true) {
                  System.out.println("Are you happy with this?");
                  System.out.print("(y/n): ");
                  happy = stringScan.nextLine();
                  if ("y".equals(happy) || "n".equals(happy)) {
                    proceed = true;
                  } else {
                    System.out.println("[Invalid Input]\n");
                  }
                }//while(proceed)                
                proceed = false;
                stop2 = true;
              } else {
                System.out.println("\nNo double rooms available, sorry.\n");
                unavailable = true;
                stop2 = true;
              }
            } else if (type == 3) {
              if (i != 0) {
                if (isRoomAvailable(rooms, bookings, "Double", startDate, nights)) {
                  available = true;
                } else {
                  available = false;
                }
              }//if(i != 0)
              if (available) {
                System.out.println("\nThe cost will be £" + calculateCost("Family", nights));
                if (i == 0) {
                  room = 6;
                }
                while (proceed != true) {
                  System.out.println("Are you happy with this?");
                  System.out.print("(y/n): ");
                  happy = stringScan.nextLine();
                  if ("y".equals(happy) || "n".equals(happy)) {
                    proceed = true;
                  } else {
                    System.out.println("[Invalid Input]\n");
                  }
                }//while(proceed)
                proceed = false;
                stop2 = true;
              } else {
                System.out.println("\nNo family rooms available, sorry.\n");
                unavailable = true;
                stop2 = true;
              }
            }//if(info&cost)
          }//while(stop2)

          if (unavailable != true) {
            //If the user was happy with the room and price, they proceed to enter personal info
            switch (happy) {
              case "y":
                Customer customer = new Customer(i);
                customers.add(customer);
                System.out.print("\nPlease enter your name\n: ");
                customers.get(i).setName(stringScan.nextLine());
                System.out.print("Please enter your email\n: ");
                customers.get(i).setEmail(stringScan.nextLine());
                System.out.println("Reservation number = " + reservation());

                //Books the room from the start date to the end of the user's stay
                if (type == 1) {
                  Bookings booking = new Bookings("Single", room, startDate, nights);
                  bookings.add(booking);
                } else if (type == 2) {
                  Bookings booking = new Bookings("Double", room, startDate, nights);
                  bookings.add(booking);
                } else if (type == 3) {
                  Bookings booking = new Bookings("Family", room, startDate, nights);
                  bookings.add(booking);
                }
                rooms[room].addBooking();

                System.out.print("\nPlease enter your card number\n: ");
                customers.get(i).setCardNumber(stringScan.nextLine());
                System.out.print("Please enter your card issue date\n(dd/mm/yy): ");
                customers.get(i).setIssueDate(stringScan.nextLine());
                System.out.print("Please enter your expiry date\n(dd/mm/yy): ");
                customers.get(i).setExpiryDate(stringScan.nextLine());

                //Sends all the required information to the 'confirm' object to be processed
                customers.get(i).confirmPayment(rooms, startDate, nights);
                i++;
                break;
              case "n":
                System.out.println("\nWe're sorry for the price, hope you find something cheaper!\n\n");
                break;
              default:
                break;
            }//switch(happy)
          }//if(stop != true)
          break;
        case "n":
          stop = true;
          System.out.println("\nHave a good day!");
          break;
        default:
          break;
      }//switch(response)
    }//while(stop)
    //----------------------------- End of Program -----------------------------
  }//main()

  public static boolean isRoomAvailable(Room[] rooms, List<Bookings> bookings, String type, int startDate, int nights) {
    int fail = 0, y = 0;
    switch (type) {
      case "Single":
        fail = 4;
        break;
      case "Double":
      case "Family":
        fail = 2;
        break;
    }

    for (int i = 0; i < 8; i++) {
      if (type.equals(rooms[i].getType())) {
        if (rooms[i].getBookings() == 0) {
          room = i;
          return true;
        } else {
          for (int x = 0; x < bookings.size(); x++) {
            if (bookings.get(x).getRoom() == i) {
              if (!bookings.get(x).isAvailable(startDate, nights)) {
                y++;
                x = bookings.size();
                if (y == fail) {
                  return false;
                }
              }//if()
            }//if()
          }//for()
          room = i;
        }//if()
      }//if()
    }//for()
    return true;
  }//isRoomAvailable()

  public static int calculateCost(String type, int nights) {
    switch (type) {
      case "Single":
        cost = nights * 30;
        break;
      case "Double":
        cost = nights * 40;
        break;
      case "Family":
        cost = nights * 50;
        break;
    }//switch(type)
    return cost;
  }//calculate()

  public static int reservation() {
    boolean okay = false;
    int n = 0;
    Random rGenerator = new Random();
    if (reservations.isEmpty()) {
      return rGenerator.nextInt(999999) + 1000000;
    }
    while (okay != true) {
      n = rGenerator.nextInt(999999) + 1000000;
      for (int i = 0; i < reservations.size(); i++) {
        if (n != reservations.get(i)) {
          okay = true;
        } else {
          okay = false;
          i = reservations.size();
        }
      }//for()
    }//while()
    if (okay != true) {
      return -1;
    }
    reservations.add(n);
    return n;
  }
}//Control.java
