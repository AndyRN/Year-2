/**
 * ***************************************************
 * Author = ar2-nutt Student ID = 11004967 File = Customer.java
 * ***************************************************
 */
package oldfrenchayinn;

public class Customer {

  int id;
  String name;
  String email;
  String cardNumber;
  String issueDate;
  String expiryDate;

  public Customer(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(String issueDate) {
    this.issueDate = issueDate;
  }

  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }
  
  public void confirmPayment(Room[] rooms, int startDate, int nights){
    Pay.toString(rooms, startDate, nights, name, email, cardNumber, issueDate, expiryDate);
  }
}//Customer.java