package familytree;

import java.util.ArrayList;

/**
 * Holds the details of an individual. You need to complete this class
 *
 * @author David
 */
public class Person {

  // insert instance variables here
  private ArrayList<Person> relationshipArray = new ArrayList();
  private ArrayList<Person> parentArray = new ArrayList();
  private String name, dOB, birthPlace;
  private int mPos, fPos, pPos, dpPos;
  private boolean married, adopted;

  /**
   * Creates a new instance of Person
   */
  public Person() {
  }

  public Person(String aName, String aDOB, String aBirthPlace) {
    this.name = aName;
    this.dOB = aDOB;
    this.birthPlace = aBirthPlace;
    this.mPos = -1;
    this.fPos = -1;
    this.pPos = -1;
    this.dpPos = -1;
    this.married = false;
    this.adopted = false;
  }

  public void details() {
    System.out.println("\nName = " + this.name);
    System.out.println("Date of Birth = " + this.dOB);
    System.out.println("Birthplace = " + this.birthPlace);
    System.out.println("Married = " + this.married);
    System.out.println("Adopted = " + this.adopted);
  }

  public void addPartner(Person partner) {
    relationshipArray.add(partner);
  }

  public void listCurrentPartner() {
    if (relationshipArray.isEmpty()) {
      System.out.println("\n[" + this.name + " has had no partners]");
    } else {
      System.out.println("");
      relationshipArray.get(relationshipArray.size() - 1).details();
    }
  }//listCurrentPartner()

  public void listAllPartners() {
    if (relationshipArray.isEmpty()) {
      System.out.println("\n[" + this.name + " has had no partners]");
    } else {
      System.out.println("");
      for (int i = 0; i < relationshipArray.size(); i++) {
        System.out.println("- " + relationshipArray.get(i).getName() + " " + relationshipArray.get(i).getdOB());
      }
    }
  }//listPartners()

  public void addParent(Person parent) {
    parentArray.add(parent);
  }

  public void listAllParents() {
    if (parentArray.isEmpty()) {
      System.out.println("\n[" + this.name + " has had no parents]");
    } else {
      System.out.println("");
      for (int i = 0; i < parentArray.size(); i++) {
        System.out.println("- " + parentArray.get(i).getName() + " " + parentArray.get(i).getdOB());
      }
    }
  }//listParents()

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getdOB() {
    return dOB;
  }

  public void setdOB(String dOB) {
    this.dOB = dOB;
  }

  public String getBirthPlace() {
    return birthPlace;
  }

  public void setBirthPlace(String birthPlace) {
    this.birthPlace = birthPlace;
  }

  public int getmPos() {
    return mPos;
  }

  public void setmPos(int mPos) {
    this.mPos = mPos;
  }

  public int getfPos() {
    return fPos;
  }

  public void setfPos(int fPos) {
    this.fPos = fPos;
  }

  public int getpPos() {
    return pPos;
  }

  public void setpPos(int pPos) {
    this.pPos = pPos;
  }

  public int getDpPos() {
    return dpPos;
  }

  public void setDpPos(int dpPos) {
    this.dpPos = dpPos;
  }

  public boolean isMarried() {
    return married;
  }

  public void setMarried(boolean married) {
    this.married = married;
  }

  public boolean isAdopted() {
    return adopted;
  }

  public void setAdopted(boolean adopted) {
    this.adopted = adopted;
  }
}//Person.java