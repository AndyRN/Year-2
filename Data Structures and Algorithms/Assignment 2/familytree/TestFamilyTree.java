package familytree;

import java.util.Scanner;
import java.io.*;

/**
 * TestFamilyTree provides a text-based interface for a family tree The
 * interface consists of a top-level menu with options to: <dl> <dt>Load Data
 * <dd> - loads a set of test data. This, together with any other necessary
 * data, will used when you run your code during the demonstration.</dd>
 * <dt>Input Data <dd> - provides options to add a person, make a link to mother
 * or father or record a wedding, divorce or adoption </dd> <dt>Make a Query
 * <dd> - provides options to list details of an individual and their ancestors
 * or descendants.</dd> </dl> <p> Choosing an option from the input data or
 * query menus results in a call to an empty FamilyTree method. You need to
 * implement the methods in FamilyTree.
 *
 * @author David Coward
 * @author Jane Berry
 * @version 2
 */
public class TestFamilyTree {

  FamilyTree fTree1;

  /**
   * Instantiates a FamilyTree
   *
   * @see FamilyTree
   */
  TestFamilyTree() {
    fTree1 = new FamilyTree();
  }

  /**
   * Returns the String entered at the console.
   *
   * @return the string that has been input.
   */
  public String getPersonName() {
    Scanner scan = new Scanner(System.in);
    String personName;
    System.out.println("Enter - Name : ");
    personName = scan.nextLine();
    return personName;
  }

  /**
   * Processes the response to the Input Data request, prompting for additional
   * input as required. Once the required input data has been received, the
   * relevant FamilyTree method is called.
   *
   * @see FamilyTree
   */
  private void processInput() {
    Scanner scan = new Scanner(System.in);
    Scanner selectionScan = new Scanner(System.in);
    String selection, personName, place, dOB, fDOB, mDOB, gDOB,
            mothersName, fathersName, bridesName, groomsName;
    char iChoice = 0;

    try {
      selection = selectionScan.nextLine().toUpperCase();
      iChoice = selection.charAt(0);
    } catch (Exception e) {
    }
    while (iChoice != 'X') {
      switch (iChoice) {
        case 'A':
          System.out.println("Enter - Name, DOB and Birth Place : ");
          personName = scan.next();
          dOB = scan.next();
          place = scan.next();
          Person aPerson = new Person(personName, dOB, place);
          fTree1.addPerson(aPerson);
          break;
        case 'B':
          System.out.println("Enter - Name, DOB, Mother's Name and Mother's DOB : ");
          personName = scan.next();
          dOB = scan.next();
          mothersName = scan.next();
          mDOB = scan.next();
          fTree1.makeLinkToMother(personName, dOB, mothersName, mDOB);
          break;
        case 'C':
          System.out.println("Enter - Name, DOB, Father's Name and Father's DOB : ");
          personName = scan.next();
          dOB = scan.next();
          fathersName = scan.next();
          fDOB = scan.next();
          fTree1.makeLinkToFather(personName, dOB, fathersName, fDOB);
          break;
        case 'D':
          System.out.println("Enter - Bride's Name and DOB "
                  + "and Groom's Name and DOB : ");
          bridesName = scan.next();
          dOB = scan.next();
          groomsName = scan.next();
          gDOB = scan.next();
          fTree1.recordWedding(bridesName, dOB, groomsName, gDOB);
          break;
        case 'E':
          System.out.println("Enter - Wife's Name and DOB "
                  + "and Husband's Name and DOB : ");
          bridesName = scan.next();
          dOB = scan.next();
          groomsName = scan.next();
          gDOB = scan.next();
          fTree1.recordDivorce(bridesName, dOB, groomsName, gDOB);
          break;
        case 'F':
          System.out.println("Enter - Name and DOB of person adopted : ");
          personName = scan.next();
          dOB = scan.next();
          fTree1.recordAdoption(personName, dOB);
          break;
        default:
          System.out.println("\n[Invalid input choice. Try again]\n");                    //do nothing
      }
      inputMenu();
      try {
        selection = selectionScan.nextLine().toUpperCase();
        iChoice = selection.charAt(0);
      } catch (Exception e) {
      }
    }
  }//processInput()

  /**
   * Processes a family tree query by calling the relevant FamilyTree method.
   *
   * @see FamilyTree
   */
  private void processQuery() {
    Scanner scan = new Scanner(System.in);
    Scanner selectionScan = new Scanner(System.in);
    String selection, personName;
    char qChoice = 0;
    int numOfGens;

    try {
      selection = selectionScan.nextLine().toUpperCase();
      qChoice = selection.charAt(0);
    } catch (Exception e) {
    }
    while (qChoice != 'X') {
      switch (qChoice) {
        case 'K':
          fTree1.listPersonDetails(this.getPersonName());
          break;
        case 'L':
          fTree1.listParentDetails(this.getPersonName());
          break;
        case 'M':
          fTree1.listChildren(this.getPersonName());
          break;
        case 'N':
          fTree1.listSiblings(this.getPersonName());
          break;
        case 'O':
          fTree1.listPaternalLineage(this.getPersonName());
          break;
        case 'P':
          fTree1.listMaternalLineage(this.getPersonName());
          break;
        case 'Q':
          fTree1.listGrandParents(this.getPersonName());
          break;
        case 'R':
          fTree1.listGrandChildren(this.getPersonName());
          break;
        case 'S':
          fTree1.listCousins(this.getPersonName());
          break;
        case 'T':
          personName = this.getPersonName();
          System.out.println("Enter - Number of Generations required : ");
          numOfGens = scan.nextInt();
          scan.nextLine();
          fTree1.listGreatNGrandParents(personName, numOfGens);
          break;
        case 'U':
          personName = this.getPersonName();
          System.out.println("Enter - Number of Generations required : ");
          numOfGens = scan.nextInt();
          scan.nextLine();
          fTree1.listGreatNGrandChildren(personName, numOfGens);
          break;
        case 'V':
          fTree1.listAllPartners(this.getPersonName());
          break;
        case 'W':
          fTree1.listAllParents(this.getPersonName());
          break;
        case 'Y':
          fTree1.listCurrentPartner(this.getPersonName());
          break;
        default:
          System.out.println("\n[Invalid input choice. Try again]\n");
      }
      queryMenu();
      try {
        selection = selectionScan.nextLine().toUpperCase();
        qChoice = selection.charAt(0);
      } catch (Exception e) {
      }
    }
  }//processQuery()

  /**
   * Displays the top-level TestFamilyTree menu
   *
   */
  private void menu() {
    System.out.println("\n\n< FAMILY TREE MENU >\n");
    System.out.println("L\tLoad Data");
    System.out.println("I\tInput Details");
    System.out.println("Q\tMake a Query\n");

    System.out.println("X\tEXIT\n");

    System.out.println("Enter - K-U, X : ");
  }

  /**
   * Displays the options that make up the Input Details menu
   *
   */
  private void inputMenu() {
    System.out.println("\n\n< FAMILY TREE INPUT MENU >\n");
    System.out.println("A\tAdd a person to the family tree");
    System.out.println("B\tMake link to mother");
    System.out.println("C\tMake link to father");
    System.out.println("D\tRecord wedding");
    System.out.println("E\tRecord divorce");
    System.out.println("F\tRecord adoption\n");

    System.out.println("X\tEXIT INPUT\n");

    System.out.println("Enter - A-F, X : ");
  }

  /**
   * Displays the query menu
   */
  private void queryMenu() {
    System.out.println("\n\n< FAMILY TREE QUERY MENU >\n");
    System.out.println("--- Original Options ---");
    System.out.println("K\tList person details");
    System.out.println("L\tList parent details");
    System.out.println("M\tList children");
    System.out.println("N\tList siblings (noting any half-siblings)");
    System.out.println("O\tList paternal lineage (male line back to oldest man in the tree)");
    System.out.println("P\tList maternal lineage (female line back to oldest woman in the tree)");
    System.out.println("Q\tList all grandparents");
    System.out.println("R\tList all grandchildren");
    System.out.println("S\tList all cousins");
    System.out.println("T\tList all great great… (repeated N times) grandparents");
    System.out.println("U\tList all great great… (repeated N times) grandchildren\n");

    System.out.println("--- Andy's Extra Options!---");
    System.out.println("V\tList all partners");
    System.out.println("W\tList all parents");
    System.out.println("Y\tList current partner\n");

    System.out.println("X\tEXIT QUERY\n");

    System.out.println("Enter - K-U, X : ");
  }

  /**
   * Loads test data. The test data comes from 3 pre-named text files. <ul>
   * <li> person.txt - contains person details <li> fathers.txt - links a person
   * to their father <li> mothers.txt - links a person to their mother
   *
   * @see FamilyTree
   */
  private void loadData() throws IOException {
    Scanner pFile, fFile, mFile, lineScan;
    String entry, name, dOB, place, fName, fDOB, mName, mDOB;
    name = null;
    dOB = null;
    place = null;
    fName = null;
    fDOB = null;
    mName = null;
    mDOB = null;

    // read file person.txt and create new instance of person for each one 
    pFile = new Scanner(new File("person.txt"));
    while (pFile.hasNext()) {
      entry = pFile.nextLine();
      lineScan = new Scanner(entry);
      while (lineScan.hasNext()) {
        name = lineScan.next();
        dOB = lineScan.next();
        place = lineScan.next();
      }
      if ((name != null) && (dOB != null) && (place != null)) {
        Person aPerson = new Person(name, dOB, place);
        System.out.println("\n\"" + name + ", " + dOB + ", " + place + "\"");
        fTree1.addPerson(aPerson);
      }
    }
    // read file fathers.txt Foreach create father link
    fFile = new Scanner(new File("fathers.txt"));
    while (fFile.hasNext()) {
      entry = fFile.nextLine();
      lineScan = new Scanner(entry);
      while (lineScan.hasNext()) {
        name = lineScan.next();
        dOB = lineScan.next();
        fName = lineScan.next();
        fDOB = lineScan.next();
      }
      if ((name != null) && (dOB != null) && (fName != null) && (fDOB != null)) {
        System.out.println("\n\"" + name + ", " + dOB + "\" \"" + fName + ", " + fDOB + "\" - Father Added");
        fTree1.makeLinkToFather(name, dOB, fName, fDOB);
      }
    }

    // read file mothers.txt Foreach create father link        
    mFile = new Scanner(new File("mothers.txt"));
    while (mFile.hasNext()) {
      entry = mFile.nextLine();
      lineScan = new Scanner(entry);
      while (lineScan.hasNext()) {
        name = lineScan.next();
        dOB = lineScan.next();
        mName = lineScan.next();
        mDOB = lineScan.next();
      }
      if ((name != null) && (dOB != null) && (mName != null) && (mDOB != null)) {
        System.out.println("\n\"" + name + ", " + dOB + "\" \"" + mName + ", " + mDOB + "\" - Mother Added");
        fTree1.makeLinkToMother(name, dOB, mName, mDOB);
      }
    }
  }//loadData()

  /**
   * Displays the top and subsequent level menus.
   *
   * @param args unused
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException {
    TestFamilyTree tFT = new TestFamilyTree();
    Scanner scan = new Scanner(System.in);
    char mChoice = 0;
    String selection;

    tFT.menu();
    try {
      selection = scan.nextLine().toUpperCase();
      mChoice = selection.charAt(0);
    } catch (Exception e) {
    }
    while (mChoice != 'X') {
      switch (mChoice) {
        case 'L': {
          tFT.loadData();
          break;
        }
        case 'I': {
          tFT.inputMenu();
          tFT.processInput();
          break;
        }
        case 'Q': {
          tFT.queryMenu();
          tFT.processQuery();
          break;
        }
        default: {
          System.out.println("\n[Invalid choice. Try again]\n");
        }
      }
      tFT.menu();
      try {
        selection = scan.nextLine().toUpperCase();
        mChoice = selection.charAt(0);
      } catch (Exception e) {
      }
    }
  }//main()
}//TestFamilyTree.java